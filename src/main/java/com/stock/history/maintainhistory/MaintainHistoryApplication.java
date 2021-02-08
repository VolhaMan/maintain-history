package com.stock.history.maintainhistory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MaintainHistoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaintainHistoryApplication.class, args);
	}

}
