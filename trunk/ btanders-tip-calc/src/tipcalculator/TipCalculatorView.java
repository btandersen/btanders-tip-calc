/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tipcalculator;

/**
 *
 * @author Brandon
 */
public class TipCalculatorView
{

    private static TipCalculatorView instance = null;
    private TipCalculatorDelegate session = null;
    private BillEntryView billEntryView = null;
    private TipTailorView tipTailorView = null;
    private SettingsView settingsView = null;

    private TipCalculatorView()
    {
        this.session = TipCalculatorDelegate.getInstance();
        this.billEntryView = BillEntryView.getInstance();
        this.tipTailorView = TipTailorView.getInstance();
        this.settingsView = SettingsView.getInstance();
    }

    public static synchronized TipCalculatorView getInstance()
    {
        if (TipCalculatorView.instance == null)
        {
            TipCalculatorView.instance = new TipCalculatorView();
        }

        return TipCalculatorView.instance;
    }
    
    public Bill createBill()
    {
        return this.session.createBill();
    }
    
    public Bill updateView(Bill bill)
    {
        bill = this.session.processBill(bill);
        this.billEntryView.updateView(bill);
        this.tipTailorView.updateView(bill);
        this.settingsView.updateView(bill);
        
        return bill;
    }
}
