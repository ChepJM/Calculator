import java.util.HashSet;
import java.util.Scanner;


class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Calculator calc;

        while (true)
        {
            System.out.print("Input statement: ");
            String statement = in.nextLine();
            calc = new Calculator(statement);
            System.out.println(calc.calculate());
        }
    }
}