import java.util.Scanner;

public class Calculator {

    private static void displayHelp() {
        System.out.println("The program calculates additions and subtractions. Be careful, even numbers of minuses" +
                "gives plus, and the odd number of minuses give minus.");
    }

    private static int sum(String[] arr) {
        int sum = Integer.parseInt(arr[0]);
        for (int i = 1; i < arr.length; i+=2) {
            if (i != arr.length - 1) {
                if (arr[i].matches("\\D+")) {
                    sum += Integer.parseInt(arr[i + 1]) * operator(arr[i]);
                }
            }
        }
        return sum;
    }

    private static int operator(String s) {
        String pattern = "-+";
        if (s.matches(pattern)) {
            if (s.length() % 2 == 0) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return 1;
        }
    }

    private static void result(String s) {
        String[] tempArr = s.split("\\s+");
        if (s.equals("/exit")) {
            System.out.println("Bye!");
            System.exit(0);
        } else {
            if (s.equals("/help")) {
                displayHelp();
            } else {
                if (tempArr.length > 1) {
                    System.out.println(sum(tempArr));
                } else if (tempArr.length == 1) {
                    System.out.println(tempArr[0]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String temp = scanner.nextLine();
            while (temp.isEmpty()) {
                temp = scanner.nextLine();
            }
            result(temp);
        }
    }
}