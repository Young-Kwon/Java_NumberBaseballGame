import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Number Baseball Game(JAVAFX).
 *
 * @author Young Sang Kwon
 */
public class NumberBaseballGame extends Application {

    // Instance Variables for View Components and Model
    private GameModel model; // model
    private GameView view; // view
    private GraphicsContext gc;
    private TextField numField; // input box
    private Button submitButton; // submit button
    private Button restartButton; // restart button
    private Label title; // Game Title
    private Label inn1; // record inning 1
    private Label inn2; // record inning 2
    private Label inn3; // record inning 3
    private Label inn4; // record inning 4
    private Label inn5; // record inning 5
    private Label inn6; // record inning 6
    private Label inn7; // record inning 7
    private Label inn8; // record inning 8
    private Label inn9; // record inning 9
    private Label comment;  // message to user(Warning etc)

    /**
     * ActionEvent: submit button
     *
     * @param e
     **/
    private void setGameHandler(ActionEvent e) {
        int curNum = Integer.parseInt(numField.getText()); // get input number from user
        model.playingGame(curNum);  // match the number
        int count = model.getCount(); // get count
        //System.out.println("Count: " + count);
        if ( model.getIsGameOver() == true )
            comment.setText("Already Game Over"); // already game over
        else if ( !model.getIsInputError() && count<=9) { // string record
            if (count == 1)
                inn1.setText("" + model);
            else if (count == 2)
                inn2.setText("" + model);
            else if (count == 3)
                inn3.setText("" + model);
            else if (count == 4)
                inn4.setText("" + model);
            else if (count == 5)
                inn5.setText("" + model);
            else if (count == 6)
                inn6.setText("" + model);
            else if (count == 7)
                inn7.setText("" + model);
            else if (count == 8)
                inn8.setText("" + model);
            else if (count == 9)
                inn9.setText("" + model);
            else
                comment.setText("End of Game");
            view.draw(gc);
            comment.setText("" + model.inputStatus()); // string message to user
        }
    }

    /**
     * ActionEvent: restart button
     *
     * @param e
     **/
    private void restartGameHandler(ActionEvent e) {
        model.reset(); // reset the game data
        inn1.setText(" ");
        inn2.setText(" ");
        inn3.setText(" ");
        inn4.setText(" ");
        inn5.setText(" ");
        inn6.setText(" ");
        inn7.setText(" ");
        inn8.setText(" ");
        inn9.setText(" ");
        model.readyToPlay(); // make new secret number
        view.draw(gc); // draw Ball signal board
        comment.setText("Restart Game"); // comment to user
    }

    /**
     * This is where you create your components and the model and add event handlers.
     *
     * @param stage The main stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 500, 500); // set the size here
        stage.setTitle("Number Baseball Game"); // set the window title here
        stage.setScene(scene);
        // TODO: Add your GUI-building code here

        // 1. Create the model and view
        model = new GameModel();
        view = new GameView();

        // 2. Create the GUI components
        Canvas canvas = new Canvas(500, 500); // create canvas size
        title = new Label("Number Baseball Game"); // display Title
        numField = new TextField("000"); // create input box Field
        submitButton = new Button("Submit"); // create submit button Field
        restartButton = new Button("Restart"); // create restart button Field
        comment = new Label("Input only digit and 3 number. ex) 123"); // create comment Field
        inn1 = new Label(""); // create record inning 1 Field
        inn2 = new Label(""); // create record inning 2 Field
        inn3 = new Label(""); // create record inning 3 Field
        inn4 = new Label(""); // create record inning 4 Field
        inn5 = new Label(""); // create record inning 5 Field
        inn6 = new Label(""); // create record inning 6 Field
        inn7 = new Label(""); // create record inning 7 Field
        inn8 = new Label(""); // create record inning 8 Field
        inn9 = new Label(""); // create record inning 9 Field

        // 3. Add components to the root
        root.getChildren().addAll(canvas, title, numField, submitButton, restartButton, inn1, inn2, inn3, inn4, inn5, inn6, inn7, inn8, inn9, comment);

        // 4. Configure the components (colors, fonts, size, location)
        title.relocate(100, 20);
        numField.relocate(50,50);
        submitButton.relocate(220,50);
        restartButton.relocate(280, 50);
        comment.relocate(30,100);
        inn1.relocate(30,130);
        inn2.relocate(30,160);
        inn3.relocate(30,190);
        inn4.relocate(30,220);
        inn5.relocate(30,250);
        inn6.relocate(30,280);
        inn7.relocate(30,310);
        inn8.relocate(30,340);
        inn9.relocate(30,370);

        // 5. Add Listeners and do final setup
        model.readyToPlay(); // ready to play
        submitButton.setOnAction(this::setGameHandler); // set on action of submit button
        restartButton.setOnAction(this::restartGameHandler); // set on action of restart button
        gc = canvas.getGraphicsContext2D();
        view.draw(gc); // draw

        // 6. Show the stage
        stage.show();
    }

    /**
     * Make no changes here.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}