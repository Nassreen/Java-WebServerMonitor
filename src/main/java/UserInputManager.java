import java.util.Scanner;

public class UserInputManager {
    private static final String USER_INPUT_MESSAGE = "Geben Sie die zu überwachende URL ein: ";
    private static final String INVALID_URL_MESSAGE = "Ungültiges URL-Format. Bitte geben Sie eine gültige URL ein. Beispiel Format: https://example.com oder www.example.com";

    // fix a URL by adding 'http://' if it doesn't start with a valid protocol
    public static String fixUrl(String urlString) {
        if (!urlString.toLowerCase().startsWith("https://") && !urlString.toLowerCase().startsWith("http://")) {
            return "http://" + urlString;
        } else {
            return urlString;
        }
    }

     //check if a given URL has a valid format
    public static boolean isValidUrl(String urlString) {
        String lowerCaseUrl = urlString.toLowerCase();
        return lowerCaseUrl.startsWith("http://") ||
                lowerCaseUrl.startsWith("https://") ||
                lowerCaseUrl.startsWith("http://www.") ||
                lowerCaseUrl.startsWith("https://www.") ||
                lowerCaseUrl.startsWith("www.");
    }

       //get a valid user-provided URL using a Scanner object
    public static String getUserUrl(Scanner scanner) {
        while (true) {
            System.out.print(USER_INPUT_MESSAGE);
            String urlToCheck = scanner.nextLine();
            String fixedUrl = fixUrl(urlToCheck); // Fix the URL first

            if (!isValidUrl(urlToCheck)) {
                System.out.println(INVALID_URL_MESSAGE); // Display invalid URL message
            } else {
                return fixedUrl; // Return the valid URL
            }
        }
    }
}

