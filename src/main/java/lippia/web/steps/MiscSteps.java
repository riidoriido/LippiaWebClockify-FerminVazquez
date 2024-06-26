package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.*;
import lippia.web.services.MiscService;
import lippia.web.services.TimetrackerService;

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
    public void theUserClicksOnExport() throws InterruptedException {
        MiscService.clickExport();
    }

    @When("the user clicks on Save as PDF")
    public void theUserClicksOnSaveAsPDF() {
        MiscService.clickSaveAsPDF();
    }

    @Then("the app shows a Loading popup and the file is downloaded")
    public void theAppShowsALoadingPopupAndTheFileIsDownloaded() throws InterruptedException {
        MiscService.verifyLoaderPresence();
    }

    @When("the user types (.*) over task description$")
    public void theUserTypesTaskOverTaskDescription(String task) {
        TimetrackerService.editProjectDescription(task);
    }

    @And("the user clicks on the project picker")
    public void theUserClicksOnTheProjectPicker() {
    TimetrackerService.editProjectPicker();
    }

    @And("the user clicks on 'No project'")
    public void theUserClicksOn() {
        TimetrackerService.pickNullProject();
    }
    @And("the user clicks on the $ icon")
    public void theUserClicksOnThe$Icon() {
        TimetrackerService.toggleBillableEdit();
    }
    @And("the user edits the (.*) (.*) range$")
    public void theUserEditsTheStartEndRange(String start,String end) {
        TimetrackerService.editHourRange(start, end);
    }

    @And("the user selects new (.*)$")
    public void theUserSelectsNewDate(String date) {
        TimetrackerService.editTaskDate(date);
    }


}
