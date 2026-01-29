package factory;

import characters.Student;

public abstract class StudentFactory {

    protected abstract Student createStudent();

    public Student enrollStudent() {
        Student student = createStudent();
        System.out.println(student.getName() + " has been enrolled!");
        return student;
    }
}
