package com.wthink.article;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.wthink.tensquare_common.util.IdWorker;
@SpringBootApplication
public class TensquareArticleApplication {

	public static void main(String[] args) {
		SpringApplication.run(TensquareArticleApplication.class, args);
	}

	@Bean
	public IdWorker idWorkker(){
		return new IdWorker(1, 1);
	}
	
}
