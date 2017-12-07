package org.gradle;

public class PersonTestDataBuilder {
	private String name;

    public PersonTestDataBuilder() {
        this.name = "Ceiba";
    }

    public PersonTestDataBuilder withName(String name){
    	this.name = name;
    	return this;
    }
    
    public Person build(){
    	return new Person(this.name);
    }
}
