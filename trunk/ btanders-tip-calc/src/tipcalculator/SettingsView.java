/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tipcalculator;

import java.text.DecimalFormat;

/**
 * SettingsView
 * 
 * The SettingsView is implemented as a Singleton and provides an underlying
 * view for the settings tab of the GUI.
 * @author Brandon
 */
public class SettingsView
{

    // Private data members
    private static SettingsView instance = null;
    private DecimalFormat percentFormatter = null;
    private double minTipPercent;
    private double maxTipPercent;
    private boolean includeTax;
    private boolean includeDeductions;

    // Private default constructor
    private SettingsView()
    {
        this.percentFormatter = new DecimalFormat("#0.0");
    }

    // Method to get the instance of the class
    public static synchronized SettingsView getInstance()
    {
        if (SettingsView.instance == null)
        {
            SettingsView.instance = new SettingsView();
        }

        return SettingsView.instance;
    }

    // Method to update the view
    public void updateView(Bill bill)
    {
        this.minTipPercent = bill.minTipPercent;
        this.maxTipPercent = bill.maxTipPercent;
        this.includeTax = bill.includeTax;
        this.includeDeductions = bill.includeDeductions;
    }

    // The following methods are used to access the data of the view and
    // return them in a standard format for use in a GUI
    
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
