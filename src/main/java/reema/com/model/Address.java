package reema.com.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Address {

	@XmlElement(name = "street")
    private String street;
	
	@XmlElement(name = "city")
    private String city;
	
	@XmlElement(name = "state")
    private String state;
	
	@XmlElement(name = "zipCode")
    private String zipCode;

    // Constructors, getters, and setters

    // Default constructor required by JAXB
    //why ?
    public Address() {}

    public Address(String street, String city, String state, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

  
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

   
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + "]";
	}


    
    
    
    
}