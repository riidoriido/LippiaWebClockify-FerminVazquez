package lippia.web.services;

import com.crowdar.core.actions.WebActionManager;
import lippia.web.constants.TimetrackerConstants;

public class TimetrackerService {
    public static void userTypesTask(String inputText) {
        String append = String.valueOf(Math.random()*10).replace(".","1");
        int maxLength = 5;
        String taskName = inputText + append.substring(0, Math.min(append.length(), maxLength));
        WebActionManager.setInput(TimetrackerConstants.TASK_INPUT,taskName);
    }

    public static void userTypesDuration(String inputText) {
        WebActionManager.getElement(TimetrackerConstants.DURATION_INPUT).click();
        WebActionManager.setInput(TimetrackerConstants.DURATION_INPUT,inputText);
    }

    public static void userClicksProjectsTab() {
        WebActionManager.click(TimetrackerConstants.PROJECTS_TAB,false);
    }

    public static void userClickDropdownProject() {
        String taskState = WebActionManager.getText(TimetrackerConstants.TASK_INPUT);
        if (!(taskState.equals(" "))) {
            WebActionManager.waitClickable(TimetrackerConstants.DROPDOWN_TARGET);
            WebActionManager.click(TimetrackerConstants.DROPDOWN_TARGET,false);
        }
    }
}
