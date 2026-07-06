package com.example.demo.cofig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:employees.xml")

public class AppConfig {

}