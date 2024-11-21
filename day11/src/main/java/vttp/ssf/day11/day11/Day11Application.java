package vttp.ssf.day11.day11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@SpringBootApplication
public class Day11Application {


	// //http request logging
	// //logs details about incoming http requests
	// @Bean
	// public CommonsRequestLoggingFilter log(){
	// 	CommonRequestLoggingFilter logger = new CommonsRequestLoggingFilter();
	// 	logger.setIncludeClientInfo(true); //log client information like IP and name
	// 	logger.setIncludeQueryString(true); // log the query string
	// 	logger.setContentType(true);
	// 	return logger;
	// }

	public static void main(String[] args) {
		SpringApplication.run(Day11Application.class, args);
	}

}
