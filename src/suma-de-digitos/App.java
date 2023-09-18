import java.util.Scanner;

public class App {

    private static final String generateOutput(String number) {
        int sum = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);

            sum += Character.getNumericValue(c);

            sb.append(c);
            if (i < number.length() - 1)
                sb.append(" + ");
        }

        return sb.append(" = ".concat(String.valueOf(sum))).toString();
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        do {
            String numberString = sc.nextLine();

            if (numberString.charAt(0) != '-')
                System.out.println(generateOutput(numberString));
        } while (sc.hasNextLine());

        sc.close();
    }
}
