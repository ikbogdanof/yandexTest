package ru.yandex.requests;

import ru.yandex.constants.Constants;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class Requests {
    private static final String GET = "GET";
    private static final String POST = "POST";
    private static final int CONNECTION_TIMEOUT = 5000;
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APP_JSON = "application/json";

    public String getRequest(String urlValue) throws Exception {
        final URL url = new URL(urlValue);
        final HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod(GET);
        connection.setRequestProperty(CONTENT_TYPE, APP_JSON);
        connection.setConnectTimeout(CONNECTION_TIMEOUT);
        connection.setReadTimeout(CONNECTION_TIMEOUT);

        connection.disconnect();
        return readInputStream(connection);
    }

    public String postRequest(String urlValue, String title, String body, String userId) throws Exception {
        final URL url = new URL(urlValue);
        final HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod(POST);
        connection.setConnectTimeout(CONNECTION_TIMEOUT);
        connection.setReadTimeout(CONNECTION_TIMEOUT);

        final Map<String, String> parameters = new HashMap<>();
        parameters.put(Constants.TITLE, title);
        parameters.put(Constants.BODY, body);
        parameters.put(Constants.USER_ID, userId);

        connection.setDoOutput(true);
        final DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        out.writeBytes(getParamsString(parameters));
        out.flush();
        out.close();

        connection.disconnect();
        return readInputStream(connection);
    }

    private String readInputStream(final HttpURLConnection con) {
        try (final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;

            final StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();

        } catch (final Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    private String getParamsString(final Map<String, String> params) {
        final StringBuilder result = new StringBuilder();

        params.forEach((name, value) -> {
            try {
                result.append(URLEncoder.encode(name, "UTF-8"));
                result.append('=');
                result.append(URLEncoder.encode(value, "UTF-8"));
                result.append('&');
            } catch (final UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        });

        final String resultString = result.toString();

        return !resultString.isEmpty()
                ? resultString.substring(0, resultString.length() - 1)
                : resultString;
    }
}
