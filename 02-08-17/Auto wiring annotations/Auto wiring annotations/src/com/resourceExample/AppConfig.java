package com.resourceExample;

import org.springframework.config.java.plugin.context.ComponentScan;
import org.springframework.context.annotation.Configuration;

//configuratin class
@Configuration

// to automatically scan bean classes
@ComponentScan("com.resourceExample")
public class AppConfig {

}
