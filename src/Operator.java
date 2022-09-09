public class Operator {
    public String plus(String One, String Two) {
        return "\"" + One + Two + "\"";
    }

    public String minus(String One, String Two) {
        String x = One.replace(Two, "");
        return "\"" + One.replace(Two, "") + "\"";
    }
    public String multi(String One, String Two) {
        String output = new String();
        int number = Integer.parseInt(Two);
        for (int i = 1; i <= number; i++) {
            output = output + One;
        }
        return output;
    }
    public String divis(String One, String Two) {
        int index = One.length() / Integer.parseInt(Two);
        return One.substring(0, index);
    }
}

