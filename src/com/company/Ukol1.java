package com.company;

import java.io.*;

public class Ukol1 {
    public static void preved(String nazev) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("input/"+nazev+".dat"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("output1/"+nazev+".csv"));
            String nextLine = br.readLine();
            nextLine = br.readLine();

            while(nextLine != null) {
                String[] pole = nextLine.split(",");
                String spolecnost = najdiSpolecnost(Integer.parseInt(pole[1]));
                bw.write(pole[0]+";"+spolecnost+";"+pole[2]);
                bw.newLine();
                celkem(pole[0]+";"+spolecnost+";"+pole[2]);

                nextLine = br.readLine();
            }

            br.close();
            bw.close();

        } catch (IOException e) {
            System.out.println("Unable to write to file");
        }
    }

    public static void celkem(String pridej) {
        try {
            BufferedWriter bwCelkem = new BufferedWriter(new FileWriter("output1/VF_CELKEM.csv", true));
            bwCelkem.write(pridej);
            bwCelkem.newLine();
            bwCelkem.close();
        } catch (IOException e) {
            System.out.println("Unable to write to file");
        }
    }

    public static String najdiSpolecnost(int id) {
        try {
            BufferedReader brSpolecnosti = new BufferedReader(new FileReader("input/seznam-spolecnosti.dat"));
            String nextLine = brSpolecnosti.readLine();
            while(nextLine != null) {
                String[] pole = nextLine.split(":");
                if(id==Integer.parseInt(pole[1])){
                    return pole[0];
                }
                nextLine = brSpolecnosti.readLine();
            }
            brSpolecnosti.close();
        } catch (IOException e) {
            System.out.println("Unable to read file");
        }
        return "Neznámá společnost";
    }
}
