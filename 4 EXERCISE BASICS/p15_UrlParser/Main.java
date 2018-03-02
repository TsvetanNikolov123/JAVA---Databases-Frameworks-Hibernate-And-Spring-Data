/*  Write a program that parses an URL given in the following format:
        [protocol]://[server]/[resource]
    The parsing extracts its parts: protocol, server and resource.
        •	The [server] part is mandatory.
        •	The [protocol] and [resource] parts are optional.
*/

package p15_UrlParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        String[] tokens = input.split("://");

        String protocol = "";
        String serverResource = "";

        if (tokens.length > 1) {
            protocol = tokens[0];
            serverResource = tokens[1];
        } else if (tokens.length == 1) {
            serverResource = tokens[0];
        }

        String[] tokensServerResources = serverResource.split("/");

        String server = "";
        String resources = "";

        if (tokensServerResources.length == 1) {
            server = tokensServerResources[0];

        } else if (tokensServerResources.length > 1) {
            server = tokensServerResources[0];

            StringBuilder sb = new StringBuilder();
            sb.append(tokensServerResources[1]);
            for (int i = 2; i < tokensServerResources.length; i++) {
                sb.append("/").append(tokensServerResources[i]);
            }
            resources = sb.toString();
        }

        System.out.printf("[protocol] = \"%s\"%n", protocol);
        System.out.printf("[server] = \"%s\"%n", server);
        System.out.printf("[resource] = \"%s\"%n", resources);
    }
}
