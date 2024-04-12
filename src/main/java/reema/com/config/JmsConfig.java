package reema.com.config;

import javax.xml.bind.JAXBContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.xml.bind.JAXBException;
import reema.com.model.Person;

/*
defines a bean named jaxbContext of type JAXBContext.
This bean is responsible for Marshalling and Unmarshalling Java objects to and from XML.
*/

@Configuration
public class JmsConfig {


    @Bean
    public JAXBContext jaxbContext() throws JAXBException, javax.xml.bind.JAXBException {
        return JAXBContext.newInstance(Person.class); // Replace with your actual object class
    }


}



/*
@Configuration
public class JmsConfig {
	 
	
	 @Bean
	    public JmsListenerContainerFactory<?> jmsListenerContainerFactory(ConnectionFactory connectionFactory) {
	        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
	        factory.setConnectionFactory(connectionFactory);
	        return factory;
	    }
	
	
	@Bean
	    public ConnectionFactory connectionFactory() {
	        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
	        connectionFactory.setBrokerURL("tcp://localhost:61616"); // Replace with your broker URL
	        return new CachingConnectionFactory(connectionFactory);
	    }
	
	
    @Bean
    public UserCredentialsConnectionFactoryAdapter connectionFactoryAdapter(ConnectionFactory connectionFactory) {
        UserCredentialsConnectionFactoryAdapter adapter = new UserCredentialsConnectionFactoryAdapter();
        adapter.setTargetConnectionFactory(connectionFactory);
        adapter.setUsername("admin");
        adapter.setPassword("admin");
        return adapter;
    }

    @Bean
    public JmsTemplate jmsTemplate(UserCredentialsConnectionFactoryAdapter connectionFactoryAdapter) {
    	JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(connectionFactoryAdapter);
        return jmsTemplate;
    }
}

*/
