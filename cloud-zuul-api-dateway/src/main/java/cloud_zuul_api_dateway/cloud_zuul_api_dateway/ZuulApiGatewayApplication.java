package cloud_zuul_api_dateway.cloud_zuul_api_dateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulApiGatewayApplication {

	public static void main(String[] args) {

		SpringApplication.run(ZuulApiGatewayApplication.class, args);
	}

}
