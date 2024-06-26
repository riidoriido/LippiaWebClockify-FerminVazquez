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
        WebActionManager.click(TimetrackerConstants.DATE_SELECT_CALENDAR,date);
    }

    public static void userClickDropdownProject() {
        String taskState = WebActionManager.getText(TimetrackerConstants.TASK_INPUT);
        if (!(taskState.equals(" "))) {
            WebActionManager.waitClickable(TimetrackerConstants.DROPDOWN_TARGET);
            WebActionManager.click(TimetrackerConstants.DROPDOWN_TARGET,false);
        }
    }

    public static void editProjectDescription(String description) {
        WebActionManager.waitClickable(TimetrackerConstants.ENTRY_LIST_INPUT_EDIT).clear();
        WebActionManager.setInput(TimetrackerConstants.ENTRY_LIST_INPUT_EDIT,description);
    }

    public static void editProjectPicker() {
        WebActionManager.waitClickable(TimetrackerConstants.ENTRY_LIST_PROJECT_PICKER_LABEL_EDIT).click();
    }

    public static void pickNullProject() {
        WebActionManager.waitVisibility(TimetrackerConstants.ENTRY_LIST_PROJECT_PICKER_NONE).click();
    }


    public static void toggleBillableEdit(){
        WebActionManager.waitClickable(TimetrackerConstants.ENTRY_LIST_BILLABLE_SWITCH).click();
    }

    public static void editHourRange(String start, String end) {
        WebActionManager.setInput(TimetrackerConstants.ENTRY_LIST_START_EDIT,start);
        WebActionManager.setInput(TimetrackerConstants.ENTRY_LIST_END_EDIT,end,true,false);
    }

    public static void editTaskDate(String date) {
        WebActionManager.click(TimetrackerConstants.ENTRY_LIST_DATE_EDIT);
        WebActionManager.waitVisibility(TimetrackerConstants.DATE_SELECT_CALENDAR,date).click();
    }
}
