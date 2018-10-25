package p06_BirthdayCelebrations;

import p06_BirthdayCelebrations.impl.Citizen;
import p06_BirthdayCelebrations.impl.Pet;
import p06_BirthdayCelebrations.impl.Robot;
import p06_BirthdayCelebrations.interfaces.Birthable;
import p06_BirthdayCelebrations.interfaces.Identable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Birthable> birthables = new LinkedList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String line;

            while (!"End".equals(line = reader.readLine().trim())) {
                String[] tokens = line.split("\\s+");

                String type = tokens[0];

                if ("Pet".equals(type)) {
                    String name = tokens[1];
                    String birthday = tokens[2];
                    Birthable pet = new Pet(name, birthday);
                    birthables.add(pet);
                } else if ("Citizen".equals(type)) {
                    String name = tokens[1];
                    int age = Integer.parseInt(tokens[2]);
                    String id = tokens[3];
                    String birthday = tokens[4];
                    Birthable citizen = new Citizen(id, name, age, birthday);
                    birthables.add(citizen);
                }
            }

            String year = reader.readLine().trim();

            birthables.stream()
                    .filter(birthable -> birthable.getBirthday().endsWith(year))
                    .forEach(birthable -> System.out.println(birthable.getBirthday()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
