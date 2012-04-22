/*
 * Brandon T. Andersen
 * 1000878186
 * Spring 2012
 * CSE 460 / 598
 * Online Graduate Student
 */
package tipcalculator;

import java.util.ArrayList;

/**
 * Bill Class
 *
 * The Bill acts as a Transfer Object to encapsulate and transfer data between
 * the client and service.
 *
 * @author Brandon
 */
public class Bill
{

    // All members are public since this is just a Transfer Object
    public double billAmount;
    public double deductionAmount;
    public double taxAmount;
    public double minTipPercent;
    public double maxTipPercent;
    public ArrayList<Integer> guestRatings;
    public ArrayList<Double> guestTips;
    public boolean tipTailoring;
    public boolean includeTax;
    public boolean includeDeductions;
    public int numGuests;
    public int overallRating;
    public double tipRate;
    public double tipPerPerson;
    public double subTotal;
    public double tipTotal;
    public double total;

    // Constructor to initialize the Bill to default values
    public Bill()
    {
        this.billAmount = 0.0;
        this.deductionAmount = 0.0;
        this.taxAmount = 0.0;
        this.minTipPercent = 5.0;
        this.maxTipPercent = 25.0;

        this.guestRatings = new ArrayList<Integer>();
        this.guestTips = new ArrayList<Double>();

        for (int i = 0; i < 9; i++)
        {
            this.guestRatings.add(new Integer(3));
            this.guestTips.add(new Double(0.0));
        }

        this.tipTailoring = false;
        this.includeTax = false;
        this.includeDeductions = true;

        this.tipRate = 0.0;
        this.tipPerPerson = 0.0;
        this.subTotal = 0.0;
        this.tipTotal = 0.0;
        this.total = 0.0;
    }
}
