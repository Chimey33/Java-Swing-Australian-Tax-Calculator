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
public class BusinessTax implements TaxProfile {

    private int TFN;
    private String companyName;
    private double totalIncome;
    private double totalExpenses;
    private Address address;

    public BusinessTax(int TFN, String companyName, double totalIncome, double totalExpenses, Address address) {
        this.TFN = TFN;
        this.companyName = companyName;
        this.totalIncome = totalIncome;
        this.totalExpenses = totalExpenses;
        this.address = address;
    }

    public int getTFN() {
        return TFN;
    }

    public String getCompanyName() {
        return companyName;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public Address getAddress() {
        return address;
    }

    public void setTFN(int TFN) {
        this.TFN = TFN;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public void setTotalExpenses(double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public double calcTax() {
        return calcTax(this.getTotalIncome() - this.getTotalExpenses());
    }

    public static double calcTax(double taxableincome) {
        double taxAmount;
        double calcTaxIncome;
        calcTaxIncome = (taxableincome) * 30;
        taxAmount = (calcTaxIncome / 100);
        return taxAmount;
    }

    @Override
    public String toString() {
        return String.format("%s: %s%n%s: %s%n%s: %.2f%n%s: %.2f%n%s: %s%n",
                "TFN", this.getTaxID(),
                "Name", this.getNameOfTaxPayer(),
                "Total Income", this.getTotalIncome(),
                "Total Expenses", this.getTotalExpenses(),
                "Address", address.getAddress()
        );
    }

    @Override
    public double getPayableTax() {
        return this.calcTax();
    }

    @Override
    public String getTaxID() {

        return Integer.toString(TFN);
    }

    @Override
    public String getNameOfTaxPayer() {
        return this.companyName;
    }

}
