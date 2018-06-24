package com.semicolon.movieguide;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtils {
    public static String getHttpResponse(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        Scanner scanner = new Scanner(connection.getInputStream());
        scanner.useDelimiter("\\A");

        try {
            if (scanner.hasNext()) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            connection.disconnect();
        }
    }
}
