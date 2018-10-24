/*Write a program that reads a number in hexadecimal format convert it to decimal format and prints it.*/

package p01_VariableInHexadecimalFormat;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        Integer decimalFormat = Integer.parseInt(input, 16);
        System.out.println(decimalFormat);
    }
}
