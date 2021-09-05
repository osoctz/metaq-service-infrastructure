package cn.metaq.uaa.config;

import cn.metaq.common.core.DaoTemplate;
import cn.metaq.data.jpa.BaseTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class UaaBizConfiguration {


    @PersistenceContext
    private EntityManager em;

    @Bean
    public DaoTemplate template(){
        return new BaseTemplate(em);
    }
}
