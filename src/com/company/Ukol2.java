package com.company;

import java.io.*;
import java.util.ArrayList;

public class Ukol2 {
    public static void neznameSpolecnosti(ArrayList<Integer> list) {
        try {
            ArrayList<Integer> list2 = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader("output2/nezname-spolecnosti.txt"));
            String nextLine = br.readLine();
            while (nextLine != null) {
                if (!list2.contains(Integer.parseInt(nextLine))) list2.add(Integer.parseInt(nextLine));
                nextLine = br.readLine();
            }
            for (Integer integer : list) {
                if (!list2.contains(integer)) list2.add(integer);
            }
            zapis(list2);
            br.close();

        } catch (IOException e) {
            System.out.println("Unable to read file");
        }
    }

    public static void zapis(ArrayList<Integer> list) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("output2/nezname-spolecnosti.txt"));
            for (int i = 0; i < list.size(); i++) {
                bw.write(list.get(i)+"");
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Unable to write to file");
        }
    }
}
