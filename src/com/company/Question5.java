package com.company;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class Question5 {

    public static void generateUniqueRandomNumbers(int[] uniqueRandomNumbers) {
        Random rand = new Random();
        for (int i = 0; i < uniqueRandomNumbers.length; i++) {
            int random_integer = -1;

            while (exists(random_integer, uniqueRandomNumbers)) {
                random_integer = rand.nextInt(10);
            }

            uniqueRandomNumbers[i] = random_integer;
        }
    }

    public static boolean exists(int number, int[] array) {
        if (number == -1)
            return true;

        for (int i = 0; i < array.length; i++) {
            if (number == array[i])
                return true;
        }
        return false;
    }

    public static void askRandomQuestions(int[] uniqueRandomNumbers, String[] questions, boolean[] responses) {
        Scanner scanner = new Scanner(System.in);

        for (int uniqueRandomNumber : uniqueRandomNumbers) {
//            System.out.println();
            boolean answer = Boolean.parseBoolean(JOptionPane.showInputDialog(questions[uniqueRandomNumber]));
            responses[uniqueRandomNumber] = answer;
        }
    }

    public static void markResponses(boolean[] answers, boolean[] responses, int[] marks) {
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == responses[i]) {
                marks[i] = 1;
            } else {
                marks[i] = 0;
            }
        }
    }

    public static double determinePercMarkObtained(int[] marks) {
        int total = 0;

        for (int i = 0; i < marks.length; i++) {
            total += marks[i];
        }

        return total * 10;
    }

    public static void displayOutcome(String[] questions, boolean[] answers, boolean[] responses, int[] marks, double percMarkObtained) {
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.println("Correct answer: " + answers[i]);
            System.out.println("Your answer: " + responses[i]);
            System.out.println("Mark obtained: " + marks[i]);
        }

        System.out.println("Total percentage: " + percMarkObtained);
    }

    public static void main(String[] args) {
        String[] questions = new String[]{
                "An array is a list?", "An array has a fixed size?", "An array stores homogeneous elements?"
                , "The first array element is at index 0?", "The last array element is index size minus 1?"
                , "The method length() is used to determine the size of an array?", "The length keyword is used to determine the size of an array?"
                , "An array is passed by reference in a method?", "The bubble sort algorithm uses only one for loop to sort array elements?",
                "An array of ten elements has the last index as 10?"
        };

        boolean[] answers = {
                true, true, true, true, true, false, true, true, false, false
        };

        String option = "";
        Scanner scanner = new Scanner(System.in);

        do {
            int[] uniqueRandomNumbers = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
            boolean[] responses = new boolean[10];
            int[] marks = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};


            generateUniqueRandomNumbers(uniqueRandomNumbers);

            askRandomQuestions(uniqueRandomNumbers, questions, responses);

            markResponses(answers, responses, marks);

            double percentage = determinePercMarkObtained(marks);

            displayOutcome(questions, answers, responses, marks, percentage);


            System.out.println("Do you want to test again? ");
            option = scanner.next();

            System.out.println(option);
        } while (option.equals("yes"));
    }
}
