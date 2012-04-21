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
}
