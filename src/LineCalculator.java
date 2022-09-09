import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineCalculator {
    public static void main(String[] args) throws Exception {
        LineCalculator calculatorl = new LineCalculator();
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите значения: ");
            String value = in.nextLine();
            System.out.println(calculatorl.calculatel(value));
        }
    }

    public String calculatel(String value) throws Exception {
        List<String> objects = new ArrayList<>();
        Matcher matcher = Pattern.compile("(?<=\").*?(?=\")|(10|[1-9])| [+,-,*,\\/] ").matcher(value);
        while (matcher.find()) {
            objects.add(matcher.group(0));
        }

        if (objects.size() == 3 && (objects.get(0).length() <= 10) && (objects.get(2).length() <= 10)) {
            String output = new String();
            Operator operator = new Operator();

            if (objects.get(1).equals(" + ")) {
                output = operator.plus(objects.get(0), objects.get(2));
            } else if (objects.get(1).equals(" - ")) {
                output = operator.minus(objects.get(0), objects.get(2));
            } else if (objects.get(1).equals(" * ")) {
                output = operator.multi(objects.get(0), objects.get(2));
            } else if (objects.get(1).equals(" / ")) {
                output = operator.divis(objects.get(0), objects.get(2));
            }
            if (output.length() >= 40){
                return output.substring(0, 39) + "...";
            }
            return output;
        }
        return "";
    }
}