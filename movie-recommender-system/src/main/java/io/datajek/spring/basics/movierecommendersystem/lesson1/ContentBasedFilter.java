package io.datajek.spring.basics.movierecommendersystem.lesson1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Qualifier("CBF")
public class ContentBasedFilter implements Filter {
    private static int instances = 0;

    @Autowired
    private Movie movie;

    //constructor
    public ContentBasedFilter(){
        instances++;
        System.out.println("ContentBased Filter constructor called");
        System.out.println("CBF instances ==> " + instances);
    }

    public Movie getMovie(){
        return movie;
    }

    public static int getInstances(){
        return ContentBasedFilter.instances;
    }

    public String[] getRecommendations(String movie){
        //logic of content based filter
        return new String[] {"Happy Feet", "Ice Age", "Shark Tale"};
    }
}
