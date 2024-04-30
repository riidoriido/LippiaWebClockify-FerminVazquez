package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.*;
import lippia.web.services.TimetrackerService;

public class TimetrackerSteps extends PageSteps {
    @When("the user types a (.*)$")
    public void theUserTypesTask(String inputText) {
        TimetrackerService.userTypesTask(inputText);
    }

    @And("the user types (.*) as duration$")
    public void theUserTypesTimeAsDuration(String inputText) {
        TimetrackerService.userTypesDuration(inputText);
    }

    @When("the user deploys the dropdown on the selected entry$")
    public void theUserDeploysTheDropdownOnTheSelectedEntry() {
        TimetrackerService.userClickDropdownProject();
    }
}
