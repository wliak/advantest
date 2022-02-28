package common;

import xoc.dta.TestMethod;
import xoc.dta.binning.IBinTable;
import xoc.dta.binning.IBinning.Color;
import xoc.dta.binning.IBinning.ResultType;

/**
 * Defines the bins when the PreBind testflow is executed.
 * If you use a test table, you do not need to define bins in your test methods.
 *
 * @see "Test table concept in TDC (Topic 249089)"
 * @see "Binning concept in TDC (Topic 256361)"
 */
public class DefineBins extends TestMethod {

    @Override
    public void execute() {
        IBinTable binTable = context.binning().binTable();
        binTable.clear();

        binTable.addHardBin(1, "passed", ResultType.PASS);
        binTable.addSoftBin(1, 1, "passed", ResultType.PASS, 0, Color.GREEN);

        binTable.addHardBin(2, "failed", ResultType.FAIL);
        binTable.addSoftBin(2, 2, "failed", ResultType.FAIL, 0, Color.RED);
    }
}
