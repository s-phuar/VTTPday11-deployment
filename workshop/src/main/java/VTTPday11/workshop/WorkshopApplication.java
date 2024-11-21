package VTTPday11.workshop;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationArguments; //important to allow passing arguments in CLI
import org.springframework.boot.DefaultApplicationArguments; //important for setting new port number

//mvn clean spring-boot:run
	//run web app normally

//mvn clean spring-boot:run -Dserver.port=8082
	//highest possible priority for setting port number, only if we do this before set SERVER_PORT

//set SERVER_PORT=8081	
	//setting the port number via environment/terminal
	//higher priority than defaultproperties set in the main code below
	//lower priority than CLI passing with -D or -- flags

//set SERVER_PORT=
	//unsets the port

//echo %SERVER_PORT%
	//check if unset correctly

//mvn clean spring-boot:run -Dspring-boot.run.arguments="--port=8081"
	//passing port number argument as arg[0]
	//highest possible priority for setting port number, only if we do this before set SERVER_PORT

//mvn clean spring-boot:run -Dspring-boot.run.arguments="--port=8082 --logLevel=TRACE"
	//if we want to see verbose stuff
	//DEBUG, ERRO etc.



@SpringBootApplication
public class WorkshopApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(WorkshopApplication.class); //initialises a newspringapplication instance of the class

		//OG line in base maven
			// SpringApplication.run(WorkshopApplication.class, args);


		String port = "3000";	//sets a default port number
		ApplicationArguments cliOpts = new DefaultApplicationArguments(args); //initialises an ApplicationArguments object using args passed to main method, a convenient way to access CLI options

		if(cliOpts.containsOption("port")){ //check if a --portarugment is passed when starting the application through the CLI
			port = cliOpts.getOptionValues ("port").get(0); // if port is set from command line, this retrieves the value of the port and assigns to port variable
		}



		app.setDefaultProperties(
			Collections.singletonMap("server.port", port) //sets either the default or specified port as the port to use
		);

		System.out.printf("Application started on port %s\n", port);
		app.run(args); //runs the SpringApplication instance


	}

}
