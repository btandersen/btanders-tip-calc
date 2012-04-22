/*
 * Brandon T. Andersen
 * 1000878186
 * Spring 2012
 * CSE 460 / 598
 * Online Graduate Student
 */
package tipcalculator;

import java.text.DecimalFormat;

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
    private DecimalFormat currencyFormatter = null;

    // Private default constructor
    private TipPerPerson()
    {
        this.currencyFormatter = new DecimalFormat("#0.00");
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
        bill.tipPerPerson = Double.parseDouble(this.currencyFormatter.format(bill.subTotal * (bill.tipRate / 100.0) / (double) bill.numGuests));

        return bill;
    }
}
