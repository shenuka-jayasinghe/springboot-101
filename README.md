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
![dependency-injections2](https://github.com/shenuka-jayasinghe/springboot-101/assets/137282472/24a3dafb-7330-4dd1-ad1f-581b4be32c92)

4. Beans have default names. You can set a name to a Bean through the ```@Qualifier``` annotation, or use its default name, which is the same name as of the child class, but in ```camelCase```.

#### Constructor Injection

5. We can go back to using injecting the dependency through the consructor, but here it would be in the layer of our parent class.
![Screenshot from 2024-05-17 23-30-12](https://github.com/shenuka-jayasinghe/springboot-101/assets/137282472/1d0ef068-a9bf-46bb-9818-3d66394e584a)

#### Setter Injection

6. Or, we can use the _setter_ injection.


```Java
public class RecommenderImplementation2 {

	private Filter filter;
	
    public void setFilter(Filter filter) {
        this.filter = filter;
        System.out.println("Setter method invoked..");
    }
}
```
### Summary
![5609253142921216](https://github.com/shenuka-jayasinghe/springboot-101/assets/137282472/f0933824-0ad1-4109-a0e0-11f82b86a65c)


## Mixing Bean Scope

When a bean is annotated via the ```@Component``` annotation it is a ```Singleton``` Bean (different term to the Gang of Four 'Singleton'). Which means you cannot create a new instance of it since any copy will be in the same allocated memory (Similar to a shallow copy of an object in JS). You can change this scope by making it a ```Prototype``` which makes makes a different reference in memory (similar to a deep copy of an object in JS). You can do this by giving the following annotations:
```Java
@Component
@Scope(value = "prototype")
```
or
```Java
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,
```
In Spring, by default, when a ```Singleton``` is Autowired to a ```Prototype```, the Prototype will act as a Singelton.

![coupled-protoype](https://github.com/shenuka-jayasinghe/springboot-101/assets/137282472/4db47dae-9d1c-4d32-81e9-80b3084ae83c)

You can work around this, by adding a proxy, which lets us achieve the desired effect. Proxy definitions are added to the @Scope annotations like so;
```Java
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
```





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
