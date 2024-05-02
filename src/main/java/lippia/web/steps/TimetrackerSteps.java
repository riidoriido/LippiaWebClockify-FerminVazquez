package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.*;
import lippia.web.services.TimetrackerService;

public class TimetrackerSteps extends PageSteps {
    @When("the user types a (.*)$")
    public void theUserTypesTask(String inputText) {
        TimetrackerService.userTypesTask(inputText);
    }

    @And("the user completes the (.*) (.*) range$")
    public void theUserCompletesTheHourRange(String start,String end) {
        TimetrackerService.userHourRange(start,end);
    }

    @And("the user selects desired (.*)$")
    public void theUserSelectsDesiredDate(String date) {
        TimetrackerService.userPicksProjectDate(date);
    }


    @When("the user deploys the dropdown on the selected entry$")
    public void theUserDeploysTheDropdownOnTheSelectedEntry() {
        TimetrackerService.userClickDropdownProject();
    }



}
