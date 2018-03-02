/*  You have some text that contains your email address. You are sick of spammers, so you want to hide it. You decide
    to censor your email: to replace all characters in it with asterisks ('*') except the domain.
    Assume your email address will always be in format [username]@[domain]. You need to replace the username with
    asterisks of equal number of letters and keep the domain unchanged.
    Input
    •	The first line holds your email address.
    •	The second line holds a text where the email should be censored.
*/

package p14_CensorEmailAddress;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String email = reader.readLine();
        String[] tokens = reader.readLine().split("\\s+");

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals(email)) {
                String[] mailTokens = tokens[i].split("@");
                String username = mailTokens[0];
                String domain = mailTokens[1];

                StringBuilder sb = new StringBuilder(username.length());
                for (int j = 0; j < username.length(); j++) {
                    sb.append('*');
                }
                username = sb.toString();
                tokens[i] = username + "@" + domain;
            }
        }

        for (String token : tokens) {
            System.out.print(token + " ");
        }
    }
}

