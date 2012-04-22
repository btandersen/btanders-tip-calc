/*
 * Brandon T. Andersen
 * 1000878186
 * Spring 2012
 * CSE 460 / 598
 * Online Graduate Student
 */
package tipcalculator;

/**
 * TipCalculatorSession
 *
 * The TipCalculatorSession is a Session Facade that provides the logic for
 * calculating a bill using various worker sessions to do the work. It is
 * implemented as a Singleton.
 *
 * @author Brandon
 */
public class TipCalculatorSession
{

    // Private members
    private static TipCalculatorSession instance = null;
    // Private Worker Objects
    private TipRate tipRate = null;
    private SubTotal subTotal = null;
    private TipPerPerson tipPerPerson = null;
    private IndividualTip individualTip = null;
    private TotalTip totalTip = null;
    private Total total = null;

    // Private default constructor to initialization and also to prevent
    // default public constructor
    private TipCalculatorSession()
    {
        // Get all the instances of the worker objects
        this.tipRate = TipRate.getInstance();
        this.subTotal = SubTotal.getInstance();
        this.tipPerPerson = TipPerPerson.getInstance();
        this.individualTip = IndividualTip.getInstance();
        this.totalTip = TotalTip.getInstance();
        this.total = Total.getInstance();
    }

    // Method to get the session instance
    public static synchronized TipCalculatorSession getInstance()
    {
        if (TipCalculatorSession.instance == null)
        {
            TipCalculatorSession.instance = new TipCalculatorSession();
        }

        return TipCalculatorSession.instance;
    }

    // Method to process a bill by calling the appropriate worker objects
    // in the correct order, then returning the calculate bill
    public Bill processBill(Bill bill)
    {
        this.tipRate.calcTipRate(bill);
        this.subTotal.calcSubTotal(bill);
        this.tipPerPerson.calcTipPerPerson(bill);
        this.individualTip.calcIndividualTip(bill);
        this.totalTip.calcTotalTip(bill);
        this.total.calcTotal(bill);
        return bill;
    }
}
