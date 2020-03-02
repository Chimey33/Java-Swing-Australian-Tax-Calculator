/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxcalculator;

/**
 *
 * @author matthewbelgre
 */
public class Address {
private String street_number;
private String street_name;
private String suburb;
private String city;
private State state;
private int postcode;

    public Address(String street_number, String street_name, String suburb, String city, State state, int postcode) {
        this.street_number = street_number;
        this.street_name = street_name;
        this.suburb = suburb;
        this.city = city;
        this.state = state;
        this.postcode = postcode;
    }
 public Address(){
     
 }


    public String getStreet_number() {
        return street_number;
    }

    public String getStreet_name() {
        return street_name;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getCity() {
        return city;
    }

    public State getState() {
        return state;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setStreet_number(String street_number) {
        this.street_number = street_number;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }
public String getAddress(){
    return String.format("%s",
            this.street_number + " " + this.street_name + ", " + this.suburb + ", " +
     this.city + ", " + this.state + " " + this.postcode);
    
}

     public String getCSVFile() {
        return String.format("%s",
            this.street_number + "," + this.street_name + "," + this.suburb + "," +
     this.city + "," + this.state + "," + this.postcode);
    }

}
