package com.mycompany.invoice;

import com.mycompany.invoice.controller.IInvoiceController;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

// "@Configuration" & "@ComponentScan" ne sont plus necessaires avec @SpringBootApplication
// "@PropertySource("classpath:application.properties")" n'est pas nécessaire,
// Car spring recherche le fichier nommé "ressources/application.properties"
@SpringBootApplication
public class App
{
    public static void main( String[] args )
    {
        // Création du contexte Spring en chargeant le fichier de configuration
        // Cf balise en haut de App.class
        //ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        ApplicationContext context = SpringApplication.run(App.class,args);

        // Utilisation du contexte pour récupérer un bean
        IInvoiceController invoiceController = context.getBean(IInvoiceController.class);

        // Utiliser l'objet client comme nécessaire
        invoiceController.createInvoice();
    }
}
