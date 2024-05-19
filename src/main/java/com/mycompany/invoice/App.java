package com.mycompany.invoice;

import com.mycompany.invoice.controller.IInvoiceController;
import com.mycompany.invoice.controller.cmd.InvoiceControllerCMD;
import com.mycompany.invoice.controller.douchette.InvoiceControllerDouchette;
import com.mycompany.invoice.controller.frontend.InvoiceControllerFrontend;
import com.mycompany.invoice.repository.IInvoiceRepository;
import com.mycompany.invoice.repository.cache.InvoiceRepositoryCache;
import com.mycompany.invoice.repository.db.InvoiceRepositoryDB;
import com.mycompany.invoice.service.IInvoiceService;
import com.mycompany.invoice.service.number.InvoiceServiceNumber;
import com.mycompany.invoice.service.prefixinv.InvoiceServicePrefixINV;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        /**
         * Méthode Dégeu
         * Avec "Injection de dépendances"
         * Sans "Inversion de contrôle"
         */
        //methodIf();

        /**
         * Méthode Propre
         * Avec "Injection de dépendances"
         * Sans "Inversion de contrôle"
         */
        //methodCase();

        /**
         * Méthode Dégeu
         * Avec "Injection de dépendances"
         * Avec "Inversion de contrôle"
         */
        //methodIoC();

        /**
         * Méthode Propre
         * Avec "Injection de dépendances"
         * Avec "Inversion de contrôle"
         * Avec fichier .xml (applicationContext.xml)
         * Tout est paramétré dans main/ressources/applicationContext.xml
         */
        //methodIoCWithApplicationContextXml();

        /**
         * Méthode Propre
         * Avec "Injection de dépendances"
         * Avec "Inversion de contrôle"
         * Sans fichier .xml (applicationContext.xml) ou presque
         * Sans injection de méthode
         * Tout est paramétré dans main/java/com/mycompany/invoice/AppConfigWithoutBean
         */
        //methodIoCWithoutApplicationContextXmlWithoutBean();

        /**
         * Méthode Propre
         * Avec "Injection de dépendances"
         * Avec "Inversion de contrôle"
         * Sans fichier .xml (applicationContext.xml) ou presque
         * Avec injection de méthode
         * Tout est paramétré dans main/java/com/mycompany/invoice/AppConfigWithBean
         */
        //methodIoCWithoutApplicationContextXmlWithBean();

        /**
         * Méthode Spring Boot
         */
        methodSpringBoot(args);

    }

    public static void methodIf(){
        System.out.println("Veuillez choisir le type de confirguration :");

        // Choix du type de client
        Scanner scanner = new Scanner(System.in);
        long choixClient = scanner.nextLong();

        // Controller   : Invite de commandes
        // Service      : Facture numéro 1 / 2 / 3 / ...
        // Repository   : Cache
        if (choixClient == 1) {
            InvoiceControllerCMD    invoiceControllerCMD    = new InvoiceControllerCMD();
            InvoiceServiceNumber    invoiceServiceNumber    = new InvoiceServiceNumber();
            InvoiceRepositoryCache  invoiceRepositoryCache  = new InvoiceRepositoryCache();

            invoiceServiceNumber.setInvoiceRepository(invoiceRepositoryCache);
            invoiceControllerCMD.setInvoiceService(invoiceServiceNumber);
            invoiceControllerCMD.createInvoice();

            // Controller   : Interface frontend
            // Service      : Facture numéro INV_1 / INV_2 / INV_3 / ...
            // Repository   : DB
        } else if (choixClient == 2) {
            InvoiceControllerFrontend   invoiceControllerFrontend   = new InvoiceControllerFrontend();
            InvoiceServicePrefixINV     invoiceServicePrefixINV     = new InvoiceServicePrefixINV();
            InvoiceRepositoryDB         invoiceRepositoryDB         = new InvoiceRepositoryDB();

            invoiceServicePrefixINV.setInvoiceRepository(invoiceRepositoryDB);
            invoiceControllerFrontend.setInvoiceService(invoiceServicePrefixINV);
            invoiceControllerFrontend.createInvoice();

            // Controller   : Interface frontend
            // Service      : Facture numéro 1 / 2 / 3 / ...
            // Repository   : DB
        } else if (choixClient == 3) {
            InvoiceControllerFrontend   invoiceControllerFrontend   = new InvoiceControllerFrontend();
            InvoiceServiceNumber        invoiceServiceNumber        = new InvoiceServiceNumber();
            InvoiceRepositoryDB         invoiceRepositoryDB         = new InvoiceRepositoryDB();

            invoiceServiceNumber.setInvoiceRepository(invoiceRepositoryDB);
            invoiceControllerFrontend.setInvoiceService(invoiceServiceNumber);
            invoiceControllerFrontend.createInvoice();

            // Controller   : Douchette numérique
            // Service      : Facture numéro 1 / 2 / 3 / ...
            // Repository   : DB
        } else if (choixClient == 4) {
            InvoiceControllerDouchette  invoiceControllerDouchette  = new InvoiceControllerDouchette();
            InvoiceServiceNumber        invoiceServiceNumber        = new InvoiceServiceNumber();
            InvoiceRepositoryDB         invoiceRepositoryDB         = new InvoiceRepositoryDB();

            invoiceServiceNumber.setInvoiceRepository(invoiceRepositoryDB);
            invoiceControllerDouchette.setInvoiceService(invoiceServiceNumber);
            invoiceControllerDouchette.createInvoice();
        }
    }
    public static void methodCase(){

        Scanner scanner = new Scanner(System.in);

        // Choix du controller
        System.out.println("Veuillez choisir le type de controller (CMD/Douchette/Frontend) :");
        String choixController = scanner.nextLine();

        // Choix du service
        System.out.println("Veuillez choisir le type de service (Number/PrefixINV) :");
        String choixService = scanner.nextLine();

        // Choix du repository
        System.out.println("Veuillez choisir le type de repository (Cache/DB) :");
        String choixRepository = scanner.nextLine();

        IInvoiceController invoiceController = null;
        switch (choixController){
            case "CMD"          : invoiceController = new InvoiceControllerCMD();
            case "Douchette"    : invoiceController = new InvoiceControllerDouchette();
            case "Frontend"     : invoiceController = new InvoiceControllerFrontend();
        }

        IInvoiceService invoiceService = null;
        switch (choixService){
            case "Number"       : invoiceService = new InvoiceServiceNumber();
            case "PrefixINV"    : invoiceService = new InvoiceServicePrefixINV();
        }

        IInvoiceRepository invoiceRepository = null;
        switch (choixRepository){
            case "Cache" : invoiceRepository = new InvoiceRepositoryCache();
            case "DB"    : invoiceRepository = new InvoiceRepositoryDB();
        }

        invoiceService.setInvoiceRepository(invoiceRepository);
        invoiceController.setInvoiceService(invoiceService);
        invoiceController.createInvoice();
}
    public static void methodIoC(){

         Scanner scanner = new Scanner(System.in);

        // Choix du controller
        System.out.println("Veuillez saisir le nom du controller :");
        String choixController = scanner.nextLine();

        // Choix du service
        System.out.println("Veuillez saisir le nom de service :");
        String choixService = scanner.nextLine();

        // Choix du repository
        System.out.println("Veuillez saisir le nom de repository :");
        String choixRepository = scanner.nextLine();

        IInvoiceController  invoiceController   = null;
        IInvoiceService     invoiceService      = null;
        IInvoiceRepository  invoiceRepository   = null;

        try {
            invoiceController   = (IInvoiceController)Class.forName(choixController).getDeclaredConstructor().newInstance();
            invoiceService      = (IInvoiceService)Class.forName(choixService).getDeclaredConstructor().newInstance();
            invoiceRepository   = (IInvoiceRepository)Class.forName(choixRepository).getDeclaredConstructor().newInstance();

        }catch(Exception e){
            e.printStackTrace();
        }

        invoiceController.setInvoiceService(invoiceService);
        invoiceService.setInvoiceRepository(invoiceRepository);

        invoiceController.createInvoice();

    }
    public static void methodIoCWithApplicationContextXml(){

        // Création du contexte Spring en chargeant le fichier de configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Utilisation du contexte pour récupérer un bean
        IInvoiceController invoiceController = context.getBean(IInvoiceController.class);

        // Utiliser l'objet client comme nécessaire
        invoiceController.createInvoice();
    }
    public static void methodIoCWithoutApplicationContextXmlWithoutBean(){

        // Création du contexte Spring en chargeant le fichier de configuration
        // Qui est la class AppConfigWithoutBean et non un fchier .xml
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigWithoutBean.class);

        // Utilisation du contexte pour récupérer un bean
        IInvoiceController invoiceController = context.getBean(IInvoiceController.class);

        // Utiliser l'objet client comme nécessaire
        invoiceController.createInvoice();
    }
    public static void methodIoCWithoutApplicationContextXmlWithBean(){

        // Création du contexte Spring en chargeant le fichier de configuration
        // Qui est la class AppConfigWithBean et non un fchier .xml
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigWithBean.class);

        // Utilisation du contexte pour récupérer un bean
        IInvoiceController invoiceController = context.getBean(IInvoiceController.class);

        // Utiliser l'objet client comme nécessaire
        invoiceController.createInvoice();
    }
    public static void methodSpringBoot(String[] args){

        // Création du contexte Spring en chargeant le fichier de configuration
        // Qui est la class AppConfigWithoutBean et non un fchier .xml
        ApplicationContext context = SpringApplication.run(AppConfigSpringBoot.class,args);

        // Utilisation du contexte pour récupérer un bean
        IInvoiceController invoiceController = context.getBean(IInvoiceController.class);

        // Utiliser l'objet client comme nécessaire
        invoiceController.createInvoice();
    }
}
