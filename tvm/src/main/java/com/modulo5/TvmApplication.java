package com.modulo5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class TvmApplication {

	public static void main(String[] args) {
		SpringApplication.run(TvmApplication.class, args);
	}

}
