package com.example.a10120062sensor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * 10120062
 * Ahmad Sanosi
 * IF-2
 */
public class DownloadUrl {
    public String retriveUrl(String url) throws IOException {
        String urlData;
        HttpURLConnection httpURLConnection = null;
        InputStream inputStream = null;

        try {
            URL getUrl = new URL(url);
            httpURLConnection = (HttpURLConnection) getUrl.openConnection();
            httpURLConnection.connect();

            inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuilder buffer = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null){
                buffer.append(line);
            }

            urlData = buffer.toString();
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            assert inputStream != null;
            inputStream.close();
            httpURLConnection.disconnect();
        }
        return urlData;
    }
}

