/*
 * Brandon T. Andersen
 * 1000878186
 * Spring 2012
 * CSE 460 / 598
 * Online Graduate Student
 */
package tipcalculator;

/**
 * Total
 *
 * The Total is implemented as a Singleton Worker object to simply calculate the
 * total for a bill.
 *
 * @author Brandon
 */
public class Total
{

    // private data memeber
    private static Total instance = null;

    // Private default constructor
    private Total()
    {
        // nothing to do here...
    }

    // Method to get the instance of the class
    public static synchronized Total getInstance()
    {
        if (Total.instance == null)
        {
            Total.instance = new Total();
        }

        return Total.instance;
    }

    // Method to calculate the total for a bill
    public Bill calcTotal(Bill bill)
    {
        bill.total = bill.subTotal + bill.tipTotal;

        return bill;
    }
}
