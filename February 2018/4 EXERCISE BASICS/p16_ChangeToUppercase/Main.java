/*  We are given a text. Write a program that modifies the casing of letters to uppercase at all places in the text
    surrounded by <upcase> and </upcase> tags. Tags cannot be nested.
*/

package p16_ChangeToUppercase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        StringBuilder sb = new StringBuilder();

        int indexUpCase = input.indexOf("<upcase>");
        int indexUpCaseClose = input.indexOf("</upcase>");

        while (indexUpCase != -1) {
            sb.append(input.substring(sb.length(), indexUpCase));
            sb.append(input.substring(indexUpCase + 8, indexUpCaseClose).toUpperCase());

            input = input.replaceFirst("<upcase>", "");
            input = input.replaceFirst("</upcase>", "");

            indexUpCase = input.indexOf("<upcase>");
            indexUpCaseClose = input.indexOf("</upcase>");
        }

        if (sb.length() < input.length()) {
            sb.append(input.substring(sb.length(), input.length()));
        }

        System.out.println(sb.toString());
    }
}
