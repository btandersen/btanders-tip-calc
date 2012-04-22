/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tipcalculator;

/**
 * IndividualTip
 * 
 * The IndividualTip is implemented as a Singleton Worker object to simply
 * calculate the individual tips for each guest given a bill.
 * 
 * @author Brandon
 */
public class IndividualTip
{

    // private data member
    private static IndividualTip instance = null;

    // Private default contructor
    private IndividualTip()
    {
        // nothing to do here...
    }

    // Method to get the instance of the class
    public static synchronized IndividualTip getInstance()
    {
        if (IndividualTip.instance == null)
        {
            IndividualTip.instance = new IndividualTip();
        }

        return IndividualTip.instance;
    }

    // Method to calculate each individual's tip from a bill
    public Bill calcIndividualTip(Bill bill)
    {
        int count = 0;

        // See how many guests don't want to tip
        for (int i = 0; i < bill.numGuests; i++)
        {
            if (bill.guestRatings.get(i).intValue() != 0)
            {
                count++;
            }
        }

        for (int i = 0; i < bill.numGuests; i++)
        {
            // If at least one person will tip, calculate the tip amount for the individual
            // based on their own tip rate
            if (count != 0)
            {
                double individualTipRate = 0.0;

                if (bill.guestRatings.get(i).intValue() != 0)
                {
                    individualTipRate = ((bill.maxTipPercent - bill.minTipPercent) / 4.0) * (bill.guestRatings.get(i).intValue() - 1) + bill.minTipPercent;
                }

                bill.guestTips.set(i, Double.valueOf((bill.subTotal * individualTipRate / 100.0) / count));
            }
            else
            {
                bill.guestTips.set(i, Double.valueOf(0));
            }
        }

        return bill;
    }
}
