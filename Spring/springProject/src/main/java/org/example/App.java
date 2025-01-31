package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); //creates the IOC Cotainer

        Student st = context.getBean(Student.class);
        st.greetStudent();
        System.out.println(st.getAge());
        System.out.println( "Hello World!" );
    }
}
