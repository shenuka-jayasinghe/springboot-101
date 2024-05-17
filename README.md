# springboot-101

## Notes


## Spring

Spring is a dependency inversion framework for Java.

It implements the concept of 'Beans' and Annotation to give flexibility to the user to invert dependency in OOP.

Any class that ```inherits``` methods from another class, is tightly copuled to and dependent on that class. There are many cases in writing software where it is necessary to invert dependencies and make them losely coupled.

### 1. Without Beans

Without Beans, a dependency can simply be inverted by instead of ```inheriting``` a class, we can abastract the contracts of the class with another using an interface. Then the super class can inject any child it wants without being tightly coupled to it.

for example;
![dependency-injections drawio](https://github.com/shenuka-jayasinghe/springboot-101/assets/137282472/8566600f-1898-4f58-b861-624540b73503)

This can be implemented by running 
```java
public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(MovieRecommenderSystemApplication.class, args);
		RecommenderImplementation recommender = new RecommenderImplmentation(new CollaborativeFilter);
		String[] result = recommender.recommendMovies("Finding Dory");
		System.out.println(Arrays.toString(result));
	}
```

here:
```java
RecommenderImplementation recommender = new RecommenderImplmentation(new CollaborativeFilter);
```
OR
```java
RecommenderImplementation recommender = new RecommenderImplmentation(new ContentBasedFilter);
```
can be injected with lose coupling, thanks to dependency inversion.

### 2. With Beans

A Bean is annoted by the ```@Compenent``` annotation. A Bean is connected to another Bean via the ```@Autowired``` annotation. In this chain, there can only 2 Beans between the wiring (there are many forms of configuration).

```Parent Class``` <=== ```Interface``` ==```Abstracted Child Class```

```@Component``` <===```@Autowired```== ```@Component```

#### Configuration forms
1. If there are many abstracted child classes (Beans with the ```@Component``` annotation), the ```@Primary``` annotation will priorotise one of them
2. Autowiring by name
3. Giving the ```@Qualifier``` annotation to the ```@Autowired``` parent Bean like the example above

If many Beans 



We can invert dependency without a constructor of the super class like so.

## Spring Boot



### 1. Initialize Spring boot

From [Spring Initializer](start.spring.io)

Java 17 in tutorial (but I use Java 11)

### Hello World Spring Boot application

Create JavaClass: HelloWorldController

```Java
@RestController
public class HelloWorldController{

    @GetMapping(path = "/hello")
    public String helloWorld(){
        return "Hello World!";
    }
}

```

## Maven 

Maven is a build tool that can be used in the cli. You can install mvn locally or run it via the wrapper ```mvnw``` in the root directory of the spring boot application.

```
./mvnw [options] [<goal(s)>] [<phase(s)>]
```

### Options

#### clean

remove temp direcotries and files

#### default

Where the most useful goals live

```compile```,```test```,```package```,```verify```

If you want to run all, run ```verify```.

```test``` runs compiler, then test.

#### site

Where documentation lives


can also run the app via springboot application via the maven plugin
```
./mvnw spring-boot:run
```
