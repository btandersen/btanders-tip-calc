/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tipcalculator;

/**
 *
 * @author Brandon
 */
public class TipPerPerson
{

    private static TipPerPerson instance = null;

    private TipPerPerson()
    {
        //
    }

    public static synchronized TipPerPerson getInstance()
    {
        if (TipPerPerson.instance == null)
        {
            TipPerPerson.instance = new TipPerPerson();
        }

        return TipPerPerson.instance;
    }
    
    public Bill calcTipPerPerson(Bill bill)
    {
        bill.tipPerPerson = bill.subTotal * (bill.tipRate / 100.0) / bill.numGuests;
        
        return bill;
    }
}
