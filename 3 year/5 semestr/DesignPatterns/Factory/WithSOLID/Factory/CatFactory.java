package WithSOLID.Factory;

import WithSOLID.Animal.Animal;
import WithSOLID.Animal.Cat;

public class CatFactory implements AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}
