package register;

import java.util.Arrays;

/**
 * Created by jaro on 3.2.2014.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Register register = new Register(20);

        register.addPerson(new Person("Janko Hrasko", "0900123456"));
        register.addPerson(new Person("Zdeno Hruska", "0900156494"));
        register.addPerson(new Person("Andrej Kolar", "0900156494"));
        register.addPerson(new Person("Fero Mrkvicka", "0900156494"));
        register.addPerson(new Person("Barbora Zavacka", "0900156494"));

        ConsoleUI ui = new ConsoleUI(register);
        ui.run();
    }
}
