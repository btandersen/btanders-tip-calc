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

    public String getBillAmount()
    {
        return this.billEntryView.getBillAmount();
    }

    public String getDeductionAmount()
    {
        return this.billEntryView.getDeductionAmount();
    }

    public String getTaxAmount()
    {
        return this.billEntryView.getTaxAmount();
    }

    public String getTipRate()
    {
        return this.billEntryView.getTipRate();
    }

    public String getTipPerPerson()
    {
        return this.billEntryView.getTipPerPerson();
    }

    public String getTipTotal()
    {
        return this.billEntryView.getTipTotal();
    }

    public String getTotal()
    {
        return this.billEntryView.getTotal();
    }

    public boolean getTipTailoring()
    {
        return this.billEntryView.getTipTailoring();
    }

    public int getGuestRatings(int index)
    {
        return this.tipTailorView.getGuestRatings(index);
    }

    public String getGuestTip(int index)
    {
        return this.tipTailorView.getGuestTip(index);
    }
    
    public String getMinTipPercent()
    {
        return this.settingsView.getMinTipPercent();
    }
    
    public String getMaxTipPercent()
    {
        return this.settingsView.getMaxTipPercent();
    }
    
    public boolean getIncludeTax()
    {
        return this.settingsView.getIncludeTax();
    }
    
    public boolean getIncludeDeductions()
    {
        return this.settingsView.getIncludeDeductions();
    }
}
