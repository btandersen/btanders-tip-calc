/*
 * Brandon T. Andersen
 * 1000878186
 * Spring 2012
 * CSE 460 / 598
 * Online Graduate Student
 */
package tipcalculator;

/**
 * TipCalculatorView
 * 
 * The TipCalculatorView is implemented as a Singleton and represents the view
 * for the client GUI. It maintains instances of the views for each tab of the
 * GUI and provides an interface to each underlying view. It also acts as the
 * connection to the TipCalculatorDelegate for the client.
 * 
 * @author Brandon
 */
public class TipCalculatorView
{

    // Private data members
    private static TipCalculatorView instance = null;
    // Session for the delegate maintained here
    private TipCalculatorDelegate session = null;
    // Instances of the underlying views for the GUI
    private BillEntryView billEntryView = null;
    private TipTailorView tipTailorView = null;
    private SettingsView settingsView = null;

    // Default private constructor to init the instances
    private TipCalculatorView()
    {
        this.session = TipCalculatorDelegate.getInstance();
        this.billEntryView = BillEntryView.getInstance();
        this.tipTailorView = TipTailorView.getInstance();
        this.settingsView = SettingsView.getInstance();
    }

    // Method to get the instance of the class
    public static synchronized TipCalculatorView getInstance()
    {
        if (TipCalculatorView.instance == null)
        {
            TipCalculatorView.instance = new TipCalculatorView();
        }

        return TipCalculatorView.instance;
    }

    // Interface to the delegate to get a Bill object
    public Bill createBill()
    {
        return this.session.createBill();
    }

    // Interface to the GUI to process the bill and update the views
    public Bill updateView(Bill bill)
    {
        bill = this.session.processBill(bill);
        this.billEntryView.updateView(bill);
        this.tipTailorView.updateView(bill);
        this.settingsView.updateView(bill);

        return bill;
    }

    // The following methods provide and interface to the associated underlying
    // views, allowing the GUI to get the results in the appropriate format
    
    public int getNumGuests()
    {
        return this.billEntryView.getNumGuests();
    }

    public int getOverallRating()
    {
        return this.billEntryView.getOverallRating();
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
