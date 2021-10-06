package Calc;

public class Action{

    public static String calculate(Integer a, Integer b, String action) throws Exception {

        int result;
        switch (action) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                throw new Exception("Не верно введена операция +, -, *, /");
        }
        return String.valueOf(result);
    }
}