package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.*;
import lippia.web.services.CommonService;

public class ProjectsSteps extends PageSteps {

    @And("the user types (.*) on the (.*) name input field$")
    public void userTypesProjectsName(String inputText, String locator){
        CommonService.typeNewName(inputText, locator);

    }
}
