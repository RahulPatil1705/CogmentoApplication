package utilsLayer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerSetUp implements IRetryAnalyzer {

    private int counter = 0;
    private int maxCounter;

    // Constructor to allow customization of retry count
    public RetryAnalyzerSetUp() {
        this.maxCounter = Integer.parseInt(System.getProperty("retryCount", "3")); // Default 3 retries
    }

    @Override
    public boolean retry(ITestResult result) {
        if (counter < maxCounter) {
            counter++;
            System.out.println("Retrying test: " + result.getName() + " (Attempt " + counter + " of " + maxCounter + ")");
            return true;
        }
        return false;
    }
}
