package factory;

import characters.RavenclawStudent;
import characters.Student;

public class RavenclawFactory extends StudentFactory {

    @Override
    protected Student createStudent() {
        return new RavenclawStudent();
    }
}
