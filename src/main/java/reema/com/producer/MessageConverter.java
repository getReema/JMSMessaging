package reema.com.producer;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import jakarta.xml.bind.JAXBException;
import reema.com.model.Person;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import java.io.StringReader;
import java.io.StringWriter;

/*
 * MessageProducer class is a service annotated with @Service.
 *  It has a constructor that takes a JmsTemplate and JAXBContext
 *  as dependencies. The sendObjectAsXml method in this class marshals
 *  the given object into XML using the JAXBContext and sends it to a
 *  JMS destination using the JmsTemplate.
 */

@Service
public class MessageConverter {

    private final JmsTemplate jmsTemplate;
    private final JAXBContext jaxbContext;
    
    @Value("${to.queue}")
    private String destination;
    

    public MessageConverter(JmsTemplate jmsTemplate, JAXBContext jaxbContext) {
        this.jmsTemplate = jmsTemplate;
        this.jaxbContext = jaxbContext;
    }

    public void personToXml(Object object) throws JAXBException, javax.xml.bind.JAXBException {
        Marshaller marshaller = jaxbContext.createMarshaller();
        StringWriter writer = new StringWriter();
        marshaller.marshal(object, writer);
        String xmlMessage = writer.toString();
        
        sendObjectAsXml(xmlMessage);
    }
    
    public void sendObjectAsXml(String xmlMessage) {
        jmsTemplate.convertAndSend(destination, xmlMessage);
    }
    
    
    /*
    extracted XML content is then parsed into a Person object using 
    the parseXmlToPerson method. The JAXBContext and Unmarshaller are
    used for this purpose.
    */
    public Person xmlToPerson(String xmlContent) throws javax.xml.bind.JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (Person) unmarshaller.unmarshal(new StringReader(xmlContent));
    }
    
    
}




/*
 * @Service public class XmlProducerService {
 * 
 * @Autowired private final JmsTemplate jmsTemplate;
 * 
 * // @Autowired public XmlProducerService(JmsTemplate jmsTemplate) {
 * this.jmsTemplate = jmsTemplate; }
 * 
 * public void sendXmlMessage(Object object) throws Exception { JAXBContext
 * jaxbContext = JAXBContext.newInstance(object.getClass()); Marshaller
 * marshaller = jaxbContext.createMarshaller(); StringWriter stringWriter = new
 * StringWriter(); marshaller.marshal(object, stringWriter); String xmlMessage =
 * stringWriter.toString(); jmsTemplate.convertAndSend("foo.bar", xmlMessage); }
 * }
 */