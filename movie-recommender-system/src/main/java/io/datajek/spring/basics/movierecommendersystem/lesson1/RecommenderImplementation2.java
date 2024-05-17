package io.datajek.spring.basics.movierecommendersystem.lesson1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation2 {
    private Filter filter;
    @Autowired
    @Qualifier("collaborativeFilter")
    public void setFilter(Filter filter){
        this.filter = filter;
        System.out.println("Setter method invoked...");
    }

    public String[] recommendMovies (String movie){
//        ContentBasedFilter filter = new ContentBasedFilter();
        System.out.println("Name of the filter is " + filter + "\n");
        String[] results = filter.getRecommendations(movie);
        return results;
    }
}
