package com.crowdar;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import lippia.web.services.APIManagementService;
import lippia.web.services.WorkspaceService;

public class Hooks {

    @Before(value = "@SetupEntriesForPDF")
    public void setupEntriesForPDF() {
        APIManagementService.setupTimeEntries();
    }

    @After(value = "@SetupEntriesForPDF")
    public void cleanUpEntriesAfterPDF() {
        APIManagementService.cleanUpEntriesAfterTest();
    }

    @After(value = "@CleanupWorkspaceCreation")
    public void cleanupCreatedWorkspace() throws InterruptedException {
        WorkspaceService.resetWorkspaceCreated();
    }

    @Before(value = "@setupProjectCreation")
    public void setupProjectCreation() {
        APIManagementService.checkForWorkspace();
        APIManagementService.checkForProjectAndDelete();
    }

    @After(value = "setupProjectCreation")
    public void cleanupProjectCreation() {
        APIManagementService.checkForProjectAndDelete();
    }

    @After(value = "@revertChangesTimeEntry")
    public void rollbackEntryEdit(){
        APIManagementService.editTimeEntry();
    }
}
