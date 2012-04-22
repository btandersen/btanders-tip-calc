/*
 * Brandon T. Andersen
 * 1000878186
 * Spring 2012
 * CSE 460 / 598
 * Online Graduate Student
 */
package tipcalculator;

/**
 * TipRate
 *
 * The TipRate is implemented as a Singleton Worker object that simply
 * calculates the tip rate given a Bill object.
 *
 * @author Brandon
 */
public class TipRate
{

    // Private instances
    private static TipRate instance = null;

    // Default private constructor to prevent public default
    private TipRate()
    {
        // nothing to do here...
    }

    // Method to get the instance of the class
    public static synchronized TipRate getInstance()
    {
        if (TipRate.instance == null)
        {
            TipRate.instance = new TipRate();
        }

        return TipRate.instance;
    }

    // Calculate the tip rate given a bill
    public Bill calcTipRate(Bill bill)
    {
        // If tailoring is enabled...
        if (bill.tipTailoring)
        {
            double result = 0.0;

            int count = 0;

            // find out how many of the guest want to tip (i.e. their rating is not zero)
            for (int i = 0; i < bill.numGuests; i++)
            {
                if (bill.guestRatings.get(i).intValue() != 0)
                {
                    count++;
                }
            }

            // From the users who do want to tip, determine the weighted tip rate
            if (count != 0)
            {
                for (int i = 0; i < bill.numGuests; i++)
                {
                    double individualTipRate = 0.0;

                    if (bill.guestRatings.get(i).intValue() != 0)
                    {
                        individualTipRate = ((bill.maxTipPercent - bill.minTipPercent) / 4.0) * (bill.guestRatings.get(i).intValue() - 1) + bill.minTipPercent;
                    }

                    result = result + (individualTipRate / (double) count);
                }
            }
            else
            {
                result = 0;
            }

            bill.tipRate = result;
        }
        // No tailoring...
        else
        {
            // Just calculate the tip rate using the overall rating
            bill.tipRate = ((bill.maxTipPercent - bill.minTipPercent) / 4.0) * (bill.overallRating - 1) + bill.minTipPercent;
        }

        return bill;
    }
}
