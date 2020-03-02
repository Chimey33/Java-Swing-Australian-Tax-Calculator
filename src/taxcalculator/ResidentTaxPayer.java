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
public class ResidentTaxPayer extends TaxPayer{
private State state;    

    public ResidentTaxPayer(String TFN, String firstName, String lastName, double income, Address address, State state) {
        super(TFN, firstName, lastName, income, address);
        this.state = state;
    }
    
    public static double calcTax(double taxableIncome){
            double taxAmount =0;
        double calcTaxIncome;
        if(taxableIncome <= 18200){
           taxAmount = 0; 
        }else if(taxableIncome >18200 && taxableIncome <=37000 ){
            calcTaxIncome = (taxableIncome - 18200) * 19;
            taxAmount = calcTaxIncome/100;
        } else if(taxableIncome >37000 && taxableIncome <=90000 ){
            calcTaxIncome = (taxableIncome - 37000) * 32.5;
            taxAmount = (calcTaxIncome/100) + 3572;
        }else if(taxableIncome >90000 && taxableIncome <=180000 ){
            calcTaxIncome = (taxableIncome - 90000) * 37;
            taxAmount = (calcTaxIncome/100) + 20797;
        }else if(taxableIncome >180000 ){
            calcTaxIncome = (taxableIncome - 180000) * 45;
            taxAmount = (calcTaxIncome/100) + 54097;
        }
 
        return taxAmount;
    
    }
    
     @Override
public double calcTax(){
return ResidentTaxPayer.calcTax(this.getIncome());
}


    @Override
    public String getTaxID() {
        return this.getTFN();
    }
    
@Override
    public String toString(){
        return super.toString() + String.format("%s: %s%n",
                "State", this.state);
    }  
    
}
