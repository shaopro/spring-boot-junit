package com.github.spring.boot.junit.manager;

import com.github.spring.boot.junit.pojo.ResultDTO;
import com.github.spring.boot.junit.pojo.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

import static java.util.Objects.requireNonNull;


/**
 * <p>
 * 创建时间为 上午11:06 2020/3/31
 * 项目名称 spring-boot-junit
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
@Service
public class UserManager {

    private RestTemplate template = new RestTemplate();

    public UserDTO getUserByUsername(String url, String username) {
        ResponseEntity<UserDTO> responseEntity = template.getForEntity(url + username, UserDTO.class);
        UserDTO result = responseEntity.getBody();
        log.debug("{}", result);
        return result;
    }


    public ResultDTO<UserDTO> saveUser(String ur, UserDTO user) throws URISyntaxException {
        log.debug("push data request:{}", user);
        RequestEntity<UserDTO> requestEntity = RequestEntity.post(new URI(ur))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(user);
        ParameterizedTypeReference<ResultDTO<UserDTO>> myBean = new ParameterizedTypeReference<ResultDTO<UserDTO>>() {
        };
        ResponseEntity<ResultDTO<UserDTO>> response = template.exchange(requestEntity, myBean);
        ResultDTO<UserDTO> result = requireNonNull(response.getBody());
        log.debug("push data response:{}", result);
        return result;
    }

}
