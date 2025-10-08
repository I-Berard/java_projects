import java.util.Optional;

public class Optionals {

    public static void main(String[] args) {
        Optional<String> optionalName = Optional.of("Berard");

        Optional<String> optionalNullable = Optional.ofNullable(null);

        Optional<String> emptyOptional = Optional.empty();

        Optional<Integer> length = optionalName.map(String::length);

        if(optionalName.isPresent()){
            System.out.println(length.get() + " " + optionalName.get());
        }

        System.out.println(emptyOptional.isPresent());

        length.ifPresent(l -> System.out.println("Length is: " + l));
    }

}