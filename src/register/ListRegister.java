package register;

import java.util.ArrayList;
import java.util.Iterator;

public class ListRegister implements Register{

    private ArrayList<Person> persons = new ArrayList<>();

    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public Person getPerson(int index) {
        return persons.get(index);
    }

    @Override
    public void addPerson(Person person) {
        persons.add(person);
    }

    @Override
    public Person findPersonByName(String name) {
        for (Person p : persons) {
            if(p.getName().equals(name)) return p;
        }
        return null;
    }

    @Override
    public Person findPersonByPhoneNumber(String phoneNumber) {
        return null;
    }

    @Override
    public void removePerson(Person person) {

        Iterator<Person> iterator = persons.iterator();

        while (iterator.hasNext()){
            if (iterator.next().equals(person)){
                iterator.remove();
            }
        }
        persons.remove(person);
    }
}
