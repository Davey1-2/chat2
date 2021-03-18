package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        try {
            Scanner sc = new Scanner(System.in);
            BufferedWriter bw = new BufferedWriter(new FileWriter("chat.txt"));
            BufferedReader br = new BufferedReader(new FileReader("chat.txt"));

            Object promenne = new Object();



                System.out.println("Zadej jmeno: ");
                promenne.jmeno = sc.nextLine();

                if (promenne.countLine == 0) {
                    System.out.println("-- žádné předchozí zprávy--");
                } else {
                    System.out.println("V databázi máš " + promenne.countLine + " zprávy");
                    System.out.println("-------------------------------------------");
                    while ((promenne.line = br.readLine()) != null) {
                        System.out.println(promenne.line);
                    }
                    System.out.println("-------------------------------------------");
                }
                System.out.println("Pro ukončení zápisu zpráv zadejte `konec1`");
                while (promenne.exit) {
                    promenne.zprava = sc.nextLine();

                    if (promenne.zprava.equals("konec1")) {
                        promenne.exit = false;
                    } else {
                        bw.write(promenne.jmeno + " : " + promenne.zprava);
                        bw.newLine();
                        promenne.countLine++;
                    }
                }
                bw.close();



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
