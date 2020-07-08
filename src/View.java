import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View {
    private Stage stage;


    protected Label label;
    protected Button plus;
    protected Button minus;
    protected Button multiply;
    protected Button equals;
    protected Button clear;
    protected Button divide;
    protected Button[] numbers;

    public View(Stage stage){
        this.stage = stage;

        stage.setTitle("Calculator");

        label = new Label("0");
        plus = new Button("+");
        minus = new Button("-");
        multiply = new Button("*");
        equals = new Button("=");
        clear = new Button("C");
        divide = new Button("/");
        numbers = new Button[10];

        //create and store number buttons
        for(int i = 0; i<10;i++){
            numbers[i] = new Button(Integer.toString(i));
        }

        //organize buttons on the user interface
        GridPane buttonsGrid = new GridPane();

        int counter = 1;
        buttonsGrid.add(numbers[0],1,3);
        for(int i = 2; i>=0;i--){
            for(int j= 0; j<3; j++){
                buttonsGrid.add(numbers[counter],j,i);
                counter++;
            }
        }

        buttonsGrid.add(clear,0,3);
        buttonsGrid.add(multiply,3,0);
        buttonsGrid.add(plus,3,1);
        buttonsGrid.add(minus,3,2);
        buttonsGrid.add(equals,3,3);
        buttonsGrid.add(divide,2,3);

        VBox vBox = new VBox(label, buttonsGrid);

        Scene scene = new Scene(vBox);

        //Add stylesheet to GUI
        multiply.getStyleClass().add("operator");
        plus.getStyleClass().add("operator");
        minus.getStyleClass().add("operator");
        equals.getStyleClass().add("operator");
        scene.getStylesheets().add(getClass().getResource("Calculator.css").toExternalForm());

        stage.setScene(scene);



    }

    public void start(){
        stage.show();
    }

}
