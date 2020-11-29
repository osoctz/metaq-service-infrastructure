package cn.metaq.service.gateway.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
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

    @Bean
    public ReactiveRedisTemplate<String, Object> redisTemplate(ReactiveRedisConnectionFactory reactiveRedisConnectionFactory){

        log.info("ReactiveRedisTemplate  init......");
        //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值（默认使用JDK的序列化方式）
        Jackson2JsonRedisSerializer jacksonSeial = new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper om = new ObjectMapper();
        // 指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 指定序列化输入的类型，类必须是非final修饰的，final修饰的类，比如String,Integer等会跑出异常
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jacksonSeial.setObjectMapper(om);

        RedisSerializationContext<String, Object> serializationContext = RedisSerializationContext.<String,Object>newSerializationContext()
                .key(new StringRedisSerializer())
                .value(jacksonSeial)
                .hashKey(new StringRedisSerializer())
                .hashValue(jacksonSeial)
                .build();

        ReactiveRedisTemplate redisTemplate=new ReactiveRedisTemplate(reactiveRedisConnectionFactory, serializationContext);

        return redisTemplate;
    }
}
