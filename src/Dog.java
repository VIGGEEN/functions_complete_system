/*
 * Lisa Nordquist lino0425
 * Har samarbetat med Charlotte Hjalmarsson chhj2260
 * [Vi har g�tt p� m�nga handledningspass, tittat p� kod fr�n f�rel�sningar samt
 * diskuterat med varandra.]
 */

public class Dog implements Comparable<Dog> {

    private String name;
    private String breed;
    private int age;
    private int weight;
    private User owner;

    public Dog(String name, String breed, int age, int weight) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public void incrementAge() {
        age = age + 1;
    }

    public int getWeight() {
        return weight;
    }

    public User getOwner() {
        return owner;
    }

    public boolean isOwned() {
        return owner != null;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public double getTailLength() {

        if (breed.equalsIgnoreCase("tax") || breed.equalsIgnoreCase("dachshund")) {
            return 3.7;
        } else {
            return (age * weight) / 10.0;
        }

    }

    public int compareTo(Dog dog) {
        return name.compareTo(dog.getName());
    }

    public String toString() {
        String s = "* " + name + " (" + breed + ", " + age + " years, " + weight + " kilo, " + getTailLength() + " cm tail)";
        if (isOwned())
            return s + " owned by " + owner.getName();
        else
            return s;

    }
}
