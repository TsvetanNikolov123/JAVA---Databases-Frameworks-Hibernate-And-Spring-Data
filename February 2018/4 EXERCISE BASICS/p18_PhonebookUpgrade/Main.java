/*  Add functionality to the phonebook from the previous task to print all contacts ordered lexicographically
    when receive the command “ListAll”.*/

package p18_PhonebookUpgrade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> phoneBook = new TreeMap<>();
        String input;

        while (!"END".equals(input = reader.readLine())) {

            String[] data = input.split(" ");
            String command = data[0];

            switch (command) {
                case "A":
                    String name = data[1];
                    String number = data[2];

                    phoneBook.put(name, number);
                    break;
                case "S":
                    name = data[1];

                    if (phoneBook.containsKey(name)) {
                        number = phoneBook.get(name);
                        System.out.println(String.format("%s -> %s", name, number));
                    } else {
                        System.out.println(String.format("Contact %s does not exist.", name));
                    }
                    break;
                case "ListAll":
//                    phoneBook.forEach((key, value)
//                            ->
//                            System.out.println(String.format("%s -> %s", key, value)));
                    for (Map.Entry<String, String> entrySet : phoneBook.entrySet()) {
                        System.out.println(String.format("%s -> %s", entrySet.getKey(), entrySet.getValue()));
                    }
                    break;

            }
        }
    }
}
