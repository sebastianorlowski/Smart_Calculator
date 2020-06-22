import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        while (!"/exit".equals(input)) {
            input = scanner.nextLine();

            if (input.startsWith("/")) {
                switch (input) {
                    case "/exit":
                        System.out.println("Bye!");
                        break;
                    case "/help":
                        System.out.println("The program can calculate expressions with multiple additions and subtractions");
                        break;
                    default:
                        System.out.println("Unknown command");
                }
            } else if (!"".equals(input)){
                System.out.println(sum(input));
            }
        }
    }

    public static String sum(String input) {
        String[] inputArray = input.split("\\s+");
        int answer = 0;

        try {
            answer = Integer.parseInt(inputArray[0]);
            if (inputArray.length == 1) {
                return (answer + "");
            }
            for (int i = 1; i < inputArray.length; i += 2) {
                answer = operation(answer, inputArray[i], Integer.parseInt(inputArray[i + 1]));
            }
            return (answer + "");
        }
        catch (Exception e) {
            return "Invalid expression";
        }
    }

    public static int operation(int a, String operand, int b) {
        if (operand.matches("\\++")) {
            return a + b;
        } else if (operand.length() % 2 == 0) {
            return a + b;
        } else return a - b;
    }
}