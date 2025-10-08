public class Check {
    public static void main(String[] args) {
        char choice = 'r';
        System.out.printf("%c is a %s", choice, decide(choice));
    }

    public static String decide(char key) {
        switch (key) {
            case 'a', 'e', 'i', 'o', 'u':
                return "Vowel";
            case 'b', 'c', 'd', 'f', 'g','h', 'j', 'k', 'l', 'm','n', 'p', 'q', 'r', 's','t', 'v', 'w', 'x', 'y', 'z':
                return "Consonant";
            default:
                return "Invalid character";
        }
    }
}
