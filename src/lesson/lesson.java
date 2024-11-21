package lesson;

public class lesson {
    
}


//http protocol, get, post, head, delete, etc.
    //VERB NOUN (GET /images etc.)
    //noun comes after the server (server e.g. wikipedia.com, noun being specific articles e.g /caving)
//CGI program for dynamic html generation
//3 core http properties
    //1. request response
    //2. server cannot make unsolicited requests to client. Unless server push
    //3. stateless. If client makes consecutive calls to the server, the server does not know their relation(cannot correlate 2 calls from same client) nor remember the state of previous calls
        //stateful connection is something like our shopping cart with login functionality (much more difficult to scale vertically)

//important sprinboot dependencies - Spring Boot DevTools/Spring Web/ Thymeleaf
//start spring boot application, while inside the root directory with the pom.xml
    //mvn clean spring-boot:run

//how to deploy
    //rmb to set the pom jdk to 21
    //use normal command prompt
        //finish railway side below before going down
    //railway link, to your root directory (\Desktop\NUS\coding\day11workshopssf\day11>)
    //railway up, to deploy

//on railway side
    //create railway project (empty project)
    //create service (empty service)
    //force the service to use jdk 21
        //click into service
        //variable tab
        //new variable, enter from here: NIXPACKS_JDK_VERSION
            //https://nixpacks.com/docs/providers/java
            //set the value to 21
    //re-deploy
    //go to empty services -> settings -> generate domain, test the new website
