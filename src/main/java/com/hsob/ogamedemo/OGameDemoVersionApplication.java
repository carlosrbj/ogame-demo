package com.hsob.ogamedemo;

import com.hsob.ogamedemo.service.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OGameDemoVersionApplication implements CommandLineRunner {
	@Autowired
	private Utils utils;

	public static void main(String[] args) {
		SpringApplication.run(OGameDemoVersionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		utils.populateResourcesDb();
		utils.populateUserDb();
	}
}
