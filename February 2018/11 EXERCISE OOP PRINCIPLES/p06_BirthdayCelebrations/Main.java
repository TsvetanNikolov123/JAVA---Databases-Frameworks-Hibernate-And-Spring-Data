package p06_BirthdayCelebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Identifiable> identifiables = new ArrayList<Identifiable>();
        List<Birthable> birthables = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = reader.readLine();

            if (line.equals("End")) {
                break;
            }

            String[] info = line.split("\\s+");

            switch (info[0]) {
                case "Citizen":
                    String name = info[1];
                    int age = Integer.parseInt(info[2]);
                    String id = info[3];
                    String birthday = info[4];

                    Citizen person = new CitizenImpl(id, name, age, birthday);
                    birthables.add(person);
                    identifiables.add(person);
                    break;
                case "Pet":
                    String petName = info[1];
                    String petBirthday = info[2];
                    Pet pet = new PetImpl(petName, petBirthday);
                    birthables.add(pet);
                    break;
                case "Robot":
                    String robotName = info[1];
                    String robotId = info[2];
                    Robot robot = new RobotImpl(robotId, robotName);
                    identifiables.add(robot);
                    break;
            }
        }

        String year = reader.readLine();
        for (Birthable birthable : birthables){
            if (birthable.getBirthday().endsWith(year)){
                System.out.println(birthable.getBirthday());
            }
        }
    }
}
