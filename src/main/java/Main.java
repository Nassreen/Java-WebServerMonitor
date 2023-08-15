
        import java.util.Scanner;

        public class Main {

            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                String urlToMonitor = UserInputManager.getUserUrl(scanner);
                int intervalInSeconds = 30; // Define the interval here

                WebServerMonitor.startMonitoring(urlToMonitor, intervalInSeconds);

                System.out.println(urlToMonitor + WebServerMonitor.MONITORING_MESSAGE);
                scanner.nextLine(); // Wait for user input

                WebServerMonitor.stopMonitoring();
                System.out.println(WebServerMonitor.EXIT_MESSAGE);
            }
        }


