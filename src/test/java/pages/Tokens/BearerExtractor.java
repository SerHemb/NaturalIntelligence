package pages.Tokens;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static pages.Tokens.NetworkLogs.bearerToken;
public class BearerExtractor {
    public static void bearerFinder() {
        String pattern = "Bearer\\s([^,]+),";
        List<String> matches = extractBearerTokens(bearerToken, pattern);

        System.out.println(bearerToken);

        if (matches.isEmpty()) {
            System.out.println("No Bearer tokens found in the text.");
        } else {
            for (String match : matches) {
                System.out.println(match);
            }
        }
    }
    public static List<String> extractBearerTokens(String text, String pattern) {
        List<String> matches = new ArrayList<>();
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(text);

        while (matcher.find()) {
            String match = matcher.group(1); // Extract the captured group
            matches.add(match);
        }

        return matches;
    }

}
