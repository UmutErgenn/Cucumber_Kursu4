package StepDefinitions;

import Pages.LeftNav;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

import java.util.List;

public class _05_DataTableSteps {
    LeftNav ln = new LeftNav();
    @And("Click on the element in left nav")
    public void clickOnTheElementInLeftNav(DataTable elemanlar)
    {
        List<String> listElemanlar = elemanlar.asList(String.class);

        for (String eleman : listElemanlar)
        {
//            System.out.println("eleman = " + eleman);
            ln.findAndClick(eleman);
        }
    }
}
