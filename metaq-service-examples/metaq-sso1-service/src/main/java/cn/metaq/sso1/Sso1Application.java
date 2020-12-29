package cn.metaq.sso1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableOAuth2Sso
public class Sso1Application {

    public static void main(String[] args) {

        SpringApplication.run(Sso1Application.class,args);
    }
}
