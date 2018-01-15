package com.igl.gov;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@Controller
public class App {
    public static void main(String[] args) {
        run(App.class,args);
    }
}
