package io.datajek.spring.basics.movierecommendersystem.lesson1;

public class RecommenderImplementation {
    //use filter interface to select filter
    private Filter filter;

    public RecommenderImplementation(Filter filter) {
        super();
        this.filter = filter;
    }

    public String[] recommendMovies (String movie){
//        ContentBasedFilter filter = new ContentBasedFilter();
        System.out.println("Name of the filter is " + filter + "\n");
        String[] results = filter.getRecommendations(movie);
        return results;
    }
}
