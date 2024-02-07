import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GameView {

    private GameModel model = new GameModel(); // model
    /**
     * draw in screen
     *
     * @param gc
     */
    public void draw(GraphicsContext gc) {
        int posX1 = 20;
        int posY1 = 120;
        int posX2 = 200;
        int posY2 = 120;
        int strike = model.getStrike();
        int ball = model.getBall();
        int out = model.getOut();
        gc.setFill(Color.LIGHTGRAY); // record field
        gc.fillRect(posX1, posY1, 170, 300);
        gc.setFill(Color.GREEN); // ball count signal field
        gc.fillRect(posX2, posY2, 200, 200);
        gc.setFill(Color.DARKBLUE); // string for count signal field
        gc.setFont(new Font("System", 20));
        gc.strokeText("Ball Count", 220, 150);
        gc.setLineWidth(1);

        // draw Ball signal
        gc.setFill(Color.BLACK);
        gc.setFont(new Font("System", 15));
        gc.setFill(Color.YELLOW);
        gc.strokeText("B", posX2+20, posY2+65);
        if ( ball == 0) {
            gc.strokeOval(posX2+50,  posY2+50, 20, 20);
            gc.strokeOval(posX2+100, posY2+50, 20, 20);
            gc.strokeOval(posX2+150, posY2+50, 20, 20);
        }
        else if ( ball == 1 ) {
            gc.fillOval(posX2+50, posY2+50, 20, 20);
            gc.strokeOval(posX2+100, posY2+50, 20, 20);
            gc.strokeOval(posX2+150, posY2+50, 20, 20);
        }
        else if ( ball == 2 ) {
            gc.fillOval(posX2+50, posY2+50, 20, 20);
            gc.fillOval(posX2+100, posY2+50, 20, 20);
            gc.strokeOval(posX2+150, posY2+50, 20, 20);
        }
        else if ( ball == 3 ) {
            gc.fillOval(posX2+50, posY2+50, 20, 20);
            gc.fillOval(posX2+100, posY2+50, 20, 20);
            gc.fillOval(posX2+150, posY2+50, 20, 20);
        }

        // draw Strike signal
        gc.setFill(Color.BLUE);
        gc.strokeText("S", posX2+20, posY2+115);
        if ( strike == 0 ) {
            gc.strokeOval(posX2+50, posY2+100, 20, 20);
            gc.strokeOval(posX2+100, posY2+100, 20, 20);
            gc.strokeOval(posX2+150, posY2+100, 20, 20);
        }
        else if ( strike == 1 ) {
            gc.fillOval(posX2+50, posY2+100, 20, 20);
            gc.strokeOval(posX2+100, posY2+100, 20, 20);
            gc.strokeOval(posX2+150, posY2+100, 20, 20);
        }
        else if ( strike == 2 ) {
            gc.fillOval(posX2+50, posY2+100, 20, 20);
            gc.fillOval(posX2+100, posY2+100, 20, 20);
            gc.strokeOval(posX2+150, posY2+100, 20, 20);
        }
        else if ( strike == 3 ) {
            gc.fillOval(posX2+50, posY2+100, 20, 20);
            gc.fillOval(posX2+100, posY2+100, 20, 20);
            gc.fillOval(posX2+150, posY2+100, 20, 20);
        }

        // draw Out signal
        gc.setFill(Color.RED);
        gc.strokeText("O", posX2+20, posY2+165);
        if ( out == 0 ) {
            gc.strokeOval(posX2+50, posY2+150, 20, 20);
            gc.strokeOval(posX2+100, posY2+150, 20, 20);
            gc.strokeOval(posX2+150, posY2+150, 20, 20);
        }
        else if ( out == 1 ) {
            gc.fillOval(posX2+50, posY2+150, 20, 20);
            gc.strokeOval(posX2+100, posY2+150, 20, 20);
            gc.strokeOval(posX2+150, posY2+150, 20, 20);
        }
        else if ( out == 2 ) {
            gc.fillOval(posX2+50, posY2+150, 20, 20);
            gc.fillOval(posX2+100, posY2+150, 20, 20);
            gc.strokeOval(posX2+150, posY2+150, 20, 20);
        }
        else if ( out == 3 ) {
            gc.fillOval(posX2+50, posY2+150, 20, 20);
            gc.fillOval(posX2+100, posY2+150, 20, 20);
            gc.fillOval(posX2+150, posY2+150, 20, 20);
        }
    }

}
