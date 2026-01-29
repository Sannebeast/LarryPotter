package factory;

import characters.RavenClawStudent;
import characters.Student;

public class RavenclawFactory extends StudentFactory {

    @Override
    protected Student createStudent() {
        return new RavenClawStudent();
    }
}
