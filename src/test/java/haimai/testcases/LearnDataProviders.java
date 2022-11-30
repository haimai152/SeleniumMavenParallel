package haimai.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class LearnDataProviders {
    /*
    @DataProvider(name = "data_login", parallel = true)
    public Object[][] dpMethod() {
        return new Object[][]{{"username1", "password1", 1}, {"username2", "password2", 2}};
    }

    @Test(dataProvider = "data_login")
    public void testLoginDataDrovider(String username, String password, int position) {
        System.out.println(username + " - " + password + " - " + position);
    }
     */
    @DataProvider(name = "data-provider")
    public Object[][] dpMethod(Method m) {
        switch (m.getName()) {
            case "Sum":
                return new Object[][]{{2, 3, 5}, {5, 7, 9}};
            case "Diff":
                return new Object[][]{{2, 3, -1}, {5, 7, -2}};
        }
        return null;
    }


    @Test(dataProvider = "data-provider")
    public void Sum(int a, int b, int result) {
        int sum = a + b;
        Assert.assertEquals(result, sum);
    }

    @Test(dataProvider = "data-provider")
    public void Diff(int a, int b, int result) {
        int diff = a - b;
        Assert.assertEquals(result, diff);
    }
}
