/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tipcalculator;

/**
 *
 * @author Brandon
 */
public class BillValidator
{

    private static BillValidator instance = null;

    private BillValidator()
    {
        //
    }

    public static synchronized BillValidator getInstance()
    {
        if (BillValidator.instance == null)
        {
            BillValidator.instance = new BillValidator();
        }

        return BillValidator.instance;
    }
    
    public Bill validateBill(Bill bill)
    {
        
        
        return bill;
    }
}
