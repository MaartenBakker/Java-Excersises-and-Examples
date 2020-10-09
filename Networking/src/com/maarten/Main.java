package com.maarten;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.example.com");

            URLConnection urlConnection = url.openConnection();
            urlConnection.setDoOutput(true);

            urlConnection.connect();

            try (BufferedReader inputStream = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))){

                String input = "";

                while (input != null) {
                    input = inputStream.readLine();
                    System.out.println(input);
                }

            } catch (IOException e) {
                e.getMessage();
                e.printStackTrace();
            }

        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
