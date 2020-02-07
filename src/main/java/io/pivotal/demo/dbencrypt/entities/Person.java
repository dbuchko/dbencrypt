package io.pivotal.demo.dbencrypt.entities;

import io.pivotal.demo.dbencrypt.utils.AttributeEncryptor;

import javax.persistence.*;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;
    private String lastName;

    @Convert(converter = AttributeEncryptor.class)
    private String piiData;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPiiData() {
        return piiData;
    }

    public void setPiiData(String piiData) {
        this.piiData = piiData;
    }

}