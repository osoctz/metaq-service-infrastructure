package cn.metaq.example.sso2.config;

import cn.metaq.example.sso2.jackson.OAuth2Jackson2Module;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.security.jackson2.SecurityJackson2Modules;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession
@Configuration
public class SpringSessionConfiguration implements BeanClassLoaderAware {

    private ClassLoader loader;

    @Bean
    public RedisSerializer<Object> springSessionDefaultRedisSerializer() {
        return new GenericJackson2JsonRedisSerializer(objectMapper());
    }

    /**
     * Customized {@link ObjectMapper} to add mix-in for class that doesn't have default
     * constructors
     * @return the {@link ObjectMapper} to use
     */
    private ObjectMapper objectMapper() {

        ObjectMapper mapper = new ObjectMapper();

//        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

        mapper.registerModules(new OAuth2Jackson2Module());
        //mapper.registerModules(ObjectMapper.findModules(this.loader));
        mapper.registerModules(SecurityJackson2Modules.getModules(this.loader));

        return mapper;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.beans.factory.BeanClassLoaderAware#setBeanClassLoader(java.lang
     * .ClassLoader)
     */
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.loader = classLoader;
    }

}
