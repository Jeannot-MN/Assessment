package com.company;

import java.util.Scanner;

public class Question4 {

    public static void main(String[] args) {

        String[] students = new String[5];
        double[] marks = new double[5];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < students.length; i++) {
            System.out.println("Enter the student number ");
            students[i] = scanner.next();

            System.out.println("Enter the mark");
            marks[i] = scanner.nextDouble();


        }

        for (int i = 0; i < students.length - 1; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (marks[j] > marks[i]) {
                    double temp = marks[j];
                    marks[j] = marks[i];
                    marks[i] = temp;

                    String tempStud = students[j];
                    students[j] = students[i];
                    students[i] = tempStud;
                }
            }
        }

        double sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum += marks[i];
        }

        double average = sum / marks.length;

        System.out.println("Highest performing: " + students[0] + " with " + marks[0]);
    }
}
