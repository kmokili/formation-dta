package fr.pizzeria.spring.mvc.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("fr.pizzeria.spring.mvc.controller")
public class PizzeriaSpringConfig {

}
