package io.datajek.spring.basics.movierecommendersystem.lesson1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {
    //use filter interface to select filter
    @Autowired
    @Qualifier("CF")
    private Filter filter;

    public String[] recommendMovies (String movie){
//        ContentBasedFilter filter = new ContentBasedFilter();
        System.out.println("Name of the filter is " + filter + "\n");
        String[] results = filter.getRecommendations(movie);
        return results;
    }
}
