package com.company;

/**
 * This class creates and processes a field (input) and creates hints for the fields.
 */
public class Field {
    private final int myWidth;
    private final int myHeight;
    private final double myRandomPercentage; //
    private char[][] myField;

    /**
     * Constructor
     * @param theHeight indicates the number of rows
     * @param theWidth  indicates the number of column
     * @param theRandomPercentage   indicates the random percent of a mine spawning in the field.
     */
    public Field(final int theHeight, final int theWidth, final double theRandomPercentage){
        myWidth = theWidth;
        myHeight = theHeight;
        myRandomPercentage = theRandomPercentage;
        myField = newRandomField();
    }

    /**
     * Constructor
     * @param theHeight indicates the number of rows
     * @param theWidth indicates the number of column
     * @param theMap indicates the field that entered from users
     */
    public Field( final int theHeight, final int theWidth, final char[][] theMap){
        myWidth = theWidth;
        myHeight = theHeight;
        myRandomPercentage =0;
        myField = theMap;
    }

    /**
     * This method creates a random field depending on myHeight, myWidth, and myRandomPercentage
     * @return a 2D char array as a field of mines
     */
    private char[][] newRandomField(){
        char[][] inField = new char[myHeight][myWidth];

        for(int row = 0; row < myHeight; row++){
            for(int col = 0; col < myWidth; col++){
                if(Math.random() < myRandomPercentage) inField[row][col] = '*';
                else inField[row][col]='.';
            }
        }
        return inField;
    }

    /**
     * Convert the 2D char array into a String
     * @return a String
     */
    public String convertToString(){
        StringBuilder returnString = new StringBuilder();
        for(char[] row : myField){
            for ( char col: row){
                returnString.append(col);
            }
            returnString.append("\n");
        }
        returnString.delete(returnString.length()-1,returnString.length());
        return String.valueOf(returnString);
    }

    /**
     * Create hints based on the 2D char array myField and replace the '.' with the number of mines
     * next to that spot
     */
    public void createHints(){
        int[][] hints = new int[myHeight+2][myWidth+2];

        for(int row = 0; row < myHeight; row++){
            for(int col = 0; col < myWidth; col++){
                if (myField[row][col] == '*'){

                    for(int i = 0; i < 9; i++){
                        int rowManager = i%3;
                        int colManager = i/3;
                        hints[row+rowManager][col+colManager]++;
                    }

                }
            }
        }
        for(int row = 0; row < myHeight; row++){
            for(int col = 0; col < myWidth; col++){
                if (myField[row][col] != '*') myField[row][col] = Character.forDigit(hints[row+1][col+1], 16);
            }
        }
    }
}
