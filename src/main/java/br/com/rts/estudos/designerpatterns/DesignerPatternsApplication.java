package br.com.rts.estudos.designerpatterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DesignerPatternsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesignerPatternsApplication.class, args);
    }

}
