package com.wthink.gathering2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import com.wthink.tensquare_common.util.IdWorker;
@SpringBootApplication
@EnableCaching
public class TensquareGathering2Application {

	public static void main(String[] args) {
		SpringApplication.run(TensquareGathering2Application.class, args);
	}

	@Bean
	public IdWorker idWorkker(){
		return new IdWorker(1, 1);
	}
	
}
