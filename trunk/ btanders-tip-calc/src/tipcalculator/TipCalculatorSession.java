/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tipcalculator;

/**
 * TipCalculatorSession
 *
 * @author Brandon
 */
public class TipCalculatorSession
{

    private static TipCalculatorSession instance = null;
    private TipRate tipRate = null;
    private SubTotal subTotal = null;
    private TipPerPerson tipPerPerson = null;
    private IndividualTip individualTip = null;
    private TotalTip totalTip = null;
    private Total total = null;

    private TipCalculatorSession()
    {
        this.tipRate = TipRate.getInstance();
        this.subTotal = SubTotal.getInstance();
        this.tipPerPerson = TipPerPerson.getInstance();
        this.individualTip = IndividualTip.getInstance();
        this.totalTip = TotalTip.getInstance();
        this.total = Total.getInstance();
    }

    public static synchronized TipCalculatorSession getInstance()
    {
        if (TipCalculatorSession.instance == null)
        {
            TipCalculatorSession.instance = new TipCalculatorSession();
        }

        return TipCalculatorSession.instance;
    }
    
    public Bill processBill(Bill bill)
    {
        this.tipRate.calcTipRate(bill);
        this.subTotal.calcSubTotal(bill);
        this.tipPerPerson.calcTipPerPerson(bill);
        this.individualTip.calcIndividualTip(bill);
        this.totalTip.calcTotalTip(bill);
        this.total.calcTotal(bill);
        return bill;
    }
}
