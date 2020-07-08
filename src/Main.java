import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    private Model model;
    private View view;
    private Controller controller;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage){
        model = new Model();
        view = new View(stage);
        controller = new Controller(model, view);
        view.start();
    }

}
