package factory;

import characters.LarryPotter;
import characters.Student;

public class LarryPotterFactory extends StudentFactory {

    @Override
    protected Student createStudent() {
        return new LarryPotter();
    }
}
