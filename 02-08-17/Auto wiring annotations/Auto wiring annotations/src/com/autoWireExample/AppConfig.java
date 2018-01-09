package com.autoWireExample;

import org.springframework.config.java.plugin.context.ComponentScan;
import org.springframework.context.annotation.Configuration;

//makes class cofiguration class
@Configuration

// to automatically scan bean classes
@ComponentScan("com.autoWireExample")
public class AppConfig {

}
