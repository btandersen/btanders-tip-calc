/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tipcalculator;

import java.util.ArrayList;

/**
 *
 * @author Brandon
 */
public class Bill
{
    public double billAmount;
    public double deductionAmount;
    public double taxAmount;
    public double minTipPercent;
    public double maxTipPercent;
    
    public ArrayList<String> guestList;
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
    
    public Bill()
    {
        
    }
}
