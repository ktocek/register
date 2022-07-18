package register;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * User interface of the application.
 */
public class ConsoleUI {
    /**
     * register.Register of persons.
     */
    private ArrayRegister arrayRegister;

    /**
     * In JDK 6 use Console class instead.
     *
     * @see readLine()
     */
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Menu options.
     */
    private enum Option {
        PRINT, ADD, UPDATE, REMOVE, FIND, EXIT
    }

    ;

    public ConsoleUI(ArrayRegister arrayRegister) {
        this.arrayRegister = arrayRegister;
    }

    public void run() {
        while (true) {
            switch (showMenu()) {
                case PRINT:
                    printRegister();
                    break;
                case ADD:
                    addToRegister();
                    break;
                case UPDATE:
                    updateRegister();
                    break;
                case REMOVE:
                    removeFromRegister();
                    break;
                case FIND:
                    findInRegister();
                    break;
                case EXIT:
                    return;
            }
        }
    }

    private String readLine() {
        //In JDK 6.0 and above Console class can be used
        //return System.console().readLine();

        try {
            return input.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    private Option showMenu() {
        System.out.println("Menu.");
        for (Option option : Option.values()) {
            System.out.printf("%d. %s%n", option.ordinal() + 1, option);
        }
        System.out.println("-----------------------------------------------");

        int selection = -1;
        do {
            System.out.println("Option: ");
            selection = Integer.parseInt(readLine());
        } while (selection <= 0 || selection > Option.values().length);

        return Option.values()[selection - 1];
    }

    private void printRegister() {
        Arrays.sort(arrayRegister.persons, Comparator.nullsLast(Comparator.naturalOrder()));

        for (int i = 0; i < arrayRegister.getSize(); i++) {
            System.out.println((i + 1) + ". " + arrayRegister.getPerson(i));
        }

    }

    private void addToRegister() {
        boolean equalString = true;
        System.out.println("Enter Name: ");
        String name = readLine();
        System.out.println("Enter Phone Number: ");
        String phoneNumber = readLine();

        for (int i = 0; i < arrayRegister.getSize(); i++) {
            Person person = arrayRegister.getPerson(i);
            if (person == null) {
                equalString = true;
            } else if (person.getName().equals(name) || person.getPhoneNumber().equals(phoneNumber)) {
                equalString = false;
                break;
            }
        }

        if (equalString) {
            arrayRegister.addPerson(new Person(name, phoneNumber));
        } else System.out.println("Person already exist!");
    }

    private void updateRegister() {
        System.out.println("Enter index: ");
        int index = Integer.parseInt(readLine());
        System.out.println("Enter new name: ");
        String name = readLine();
        System.out.println("Enter new Phone Number: ");
        String phoneNumber = readLine();
        Person person = arrayRegister.getPerson(index - 1);
        person.setName(name);
        person.setPhoneNumber(phoneNumber);
    }

    private void findInRegister() {
        System.out.println("Want you find person by name(1) or by phone number(2)?");
        int num = Integer.parseInt(readLine());
        if (num == 1) {
            System.out.println("Enter name: ");
            String name = readLine();
            arrayRegister.findPersonByName(name);
        } else if (num == 2) {
            System.out.println("Enter phone number: ");
            String phoneNumber = readLine();
            arrayRegister.findPersonByPhoneNumber(phoneNumber);
        } else System.out.println("Bad input!");
    }

    private void removeFromRegister() {
        System.out.println("Enter index: ");
        int index = Integer.parseInt(readLine());
        Person person = arrayRegister.getPerson(index - 1);
        arrayRegister.removePerson(person);
    }

}
