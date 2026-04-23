class Animal {
    String name;
    String scientificName;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getScientificName() {
        return scientificName;
    }
    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }    
}

class Dog extends Animal{
    String owner;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}

class Cat extends Animal{
    String sound;

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
    
}

public class Main{
    public static void main(String[] args) {        
        Cat animal = new Cat();
        animal.setName("cat");
        Cat cat = (Cat) animal;
        System.out.println(cat.getName());
    }
}
