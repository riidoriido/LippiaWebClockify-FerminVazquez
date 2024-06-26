package com.crowdar;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import lippia.web.services.APIManagementService;

public class Hooks {

    @Before(value = "@SetupEntriesForPDF")
    public void setupEntriesForPDF() {
        APIManagementService.setupTimeEntries();
    }

    @After(value = "@SetupEntriesForPDF")
    public void cleanUpEntriesAfterPDF() {
        APIManagementService.cleanUpEntriesAfterTest();
    }

    @Before(value = "@setupProjectCreation")
    public void setupProjectCreation() {
        APIManagementService.checkForWorkspace();
    }

    @After(value = "@setupProjectCreation")
    public void cleanupProjectCreation() {
        APIManagementService.checkForProjectAndDelete();
    }

    @After(value = "@revertChangesTimeEntry")
    public void rollbackEntryEdit(){
        APIManagementService.editTimeEntry();
    }
}
