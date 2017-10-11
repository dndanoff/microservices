package eu.dreamix.hystrixboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@EnableDiscoveryClient
@EnableHystrixDashboard
@Controller
@SpringBootApplication
public class HystrixDashboardApplication {

    @RequestMapping("/")
    public String home() {
        return "forward:/hystrix";
    }
	
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApplication.class, args);
    }
}
