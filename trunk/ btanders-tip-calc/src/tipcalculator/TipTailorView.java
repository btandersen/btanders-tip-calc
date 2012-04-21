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
    private ArrayList<String> guestList = null;
    private ArrayList<Integer> guestRatings = null;
    private ArrayList<Double> guestTips = null;

    private TipTailorView()
    {
        //
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
        this.guestList = bill.guestList;
        this.guestRatings = bill.guestRatings;
        this.guestTips = bill.guestTips;
    }
}
