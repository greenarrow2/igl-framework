package com.igl.gov;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import static org.springframework.boot.SpringApplication.run;

/**
 * 项目启动主方法类
 * @author fancr
 */
@SpringBootApplication
@Controller
public class App {
    public static void main(String[] args) {
        run(App.class,args);
    }
}
