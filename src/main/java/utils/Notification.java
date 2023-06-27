package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Notification {
    public static void send(String title, String body, String recipientToken, Date schedule) throws MalformedURLException {
        Map<String, String> headers = new HashMap<>();
        headers.put("host", "exp.host");
        headers.put("accept", "application/json");
        headers.put("accept-encoding", "gzip, deflate");
        headers.put("content-type", "application/json");

        String date = new SimpleDateFormat("YYYY-MM-DD'T'HH:mm:ss.SSSZ").format(schedule);

        String reqBody = "{" +
                "  \"to\": \"ExponentPushToken[" + recipientToken + "]\"," +
                "  \"title\":\"" + title + "\"," +
                "  \"body\": \"" + body + "\"," +
                "  \"trigger\": {" +
                "  \"time\":\"" + date + "\"" +
                "}" +
                "}";

        System.out.println(reqBody);
        System.out.println("before url");
        URL urlObject = new URL("https://exp.host/--/api/v2/push/send");
        System.out.println("passed url");
        HttpURLConnection con;
        try {
            con = (HttpURLConnection) urlObject.openConnection();
            System.out.println("opened connection");

            for (Map.Entry<String, String> entry : headers.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
                con.setRequestProperty(entry.getKey(), entry.getValue());
            }

            System.out.println("setted headers");

            try {
                con.setRequestMethod("POST");
            } catch (ProtocolException err) {
                err.printStackTrace(System.err);
            }

            System.out.println("setted method");

            con.setDoOutput(true);

            String postData = reqBody;
            System.out.println("before outputstream");
            try (OutputStream os = con.getOutputStream()) {
                os.write(postData.getBytes());
                os.flush();
            }
            System.out.println("after outputstream");

            int responseCode = con.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                    System.out.println("Reading response...");
                    String inputLine;
                    StringBuilder content = new StringBuilder();
                    while ((inputLine = in.readLine()) != null) {
                        content.append(inputLine);
                    }
                    in.close();
                    con.disconnect();
                    System.out.println("Response Body: " + content.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                try (BufferedReader errorReader = new BufferedReader(new InputStreamReader(con.getErrorStream()))) {
                    System.out.println("Reading error response...");
                    String inputLine;
                    StringBuilder errorResponse = new StringBuilder();
                    while ((inputLine = errorReader.readLine()) != null) {
                        errorResponse.append(inputLine);
                    }
                    errorReader.close();
                    con.disconnect();
                    System.out.println("Error Response: " + errorResponse.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException err) {
            err.printStackTrace(System.err);
            return;
        }
    }
}
