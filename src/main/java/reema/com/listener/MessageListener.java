package reema.com.listener;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.TextMessage;

import reema.com.model.Person;
import reema.com.processor.Flow;
import reema.com.processor.PersonProcessor;
import reema.com.producer.MessageConverter;


/*
listens to a JMS destination (queue) specified by ${mq.queue.name} property
When a message is received, the receiveMessage method is invoked. It checks if 
the message is of type TextMessage and then extracts the XML content from it.
*/


@Component
public class MessageListener {

	 private static final Logger log = Logger.getLogger(MessageListener.class.getName());
	
	@Autowired 
	MessageConverter producer;
	
	@Autowired 
	PersonProcessor processor;
	
	@Autowired 
	Flow flow;
    
    @JmsListener(destination = "${from.queue}")
    public void receiveMessage(Message message) throws JMSException {
    	try {
    	
    		log.info(" Recieved message ID:"+ message.getJMSMessageID()+"Correlation Id: "+message.getJMSCorrelationID());
    	
        if (message instanceof TextMessage) {
            try {
            	
            	
            	
                String xmlContent =  ((TextMessage) message).getText();
                log.info(" The xmlContent is extracted");
                
                // Parse the XML content and translate it to Java objects
                Person person= producer.xmlToPerson(xmlContent);
                log.info(" the person is parsed");
                
                
                // Process and update the Person object as needed
                person= processor.processPerson(person);
                
               
                producer.personToXml(person);
                
                log.info("sent confirmation message");
                
            } catch (Exception e) {
                // Handle any parsing or processing errors
            	log.warning(" Encountered exception");
            	log.info(e.getMessage());
            }
        }else {
        	log.info("it is not instance of TextMessage! ");
        	
        }
    	} catch (Exception ex) {
    		log.warning(ex.getMessage());
    	}
    }


    
	
	
	
	
	
	
	
    
    
    
}