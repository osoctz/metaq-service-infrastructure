package cn.metaq.tx1;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        System.out.println("args = " + new BCryptPasswordEncoder().encode("sso1client"));
    }
}
