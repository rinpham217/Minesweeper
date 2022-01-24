//package com.company;

import java.util.Scanner;

/**
 *  This program performs the minesweeper problem.
 * @author Ilya Nikolay Kozorezov
 * @author Rin Van Pham
 * @version 1.1
 */
public class Main {

    public static void main(String[] args) {
        runMinesweeperInput();
    }

    public static void runMinesweeperInput(){
        int numberOfFields = 0;
        Scanner input = new Scanner(System.in);

        int height = input.nextInt();
        while(height != 0){
            int width = input.nextInt();
            char[][] userInputtedField = new char[height][width];
            userInputtedField[0] = input.nextLine().toCharArray();
            for(int i = 0; i < height; i++){
                userInputtedField[i] = input.nextLine().toCharArray();
            }
            Field f = new Field(height,width, userInputtedField);
            f.createHints();
            System.out.println("Field #"+ (++numberOfFields) +":\n" + f.convertToString()+"\n");
            height = input.nextInt();
        }
    }
}
