import java.util.Scanner;
import java.util.Stack;

public class App {
    static final char TALL_WOMAN = 'M';
    static final char TALL_MAN = 'H';

    static final char SHORT_WOMAN = 'm';
    static final char SHORT_MAN = 'h';

    static final char BLOCK_COMMODITY = '@';
    static final char EMPTY_WAGON = '_';

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);

        int numMatches;
        Stack<Character> couples;
        char[] train;

        while (sc.hasNext()) {
            train = sc.nextLine().toCharArray();
            numMatches = 0;
            couples = new Stack<>();

            for (int i = 0; i < train.length; i++) {
                char letter = train[i];

                switch (letter) {
                    case BLOCK_COMMODITY:
                        couples.clear();
                        break;
                    case SHORT_MAN:
                    case TALL_MAN:
                        couples.push(letter);
                        break;
                    case SHORT_WOMAN:
                        if (!couples.empty() && couples.pop() == SHORT_MAN)
                            numMatches++;
                        else
                            couples.push(letter);
                        break;
                    case TALL_WOMAN:
                        if (!couples.empty() && couples.pop() == TALL_MAN)
                            numMatches++;
                        else
                            couples.push(letter);
                        break;
                }
            }
            System.out.println(numMatches);

            sc.close();
        }
    }
}