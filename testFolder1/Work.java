package com.company.Workraft;

//import java.util.ArrayList;
import java.util.Scanner;

public class Work{
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int counter = 0;
        while(true){
            System.out.println("1. Continue working");
            System.out.println("2. Stop working");
            int step = sc.nextInt();
            if (step == 2) {
                break;
            }
            else if (step != 1)
                System.out.println("WRONG WAY");
            else counter += 1;
        }
        System.out.println("The worker is working " + counter + " times");
    }
}
