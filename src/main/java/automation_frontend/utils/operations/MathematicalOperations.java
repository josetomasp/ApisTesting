package automation_frontend.utils.operations;

public class MathematicalOperations {

    public String multiplication(String value1, String value2){

        Double op1;
        Double op2;
        Double result;

        if(value1.contains(",")){
            op1 = Double.parseDouble(value1.replaceAll(",","."));
        }else
            op1 = Double.parseDouble(value1);
        if(value2.contains(",")){
            op2 = Double.parseDouble(value2.replaceAll(",","."));
        }else
            op2 = Double.parseDouble(value2);

        result = op1*op2;

        return String.format("%.2f", result);
    }

    public String division(String value1, String value2){

        Double op1;
        Double op2;
        Double result;

        if(value1.contains(",")){
            op1 = Double.parseDouble(value1.replaceAll(",","."));
        }else
            op1 = Double.parseDouble(value1);
        if(value2.contains(",")){
            op2 = Double.parseDouble(value2.replaceAll(",","."));
        }else
            op2 = Double.parseDouble(value2);

        result = op1/op2;

        return String.format("%.2f", result);
    }

    public String sum(String value1, String value2){

        Double op1;
        Double op2;
        Double result;

        if(value1.contains(",")){
            op1 = Double.parseDouble(value1.replaceAll(",","."));
        }else
            op1 = Double.parseDouble(value1);
        if(value2.contains(",")){
            op2 = Double.parseDouble(value2.replaceAll(",","."));
        }else
            op2 = Double.parseDouble(value2);

        result = op1+op2;

        return String.format("%.2f", result);
    }

    public String subtraction(String value1, String value2){

        Double op1;
        Double op2;
        Double result;

        if(value1.contains(",")){
            op1 = Double.parseDouble(value1.replaceAll(",","."));
        }else
            op1 = Double.parseDouble(value1);
        if(value2.contains(",")){
            op2 = Double.parseDouble(value2.replaceAll(",","."));
        }else
            op2 = Double.parseDouble(value2);

        result = op1-op2;

        return String.format("%.2f", result);
    }


}
