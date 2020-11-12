package com.company;

import java.io.*;
import java.util.ArrayList;

public class main
{
    public static void main(String[] args) throws IOException
    {
        BufferedWriter bw = new BufferedWriter(new FileWriter("orchester.dat"));
        ArrayList<Nastroj> orchester = new ArrayList<>();
        Nastroj drumbla = new Nastroj("drumbľa", 5.50, "bingwau", 3);
        // add_to_orchester(orchester, drumbla);
        StrunovyNastroj ukulele = new StrunovyNastroj("ukulele", 60, "brinkibrink", 2, 4, "DGHE");
        //  add_to_orchester(orchester, ukulele);
       /* DychovyNastroj trubka = new DychovyNastroj("Trúbka", 3000.455, "tututu", 1, 1, "D");
        add_to_orchester(orchester, trubka);
        SlacikovyNastroj husle = new SlacikovyNastroj("Husle", 998, "piiiskhiisk", 4, 4, "ACG", "2.husle");
        add_to_orchester(orchester, husle);
        get_zoznam_nastrojov(orchester);*/

        Hrac matej = new Hrac("Matej", "Koscelnik", ukulele, 454.6);
        bw.write(drumbla.saveData() + "\n");
        bw.write(ukulele.saveData() + "\n");
        //    bw.write(matej.saveData()+"\n");
        bw.close();

        BufferedReader br = new BufferedReader(new FileReader("orchester.dat"));
        String line;
        Nastroj nastroj = null;
        while ((line = br.readLine()) != null)
        {
            String[] splitLine = line.split(",");
            switch (splitLine[0])
            {
                case "n":
                    nastroj = new Nastroj(splitLine[1], Double.parseDouble(splitLine[2]), splitLine[3], Integer.parseInt(splitLine[4]));
                    break;
                case "s":
                    nastroj = new StrunovyNastroj(splitLine[1], Double.parseDouble(splitLine[2]), splitLine[3], Integer.parseInt(splitLine[4]),
                            Integer.parseInt(splitLine[5]), splitLine[6]);
                    break;
                case "S":
                    nastroj = new SlacikovyNastroj(splitLine[1], Double.parseDouble(splitLine[2]), splitLine[3], Integer.parseInt(splitLine[4]),
                            Integer.parseInt(splitLine[5]), splitLine[6], splitLine[6]);
                    break;
                case "r":
                    nastroj = new RytmickyNastroj(splitLine[1], Double.parseDouble(splitLine[2]), splitLine[3], Integer.parseInt(splitLine[4]),
                            Integer.parseInt(splitLine[5]));
                    break;
                case "k":
                    nastroj = new KlavesovyNastroj(splitLine[1], Double.parseDouble(splitLine[2]), splitLine[3], Integer.parseInt(splitLine[4]), Integer.parseInt(splitLine[5]));
                    break;
                case "d":
                    nastroj = new DychovyNastroj(splitLine[1], Double.parseDouble(splitLine[2]), splitLine[3], Integer.parseInt(splitLine[4]),
                            Integer.parseInt(splitLine[5]), splitLine[6]);

            }
            add_to_orchester(orchester, nastroj);
        }
        get_zoznam_nastrojov(orchester);


    }

    public static void add_to_orchester(ArrayList<Nastroj> orchester, Nastroj nastroj)
    {
        if (Nastroj.dataOK)
        {
            orchester.add(nastroj);
            System.out.println("NASTROJ PRIDANY");
        }
        else System.out.println("ZADANE CHYBNE DATA, NASTROJ NEPRIDANY");

    }

    public static double get_materialne_naklady(ArrayList<Nastroj> orchester)
    {
        double cena = 0;

        for (Nastroj nastroj : orchester)
        {
            cena += nastroj.getCena() * nastroj.getPocet();
        }

        return cena;
    }

    public static void zahraj_skladbu(ArrayList<Nastroj> orchester)
    {
        for (Nastroj nastroj : orchester)
        {
            for (int i = 0; i < nastroj.getPocet(); i++)
            {
                System.out.print(nastroj.getZvuk() + " ");
            }
            System.out.println();
        }
    }

    public static void get_zoznam_nastrojov(ArrayList<Nastroj> orchester)
    {
        for (Nastroj nastroj : orchester)
        {
            System.out.println(nastroj.toString());
        }
    }


}
