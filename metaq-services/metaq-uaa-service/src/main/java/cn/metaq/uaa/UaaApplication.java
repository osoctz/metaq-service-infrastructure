package cn.metaq.uaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@SpringBootApplication(scanBasePackages = {"cn.metaq.uaa","cn.metaq.common.web"})
@EnableOAuth2Sso
public class UaaApplication {

    public static void main(String[] args) {
        SpringApplication.run(UaaApplication.class, args);
    }

}
