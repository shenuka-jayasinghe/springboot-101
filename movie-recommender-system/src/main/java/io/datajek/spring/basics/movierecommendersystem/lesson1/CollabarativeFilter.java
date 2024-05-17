package io.datajek.spring.basics.movierecommendersystem.lesson1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component("CF")
public class CollabarativeFilter implements Filter {
    public String[] getRecommendations(String movie) {
        //logic of collaborative filter
        return new String[] {"Finding Nemo", "Ice Age", "Toy Story"};
    }
}
