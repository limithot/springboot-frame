package kr.softwarearchitect.springboot;


import kr.softwarearchitect.springboot.frame.configuration.RootSpringConfig;
import org.springframework.boot.SpringApplication;


public class Main
{
    public static void main(String ...strings)
    {
        SpringApplication app = new SpringApplication(RootSpringConfig.class);
        app.run(strings);
    }
}
