package com.ORMTutorial.ORMAPP1.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String fullName;
    protected Customer(){}

    public Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName+" "+lastName;
    }

    //override the toString method now when customer_obj.toString()
    //method calls the below used format is used.
    @Override
    public String toString(){
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id,firstName,lastName);
    }

    public Long getId(){
        return id;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
        this.fullName = this.firstName+" "+this.lastName;

    }

    public String getFirstName()
    {
        return this.firstName;
    }


    public void setLastName(String lastName){
        this.lastName = lastName;
        this.fullName = this.firstName+" "+this.lastName;

    }

    public String getLastName(){
        return this.lastName;
    }
    public String getFullName(){
        return this.fullName;
    }
    public void setFullName(String fullName){
        this.fullName=fullName;
        String [] arr = fullName.split(" ");
        this.firstName = arr[0];
        this.lastName =  arr[1];
    }
}
