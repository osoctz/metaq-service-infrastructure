package cn.metaq.uaa.config;

import cn.metaq.uaa.security.details.CustomClientDetailsService;
import cn.metaq.uaa.security.details.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DetailsConfiguration {

    @Bean
    public CustomClientDetailsService customClientDetailsService(){

        return new CustomClientDetailsService();
    }

    @Bean
    public CustomUserDetailsService customUserDetailsService(){

        return new CustomUserDetailsService();
    }
}
