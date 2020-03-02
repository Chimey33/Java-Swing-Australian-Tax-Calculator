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
public class ForeignResidentTaxPayer extends TaxPayer{
 private String countryOfOrigin;

    public ForeignResidentTaxPayer(String TFN, String firstName, String lastName, double income, Address address, String countryOfOrigin) {
        super(TFN, firstName, lastName, income, address);
        this.countryOfOrigin = countryOfOrigin;
    }

    public static double calcTax(Double taxableIncome){
        double taxAmount =0;
        double calcTaxIncome;
        
        if(taxableIncome  <=90000 ){
            calcTaxIncome = (taxableIncome) * 32.5;
            taxAmount = calcTaxIncome/100;
        }else if(taxableIncome >90000 && taxableIncome <=180000 ){
            calcTaxIncome = (taxableIncome - 90000) * 37;
            taxAmount = (calcTaxIncome/100) + 29250;
        }else if(taxableIncome >180000 ){
            calcTaxIncome = (taxableIncome - 180000) * 45;
            taxAmount = (calcTaxIncome/100) + 62550;
        }
 
        return taxAmount;
    }
    
     @Override
public double calcTax(){
return ForeignResidentTaxPayer.calcTax(this.getIncome());
}
    @Override
    public String getTaxID() {
        return this.getTFN();
    }
    
    @Override
    public String toString(){
        return super.toString() + String.format("%s: %s%n",
                "Country of Origin", this.countryOfOrigin);
    } 
}
