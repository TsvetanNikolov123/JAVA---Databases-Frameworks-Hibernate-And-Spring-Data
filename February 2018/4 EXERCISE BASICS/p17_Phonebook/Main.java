/*  Write a program that receives some info from the console about people and their phone numbers. Each entry
    should have just one name and one number (both of them strings).
    On each line you will receive some of the following commands:
        •	A {name} {phone} – adds entry to the phonebook. In case of trying to add a name that is already in the
            phonebook you should change the existing phone number with the new one provided.
        •	S {name} – searches for a contact by given name and prints it in format "{name} -> {number}". In case
            the contact isn't found, print "Contact {name} does not exist.".
        •	END – stop receiving more commands.
*/
package p17_Phonebook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> phoneBook = new HashMap<>();
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
            }
        }
    }
}
