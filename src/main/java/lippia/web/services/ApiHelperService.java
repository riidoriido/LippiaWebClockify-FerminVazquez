package lippia.web.services;


import com.crowdar.core.PropertyManager;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class ApiHelperService {
    public static final String baseUrl = "https://api.clockify.me/api/v1";
    public static final String apiKey = PropertyManager.getProperty("clockify.token");

    public static Response sendPostRequest(String endpoint, String body) {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .header("x-api-key", apiKey)
                .body(body)
                .post(baseUrl+endpoint)
                .then().extract().response();
    }

    public static Response sendPutRequest(String endpoint, String body) {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .header("x-api-key", apiKey)
                .body(body)
                .put(baseUrl+endpoint);
    }

    public static Response sendGetRequest(String endpoint) {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .header("x-api-key", apiKey)
                .when()
                .get(baseUrl+endpoint);
    }

    public static Response sendDeleteRequest(String endpoint) {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .header("x-api-key", apiKey)
                .delete(baseUrl+endpoint);
    }

    public static Response sendGetRequestAndSaveResponse(String endpoint) {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .header("x-api-key", apiKey)
                .when()
                .get(baseUrl+endpoint)
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

    public static void checkForProject() {
        Response projectsList = sendGetRequestAndSaveResponse("/workspaces/"+checkForWorkspace()+"/projects");
        String responseBody = projectsList.getBody().asString();
        JsonPath projectResponse = new JsonPath(responseBody);
        boolean projectExists = projectResponse.getBoolean("find { it.name == 'tpFinalProject' } != null");
        String projectID;

        if (projectExists) {
            projectID = projectResponse.getString("find { it.name == 'tpFinalProject' }.id");
            String body = "{\"archived\":true}";
            sendPutRequest("/workspaces/"+checkForWorkspace()+"/projects/"+projectID,body);
            sendDeleteRequest("/workspaces/"+checkForWorkspace()+"/projects/"+projectID);
            System.out.println("Successfully deleted project.");
        } else{
            System.out.println("Project not found.");
        }
    }

    public static void setupTimeEntries() {

    }
}
