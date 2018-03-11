package p09_PrintFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isPrinted = false;
        char ch = 'y';
        Scanner scanner = new Scanner(System.in);
        try {
            do {
                System.out.println("Enter path to the file to print : ");
                String filePath = scanner.nextLine();
                try {
                    printFile(filePath);
                    isPrinted = true;
                } catch (FileNotFoundException e) {
                    System.out.println("File withe name \"" + filePath + " \" is not found !");
                    System.out.println("Do you want to try again ? (y or n)");
                    ch = scanner.next().toLowerCase().trim().charAt(0);
                }
            } while (!isPrinted && ch == 'y');
        } finally {
            scanner.close();
        }

        if (isPrinted) {
            System.out.println("File printed successfully !");
        }
        System.out.println("Good bye !");
    }

    private static void printFile(String fileName) throws FileNotFoundException {
        File sourceFile = new File(fileName);
        Scanner scanner = new Scanner(sourceFile);
        String line = "";
        try {
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                System.out.println(line);
            }
        } finally {
            scanner.close();
        }
    }
}
