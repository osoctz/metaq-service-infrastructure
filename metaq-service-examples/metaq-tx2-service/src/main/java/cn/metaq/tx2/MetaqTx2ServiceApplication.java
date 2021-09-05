package cn.metaq.tx2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"cn.metaq.tx2","cn.metaq.common.web"})
public class MetaqTx2ServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MetaqTx2ServiceApplication.class, args);
    }

}
