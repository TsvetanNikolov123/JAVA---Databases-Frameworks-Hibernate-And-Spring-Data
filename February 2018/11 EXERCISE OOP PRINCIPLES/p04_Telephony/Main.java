package p04_Telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Smartphone smartphone = new Smartphone();

        String[] numberTokens = reader.readLine().trim().split("\\s+");
        for (int i = 0; i < numberTokens.length; i++) {
            smartphone.call(numberTokens[i]);
        }

        String[] siteTokens = reader.readLine().trim().split("\\s+");
        for (int i = 0; i < siteTokens.length; i++) {
            smartphone.browsing(siteTokens[i]);
        }
    }
}
