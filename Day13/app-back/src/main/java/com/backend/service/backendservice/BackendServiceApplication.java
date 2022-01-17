package com.backend.service.backendservice;

import com.backend.service.backendservice.model.HeatingDwp;
import com.backend.service.backendservice.model.LightDwp;
import com.backend.service.backendservice.repository.HeatingDwpRepo;
import com.backend.service.backendservice.service.LightDwpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Component
@SpringBootApplication
@EnableScheduling
public class BackendServiceApplication implements CommandLineRunner {

	private static final Logger logger = Logger.getLogger(BackendServiceApplication.class.getName());

	@Autowired
	private LightDwpService lightDwpService;

	public static void main(String[] args) {
		SpringApplication.run(BackendServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Debut server");
		//Optional<LightDwp> lightDwp = lightDwpService.getLightDwpId(1L);
		//LightDwp lightDwp1 = lightDwp.get();

		//List<LightDwp> lightDwpList = lightDwpService.getLightDwp();
		//System.out.println(lightDwpList);

		//System.out.println(lightDwp1.getRoomDwp());
	}
}
