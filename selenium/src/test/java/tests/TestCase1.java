package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import selenium_scripts.e_commerce_automation.StartAutomation;

public class TestCase1 {
    @Test
    @Parameters({"browser", "status"})
    public void testCase1(String browser, String status) {
        Assert.assertEquals(true, StartAutomation.start(browser, status));
    }
}
