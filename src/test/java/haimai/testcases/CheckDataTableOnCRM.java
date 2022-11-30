package haimai.testcases;

import haimai.common.BaseTestParallel;
import haimai.pages.ClientPageCRM;
import org.testng.annotations.Test;

public class CheckDataTableOnCRM extends BaseTestParallel {
    @Test
    public void checkDataClientPage() {

        ClientPageCRM clientPageCRM = new ClientPageCRM();
        clientPageCRM.signIn();
        clientPageCRM.openClientPage();
        clientPageCRM.selectClientGroup("Gold");
        clientPageCRM.checkSearchTableByColumn(4, "Gold");
    }
}
