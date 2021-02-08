package cn.metaq.service.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DiscoveryApplication {

	public static void main(String[] args) {

//		new SpringApplicationBuilder(DiscoveryApplication.class)
//				.main(SpringVersion.class)
//				.bannerMode(Banner.Mode.CONSOLE).run(args);
		SpringApplication.run(DiscoveryApplication.class, args);
	}

}
