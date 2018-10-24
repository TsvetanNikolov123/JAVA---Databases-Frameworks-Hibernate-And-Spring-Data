package p05_BorderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Identifiable> identifiables= new ArrayList<Identifiable>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String line = reader.readLine();

            if (line.equals("End")){
                break;
            }

            String[] info = line.split("\\s+");

            if (info.length == 2){
                String name = info[0];
                String id = info[1];
                Identifiable robot = new RobotImpl(id, name);
                identifiables.add(robot);

            } else if(info.length == 3){
                String name = info[0];
                int age = Integer.parseInt(info[1]);
                String id = info[2];
                Identifiable citizen = new CitizenImpl(id,name,age);
                identifiables.add(citizen);
            }
        }

        String validId = reader.readLine();

        for (Identifiable identifiable : identifiables) {
            if(identifiable.getId().endsWith(validId)){
                System.out.println(identifiable.getId());
            }
        }
    }
}
