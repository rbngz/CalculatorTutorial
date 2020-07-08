import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Model {
    private String equation;
    private boolean solved;

    public Model(){
        equation = "0";
        solved = false;
    }

    public void addElement(String element){
        if(equation.equals("0")&&!isOperator(element)){
            equation = element;
        } else if(isOperator(element)&& isOperator(Character.toString(equation.charAt(equation.length()-1)))){
            equation = equation.substring(0,equation.length()-1)+element;
        } else{
            equation = equation +element;
        }
        solved = false;
    }
    public void clearEquation(){
        equation = "0";
    }
    public String calculate() throws ScriptException{
        if(isOperator(Character.toString(equation.charAt(equation.length()-1)))){
            addElement("0");
        }
        System.out.println(equation);
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        String result = engine.eval(equation).toString();
        solved = true;
        equation = result;
        return result;

    }
    public boolean isOperator(String element){
        if(element.equals("-")||element.equals("+")||element.equals("*")||element.equals("/")){
            return true;
        } else return false;
    }

    public String getEquation(){
        return equation;
    }
    public boolean isSolved(){
        return solved;
    }

}
