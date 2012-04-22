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
 * BillEntryView
 *
 * The BillEntryView is implemented as a Singleton and provides an underlying
 * view for the bill entry tab of the GUI.
 *
 * @author Brandon
 */
public class BillEntryView
{

    // Private data memebers
    private static BillEntryView instance = null;
    private DecimalFormat currencyFormatter = null;
    private DecimalFormat percentFormatter = null;
    private int numGuests;
    private int overallRating;
    private double billAmount;
    private double deductionAmount;
    private double taxAmount;
    private double tipRate;
    private double tipPerPerson;
    private double subTotal;
    private double tipTotal;
    private double total;
    private boolean tipTailoring;

    // Private default constructor
    private BillEntryView()
    {
        this.currencyFormatter = new DecimalFormat("#0.00");
        this.percentFormatter = new DecimalFormat("#0.0");
    }

    // Method to get the instance of the class
    public static synchronized BillEntryView getInstance()
    {
        if (BillEntryView.instance == null)
        {
            BillEntryView.instance = new BillEntryView();
        }

        return BillEntryView.instance;
    }

    // Method to update the view
    public void updateView(Bill bill)
    {
        this.numGuests = bill.numGuests;
        this.overallRating = bill.overallRating;
        this.billAmount = bill.billAmount;
        this.deductionAmount = bill.deductionAmount;
        this.taxAmount = bill.taxAmount;
        this.tipRate = bill.tipRate;
        this.tipPerPerson = bill.tipPerPerson;
        this.subTotal = bill.subTotal;
        this.tipTotal = bill.tipTotal;
        this.total = bill.total;
        this.tipTailoring = bill.tipTailoring;
    }

    // The following methods are used to access the data of the view and
    // return them in a standard format for use in a GUI
    public int getNumGuests()
    {
        return this.numGuests;
    }

    public int getOverallRating()
    {
        return this.overallRating;
    }

    public String getBillAmount()
    {
        return this.currencyFormatter.format(this.billAmount);
    }

    public String getDeductionAmount()
    {
        return this.currencyFormatter.format(this.deductionAmount);
    }

    public String getTaxAmount()
    {
        return this.currencyFormatter.format(this.taxAmount);
    }

    public String getTipRate()
    {
        return this.percentFormatter.format(this.tipRate);
    }

    public String getTipPerPerson()
    {
        return this.currencyFormatter.format(this.tipPerPerson);
    }

    public String getTipTotal()
    {
        return this.currencyFormatter.format(this.tipTotal);
    }

    public String getTotal()
    {
        return this.currencyFormatter.format(this.total);
    }

    public boolean getTipTailoring()
    {
        return this.tipTailoring;
    }
}
