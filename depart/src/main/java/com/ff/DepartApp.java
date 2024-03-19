package com.ff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class DepartApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(DepartApp.class, args);
        System.out.println( "Hello World!" );
    }
}
