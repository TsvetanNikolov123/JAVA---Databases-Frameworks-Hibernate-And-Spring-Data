package p08_1_BookLibrary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int inputCount = Integer.parseInt(reader.readLine());
        Library library = new Library("name");
        while (--inputCount >= 0) {
            String[] inputData = reader.readLine().split("\\s+");

            Book book = new Book(inputData[0], inputData[1], inputData[2], inputData[3],inputData[4],Double.parseDouble(inputData[5]));
            library.addBook(book);
        }
        System.out.println(library);
    }
}
