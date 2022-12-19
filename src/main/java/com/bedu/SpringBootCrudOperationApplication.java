package com.bedu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration.class})
public class SpringBootCrudOperationApplication 
{
    public static void main(String[] args) 
    {
        SpringApplication.run(SpringBootCrudOperationApplication.class, args);
    }
}
