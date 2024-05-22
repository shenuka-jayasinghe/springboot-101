package io.datajek.spring.basics.movierecommendersystem.lesson1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {
    //use filter interface to select filter
    //constructor injection
    private Filter filter;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public RecommenderImplementation(@Qualifier("collaborativeFilter") Filter filter) {
        logger.info("In Recommender Implmentation setter method.. dependency injection")
        this.filter = filter;
    }

    public String[] recommendMovies (String movie){
//        ContentBasedFilter filter = new ContentBasedFilter();
        System.out.println("Name of the filter is " + filter + "\n");
        String[] results = filter.getRecommendations(movie);
        return results;
    }
}
