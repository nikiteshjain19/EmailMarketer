package se.thinkcode.jdd;

public class Subscriptions {
    public String subscribe(String address) {
        return validateEmailAddress(address);
    }

    private String validateEmailAddress(String address) {
        if (address.contains("@")) {
            return "Welcome " + address;
        } else {
            return "There was an error subscribing";
        }
    }
}
