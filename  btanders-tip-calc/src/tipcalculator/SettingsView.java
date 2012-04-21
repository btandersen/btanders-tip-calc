/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tipcalculator;

import java.text.DecimalFormat;

/**
 *
 * @author Brandon
 */
public class SettingsView
{

    private static SettingsView instance = null;
    private DecimalFormat percentFormatter = null;
    private double minTipPercent;
    private double maxTipPercent;
    private boolean includeTax;
    private boolean includeDeductions;

    private SettingsView()
    {
        //
        this.percentFormatter = new DecimalFormat("#0.0");
    }

    public static synchronized SettingsView getInstance()
    {
        if (SettingsView.instance == null)
        {
            SettingsView.instance = new SettingsView();
        }

        return SettingsView.instance;
    }
    
    public void updateView(Bill bill)
    {
        this.minTipPercent = bill.minTipPercent;
        this.maxTipPercent = bill.maxTipPercent;
        this.includeTax = bill.includeTax;
        this.includeDeductions = bill.includeDeductions;
    }
    
    public String getMinTipPercent()
    {
        return this.percentFormatter.format(this.minTipPercent);
    }
    
    public String getMaxTipPercent()
    {
        return this.percentFormatter.format(this.maxTipPercent);
    }
    
    public boolean getIncludeTax()
    {
        return this.includeTax;
    }
    
    public boolean getIncludeDeductions()
    {
        return this.includeDeductions;
    }
}
