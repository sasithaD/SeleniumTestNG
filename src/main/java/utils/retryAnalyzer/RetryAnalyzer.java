package utils.retryAnalyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import utils.TestBase;


public class RetryAnalyzer implements IRetryAnalyzer {

    public TestBase testBase;
    int counter = 0;

    @Override
    public boolean retry(ITestResult result) {
        testBase = new TestBase();
        int retryLimit = Integer.parseInt(testBase.getPropertyFileValue("retryLimit"));

        if(counter < retryLimit)
        {
            counter++;
            return true;
        }
        return false;
    }
}
