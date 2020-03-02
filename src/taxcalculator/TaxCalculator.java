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
public class TaxCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Address address = new Address("211", "Liverpool avenue", "Liverpool", "Sydney", State.NSW, 2440);
        ForeignResidentTaxPayer foreign1 = new ForeignResidentTaxPayer("123567", "Matt", "Belgre", 120000, address, "England");
        ResidentTaxPayer resident1 = new ResidentTaxPayer("123567", "Matt", "Belgre", 80000, address, address.getState());
        WorkingHolidayTaxPayer holiday1 = new WorkingHolidayTaxPayer("123567", "Matt", "Belgre", 187000, address, "Japan", 56757);
        BusinessTax business1 = new BusinessTax(123567, "ThyssenKrupp", 187000, 30000, address);

//        System.out.println(foreign1.calcTax());
//        System.out.println(foreign1.getPayableTax());
//        System.out.println(foreign1.getTaxID());
//        System.out.println(foreign1.getNameOfTaxPayer());
//        System.out.println(foreign1.toString());

//        System.out.println(resident1.calcTax());
//        System.out.println(resident1.toString());
//        System.out.println(resident1.getPayableTax());
//        System.out.println(resident1.getTaxID());
//        System.out.println(resident1.getNameOfTaxPayer());

//        System.out.println(holiday1.calcTax());
//        System.out.println(holiday1.toString());
//        System.out.println(holiday1.getPayableTax());
//        System.out.println(holiday1.getTaxID());
//        System.out.println(holiday1.getNameOfTaxPayer());

//        System.out.println(business1.calcTax());
//        System.out.println(business1.toString());
//        System.out.println(business1.getPayableTax());
//        System.out.println(business1.getTaxID());
//        System.out.println(business1.getNameOfTaxPayer());

        BusinessPersonal bP = new BusinessPersonal();
    }
}






