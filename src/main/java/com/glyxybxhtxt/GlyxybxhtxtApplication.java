package com.glyxybxhtxt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.glyxybxhtxt.dao")
@EnableAsync  //�����첽ע�⹦��
@EnableScheduling //��������ע��Ķ�ʱ����
public class GlyxybxhtxtApplication {
    public static void main(String[] args) {
        SpringApplication.run(GlyxybxhtxtApplication.class, args);
    }
}
