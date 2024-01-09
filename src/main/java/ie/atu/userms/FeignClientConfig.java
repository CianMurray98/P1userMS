package ie.atu.userms;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "ie.atu.userms")
public class FeignClientConfig {
}