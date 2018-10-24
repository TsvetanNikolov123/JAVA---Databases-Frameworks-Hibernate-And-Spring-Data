package p04_NumberInReversedOrder;

public class DecimalNumber {
    private String number;

    public DecimalNumber() {
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public static String reversedOrder(String number) {
        char[] charArr = number.toCharArray();
        String reversedStr = "";
        for (int i = charArr.length - 1; i >= 0; i--) {
            reversedStr += charArr[i];
        }

       return reversedStr;
    }
}
