package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        try {
            Scanner sc = new Scanner(System.in);
            BufferedWriter bw = new BufferedWriter(new FileWriter("chat.txt"));
            BufferedReader br = new BufferedReader(new FileReader("chat.txt"));

            String jmeno;
            String zprava;
            String line = br.readLine();
            int countLine = 0;
            boolean exit = true;
            boolean allExit = true;

            while (allExit = true) {
                exit = true;
                System.out.println("Zadej jmeno: ");
                jmeno = sc.nextLine();
                if (jmeno.equals("end1")){
                    allExit = false;
                }
                if (countLine == 0) {
                    System.out.println("-- žádné předchozí zprávy--");
                } else {
                    System.out.println("V databázi máš " + countLine + " zprávy");
                    System.out.println("-------------------------------------------");
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }
                    System.out.println("-------------------------------------------");
                }
                System.out.println("Pro ukončení zápisu zpráv zadejte `konec1`, pro uplny konec zadej `end1`");
                while (exit) {
                    zprava = sc.nextLine();
                    if (zprava.equals("end")){
                        allExit = false;
                        System.exit(0);
                    }
                    if (zprava.equals("konec1")) {
                        exit = false;
                    } else {
                        bw.write(jmeno + " : " + zprava);
                        bw.newLine();
                        countLine++;
                    }
                }
                bw.close();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
