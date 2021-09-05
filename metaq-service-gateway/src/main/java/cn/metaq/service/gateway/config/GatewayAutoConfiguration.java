package cn.metaq.service.gateway.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Mono;

/**
 * GatewayAutoConfiguration
 *
 * @author tz
 * @date 2020/11/29 下午2:23
 * @since 1.0
 */
@Configuration
public class GatewayAutoConfiguration {

    private static final Log log = LogFactory.getLog(GatewayAutoConfiguration.class);

    /**
     * 根据请求参数中的userId进行限流
     * <p>
     * 请求地址写法：http://localhost:8801/rate/123?userId=lisi
     *
     * @return
     */
    @Bean
    public KeyResolver userKeyResolver() {

        log.info("userKeyResolver");
        return exchange -> Mono.just(
                exchange.getRequest()
                        .getQueryParams()
                        .getFirst("userId")
        );
    }

    /**
     * 根据请求IP限流
     *
     * @return
     */
    @Bean
    public KeyResolver hostKeyResolver() {

        log.info("hostKeyResolver");
        return exchange -> Mono.just(
                exchange.getRequest()
                        .getRemoteAddress()
                        .getHostName()
        );
    }

    /**
     * 接口限流：根据请求路径限流
     *
     * @return
     */
    @Bean
    @Primary
    public KeyResolver pathKeyResolver() {

        log.info("pathKeyResolver");
        return exchange -> Mono.just(
                exchange.getRequest()
                        .getPath().toString()
        );
    }
}
