package games;
import java.util.Scanner;

public class TicTacToe {

    static int[][] box = new int[3][3];
    static Scanner scan = new Scanner(System.in);
    static int count = 0;


    public static void main(String... args) {


        setArrayValue();
        displayBox();
        determineWins();

    }


    public static void setArrayValue() {
        int rowCOunt = 0;
        for (int[] row : box) {
            rowCOunt++;
            for (int column = 0; column < row.length; column++) {
                System.out.printf("Enter value for row %d, column %d ", rowCOunt, column);
                int value = scan.nextInt();
                row[column] = value;
            }
        }
    }

    private static void resetCountValue(){
        count = 0;
    }


    private static boolean checkHorizontalWin() {
        resetCountValue();
        for (int[] row : box) {
            for (int column = 0; column < row.length; column++) {
                if (row[column] == box[0][0])
                    count++;
            }
            if(count==box.length)
                System.out.println("You Win");
            break;
        }
        return (count == box.length);
    }


    private static boolean checkLeftVerticalWin() {
        resetCountValue();
        for (int[] row : box) {
            if(row[0]==box[0][0])
                count++;

            if(count==box.length) {
                System.out.println("You Win");
                break;
            }
        }
        return (count==box.length);
    }

    private static boolean checkRightVerticalWin() {
        resetCountValue();
        for (int[] row : box) {
            if(row[box.length-1]==box[0][box.length-1])
                count++;

            if(count==box.length) {
                System.out.println("You Win");
                break;
            }
        }
        return (count==box.length);
    }

    private static boolean checkDiagonalWin() {
        resetCountValue();
        int step = 0;
        for (int[] row : box) {
            if(row[step]==box[0][0])
                count++;
            step++;

            if(count==box.length) {
                System.out.println("You Win");
                break;
            }
        }
        return (count==box.length);
    }


    public static void displayBox(){

        System.out.println("This is your tic tac toe box");

        for(int [] row: box){
            for (int column=0; column<row.length; column++){
                System.out.printf("%-4d", row[column]);
            }
            System.out.println();
        }
    }

    public static void determineWins() {

        if (checkHorizontalWin()) {
            System.out.printf("%B 1",checkHorizontalWin());
        } else if (checkDiagonalWin()) {
            System.out.printf("%B 2",checkDiagonalWin());
        } else if (checkLeftVerticalWin()) {
            System.out.printf("%B 3",checkLeftVerticalWin());
        } else if (checkRightVerticalWin()) {
            System.out.printf("%B 4",checkRightVerticalWin());
        }
        else {System.out.println("No Win.");}
    }
}
