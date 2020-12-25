package cn.metaq.clientdetails.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * ClientDetailsClientAutoConfiguration
 *
 * @author tz
 * @date 2020/12/14 下午5:04
 * @since 1.0
 */
@Configuration
@EnableFeignClients(basePackages = "cn.metaq.clientdetails")
public class ClientdetailsClientAutoConfiguration {

}
