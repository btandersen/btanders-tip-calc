/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tipcalculator;

/**
 * TipPerPerson
 * 
 * The TipPerPerson is implemented as a Singleton Worker object to simply
 * calculate the tip per person for a bill.
 * 
 * @author Brandon
 */
public class TipPerPerson
{

    // Private data memeber
    private static TipPerPerson instance = null;

    // Private default constructor
    private TipPerPerson()
    {
        // nothing to do here...
    }

    // Method to get the instance of the class
    public static synchronized TipPerPerson getInstance()
    {
        if (TipPerPerson.instance == null)
        {
            TipPerPerson.instance = new TipPerPerson();
        }

        return TipPerPerson.instance;
    }

    // Method to calculate the tip per person
    public Bill calcTipPerPerson(Bill bill)
    {
        bill.tipPerPerson = bill.subTotal * (bill.tipRate / 100.0) / bill.numGuests;

        return bill;
    }
}
