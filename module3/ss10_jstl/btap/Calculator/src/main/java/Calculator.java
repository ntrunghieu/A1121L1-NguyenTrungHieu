public class Calculator {
    public static float calculate(float first_number, float last_number, String operator) throws ArithmeticException{
        float result=0;
        switch (operator){
            case "+":
                result=first_number+last_number;
                break;
            case "-":
                result=first_number-last_number;
                break;
            case "*":
                result=first_number*last_number;
                break;
            case "/":
                if (last_number==0){
                    throw new ArithmeticException("Không chia cho 0");
                } else {
                    result = first_number / last_number;}
                break;
        }
        return result;
    }
}
