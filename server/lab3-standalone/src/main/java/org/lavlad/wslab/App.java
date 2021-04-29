package org.lavlad.wslab;

import org.lavlad.wslab.dataaccess2.BookRepository;
import org.lavlad.wslab.service.BookService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.Validator;
import javax.xml.ws.Endpoint;

@ComponentScan(basePackages = "org.lavlad.wslab")
@Configuration
@EnableJpaRepositories(basePackages = "org.lavlad.wslab.dataaccess2")
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(App.class);

        BookService service = applicationContext.getBean(BookService.class);

        Endpoint.publish("http://0.0.0.0:8080/wslab-server/BookWebService", service);
    }

    @Bean
    public BookService getBookService(BookRepository repository, Validator validator) {
        return new BookService(repository, validator);
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager getDBTransactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
        return jpaTransactionManager;
    }

    @Bean(name = "entityManagerFactory")
    public EntityManagerFactory getEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("book");
    }

    @Bean
    public Validator getValidator() {
        return new LocalValidatorFactoryBean();
    }

}
