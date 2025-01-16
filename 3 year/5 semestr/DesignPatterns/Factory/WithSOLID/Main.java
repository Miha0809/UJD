package WithSOLID;

import WithSOLID.Animal.Animal;
import WithSOLID.Factory.AnimalFactory;
import WithSOLID.Factory.CatFactory;
import WithSOLID.Factory.DogFactory;

public class Main {
    public static void main(String[] args) {
        AnimalFactory dogFactory = new DogFactory();
        Animal dog = dogFactory.createAnimal();
        dog.makeSound();

        AnimalFactory catFactory = new CatFactory();
        Animal cat = catFactory.createAnimal();
        cat.makeSound();
    }
}
