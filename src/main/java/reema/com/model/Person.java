package reema.com.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {

	@XmlElement(name = "name")
    private String name;
	
	@XmlElement(name = "age")
    private int age;
	
	@XmlElement(name = "address")
    private Address personAddress;
	
	@XmlElement(name = "phoneNumber")
    private String phoneNumber;

    // Constructors, getters, and setters

    // Default constructor required by JAXB
    public Person() {}

    public Person(String name, int age, Address address, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.personAddress = address;
        this.phoneNumber = phoneNumber;
    }

 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

  
    public Address getAddress() {
        return personAddress;
    }

    public void setAddress(Address address) {
        this.personAddress = address;
    }

    //@XmlElement(nillable = true)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", personAddress=" + personAddress + ", phoneNumber="
				+ phoneNumber + "]";
	}

    
    
	
    
    
}
