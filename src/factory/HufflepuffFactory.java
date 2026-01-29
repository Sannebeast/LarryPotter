package factory;

import characters.HufflepuffStudent;
import characters.Student;

public class HufflepuffFactory extends StudentFactory {

    @Override
    protected Student createStudent() {
        return new HufflepuffStudent();
    }
}
