package lippia.web.services;

import com.crowdar.core.actions.WebActionManager;
import lippia.web.constants.TimetrackerConstants;

public class TimetrackerService {
    public static void userTypesTask(String inputText) {
        WebActionManager.setInput(TimetrackerConstants.TASK_INPUT,inputText+CommonService.generateRandomString(5));
    }

    public static void userHourRange(String start, String end) {
        WebActionManager.getElement(TimetrackerConstants.HOUR_INPUT,"1").click();
        WebActionManager.setInput(TimetrackerConstants.HOUR_INPUT,start,"1");
        WebActionManager.getElement(TimetrackerConstants.HOUR_INPUT,"2").click();
        WebActionManager.setInput(TimetrackerConstants.HOUR_INPUT,end,true,"2");

    }
    public static void userPicksProjectDate(String date) {
        WebActionManager.waitClickable(TimetrackerConstants.DATE_SELECT_DROPDOWN).click();
        WebActionManager.click(TimetrackerConstants.DATE_SELECT,date);
    }

    public static void userClickDropdownProject() {
        String taskState = WebActionManager.getText(TimetrackerConstants.TASK_INPUT);
        if (!(taskState.equals(" "))) {
            WebActionManager.waitClickable(TimetrackerConstants.DROPDOWN_TARGET);
            WebActionManager.click(TimetrackerConstants.DROPDOWN_TARGET,false);
        }
    }
}
