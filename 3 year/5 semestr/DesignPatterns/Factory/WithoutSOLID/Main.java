package WithoutSOLID;

import WithoutSOLID.Animal.Animal;
import WithoutSOLID.Factory.AnimalFactory;

public class Main {
    public static void main(String[] args) {
        AnimalFactory dogFactory = new AnimalFactory();
        Animal dog = dogFactory.createAnimal("Dog");
        dog.makeSound();

        AnimalFactory catFactory = new AnimalFactory();
        Animal cat = catFactory.createAnimal("Cat");
        cat.makeSound();
    }
}
