package lippia.web.constants;

public class TimetrackerConstants {
    public static final String TASK_INPUT = "xpath://input[@placeholder='What have you worked on?']";
    public static final String HOUR_INPUT = "xpath://time-tracker-recorder//input-time-ampm[%s]/input";
    public static final String DATE_SELECT_DROPDOWN = "xpath://time-tracker-recorder//input-single-date";
    public static final String DATE_SELECT_CALENDAR = "xpath://div[@class='calendar-table']//td[text()=%s]";
    public static final String DROPDOWN_TARGET = "xpath: //time-tracker-entry/div/div[4]/div/div[3]";

    public static final String ENTRY_LIST_INPUT_EDIT = "xpath://entry-group[1]//input[@id='667b2cb3e0efde0334f5a8f7']";
    public static final String ENTRY_LIST_PROJECT_PICKER_LABEL_EDIT ="xpath://entry-group[1]//project-picker-label";
    public static final String ENTRY_LIST_PROJECT_PICKER_NONE = "xpath://entry-group[1]//a[text()=' No project ']";
    public static final String ENTRY_LIST_BILLABLE_SWITCH = "xpath://entry-group[1]//span[text()=' $ ']";
    public static final String ENTRY_LIST_START_EDIT = "xpath://entry-group[1]//input-time-ampm[1]/input";
    public static final String ENTRY_LIST_END_EDIT = "xpath://entry-group[1]//input-time-ampm[2]/input";
    public static final String ENTRY_LIST_DATE_EDIT = "xpath://entry-group[1]//input-single-date";

}
