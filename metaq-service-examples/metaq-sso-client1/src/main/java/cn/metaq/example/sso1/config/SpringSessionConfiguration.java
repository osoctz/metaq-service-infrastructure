package cn.metaq.example.sso1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

//@Configuration
public class SpringSessionConfiguration {

    //@Bean("springSessionDefaultRedisSerializer")
    public RedisSerializer setSerializer(){
        return new GenericJackson2JsonRedisSerializer();
    }
}
