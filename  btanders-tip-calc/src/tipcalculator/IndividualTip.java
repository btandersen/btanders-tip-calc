/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tipcalculator;

/**
 *
 * @author Brandon
 */
public class IndividualTip
{

    private static IndividualTip instance = null;

    private IndividualTip()
    {
        //
    }

    public static synchronized IndividualTip getInstance()
    {
        if (IndividualTip.instance == null)
        {
            IndividualTip.instance = new IndividualTip();
        }

        return IndividualTip.instance;
    }

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
