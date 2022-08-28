import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws Exception {
        Calculator calculator = new Calculator();
        while(true){
            Scanner in = new Scanner(System.in);
            System.out.print("Input a value:");
            String value = in.nextLine();

            System.out.println(calculator.calculate(value));
        }
    }
    public String calculate(String value) throws Exception {
        String[] object = value.split(" ");
        // 1.Содержит ли пример три объекта (1 знак)
        if(!(object.length == 3 && (object[1].equals("+") || object[1].equals("-") || object[1].equals("*") || object[1].equals("/")))){
            throw new Exception("Пример написан не корректно");
        }

        // 2.Эти два объекта целые числа от 1-10
        {
            int first = Integer.parseInt(object[0]);
            int second = Integer.parseInt(object[2]);

            if ((first >= 1 && first <= 10) && (second >= 1 && second <= 10)) {
                return String.valueOf(mathOperation(first, second, object[1]));
            }
        }
        // 3.Или эти два объекта римские цифры от I-X
        int first = RomanNumerals.convertStringToInt(object[0]);
        int second = RomanNumerals.convertStringToInt(object[2]);
        if((first >= 1 && first <= 10) && (second >= 1 && second <= 10)) {
            int result = mathOperation(first, second, object[1]);
            if (result < 0) {
                throw new Exception("B римской системе нет отрицательных чисел");
            }
            return RomanNumerals.convertIntToRoman (result);
        }

        return "";
    }
    private int mathOperation(int first, int second, String operator){
        switch(operator){
            case "+":
                return first + second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            case "/":
                return first / second;
            default:
                return 0;
        }
    }

}
