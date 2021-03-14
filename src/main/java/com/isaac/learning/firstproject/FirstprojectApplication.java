package com.isaac.learning.firstproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FirstprojectApplication {

	public static void main(String[] args) {
		/**
		 * Inside JVM container, spring creates a special container - Spring container
		 * Inside Spring container, spring will create different objects i.e. Spring bean
		 * 2 different scopes when you create a bean i.e;
		 * - Singleton Scope
		 * - Prototype scope
		 * Marking a class with @Component makes it a bean thereby enabling Spring to create its object in Spring container
		 * The bean is then injected into our application automatically.
		 * By default, Spring uses the 'Singleton' scope thereby creating an object only once per application lifetime.
		 * Using prototype does not create an instance of an object by default for you but rather creates it when needed
		 * We mark the class with @Scope(value="prototype") to enable the prototype scope.
		 *
		 */
		ConfigurableApplicationContext context = SpringApplication.run(FirstprojectApplication.class, args);
		Alien alien = context.getBean(Alien.class);
		alien.showObject();

		Alien alien1 = context.getBean(Alien.class);
		alien1.showObject();
	}

}
