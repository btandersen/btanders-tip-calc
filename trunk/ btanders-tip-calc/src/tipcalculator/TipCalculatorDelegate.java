/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tipcalculator;

/**
 * TipCalculatorDelegate
 * 
 * @author Brandon
 */
public class TipCalculatorDelegate
{
    private static TipCalculatorDelegate instance = null;
    private TipCalculatorSession session;
    
    private TipCalculatorDelegate()
    {
        this.session = TipCalculatorSession.getInstance();
    }
    
    public static synchronized TipCalculatorDelegate getInstance()
    {
        if (TipCalculatorDelegate.instance == null)
        {
            TipCalculatorDelegate.instance = new TipCalculatorDelegate();
        }

        return TipCalculatorDelegate.instance;
    }
    
    public Bill createBill()
    {
        return new Bill();
    }
    
    public Bill processBill(Bill bill)
    {
        return this.session.processBill(bill);
    }
}
