package cn.metaq.uaa.config;

import cn.metaq.uaa.security.details.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
@Order(1)
@AutoConfigureAfter({DetailsConfiguration.class})
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    /**
     * httpSecurity中配置所有请求的安全验证
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http.sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//                .and()
//                .exceptionHandling().authenticationEntryPoint((HttpServletRequest request, HttpServletResponse response, AuthenticationException e)->response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage()))
//                .and()
//                .requestMatchers().antMatchers("**")
//                .and()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.GET,"/favicon.ico").permitAll()//不鉴权
//                .antMatchers("/actuator/**",
//                        "/instances",
//                        "/instances/*",
//                        "/oauth/authorize").permitAll() //监控admin端点不鉴权
//                .anyRequest().authenticated()
////                .and()
////                .formLogin().loginPage("/login").permitAll()
//                .and()
//                .csrf().disable();
        http.requestMatchers()
                .antMatchers("/login")
//                .antMatchers("/current")
                .antMatchers("/oauth/authorize")
                .antMatchers("/")
                .and()
                .authorizeRequests()
                .anyRequest().authenticated()//所有请求都需身份认证
                .and()
                .formLogin().loginPage("/login").permitAll()    // 自定义登录页面，这里配置了 loginPage, 就会通过 LoginController 的 login 接口加载登录页面
                .and().csrf().disable();

    }

    @Autowired
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 注入Bean AuthenticationManager 用来做验证
     *
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        AuthenticationManager manager = super.authenticationManagerBean();
        return manager;
    }
}
