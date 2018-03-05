package p03_LastDigitName;

public class Number {
    private int number;

    public Number(int number) {
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public static String englishNameOfLastDigit(int number) {
        String lastDigitName = "";
        int lastNumber = number % 10;

        switch (lastNumber) {
            case 0:
                lastDigitName = "zero";
                break;
            case 1:
                lastDigitName = "one";
                break;
            case 2:
                lastDigitName = "two";
                break;
            case 3:
                lastDigitName = "three";
                break;
            case 4:
                lastDigitName = "four";
                break;
            case 5:
                lastDigitName = "five";
                break;
            case 6:
                lastDigitName = "six";
                break;
            case 7:
                lastDigitName = "seven";
                break;
            case 8:
                lastDigitName = "eight";
                break;
            case 9:
                lastDigitName = "nine";
                break;
        }

        return lastDigitName;
    }

    @Override
    public String toString() {
        return "number: " + this.number;
    }
}
