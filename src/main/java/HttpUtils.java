////import java.io.IOException;
////import java.net.MalformedURLException;
////import java.net.URL;
////import org.apache.http.HttpResponse;
////import org.apache.http.impl.client.CloseableHttpClient;
////import org.apache.http.client.methods.HttpGet;
////import org.apache.http.impl.client.HttpClients;
////
////public class HttpUtils {
////
////    public static boolean isValidUrl(String urlString) {
////        if (!urlString.toLowerCase().startsWith("http://") && !urlString.toLowerCase().startsWith("https://")) {
////            urlString = "http://" + urlString; // Add "http://" as default scheme if missing
////        }
////
////        try {
////            new URL(urlString); // Attempt to create a URL object
////            return true;
////        } catch (MalformedURLException e) {
////            return false;
////        }
////    }
////
////    public static boolean isUrlReachable(String urlString) {
////        if (!isValidUrl(urlString)) {
////            return false;
////        }
////
////        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
////            HttpGet httpGet = new HttpGet(urlString);
////            HttpResponse response = httpClient.execute(httpGet);
////
////            int statusCode = response.getStatusLine().getStatusCode();
////            return statusCode >= 200 && statusCode < 300;
////        } catch (IOException e) {
////            return false;
////        }
////    }
////}
//
//
//import org.apache.http.HttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.net.URL;
//
//
//public class HttpUtils {
//
//    public static boolean isValidUrl(String urlString) {
//        // Check for "www.", "http://", or "https://" prefixes
////        if (!urlString.toLowerCase().startsWith("http://") &&
////                !urlString.toLowerCase().startsWith("https://") &&
////                !urlString.toLowerCase().startsWith("www.")) {
////            return false;
////        }
//
//        //if (!urlString.toLowerCase().startsWith("http://") && !urlString.toLowerCase().startsWith("https://")) {
//            //urlString = "http://" + urlString; // Add "http://" as default scheme if missing
//        //}
//
//
////        try {
////            new URL(urlString); // Attempt to create a URL object
////            return true;
////        } catch (MalformedURLException e) {
////            return false;
////        }
//        try {
//            URL url = new URL(urlString); // Attempt to create a URL object
//            String protocol = url.getProtocol();
//            String host = url.getHost();
//
//            return ("http".equalsIgnoreCase(protocol) || "https".equalsIgnoreCase(protocol)) &&
//                    host != null && host.startsWith("www.");
//        } catch (MalformedURLException e) {
//            return false;
//        }
//    }
//
//
//    public static boolean isUrlReachable(String urlString) {
//        if (!isValidUrl(urlString)) {
//            return false;
//        }
//
//        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
//            HttpGet httpGet = new HttpGet(urlString);
//            HttpResponse response = httpClient.execute(httpGet);
//
//            int statusCode = response.getStatusLine().getStatusCode();
//            return statusCode >= 200 && statusCode < 300;
//        } catch (IOException e) {
//            return false;
//        }
//    }
//
//}




