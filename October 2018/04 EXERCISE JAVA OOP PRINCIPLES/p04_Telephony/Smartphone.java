package p04_Telephony;

import p04_Telephony.interfaces.Browseable;
import p04_Telephony.interfaces.Callable;

public class Smartphone implements Callable, Browseable {


    @Override
    public void browse(String site) {
        if (isSiteValid(site)){
            System.out.println("Browsing: " + site + "!");
        } else {
            throw new IllegalArgumentException("Invalid URL!");
        }
    }

    @Override
    public void call(String number) {
        if (isNumberValid(number)){
            System.out.println("Calling... " + number);
        } else {
            throw new IllegalArgumentException("Invalid number!");
        }
    }

    private boolean isNumberValid(String number) {
        return number.matches("\\d+");
    }

    private boolean isSiteValid(String site) {
        return site.matches("\\D*");
    }
}
