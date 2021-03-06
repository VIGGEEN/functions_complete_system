import java.util.ArrayList;

public class User {

    private ArrayList<Dog> dogList;

    private String name;

    public User(String name) {
        this.name = name;
        dogList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name + dogList;
    }

    public void addDog(Dog dog) {
        dogList.add(dog);
    }

    public void removeDog(Dog dog) {
        dogList.remove(dog);

    }
}
