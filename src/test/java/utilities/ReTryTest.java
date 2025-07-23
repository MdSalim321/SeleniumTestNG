package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ReTryTest implements IRetryAnalyzer {
    int count = 0;
    int maxTry = 2;

    @Override
    public boolean retry(ITestResult result) {
        if (count < maxTry) {
            count++;
            return true;  // Retry the test
        }
        return false;  // Do not retry
    }
}

