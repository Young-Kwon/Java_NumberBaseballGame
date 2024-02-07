/**
 * Number Judge Class can report matching digit and order.
 *
 * @author Young Sang Kwon
 **/
public class GameModel {
    int[] ans = {0,0,0}; // Secret number
    private int inputNum; // user input number
    private int strike; // match digit and order
    private int ball; // match digit but order is wrong
    private int out; // no match
    private int count; // how many you tried
    private boolean isInputError; // is input error?
    private boolean isGameOver; // is game over?

    /**
     * ready to play
     *
     */
    public void readyToPlay() {
        isGameOver = false;
        for(int i=0; i<3; i++) { // Duplicate number is not permitted in secret number
            boolean duplicate = false;
            ans[i] = (int)(Math.random() * 10); // random value is 0 ~ 9 in integer.
            do {
                if  ( i == 1 && (ans[1] == ans[0]) || ( i == 2 && ((ans[2] == ans[0]) || (ans[2] == ans[1]))) ) {
                    duplicate = true;
                    //System.out.println("Duplicate[" + i + "]: " + ans[0] + ", " + ans[1] + ", " + ans[2]);
                    ans[i] = (int)(Math.random() * 10);
                }
                else {
                    duplicate = false;
                }
            } while(duplicate);
        }
        count = 0; // count if count is over 9 or not
        //System.out.println("Answer: " + ans[0] + ", " + ans[1] + ", " + ans[2]);
    }

    /**
     * checking input Error
     *
     * @param (num1, num2, num3) which were typed by user
     */
    public void inputErrorCheck(int num1, int num2, int num3) {
        isInputError = false;
        if ( ( num1 == num2) || (num1 == num3) || (num2 == num3) ) { // duplicate number checking
            //System.out.println("Duplicate number is invalid.");
            isInputError = true;
        }
        else if ( num1 < 0 || num1 > 9 || num2 < 0 || num2 > 9 || num3 < 0 || num3 > 9){ // single digit checking
            //System.out.println("You can input 0 to 9 only");
            isInputError = true;
        }
        else {
            isInputError = false;
        }
    }

    /**
     * match number
     *
     * @param inputNum which was typed by user
     */
    public void playingGame(int inputNum) {
        int[] num = {0,0,0};
        num[0] = (int)(inputNum/100); // first number
        num[1] = (int)((inputNum-num[0]*100)/10); // second number
        num[2] = (int)(inputNum%10); // third number
        //System.out.println("Input: " + num[0] + ", " + num[1] + ", " + num[2]);
        inputErrorCheck(num[0], num[1], num[2]); // checking input error
        setInputNumber(inputNum); // set input number
        inputStatus(); // message to user
        strike = 0; // initialize value;
        ball = 0; // initialize value;
        out = 0; // initialize value;
        if(!isInputError) { // No input Error
            count++; // increasing number which user tried
            //System.out.println("count: " + count);
            for (int k=0; k<3; k++) {
                if(num[k] == ans[k]) { // count strike
                    strike += 1;
                }
                else { // count ball
                    if ( k == 0 && ( (num[0] == ans[1] ) || ( num[0] == ans[2] ) ) ) {
                        ball += 1;
                    }
                    else if ( k == 1 && ( ( num[1] == ans[0] ) || ( num[1] == ans[2] ) ) ) {
                        ball += 1;
                    }
                    else if ( k == 2 && ( ( num[2] == ans[0] ) || ( num[2] == ans[1] ) ) ) {
                        ball += 1;
                    }
                }
            }
            if (strike == 0 && ball == 0) { // out
                out = 3;
            }
            else {
                out = 0;
            }
            //System.out.println(strike + "Strike " + ball + "Ball " + out + "out");
        }
    }

    /**
     * set input number
     *
     * @param inputNum which was typed by user
     */
    public void setInputNumber(int inputNum) {
        this.inputNum = inputNum;
    }

    /**
     * reset variable
     */
    public void reset() {
        count = 0;
        strike = 0;
        ball = 0;
        out = 0;
    }

    /**
     * get count
     *
     * @return count which is tried number
     */
    public int getCount() {
        return count;
    }

    /**
     * get strike count
     *
     * @return strike count
     */
    public int getStrike() {
        return strike;
    }

    /**
     * get ball count
     *
     * @return ball count
     */
    public int getBall() {
        return ball;
    }

    /**
     * get out count
     *
     * @return out count
     */
    public int getOut() {
        return out;
    }

    /**
     * get checking game is done or not
     *
     * @return isGameOver ture of false
     */
    public boolean getIsGameOver() {
        return isGameOver;
    }

    /**
     * get checking Input Error
     *
     * @return isInputError ture of false
     */
    public boolean getIsInputError() {
        return isInputError;
    }

    /**
     * for print
     * @return String of sides and current number
     * print sides and current number of each dice
     */
    public String inputStatus() {
        String str;
        if (isInputError == true)
            str =  "Invalid Numeber. Please input only 3 digit single number(ex, 123)";
        else if ( strike == 3) {
            str = "You Win!";
            isGameOver = true;
        }
        else if ( count == 0 ) {
            str = "Restart Game";
            isGameOver = false;
        }
        else if ( count > 8 ) {
            str = "You lose Game!";
            isGameOver = true;
        }
        else
            str =  "You remain " + (9-count) + " chance";
        return str;
    }

    /**
     * for print
     * @return String of sides and current number
     * print sides and current number of each dice
     */
    public String toString() {
        String str;
        int[] num = {0,0,0};
        //System.out.println("toString: inputNum " + inputNum);
        num[0] = (int)(inputNum/100);
        num[1] = (int)((inputNum-num[0]*100)/10);
        num[2] = (int)(inputNum%10);
        if ( count == 0 ) {
            str =  " ";
        }
        else if ( out == 3 )
            str =  "inn " + count + ": [" + num[0] + num[1] + num[2] + "] " + out + "Out";
        else
            str =  "inn " + count + ": [" + num[0] + num[1] + num[2] + "] " + ball + "Ball " + strike + "Strike" ;
        return str;
    }
}
