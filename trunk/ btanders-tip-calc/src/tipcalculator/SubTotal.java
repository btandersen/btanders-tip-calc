/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tipcalculator;

/**
 *
 * @author Brandon
 */
public class SubTotal
{

    private static SubTotal instance = null;

    private SubTotal()
    {
        //
    }

    public static synchronized SubTotal getInstance()
    {
        if (SubTotal.instance == null)
        {
            SubTotal.instance = new SubTotal();
        }

        return SubTotal.instance;
    }

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
