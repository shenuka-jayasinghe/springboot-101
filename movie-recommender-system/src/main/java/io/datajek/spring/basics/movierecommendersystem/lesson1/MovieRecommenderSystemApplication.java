package io.datajek.spring.basics.movierecommendersystem.lesson1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.Arrays;


@SpringBootApplication
public class MovieRecommenderSystemApplication {

//	public static void main(String[] args) {
//		ApplicationContext appContext = SpringApplication.run(MovieRecommenderSystemApplication.class, args);
//		RecommenderImplementation recommender = appContext.getBean(RecommenderImplementation.class);
//		String[] result = recommender.recommendMovies("Finding Dory");
//		System.out.println(Arrays.toString(result));
//	}

	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(MovieRecommenderSystemApplication.class, args);
		RecommenderImplementation recommender2 = new RecommenderImplementation(new CollaborativeFilter());
		String[] result = recommender2.recommendMovies("Finding Dory");
		System.out.println(Arrays.toString(result));
	}

}
