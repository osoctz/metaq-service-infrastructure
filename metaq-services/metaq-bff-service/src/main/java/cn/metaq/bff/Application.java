package cn.metaq.bff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"cn.metaq.bff","cn.metaq.common.web"})
@EnableFeignClients
@EnableOAuth2Sso
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class,args);
    }
}
