package p04_Telephony;

public class Smartphone implements CallingPhone, BrowsingPhone {


    @Override
    public void call(String number) {
        if (isValidNumber(number)) {
            System.out.println("Calling... " + number);
        } else {
            System.out.println("Invalid number!");
        }
    }

    @Override
    public void browsing(String site) {
        if (isValidSite(site)) {
            System.out.println("Browsing: " + site + "!");
        } else {
            System.out.println("Invalid URL!");
        }
    }

    private boolean isValidSite(String site) {
        return site.matches("\\D*");
    }


    private boolean isValidNumber(String number) {
        return number.matches("\\d+");
    }
}
