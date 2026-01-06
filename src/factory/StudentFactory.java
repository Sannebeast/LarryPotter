public class StudentFactory {

    public static Student createStudent(String type) {
        switch (type.toUpperCase()) {
            case "LARRY":
                return new LarryPotter();
            case "GRYFFINDOR":
                return new GriffendorStudent();
            case "SLYTHERIN":
                return new SlytherinStudent();
            default:
                throw new IllegalArgumentException("Unknown student type");
        }
    }
}
