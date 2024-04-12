package reema.com.producer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import jakarta.jms.JMSException;
import jakarta.jms.Session;
import jakarta.jms.TextMessage;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
//import reema.com.model.Employee;
import reema.com.model.Person;

import java.io.StringWriter;

// not used
public class XmlMessageConverter 
//implements MessageConverter
{
	/*
	 * private JAXBContext jaxbContext;
	 * 
	 * @Autowired public XmlMessageConverter() throws JAXBException { //jaxbContext
	 * = JAXBContext.newInstance(Employee.class); jaxbContext =
	 * JAXBContext.newInstance(Person.class);
	 * 
	 * }
	 * 
	 * // @Override public jakarta.jms.Message toMessage(Object object, Session
	 * session) throws JMSException, MessageConversionException { try { Marshaller
	 * marshaller = jaxbContext.createMarshaller(); StringWriter writer = new
	 * StringWriter(); marshaller.marshal(object, writer); String xml =
	 * writer.toString(); TextMessage message = session.createTextMessage(xml);
	 * return message; } catch (JAXBException e) { throw new
	 * MessageConversionException("Error converting object to XML", e); } }
	 * 
	 * // @Override public Object fromMessage(jakarta.jms.Message message) throws
	 * JMSException, MessageConversionException { throw new
	 * UnsupportedOperationException("Conversion from XML to object is not supported"
	 * ); }
	 */
}