package WithSOLID.Factory;

import WithSOLID.Animal.Animal;
import WithSOLID.Animal.Dog;

public class DogFactory implements AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}
