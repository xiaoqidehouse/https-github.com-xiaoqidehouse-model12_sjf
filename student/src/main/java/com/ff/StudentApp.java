package com.ff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class StudentApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(StudentApp.class, args);
        System.out.println( "Hello World!" );
    }
}
