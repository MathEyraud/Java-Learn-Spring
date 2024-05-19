package com.mycompany.invoice;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

// "@Configuration" & "@ComponentScan" ne sont plus necessaires avec @SpringBootApplication
// "@PropertySource("classpath:application.properties")" n'est pas nécessaire,
// Car spring recherche le fichier nommé "ressources/application.properties"
@SpringBootApplication
public class AppConfigSpringBoot {

}
