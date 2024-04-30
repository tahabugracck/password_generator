public class PasswordStrength {
    private String password;
    private int length;

    public PasswordStrength(String password){
        this.password = password;
        this.length = password.length();
    }

    private int getCharacterType(char c){
        if (Character.isUpperCase(c)) {
            return 1; // Büyük harf
        } else if (Character.isLowerCase(c)) {
            return 2; // Küçük harf
        } else if (Character.isDigit(c)) {
            return 3; // Sayı
        } else {
            return 4; // Sembol
        }
    }

    public int calculateStrength() {
        boolean usedUpper = false;
        boolean usedLower = false;
        boolean usedNum = false;
        boolean usedSym = false;
        int type;
        int score = 0;

        for (int i = 0; i < length; i++) {
            char c = password.charAt(i);
            type = getCharacterType(c);

            if (type == 1) usedUpper = true;
            if (type == 2) usedLower = true;
            if (type == 3) usedNum = true;
            if (type == 4) usedSym = true;
        }

        if (usedUpper) score += 1;
        if (usedLower) score += 1;
        if (usedNum) score += 1;
        if (usedSym) score += 1;

        if (length < 0){
            System.out.println("error");
        }else if (length < 8){
            score +=0;
        }else if (length <= 16){
            score ++;
        }else {
            score +=2;
        }

        return score;
    }

    @Override
    public String toString() {
        return password;
    }
}
