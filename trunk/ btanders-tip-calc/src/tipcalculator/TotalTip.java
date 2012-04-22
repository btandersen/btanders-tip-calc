/*
 * Brandon T. Andersen
 * 1000878186
 * Spring 2012
 * CSE 460 / 598
 * Online Graduate Student
 */
package tipcalculator;

/**
 * TotalTip
 * 
 * The TotalTip is implemented as a Singleton Worker object to simply
 * calculate the total tip for a bill.
 * 
 * @author Brandon
 */
public class TotalTip
{

    // private data member
    private static TotalTip instance = null;

    // Private default constructor
    private TotalTip()
    {
        // nothing to do here
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

        bill.tipTotal = result;

        return bill;
    }
}
