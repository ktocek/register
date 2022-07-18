package register;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Character.isDigit;

/**
 * register.Person.
 */
public class Person implements Comparable<Person> {
    /**
     * Name of this person.
     */
    private String name;

    /**
     * Phone number of this person.
     */
    private String phoneNumber;

    /**
     * Construct a person.
     *
     * @param name        name of the person
     * @param phoneNumber phone number of the person
     */
    public Person(String name, String phoneNumber) {
        this.name = name;
        this.setPhoneNumber(phoneNumber);
    }

    /**
     * Returns name of this person.
     *
     * @return name of this person
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name of this person.
     *
     * @param nameNew name of this person
     */
    public void setName(String nameNew) {
        name = nameNew;
    }

    /**
     * Returns phone number of this person.
     *
     * @return phone number of this person
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets phone number of this person.
     *
     * @param phoneNumberNew phone number of this person
     */
    public void setPhoneNumber(String phoneNumberNew) {
        if (!isValidPhoneNumber(phoneNumberNew)) {
            throw new RuntimeException("Phone number is not valid");
        }
        phoneNumber = phoneNumberNew;
    }

    /**
     * Validates the phone number. Valid phone numbers contains only digits.
     *
     * @param phoneNumber phone number to validate
     * @return <code>true</code> if phone number is valid, <code>false</code> otherwise
     */

    private boolean isValidPhoneNumber(String phoneNumber) {
        final String regex = "(\\d)";

        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < phoneNumber.length(); i++) {
            String reg = String.valueOf(phoneNumber.charAt(i));
            Matcher matcher = pattern.matcher(reg);
            if (!matcher.matches()) {
                return false;
            }
        }

        return true;

//        int num = 0;
//        for (int i = 0; i < phoneNumber.length(); i++) {
//           if(!isDigit(phoneNumber.charAt(i))){
//               num++;
//           }
//        }
//        return num == 0;
    }

    /**
     * Returns a string representation of the person.
     *
     * @return string representation of the person.
     */
    public String toString() {
        return name + " (" + phoneNumber + ")";

    }

    @Override
    public int compareTo(Person o) {
        return name.compareTo(o.name);
    }
}
