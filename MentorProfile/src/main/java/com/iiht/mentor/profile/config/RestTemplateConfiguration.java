package com.iiht.mentor.profile.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate(
				new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
		return restTemplate;
	}

	@Bean
	public TaskScheduler taskScheduler() {
		ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
		scheduler.setThreadNamePrefix("poolScheduler");
		scheduler.setPoolSize(50);
		return scheduler;
	}
}