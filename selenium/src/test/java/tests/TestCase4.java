package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import selenium_scripts.e_commerce_automation.StartAutomation;

public class TestCase4 {
    @Test(groups = {"firefoxTests"})
    @Parameters({"browser", "status"})
    public void case2(String browser, String status) {
        Assert.assertEquals(true, StartAutomation.start(browser, status));
    }
}
