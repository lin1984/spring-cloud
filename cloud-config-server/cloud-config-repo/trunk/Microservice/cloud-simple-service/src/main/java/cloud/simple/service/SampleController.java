package cloud.simple.service;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
 
@Controller
@SpringBootApplication
@EnableEurekaClient
public class SampleController  {
 
    @ResponseBody
    @RequestMapping(value = "/")
    String home() {   
        return "Hello World!";
    }
 
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
 
}