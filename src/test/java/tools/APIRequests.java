package tools;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import pages.BasePage;
import java.io.IOException;
import java.util.Optional;
import org.apache.log4j.Logger;

public class APIRequests extends BasePage {
    Logger logger = Logger.getLogger(APIRequests.class);

    public String FIFA_ID = "85858cf4-2448-44d5-8ba1-f86f27c6eb0f";
    public String SOCCER_ID = "05684792-9662-4e9f-a163-8545e5736c3d";
    public String BASKETBALL_ID = "6240f178-4735-4435-8b86-d7d7ca1b556b";
    public String ICE_HOCKEY_ID = "f6e5590a-4544-4541-b6d0-c5f3be1bd752";
    public String TENNIS_ID = "4cf5fdc6-3b69-454a-8f4b-58bf88e18d51";
    public String champID;
    public String leagueID;
    private String bearerToken;

    /** API request for league creating
     *
     * @param leagueName
     */
    public void requestToLeagueCreateAPI (String leagueName) {
        OkHttpClient client = new OkHttpClient();

        // Create JSON request body
        MediaType mediaType = MediaType.parse("application/json");
        JSONObject requestBody = new JSONObject();
        try {
            requestBody.put("sport", FIFA_ID);
            requestBody.put("name", leagueName);
            requestBody.put("subDomain", JSONObject.NULL);
            requestBody.put("mainColor", "");
            requestBody.put("accentColor", "");
            requestBody.put("isPublished", true);
            requestBody.put("description", "");
            requestBody.put("colorScheme", "light");
            requestBody.put("language", "en-US");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // Build the request
        RequestBody body = RequestBody.create(mediaType, requestBody.toString());
        Request request = new Request.Builder()
                .url("https://dev.easychamp.com/sc-standings-api/champ-leagues/")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", bearerToken)
                .build();
        // Send the request and handle the response
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                logger.info("League creation successful");
                ResponseBody responseBody = response.body();
                if (responseBody != null) {
                    String responseJson = responseBody.string();
                    // Extract the ID from the response JSON
                    JSONObject jsonResponse = new JSONObject(responseJson);
                    leagueID = jsonResponse.getString("id");
                    logger.info("League ID: " + leagueID);
                }
            } else {
                logger.info("League creation failed with status code: " + response.code());
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * API request for deleting a league
     */
    public void requestToDeleteLeague () {
        OkHttpClient client = new OkHttpClient();
        // Create JSON request body
        MediaType mediaType = MediaType.parse("application/json");
        JSONObject requestBody = new JSONObject();
        // Build the request
        RequestBody body = RequestBody.create(mediaType, requestBody.toString());
        Request request = new Request.Builder()
                .url("https://dev.easychamp.com/sc-standings-api/champ-leagues/" + leagueID)
                .delete(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", bearerToken)
                .build();
        // Send the request and handle the response
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                logger.info("League and all Competitions related with league deleted successful");
                ResponseBody responseBody = response.body();
                if (responseBody != null) {
                    String responseJson = responseBody.string();
                }
            } else {
                logger.info("League deleting failed with status code: " + response.code());
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * API request for Competition creating
     * @param competitionName
     */
    public void requestToChampCreateAPI (String competitionName) {
        OkHttpClient client = new OkHttpClient();
        // Create JSON request body
        MediaType mediaType = MediaType.parse("application/json");
        JSONObject requestBody = new JSONObject();
        try {
            requestBody.put("name", competitionName);
            requestBody.put("description", "Write Description");
            requestBody.put("champLeagueId", leagueID);
            requestBody.put("rankingCriterions", new JSONArray());
            requestBody.put("currency", "eur");

            JSONObject sanctions = new JSONObject();
            sanctions.put("isAccumulatedYellowCard", false);
            sanctions.put("isDoubleYellowCard", false);
            sanctions.put("isDirectRedCard", false);
            sanctions.put("accumulatedYellowCardQuantity", 2);
            sanctions.put("accumulatedYellowCardSanction", 1);
            sanctions.put("accumulatedYellowCardMissNext", 0);
            sanctions.put("doubleYellowCardQuantity", 0);
            sanctions.put("directRedCardQuantity", 0);
            requestBody.put("sanctions", sanctions);

            requestBody.put("alternative", "");
            requestBody.put("champSportSubType", "");
            requestBody.put("url", "");
            requestBody.put("startDate", "2023-07-08T19:11:35.405Z");
            requestBody.put("endDate", "2023-07-09T19:11:35.405Z");
            requestBody.put("teams", new JSONArray());
            requestBody.put("imageUrl", JSONObject.NULL);
            requestBody.put("periodInfos", new JSONArray());
            requestBody.put("isPublished", true);
            requestBody.put("isUserTeamsAllowed", false);
            requestBody.put("isUserPlayersAllowed", false);

            JSONObject standingsRules = new JSONObject();
            standingsRules.put("winPoints", 3);
            standingsRules.put("drawPoints", 1);
            standingsRules.put("lossPoints", 0);
            standingsRules.put("overtimeWinPoints", 2);
            standingsRules.put("overtimeLossPoints", 1);
            requestBody.put("standingsRules", standingsRules);

            requestBody.put("registrationStatus", 0);
            requestBody.put("registrationOption", 1);
            requestBody.put("registrationPlayerStatus", 0);
            requestBody.put("registrationPlayerOption", 1);
            requestBody.put("teamAchievements", new JSONArray());
            requestBody.put("playerAchievements", new JSONArray());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // Build the request
        RequestBody body = RequestBody.create(mediaType, requestBody.toString());
        Request request = new Request.Builder()
                .url("https://dev.easychamp.com/sc-standings-api/champs/")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", bearerToken)
                .build();
        // Send the request and handle the response
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                logger.info("Championship creation successful.........");
                ResponseBody responseBody = response.body();
                if (responseBody != null) {
                    String responseJson = responseBody.string();
                    // Extract the ID from the response JSON
                    JSONObject jsonResponse = new JSONObject(responseJson);
                    String id = jsonResponse.getString("id");
                    champID = id;
                    logger.info("Championship ID: " + id);
                }
            } else {
                logger.info("Champ creation failed with status code: " + response.code());
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * extracting Authorization Bearer token from Chrome devtools Network logs
     * @return
     */
    public String gettingBearerToken() {

        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(
                Optional.empty(),
                Optional.empty(),
                Optional.empty()));

        devTools.addListener(Network.requestWillBeSent(), request -> {
            org.openqa.selenium.devtools.v85.network.model.Request response = request.getRequest();
            if (response.getUrl().contains("https://dev.easychamp.com/sc-standings-api/sport-types/leagues")) {
                String bearerToken = response.getHeaders().get("Authorization").toString();
                if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
                    this.bearerToken = bearerToken;
                    logger.info("Bearer token: " + bearerToken);
                } else {
                    logger.info("Authorisation Bearer Token not found.");
                }

            }
        });
        return bearerToken;
    }
}
