package WithoutSOLID.Factory;

import WithoutSOLID.Animal.Animal;
import WithoutSOLID.Animal.Cat;
import WithoutSOLID.Animal.Dog;

public class AnimalFactory {
    public Animal createAnimal(String type) {
        if (type.toLowerCase().equals("dog")) {
            return new Dog();
        } else if (type.toLowerCase().equals("cat")) {
            return new Cat();
        }
        
        return null;
    }
}