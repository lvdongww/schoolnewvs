package com.kgc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.kgc.mapper")
@SpringBootApplication
public class SchoolnewvsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolnewvsApplication.class, args);
	}

}
