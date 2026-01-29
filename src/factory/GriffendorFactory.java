package factory;

import characters.GriffendorStudent;
import characters.Student;

public class GriffendorFactory extends StudentFactory {

    @Override
    protected Student createStudent() {
        return new GriffendorStudent();
    }
}
