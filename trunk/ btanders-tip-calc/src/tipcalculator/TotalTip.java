/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tipcalculator;

/**
 *
 * @author Brandon
 */
public class TotalTip
{

    private static TotalTip instance = null;

    private TotalTip()
    {
        //
    }

    public static synchronized TotalTip getInstance()
    {
        if (TotalTip.instance == null)
        {
            TotalTip.instance = new TotalTip();
        }

        return TotalTip.instance;
    }

    public Bill calcTotalTip(Bill bill)
    {
        double result = 0;

        if (bill.tipTailoring)
        {
            // For tip tailoring, use the individual amounts
            for (int i = 0; i < bill.numGuests; i++)
            {
                result = result + bill.guestTips.get(i).doubleValue();
            }
        }
        else
        {
            // Otherwise use a straight even split
            result = bill.tipPerPerson * bill.numGuests;
        }

        bill.tipTotal =  result;

        return bill;
    }
}
