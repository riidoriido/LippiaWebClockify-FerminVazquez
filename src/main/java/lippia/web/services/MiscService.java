package lippia.web.services;

import com.crowdar.core.actions.WebActionManager;
import lippia.web.constants.MiscConstants;
import org.testng.Assert;

public class MiscService {

    public static void verifyProjectNotCreated(String projectName) {
        Assert.assertFalse(WebActionManager.isPresent(MiscConstants.PROJECTS_PROJECT_LIST,projectName));
    }

    public static void openDatePicker() throws InterruptedException {
        Thread.sleep(2000);
        WebActionManager.waitClickable(MiscConstants.REPORTS_DATE_PICKER).click();
    }

    public static void setDateRange(String date) {
        WebActionManager.waitClickable(MiscConstants.REPORTS_DATE_PICKER_RANGE,date).click();
    }

    public static void clickExport() throws InterruptedException {
        Thread.sleep(2000);
        WebActionManager.waitClickable(MiscConstants.REPORTS_EXPORT_DROPDOWN).click();
    }

    public static void clickSaveAsPDF() {
        WebActionManager.waitVisibility(MiscConstants.REPORTS_EXPORT_DROPDOWN_PDF).click();
    }

    public static void verifyLoaderPresence() throws InterruptedException {
        Assert.assertTrue(WebActionManager.isVisible(MiscConstants.REPORTS_LOADER));
        Thread.sleep(3500); //wait for download to start
    }
}
