package com.github.spring.boot.junit.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assume;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * {@link TestRule} for working with an optional Redis server.
 *
 * @author Eric Bottard
 * @author Gary Russell
 * @author Dave Syer
 * @author Phillip Webb
 */
public class RedisTestServer implements TestRule {

	private static final Log logger = LogFactory.getLog(RedisTestServer.class);

	private JedisConnectionFactory connectionFactory;

	@Override
	public Statement apply(final Statement base, Description description) {
		try {
			this.connectionFactory = createConnectionFactory();
			return new RedisStatement(base, this.connectionFactory);
		}
		catch (Exception ex) {
			logger.error("No Redis server available", ex);
			return new SkipStatement();
		}
	}

	private JedisConnectionFactory createConnectionFactory() {
		JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
		connectionFactory.afterPropertiesSet();
		testConnection(connectionFactory);
		return connectionFactory;
	}

	private void testConnection(JedisConnectionFactory connectionFactory) {
		connectionFactory.getConnection().close();
	}

	/**
	 * @return the connection factory if any
	 */
	public RedisConnectionFactory getConnectionFactory() {
		return this.connectionFactory;
	}

	private static class RedisStatement extends Statement {

		private final Statement base;

		private final JedisConnectionFactory connectionFactory;

		RedisStatement(Statement base, JedisConnectionFactory connectionFactory) {
			this.base = base;
			this.connectionFactory = connectionFactory;
		}

		@Override
		public void evaluate() throws Throwable {
			try {
				this.base.evaluate();
			}
			finally {
				try {
					this.connectionFactory.destroy();
				}
				catch (Exception ex) {
					logger.warn("Exception while trying to cleanup redis resource", ex);
				}
			}
		}

	}

	private static class SkipStatement extends Statement {

		@Override
		public void evaluate() throws Throwable {
			Assume.assumeTrue("Skipping test due to " + "Redis ConnectionFactory"
					+ " not being available", false);
		}

	}

}