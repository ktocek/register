package register;

/**
 * Created by jaro on 3.2.2014.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        ArrayRegister arrayRegister = new ArrayRegister(20);

        arrayRegister.addPerson(new Person("Janko Hrasko", "0900123456"));
        arrayRegister.addPerson(new Person("Zdeno Hruska", "0900156494"));
        arrayRegister.addPerson(new Person("Andrej Kolar", "0900156494"));
        arrayRegister.addPerson(new Person("Fero Mrkvicka", "0900156494"));
        arrayRegister.addPerson(new Person("Barbora Zavacka", "0900156494"));

        ConsoleUI ui = new ConsoleUI(arrayRegister);
        ui.run();
    }
}
