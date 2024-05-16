package com.mycompany.invoice;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages = {
        "com.mycompany.invoice.controller.cmd",
        "com.mycompany.invoice.service.prefix",
        "com.mycompany.invoice.repository.cache"
})
@ImportResource("classpath:applicationContextProperties.xml")
public class AppConfigWithoutBean {

}
