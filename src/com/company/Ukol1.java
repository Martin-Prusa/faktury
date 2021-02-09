package com.company;

import java.io.*;
import java.util.ArrayList;

public class Ukol1 {
    public static int preved(String nazev) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        int suma = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("input/"+nazev+".dat"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("output1/"+nazev+".csv"));
            String nextLine = br.readLine();
            nextLine = br.readLine();
            String[] pole = nextLine.split(",");
            int cislo = Integer.parseInt(pole[0]);
            while(nextLine != null) {
                pole = nextLine.split(",");
                String spolecnost = najdiSpolecnost(Integer.parseInt(pole[1]));
                bw.write(pole[0]+";"+spolecnost+";"+pole[2]);
                bw.newLine();
                celkem(pole[0]+";"+spolecnost+";"+pole[2]);
                suma += Integer.parseInt(pole[2]);
                nextLine = br.readLine();
                if(spolecnost.contains("IČO") && !list.contains(Integer.parseInt(pole[1]))) {
                    list.add(Integer.parseInt(pole[1]));
                }
                while(cislo != Integer.parseInt(pole[0])) {
                    list2.add(cislo);
                    cislo++;
                }
                cislo++;
            }
            br.close();
            bw.close();
        } catch (IOException e) {
            System.out.println("Unable to write to file");
        }

        Ukol2.neznameSpolecnosti(list);
        Ukol3.neznameFaktury(list2);
        return suma;
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
        return "IČO:"+id;
    }
}
