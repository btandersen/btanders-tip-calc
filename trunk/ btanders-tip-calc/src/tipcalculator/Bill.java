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
    
    public String status;
    
    public Bill()
    {
        this.billAmount = 0.0;
        this.deductionAmount = 0.0;
        this.taxAmount = 0.0;
        this.minTipPercent = 5.0;
        this.maxTipPercent = 25.0;
        
        this.guestList = new ArrayList<>();
        this.guestRatings = new ArrayList<>();
        this.guestTips = new ArrayList<>();
        
        this.tipTailoring = false;
        this.includeTax = false;
        this.includeDeductions = true;
        
        this.tipRate = 0.0;
        this.tipPerPerson = 0.0;
        this.subTotal = 0.0;
        this.tipTotal = 0.0;
        this.total = 0.0;
        
        this.status = "OK";
    }
}
