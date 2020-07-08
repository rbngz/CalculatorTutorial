public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;


        //Label displays the number
        for (int i = 0;i<10; i++){
            String numString = view.numbers[i].getText();
            view.numbers[i].setOnAction(event ->{
                if(model.getEquation().equals("0")||model.isOperator(Character.toString(model.getEquation().charAt(model.getEquation().length()-1)))){
                    view.label.setText(numString);
                } else if(model.isSolved()){
                    view.label.setText(numString);
                    model.clearEquation();
                } else{
                    String currentText = view.label.getText();
                    view.label.setText(currentText + numString);
                }
                model.addElement(numString);
            });

        }
        //Clearing the label
        view.clear.setOnAction(event -> {
            view.label.setText("0");
            model.clearEquation();
        });

        //Store operators in the equation
        view.plus.setOnAction(event -> {
            model.addElement("+");
        });
        view.minus.setOnAction(event -> {
            model.addElement("-");
        });
        view.multiply.setOnAction(event -> {
            model.addElement("*");
        });
        view.divide.setOnAction(event -> {
            model.addElement("/");
        });

        view.equals.setOnAction(event -> {
            try {
                view.label.setText(model.calculate());
            }catch (Exception e){
                e.printStackTrace();
            }
        });


    }
}
