package cn.metaq.uaa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * 资源服务器
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Autowired
    private RedisTokenStore tokenStore;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
//        http.csrf().disable()
//                .requestMatchers().antMatchers("**")
//                .and()
//                .authorizeRequests().antMatchers("/login",
//                "/api/**",
//                "/swagger-resources/**",
//                "/configuration/**",
//                "/webjars/**",
//                "/actuator/**",
//                "/**/*.html",
//                "/favicon.ico",
//                "/**/*.css",
//                "/v2/**",
//                "/**/*.js").permitAll().and()
//                .authorizeRequests()
//                .antMatchers("**").authenticated();

        http.csrf().disable()
                .requestMatchers().antMatchers("/current")
                .and()
                .authorizeRequests().antMatchers("/login","/oauth/**").permitAll()
                .and()
                .authorizeRequests()
                .anyRequest().authenticated();
    }

    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore);
        return defaultTokenServices;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenServices(tokenServices());
    }
}
