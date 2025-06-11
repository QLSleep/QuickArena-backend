package cn.edu.guet.quickarenabackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.edu.guet.quickarenabackend.mapper")
public class QuickArenaBackendApplication {

  public static void main(String[] args) {
    SpringApplication.run(QuickArenaBackendApplication.class, args);
  }

}
