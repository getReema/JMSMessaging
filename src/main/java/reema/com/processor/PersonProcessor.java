package reema.com.processor;

import reema.com.model.Person;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

@Component
public class PersonProcessor {

	 private static final Logger log = Logger.getLogger(PersonProcessor.class.getName());

	
	public Person processPerson(Person person) {

		log.info("I'm processing Person: ");
		// simply prints the person's information
		log.info(person.toString());
		 person.setName("Reema mo");
		log.info(" the person "+ person.getName()+" is processed");
		return person;
	}
	
}
