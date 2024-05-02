package lippia.web.constants;

public class TimetrackerConstants {
    public static final String TASK_INPUT = "xpath://input[@placeholder='What have you worked on?']";
    public static final String HOUR_INPUT = "xpath://time-tracker-recorder//input-time-ampm[%s]/input";
    public static final String DATE_SELECT_DROPDOWN = "xpath: //input-single-date";
    public static final String DATE_SELECT = "xpath: //td[@class='available' and @data-title and text()=%s]";
    public static final String DROPDOWN_TARGET = "xpath: //time-tracker-entry/div/div[4]/div/div[3]";
}
