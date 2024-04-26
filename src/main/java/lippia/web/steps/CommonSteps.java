package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.*;
import lippia.web.services.CommonService;

public class CommonSteps extends PageSteps {
    @When("the user clicks (.*)$")
    @And("the user clicks (.*)$")
    public static void userClicks(String text, String xpath) {
        CommonService.clickLocatorWithText(text, xpath);
    }
}
