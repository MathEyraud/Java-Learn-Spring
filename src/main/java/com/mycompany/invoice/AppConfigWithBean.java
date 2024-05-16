package com.mycompany.invoice;

import com.mycompany.invoice.controller.IInvoiceController;
import com.mycompany.invoice.controller.cmd.InvoiceControllerCMD;
import com.mycompany.invoice.repository.IInvoiceRepository;
import com.mycompany.invoice.repository.cache.InvoiceRepositoryCache;
import com.mycompany.invoice.repository.db.InvoiceRepositoryDB;
import com.mycompany.invoice.service.IInvoiceService;
import com.mycompany.invoice.service.prefix.InvoiceServicePrefix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
// Plus besoin de @ComponentScan avec l'injection par méthode
/*@ComponentScan(basePackages = {
        "com.mycompany.invoice.controller.cmd",
        "com.mycompany.invoice.service.prefix",
        "com.mycompany.invoice.repository.db"
})*/
@ImportResource("classpath:applicationContextProperties.xml")
public class AppConfigWithBean {

    @Bean
    public IInvoiceController configInvoiceController(){
        return new InvoiceControllerCMD();
    }

    @Bean
    public IInvoiceService configInvoiceService(){
        return new InvoiceServicePrefix();
    }

    @Bean
    public IInvoiceRepository configInvoiceRepository(){
        return new InvoiceRepositoryDB();
    }
}
