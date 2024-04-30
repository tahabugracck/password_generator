import java.util.Scanner;

public class Machine {
    private CharacterPool characterPool;
    private Scanner scanner;

    public Machine(boolean addUpper, boolean addLower, boolean addNumber, boolean addSymbol) {
        scanner = new Scanner(System.in);
        characterPool = new CharacterPool(addUpper, addLower, addNumber, addSymbol);
    }

    public void loop() {
        String userSelect = "0";

        while (!userSelect.equals("4")) {
            printMenu();
            userSelect = scanner.next();

            switch (userSelect) {
                case "1":
                    requestPassword();
                    break;
                case "2":
                    checkPassword();
                    break;
                case "3":
                    info();
                    break;
                case "4":
                    printQuitMessage();
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }
    }

    private void info() {
        System.out.println("Ensure passwords are at least 8 characters long, if possible.");
        //Mümkünse şifrelerin en az 8 karakter uzunluğunda olduğundan emin olun.
        System.out.println();
        System.out.println("Encourage the use of uppercase and lowercase letters, numbers, and symbols in passwords.");
        //Şifrelerde büyük-küçük harf, rakam ve sembollerin kullanılmasını teşvik edin.
        System.out.println();
        System.out.println("Generate passwords randomly where possible and avoid reusing the same password.");
        //Mümkün olduğunca rastgele şifreler oluşturun ve aynı şifreyi tekrar kullanmaktan kaçının.
        System.out.println();
        System.out.println("Avoid using repetitive characters in passwords.");
        //Şifrelerde tekrarlayan karakterler kullanmaktan kaçının.
        System.out.println();
        System.out.println("Mix different character types (uppercase, lowercase, numbers, symbols) for creating strong passwords.");
        //Güçlü şifreler oluşturmak için farklı karakter türlerini (büyük harf, küçük harf, sayılar, semboller) karıştırın.
        System.out.println();

    }

    private void requestPassword() {
        boolean addUpper = false;
        boolean addLower = false;
        boolean addNumber = false;
        boolean addSymbol = false;
        boolean parameter;

        System.out.println("Hello, welcome to the Password Generator :)" +
                "\nAnswer the following questions with Yes or No:");
        System.out.println();

        do {
            System.out.println("Do you want lowercase to be used?");
            addLower = isInclude(scanner.next());

            System.out.println("Do you want Uppercase letters to be used?");
            addUpper = isInclude(scanner.next());

            System.out.println("Do you want Numbers to be used?");
            addNumber = isInclude(scanner.next());

            System.out.println("Do you want Symbols to be used?");
            addSymbol = isInclude(scanner.next());

            if (!addUpper && !addLower && !addNumber && !addSymbol) {
                System.out.println("You have selected no characters to generate your password.");
            }
        } while (!addUpper && !addLower && !addNumber && !addSymbol);

        System.out.println("Enter the length of the password:");
        int length = scanner.nextInt();

        String generatedPassword = generatePassword(length);
        System.out.println("You generated password: " + generatedPassword);
    }

    private String generatePassword(int length) {
        StringBuilder password = new StringBuilder("");
        int passwordLength = characterPool.getCharacterPool().length();
        int max = passwordLength - 1;
        int min = 0;
        int limit = max - min + 1;

        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * limit) + min;
            password.append(characterPool.getCharacterPool().charAt(index));
        }

        return password.toString();
    }

    private boolean isInclude(String input) {
        return input.equalsIgnoreCase("yes");
    }

    private void checkPassword() {
        System.out.print("Enter your password:");
        String input = scanner.next();
        final PasswordStrength p = new PasswordStrength(input);
        System.out.println(p.calculateStrength());
    }

    private void printMenu() {
        System.out.println();
        System.out.println("Enter 1 - Password Generator");
        System.out.println("Enter 2 - Password Strength Check");
        System.out.println("Enter 3 - Useful Information");
        System.out.println("Enter 4 - Quit");
        System.out.print("Choice:");
        System.out.println();
    }

    private void printQuitMessage() {
        System.out.println("Closing the program. See you later!");
    }

}
