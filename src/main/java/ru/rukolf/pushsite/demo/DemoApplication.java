package ru.rukolf.pushsite.demo;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	// public static Server server;

    // @Autowired
    // public void setDatabaseCoreServiceImpl(Server server) {
    //     DemoApplication.server = server;
    // }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
