package cn.metaq.example.sso1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.context.request.RequestContextListener;

@EnableRedisHttpSession
@SpringBootApplication
public class Application {

    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}