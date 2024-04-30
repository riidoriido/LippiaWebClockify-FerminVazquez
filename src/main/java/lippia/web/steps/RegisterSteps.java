package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.*;
import lippia.web.services.RegisterService;

public class RegisterSteps extends PageSteps {

    @And("the user (.*) the ToS agreement$")
    public static void theUserUnchecksToS(String state) {
        RegisterService.termsOfUseManage(state);
    }

    @When("the user types (.*) for email$")
    public void theUserTypesForEmail(String inputText) {
        RegisterService.inputEmailRegister(inputText);
    }

    @When("the user leaves an empty email field$")
    public void theUserLeavesAnEmptyEmailField() {
        RegisterService.emptyInputEmail();
    }
}
