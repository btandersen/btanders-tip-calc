/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tipcalculator;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * TipTailorView
 * 
 * The TipTailorView is implemented as a Singleton and provides an underlying
 * view for the tip tailoring tab of the GUI.
 * 
 * @author Brandon
 */
public class TipTailorView
{

    // Private data members
    private static TipTailorView instance = null;
    private DecimalFormat currencyFormatter = null;
    private ArrayList<Integer> guestRatings = null;
    private ArrayList<Double> guestTips = null;

    // Private default constructor
    private TipTailorView()
    {
        this.currencyFormatter = new DecimalFormat("#0.00");
    }

    // Method to get the instance of the class
    public static synchronized TipTailorView getInstance()
    {
        if (TipTailorView.instance == null)
        {
            TipTailorView.instance = new TipTailorView();
        }

        return TipTailorView.instance;
    }

    // Method to update the view
    public void updateView(Bill bill)
    {
        this.guestRatings = new ArrayList<Integer>(bill.guestRatings);
        this.guestTips = new ArrayList<Double>(bill.guestTips);
    }

    // The following methods are used to access the data of the view and
    // return them in a standard format for use in a GUI
    
    public int getGuestRatings(int index)
    {
        return this.guestRatings.get(index).intValue();
    }

    public String getGuestTip(int index)
    {
        return this.currencyFormatter.format(this.guestTips.get(index));
    }
}
