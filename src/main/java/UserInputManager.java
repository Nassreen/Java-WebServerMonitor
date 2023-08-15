import java.util.Scanner;

public class UserInputManager {
    private static final String USER_INPUT_MESSAGE = "Enter the URL to monitor: ";
    private static final String INVALID_URL_MESSAGE = "Invalid URL format. Please enter a valid URL. Example Format: https://google.com or www.google.com";

    public static String fixUrl(String urlString) {
        if (!urlString.toLowerCase().startsWith("https://") && !urlString.toLowerCase().startsWith("http://")) {
            return "http://" + urlString;
        } else {
            return urlString;
        }
    }
    public static boolean isValidUrl(String urlString) {
        String lowerCaseUrl = urlString.toLowerCase();
        return lowerCaseUrl.startsWith("http://") ||
                lowerCaseUrl.startsWith("https://") ||
                lowerCaseUrl.startsWith("http://www.") ||
                lowerCaseUrl.startsWith("https://www.") ||
                lowerCaseUrl.startsWith("www.");
    }
    public static String getUserUrl(Scanner scanner) {
        while (true) {
            System.out.print(USER_INPUT_MESSAGE);
            String urlToCheck = scanner.nextLine();
            String fixedUrl = fixUrl(urlToCheck); // Fix the URL first

            if (!isValidUrl(urlToCheck)) {
                System.out.println(INVALID_URL_MESSAGE);
            } else {
                return fixedUrl;
            }
        }
    }
}

