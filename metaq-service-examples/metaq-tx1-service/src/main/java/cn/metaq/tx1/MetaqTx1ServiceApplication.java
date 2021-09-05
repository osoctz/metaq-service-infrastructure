package cn.metaq.tx1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication(scanBasePackages = {"cn.metaq.tx1","cn.metaq.common.web"})
public class MetaqTx1ServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MetaqTx1ServiceApplication.class, args);
    }

}
