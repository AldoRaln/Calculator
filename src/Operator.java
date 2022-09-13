public class Operator {
    public String plus(String One, String Two) {
        return addBrakets(deleteBrakets(One) + deleteBrakets(Two));
    }

    public String minus(String One, String Two) {
        return addBrakets(deleteBrakets(One).replace(deleteBrakets(Two), ""));
    }

    public String mult(String One, String Two) {
        String output = new String();
        int number = Integer.parseInt(Two);
        for (int i = 1; i <= number; i++) {
            output = output + deleteBrakets(One);
        }
        return addBrakets(output);
    }

    public String div(String One, String Two) {
        int index = deleteBrakets(One).length() / Integer.parseInt(Two);
        return addBrakets(deleteBrakets(One).substring(0, index));
    }

    private String deleteBrakets(String value){
        return value.substring(1, value.length()-1);
    }

    private String addBrakets(String value){
        return "\"" + value + "\"";
    }
}

