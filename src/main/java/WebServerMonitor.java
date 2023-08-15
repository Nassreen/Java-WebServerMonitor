import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class WebServerMonitor {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy h:mm:ss a");
    private static final String REACHABLE_URL_MESSAGE = "reachable!";
    private static final String NOT_REACHABLE_URL_MESSAGE = " not reachable!";
    private static final String LOG_FILE_PATH = "availability_log.txt";
    public static final String MONITORING_MESSAGE = " is being monitored. Press Enter to exit the program...";
    public static final String EXIT_MESSAGE = "Exiting...";

    private static ScheduledExecutorService executorService;

    public static void startMonitoring(String urlToCheck, int intervalInSeconds) {
        executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(
                () -> checkAvailability(urlToCheck),
                0,
                intervalInSeconds,
                TimeUnit.SECONDS);
    }

    public static void stopMonitoring() {
        if (executorService != null) {
            executorService.shutdown();
        }
    }

private static void checkAvailability(String urlToCheck) {

    String fixedUrl = UserInputManager.fixUrl(urlToCheck);

    if (!UserInputManager.isValidUrl(urlToCheck)) {
        System.err.println("Invalid URL: " + fixedUrl);
        return;
    }

    try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
        HttpGet httpGet = new HttpGet(urlToCheck);
        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
            int statusCode = response.getStatusLine().getStatusCode();
            String status = (statusCode == 200) ? REACHABLE_URL_MESSAGE : NOT_REACHABLE_URL_MESSAGE;
            String logEntry = String.format("%s : %s -> %s", DATE_FORMAT.format(new Date()), fixedUrl, status);
            System.out.println(logEntry);
            writeLog(logEntry);
        }
    } catch (IOException e) {
        String logEntry = String.format("%s : %s -> %s", DATE_FORMAT.format(new Date()), fixedUrl, NOT_REACHABLE_URL_MESSAGE);
        System.err.println(logEntry);
        writeLog(logEntry);
    }
}
    private static void writeLog(String logEntry) {
        try (FileWriter writer = new FileWriter(LOG_FILE_PATH, true)) {
            writer.write(logEntry + "\n");
        } catch (IOException e) {
            System.err.println("Error writing log: " + e.getMessage());
        }
    }
}

