package com.company;

import java.util.Scanner;

public class Main {

    static char[][] board;
    static int currentPlayer;
    static Scanner scanner;

    static boolean gameOver = false;

    //Player can be 1 or 2

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello world!");
        currentPlayer = 1;
        scanner = new Scanner(System.in);

        //Empty 3x3 board;
        board = new char[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        while(!gameOver) {
            printBoard();
            takeTurn();
            checkWinner();
            if(!gameOver) {
                checkIfBoardFilled();
                if(!gameOver) {
                    switchPlayer();
                }
            }
        }
    }

    //board[row][col]


    /**
     *
     * X|X|X
     * -----
     * O|O|O
     * -----
     * X|X|X
     *
     *
     * */

    // Empty(' '), 'X', 'O'

    static void printBoard() {
        for(int i = 0; i < 3; i++) {

            for(int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if(j < 2) {
                    System.out.print('|');
                }
            }
            if(i < 2) {
                System.out.println("\n-----");
            }
        }
    }


    static void takeTurn() {
        char symbol;
        int row = -1;
        int col = -1;
        if(currentPlayer == 1) {
            symbol = 'X';
        } else {
            symbol = 'O';
        }

        System.out.println("\nPlayer " + currentPlayer + " is taking their turn.");
        System.out.println("Which row do you want to put a " + symbol + " in?");
        while(row == -1) {
            try {
                row = scanner.nextInt();
                if(row != 1 && row != 2 && row != 3) {
                    row = -1;
                    System.out.println("Please enter 1, 2, or 3");
                }
            } catch (Exception e) {
                System.out.println("Please enter 1, 2, or 3");
                scanner.next();
            }
        }
        System.out.println("Which column do you want to put a " + symbol + " in?");
        while(col == -1) {
            try {
                col = scanner.nextInt();
                if(col != 1 && col != 2 && col != 3) {
                    col = -1;
                    System.out.println("Please enter 1, 2, or 3");
                }
            } catch (Exception e) {
                System.out.println("Please enter 1, 2, or 3");
                scanner.next();
            }
        }


        //Row is 1, 2, or 3.  Column is 1, 2, or 3.
        row--;
        col--;

        if(board[row][col] == ' ') {
            board[row][col] = symbol;

        } else {
            printBoard();
            System.out.println("That spot is filled!");
            takeTurn();
        }
    }

    static void switchPlayer() {
        if(currentPlayer == 1) {
            currentPlayer = 2;
        } else {
            currentPlayer = 1;
        }
    }

    static void checkWinner() {
        char symbol;
        if(currentPlayer == 1) {
            symbol = 'X';
        } else {
            symbol = 'O';
        }

        if(board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) {
            System.out.println("Player " + currentPlayer + " has won the game!");
            gameOver = true;
        }
        else if(board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) {
            System.out.println("Player " + currentPlayer + " has won the game!");
            gameOver = true;
        }
        else if(board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) {
            System.out.println("Player " + currentPlayer + " has won the game!");
            gameOver = true;
        }
        else if(board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) {
            System.out.println("Player " + currentPlayer + " has won the game!");
            gameOver = true;
        }
        else if(board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) {
            System.out.println("Player " + currentPlayer + " has won the game!");
            gameOver = true;
        }
        else if(board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) {
            System.out.println("Player " + currentPlayer + " has won the game!");
            gameOver = true;
        }
        else if(board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            System.out.println("Player " + currentPlayer + " has won the game!");
            gameOver = true;
        }
        else if(board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            System.out.println("Player " + currentPlayer + " has won the game!");
            gameOver = true;
        }
        else {
        }
    }


    static void checkIfBoardFilled() {
        boolean filled = true;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
               if(board[i][j] == ' ') {
                   filled = false;
               }
            }
        }
        if(filled) {
            System.out.println("The board is filled!");
            gameOver = true;
        }
    }

    /*
    *
    * Player 1 - X, Player 2 - O
    * Board (3x3)
    * Pieces (X, 0)
    * Take Turns (Spot you want to go, Which player you are(1 or 2), if the spot is occupied, if its on the board at all)
    * Win Mechanism
    *
    *  */



}
