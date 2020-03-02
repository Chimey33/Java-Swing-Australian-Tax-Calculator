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
public interface TaxProfile {
    public double getPayableTax();
    public String getTaxID();
    public String getNameOfTaxPayer();
    
}
