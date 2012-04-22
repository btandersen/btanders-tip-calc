/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tipcalculator;

/**
 * TipCalculatorDelegate
 *
 * The TipCalculatorDelegate acts as a Business Delegate for between the client
 * and the Session Facade (the TipCalculatorSession). It is implemented as a
 * Singleton.
 * 
 * @author Brandon
 */
public class TipCalculatorDelegate
{

    // Private data members
    private static TipCalculatorDelegate instance = null;
    private TipCalculatorSession session;

    // Private default constructor to prevent a default public one and
    // to initialize the TipCalculatorSession
    private TipCalculatorDelegate()
    {
        this.session = TipCalculatorSession.getInstance();
    }

    // Method to get an instance of the TipCalculatorDelegate
    public static synchronized TipCalculatorDelegate getInstance()
    {
        if (TipCalculatorDelegate.instance == null)
        {
            TipCalculatorDelegate.instance = new TipCalculatorDelegate();
        }

        return TipCalculatorDelegate.instance;
    }

    // Method to create a new bill
    public Bill createBill()
    {
        return new Bill();
    }

    // Method to process a bill by passing the Bill object to the session facade
    public Bill processBill(Bill bill)
    {
        return this.session.processBill(bill);
    }
}
