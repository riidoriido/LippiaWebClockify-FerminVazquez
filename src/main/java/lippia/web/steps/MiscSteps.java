package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.*;
import lippia.web.services.MiscService;

public class MiscSteps extends PageSteps {


    @And("the user clicks on Range to open the Calendar")
    public void theUserClicksOnRangeToOpenTheCalendar() throws InterruptedException {
        MiscService.openDatePicker();
    }

    @And("the user sets date June {string}")
    public void theUserSetsDateJune(String date) {
        MiscService.setDateRange(date);
    }

    @And("the user clicks on Export")
    public void theUserClicksOnExport() {
        MiscService.clickExport();
    }

    @When("the user clicks on Save as PDF")
    public void theUserClicksOnSaveAsPDF() {
        MiscService.clickSaveAsPDF();
    }

    @Then("the app shows a Loading popup and the file is downloaded")
    public void theAppShowsALoadingPopupAndTheFileIsDownloaded() {
        MiscService.verifyLoaderPresence();
    }
}
