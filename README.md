# springboot-101

## Notes

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