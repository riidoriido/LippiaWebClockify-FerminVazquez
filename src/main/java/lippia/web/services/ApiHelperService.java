package lippia.web.services;


import com.crowdar.core.PropertyManager;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;


public class ApiHelperService {
    public static final String baseUrl = "https://api.clockify.me/api/v1";
    public static final String apiKey = PropertyManager.getProperty("clockify.token");

    public static Response sendPostRequest(String endpoint, String body) {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .header("x-api-key", apiKey)
                .body(body)
                .post(baseUrl + endpoint)
                .then().extract().response();
    }

    public static Response sendPutRequest(String endpoint, String body) {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .header("x-api-key", apiKey)
                .body(body)
                .put(baseUrl + endpoint);
    }

    public static Response sendDeleteRequest(String endpoint) {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .header("x-api-key", apiKey)
                .delete(baseUrl + endpoint);
    }

    public static Response sendDeleteRequestWithParams(String endpoint, String param, List<String> paramValues) {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .header("x-api-key", apiKey)
                .queryParam(param, paramValues)
                .delete(baseUrl + endpoint);
    }

    public static Response sendGetRequestAndSaveResponse(String endpoint) {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .header("x-api-key", apiKey)
                .when()
                .get(baseUrl + endpoint)
                .then()
                .extract()
                .response();
    }


    public static String checkForWorkspace() {
        Response workspacesList = sendGetRequestAndSaveResponse("/workspaces");
        String responseBody = workspacesList.getBody().asString();

        JsonPath workspaceResponse = new JsonPath(responseBody);
        boolean workspaceExists = workspaceResponse.getBoolean("find { it.name == 'tpFinal_AAT' } != null");
        String workspaceID;

        if (workspaceExists) {
            workspaceID = workspaceResponse.getString("find { it.name == 'tpFinal_AAT' }.id");
        } else {
            System.out.println("Workspace 'tpFinal_AAT' doesn't exist. Creating workspace.");
            String body = "{\"name\":\"tpFinal_AAT\"}";
            Response createWorkspaceResponse = sendPostRequest("/workspaces", body);
            JsonPath jsonResponse = createWorkspaceResponse.jsonPath();
            workspaceID = jsonResponse.getString("id");
            System.out.println("Created Workspace ID: " + workspaceID);
        }
        return workspaceID;
    }

    public static void checkForProjectAndDelete() {
        Response projectsList = sendGetRequestAndSaveResponse("/workspaces/" + checkForWorkspace() + "/projects");
        String responseBody = projectsList.getBody().asString();
        JsonPath projectResponse = new JsonPath(responseBody);
        boolean projectExists = projectResponse.getBoolean("find { it.name == 'tpFinalProject' } != null");
        String projectID;

        if (projectExists) {
            projectID = projectResponse.getString("find { it.name == 'tpFinalProject' }.id");
            String body = "{\"archived\":true}";
            sendPutRequest("/workspaces/" + checkForWorkspace() + "/projects/" + projectID, body);
            sendDeleteRequest("/workspaces/" + checkForWorkspace() + "/projects/" + projectID);
            System.out.println("Successfully deleted project.");
        } else {
            System.out.println("Project not found.");
        }
    }

    public static void setupTimeEntries() {
        String endpoint = "/workspaces/" + checkForWorkspace() + "/time-entries";
        String[] requestBodies = {
                "{\"billable\": true, \"description\": \"timeEntry-tpFinal\",  \"end\": \"2024-06-03T16:30:00Z\",  \"projectId\":null,  \"start\": \"2024-06-03T08:00:00Z\"}",
                "{\"billable\": true, \"description\": \"timeEntry-tpFinal\",  \"end\": \"2024-06-04T16:30:00Z\",  \"projectId\":null,  \"start\": \"2024-06-04T08:00:00Z\"}",
                "{\"billable\": true, \"description\": \"timeEntry-tpFinal\",  \"end\": \"2024-06-05T16:30:00Z\",  \"projectId\":null,  \"start\": \"2024-06-05T08:00:00Z\"}",
                "{\"billable\": true, \"description\": \"timeEntry-tpFinal\",  \"end\": \"2024-06-06T16:30:00Z\",  \"projectId\":null,  \"start\": \"2024-06-06T08:00:00Z\"}",
                "{\"billable\": true, \"description\": \"timeEntry-tpFinal\",  \"end\": \"2024-06-07T16:30:00Z\",  \"projectId\":null,  \"start\": \"2024-06-07T08:00:00Z\"}",
                "{\"billable\": true, \"description\": \"timeEntry-tpFinal\",  \"end\": \"2024-06-09T16:30:00Z\",  \"projectId\":null,  \"start\": \"2024-06-09T08:00:00Z\"}"
        };
        for (String requestBody : requestBodies) {
            sendPostRequest(endpoint, requestBody);
        }
    }

    public static void cleanUpEntriesAfterTest() {
        String endpoint = "/workspaces/" + checkForWorkspace() + "/user/65383a07205d0441c5269f46/time-entries";
        Response entriesList = sendGetRequestAndSaveResponse(endpoint);
        String responseBody = entriesList.getBody().asString();
        JsonPath entryResponse = new JsonPath(responseBody);
        boolean entriesExists = entryResponse.getBoolean("find { it.description.contains('timeEntry-tpFinal') } != null");

        if (entriesExists) {
            List<String> timeEntryIds = entryResponse.getList("findAll { it.description.contains('timeEntry-tpFinal') }.id");
            System.out.println(timeEntryIds);
            sendDeleteRequestWithParams(endpoint, "time-entry-ids", timeEntryIds);
            System.out.println("Successfully deleted the following entries: " + CommonService.parseListToString(timeEntryIds) + ".");
        } else {
            System.out.println("No entries found on workspace" + checkForWorkspace() + ".");
        }
    }
}
