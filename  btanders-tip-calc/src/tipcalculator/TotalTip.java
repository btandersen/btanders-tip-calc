/*
 * Brandon T. Andersen
 * 1000878186
 * Spring 2012
 * CSE 460 / 598
 * Online Graduate Student
 */
package tipcalculator;

import java.text.DecimalFormat;

/**
 * TotalTip
 *
 * The TotalTip is implemented as a Singleton Worker object to simply calculate
 * the total tip for a bill.
 *
 * @author Brandon
 */
public class TotalTip
{

    // private data member
    private static TotalTip instance = null;
    private DecimalFormat currencyFormatter = null;

    // Private default constructor
    private TotalTip()
    {
        this.currencyFormatter = new DecimalFormat("#0.00");
    }

    // Method to get the instance of the class
    public static synchronized TotalTip getInstance()
    {
        if (TotalTip.instance == null)
        {
            TotalTip.instance = new TotalTip();
        }

        return TotalTip.instance;
    }

    // Method to calculate the total tip for a bill
    public Bill calcTotalTip(Bill bill)
    {
        double result = 0.0;

        if (bill.tipTailoring)
        {
            // For tip tailoring, use the individual amounts
            for (int i = 0; i < bill.numGuests; i++)
            {
                result = result + Double.parseDouble(this.currencyFormatter.format(bill.guestTips.get(i).doubleValue()));
            }
        }
        else
        {
            // Otherwise use a straight even split
            result = bill.tipPerPerson * (double) bill.numGuests;
        }

        bill.tipTotal = result;

        return bill;
    }
}
