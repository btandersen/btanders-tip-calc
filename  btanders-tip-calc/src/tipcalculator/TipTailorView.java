/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tipcalculator;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author Brandon
 */
public class TipTailorView
{

    private static TipTailorView instance = null;
    private DecimalFormat currencyFormatter = null;
    private ArrayList<Integer> guestRatings = null;
    private ArrayList<Double> guestTips = null;

    private TipTailorView()
    {
        //
        this.currencyFormatter = new DecimalFormat("#0.00");
    }

    public static synchronized TipTailorView getInstance()
    {
        if (TipTailorView.instance == null)
        {
            TipTailorView.instance = new TipTailorView();
        }

        return TipTailorView.instance;
    }

    public void updateView(Bill bill)
    {
        this.guestRatings = new ArrayList<Integer>(bill.guestRatings);
        this.guestTips = new ArrayList<Double>(bill.guestTips);
    }
    
    public int getGuestRatings(int index)
    {
        return this.guestRatings.get(index).intValue();
    }
    
    public String getGuestTip(int index)
    {
        return this.currencyFormatter.format(this.guestTips.get(index));
    }
}
