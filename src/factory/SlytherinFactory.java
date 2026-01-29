package factory;

import characters.SlytherinStudent;
import characters.Student;

public class SlytherinFactory extends StudentFactory {

    @Override
    protected Student createStudent() {
        return new SlytherinStudent();
    }
}
