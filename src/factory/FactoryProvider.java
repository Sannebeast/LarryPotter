package factory;

import java.util.Set;

public class FactoryProvider {

    public static StudentFactory getFactory(String type) {
        return switch (type.toUpperCase()) {
            case "LARRY" -> new LarryPotterFactory();
            case "GRYFFINDOR" -> new GriffendorFactory();
            case "SLYTHERIN" -> new SlytherinFactory();
            case "RAVENCLAW" -> new RavenclawFactory();
            case "HUFFLEPUFF" -> new HufflepuffFactory();
            default -> throw new IllegalArgumentException("Unknown student type");
        };
    }

    public static Set<String> getAvailableStudents() {
        return Set.of(
                "LARRY",
                "GRYFFINDOR",
                "SLYTHERIN",
                "RAVENCLAW",
                "HUFFLEPUFF"
        );
    }
}
