/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tipcalculator;

/**
 *
 * @author Brandon
 */
public class Total
{

    private static Total instance = null;

    private Total()
    {
        //
    }

    public static synchronized Total getInstance()
    {
        if (Total.instance == null)
        {
            Total.instance = new Total();
        }

        return Total.instance;
    }

    public Bill calcTotal(Bill bill)
    {
        bill.total = bill.billAmount - bill.deductionAmount + bill.taxAmount + bill.tipTotal;

        return bill;
    }
}
