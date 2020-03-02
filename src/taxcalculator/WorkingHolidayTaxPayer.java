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
public class WorkingHolidayTaxPayer extends ForeignResidentTaxPayer {
    private int visaNumber;

    public WorkingHolidayTaxPayer(String TFN, String firstName, String lastName, double income, Address address, String countryOfOrigin, int visaNumber ) {
        super(TFN, firstName, lastName, income, address, countryOfOrigin);
        this.visaNumber = visaNumber;
    }
  public static double calcTax(Double taxableIncome){
        double taxAmount =0;
        double calcTaxIncome;
         if(taxableIncome  <=37000 ){
            calcTaxIncome = (taxableIncome) * 15;
            taxAmount = calcTaxIncome/100;
        } else if(taxableIncome >37000 && taxableIncome <=90000 ){
            calcTaxIncome = (taxableIncome - 37000) * 32.5;
            taxAmount = (calcTaxIncome/100) + 5550;
        }else if(taxableIncome >90000 && taxableIncome <=180000 ){
            calcTaxIncome = (taxableIncome - 90000) * 37;
            taxAmount = (calcTaxIncome/100) + 22775;
        }else if(taxableIncome >180000 ){
            calcTaxIncome = (taxableIncome - 180000) * 45;
            taxAmount = (calcTaxIncome/100) + 56075;
        }
 
        return taxAmount;
    }
  
       @Override
public double calcTax(){
return WorkingHolidayTaxPayer.calcTax(this.getIncome());
}
   


    @Override
    public String getTaxID() {
        return this.getTFN();
    }
    
 @Override
    public String toString(){
        return super.toString() + String.format("%s: %s%n",
                "Visa number", this.visaNumber
                
                
                );
    }
    
    
}
