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
    private TipCalculatorSession session;
    
    public TipCalculatorDelegate()
    {
        //
    }
    
    public Bill createBill()
    {
        return new Bill();
    }
    
    public Bill processBill(Bill bill)
    {
        return bill;
    }
}
