package exampleTests;

import xoc.dta.TestMethod;
import xoc.dta.datatypes.MultiSiteBoolean;
import xoc.dta.measurement.IMeasurement;
import xoc.dta.testdescriptor.IFunctionalTestDescriptor;

/**
 * An example test method using test descriptor
 */
public class ExampleTestMethod extends TestMethod {

    public IMeasurement measurement;

    public IFunctionalTestDescriptor testDescriptor;

    @Override
    public void execute() {
        println("Test started");

        measurement.execute();
        MultiSiteBoolean passFail = measurement.hasPassed();

        println();

        for (int siteNumber : context.getActiveSites()) {
            if (measurement.hasPassed(siteNumber)) {
                println("Test on site " + siteNumber + ": PASSED!");
            } else {
                println("Test on site " + siteNumber + ": FAILED!");
            }
        }

        println();
        println("Test finished");
        println("=========================");

        testDescriptor.evaluate(passFail, measurement);
    }

}
