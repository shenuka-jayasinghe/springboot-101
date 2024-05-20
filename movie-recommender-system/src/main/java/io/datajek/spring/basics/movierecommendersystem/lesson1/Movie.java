package io.datajek.spring.basics.movierecommendersystem.lesson1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;


//Remove proxyMode in @Scope and run to see how Prototypes are still created as Singletons, when Prototypes are injected into Singleton Beans
public class Movie {
    //for keeping track of instances created
    private static int instances = 0;

    private int id;
    private String name;
    private String genre;
    private String producer;

    public Movie(){
        instances++;
        System.out.println("Movie constructor called");
        System.out.println("number of instances ==> " + instances);
    }

    public static int getInstances(){
        return Movie.instances;
    }
}
