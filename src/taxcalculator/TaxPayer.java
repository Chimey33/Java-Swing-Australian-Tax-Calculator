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
public abstract class TaxPayer implements TaxProfile {

    private String TFN;
    private String firstName;
    private String lastName;
    private double income;
    private Address address;

    public TaxPayer(String TFN, String firstName, String lastName, double income, Address address) {
        this.TFN = TFN;
        this.firstName = firstName;
        this.lastName = lastName;
        this.income = income;
        this.address = address;
    }

    public String getTFN() {
        return TFN;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getIncome() {
        return income;
    }

    public Address getAddress() {
        return address;
    }

    public void setTFN(String TFN) {
        this.TFN = TFN;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static double calcTax(Double taxAmount) {
       return 8;
    }

    public abstract double calcTax();

    @Override
    public double getPayableTax() {
        return this.calcTax();
    }

    @Override
    public abstract String getTaxID();

    @Override
    public String getNameOfTaxPayer() {
        return this.firstName + " " + this.lastName;

    }

    @Override
    public  String toString(){
        return String.format("%s: %s%n%s: %s%n%s: %.2f%n%s:  %s%n",
                "TFN", this.getTaxID(),
                "Name", this.getNameOfTaxPayer(),
                "Income", this.getIncome(),
                "Address", address.getAddress()
                
                );
    }

}
