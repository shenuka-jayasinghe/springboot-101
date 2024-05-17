package io.datajek.spring.basics.movierecommendersystem.lesson1;

public class CollabarativeFilter implements Filter {
    public String[] getRecommendations(String movie) {
        //logic of collaborative filter
        return new String[] {"Finding Nemo", "Ice Age", "Toy Story"};
    }
}
