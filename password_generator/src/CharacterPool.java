import java.util.ArrayList;
import java.util.List;

public class CharacterPool {

    private List<Character> pool;
    //bu liste karakter havuzunu oluşturmak için kullanılacak.

    //sınıf adı ile aynı olan bir yapıcı metod oluşturduk.

    public CharacterPool(boolean addUpperCase, boolean addLowerCase, boolean addNumbers, boolean addSpecialCharacters) {
        pool = new ArrayList<>();
        if (addUpperCase) addCharacters('A', 'Z');
        if (addLowerCase) addCharacters('a', 'z');
        if (addNumbers) addCharacters('0', '9');
        if (addSpecialCharacters) addSpecialCharacters();
    }


    //karakter havuzuna belirli türdeki karakterleri eklemekten sorumlu iki adet metot oluşturduk.
    private void addCharacters(char start, char end) {
        for (char ch = start; ch <= end; ch++) {
            pool.add(ch);
        }
    }

    private void addSpecialCharacters() {
        String symbols = "!@#$%^&*()-_=+\\/~?";
        for (char ch : symbols.toCharArray()) {
            pool.add(ch);
        }
    }


    //havuzdaki karakterli birleştirerek 'String' olarak döndürür.
    //'StringBuilder' kullanılarak karakterleri havuzdan alır ve tek bir String haline getirir.
    public String getCharacterPool() {
        StringBuilder result = new StringBuilder();
        for (Character ch : pool) {
            result.append(ch);
        }
        return result.toString();
    }
}
