package menondemand.jwtauthentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@EntityScan( basePackages = {"ibm.mentor","menondemand"} )
@SpringBootApplication(scanBasePackages = {"menondemand"})
public class SpringBootJwtAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJwtAuthenticationApplication.class, args);
	}
}
