package dubby.serve.emailverification.util.token_generator;

import java.util.Random;

public class TokenGenerator {

    public int getGeneratedToken() {
        return getToken();
    }

    private int getToken() {
        Random ran = new Random();
        int generatedNumber = ran.nextInt();

        if (generatedNumber <= 0) {
            generatedNumber = ran.nextInt();
        }

        return generatedNumber;
    }

}
