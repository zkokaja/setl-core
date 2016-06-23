package com.kokaja.setl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Entry-point for command line execution of a {@link Job}.
 *
 * This takes in an argument of filename representing the Spring beans that
 * describe the {@link Job} and all its parts. It then uses an {@link Engine}
 * to execute that job.
 *
 * If no argument is given, {@code Setl} will look for a file named
 * {@code setl_beans.xml} on the classpath. The {@link Job} bean in the XML
 * must be named {@code job}.
 */
public class Setl {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {

        ApplicationContext context;

        String beansPath = (args.length > 1) ? args[0] : null;
        if (beansPath != null) {
            context = new FileSystemXmlApplicationContext(beansPath);
        }
        else {
           context = new ClassPathXmlApplicationContext("setl_beans.xml");
        }

        Job job = (Job) context.getBean("job");

        Engine engine = new Engine(job);
        engine.start();
    }
}
