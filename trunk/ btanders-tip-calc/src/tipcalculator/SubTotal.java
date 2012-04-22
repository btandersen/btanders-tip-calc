/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tipcalculator;

/**
 * SubTotal
 * 
 * The SubTotal is implemented as a Singleton Worker object that simply
 * calculates the bill subtotal given a bill.
 * 
 * @author Brandon
 */
public class SubTotal
{

    // Private instances
    private static SubTotal instance = null;

    // Default private constructor to prevent public default
    private SubTotal()
    {
        // nothing to do here...
    }

    // Method to get the instance of the class
    public static synchronized SubTotal getInstance()
    {
        if (SubTotal.instance == null)
        {
            SubTotal.instance = new SubTotal();
        }

        return SubTotal.instance;
    }

    // Method to calculate the subtotal for a bill
    public Bill calcSubTotal(Bill bill)
    {
        double result = bill.billAmount;

        if (bill.includeTax)
        {
            result = result + bill.taxAmount;
        }

        if (bill.includeDeductions)
        {
            result = result - bill.deductionAmount;
        }

        bill.subTotal = result;

        return bill;
    }
}
