package com.github.spring.boot.junit;

class Myf2 {
    public static void main(String args[]) {
        PhoneCard pc = new PhoneCard(12345, 123, 30);
//        pc.performConnection(12345, 123);
        //________________________________
        pc.performDial();
        System.out.println(pc.getBalance());
    }
}

class PhoneCard {
    private int password;
    long cardNumber;
    double balance;
    boolean connected;

    public PhoneCard(long cn, int pw, double bal) {
        cardNumber = cn;
        password = pw;
        balance = bal;
        connected = false;
        //______________________________
    }

    boolean performConnection(long cn, int pw) {

//        __________________________________
        if ((cn == cardNumber) && (pw == password)) {
            connected = true;
        } else {
            connected = false;
        }
        //__________________________________
        return connected;
    }

    double getBalance() {
        if (connected) return balance;
        else return -1;
    }

    void performDial() {
        if (connected) {
            balance = balance - 0.5;
            //	______________________________
        }

    }
} 