package com.company;

import java.io.*;
import java.util.ArrayList;

public class main
{
    public static void main(String[] args) throws IOException
    {
        BufferedWriter bw = new BufferedWriter(new FileWriter("orchester.dat"));
        ArrayList<Nastroj> orchesterNastroje = new ArrayList<>();
        ArrayList<Hrac> orchesterUmelci = new ArrayList<>();
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

        BufferedReader br = new BufferedReader(new FileReader("orchester.txt"));
        String line;
        Nastroj nastroj = null;
        Hrac hrac = null;
        while ((line = br.readLine()) != null)
        {
            String[] splitLine = line.split(",");
            switch (splitLine[0])
            {
                case "n":
                    nastroj = new Nastroj(splitLine[1], Double.parseDouble(splitLine[2]), splitLine[3], Integer.parseInt(splitLine[4]));
                    add_to_orchesterNastroj(orchesterNastroje, nastroj);
                    break;
                case "s":
                    nastroj = new StrunovyNastroj(splitLine[1], Double.parseDouble(splitLine[2]), splitLine[3], Integer.parseInt(splitLine[4]), Integer.parseInt(splitLine[5]), splitLine[6]);
                    add_to_orchesterNastroj(orchesterNastroje, nastroj);
                    break;
                case "S":
                    nastroj = new SlacikovyNastroj(splitLine[1], Double.parseDouble(splitLine[2]), splitLine[3], Integer.parseInt(splitLine[4]), Integer.parseInt(splitLine[5]), splitLine[6], splitLine[7]);
                    add_to_orchesterNastroj(orchesterNastroje, nastroj);
                    break;
                case "r":
                    nastroj = new RytmickyNastroj(splitLine[1], Double.parseDouble(splitLine[2]), splitLine[3], Integer.parseInt(splitLine[4]), Integer.parseInt(splitLine[5]));
                    add_to_orchesterNastroj(orchesterNastroje, nastroj);
                    break;
                case "k":
                    nastroj = new KlavesovyNastroj(splitLine[1], Double.parseDouble(splitLine[2]), splitLine[3], Integer.parseInt(splitLine[4]), Integer.parseInt(splitLine[5]));
                    add_to_orchesterNastroj(orchesterNastroje, nastroj);
                    break;
                case "d":
                    nastroj = new DychovyNastroj(splitLine[1], Double.parseDouble(splitLine[2]), splitLine[3], Integer.parseInt(splitLine[4]), Integer.parseInt(splitLine[5]), splitLine[6]);
                    add_to_orchesterNastroj(orchesterNastroje, nastroj);
                    break;
                case "u":
                    hrac = new Hrac(splitLine[1], splitLine[2], zistiDruhNastroja(splitLine[3], orchesterNastroje), Double.parseDouble(splitLine[4]));
                    add_to_orchesterUmelec(orchesterUmelci, hrac);
                    break;

            }
        }

        get_zoznam_nastrojov(orchesterNastroje);
        get_zoznam_hracov(orchesterUmelci);

    }

    public static Nastroj zistiDruhNastroja(String str, ArrayList<Nastroj> nastroje)
    {
        for (Nastroj nastroj : nastroje)
        {
            if (str.contains(nastroj.getDruh()))
            {
                if (nastroj instanceof SlacikovyNastroj)
                {
                    if (str.equals(((SlacikovyNastroj) nastroj).getSekcia()))
                    {
                        return nastroj;
                    }
                }
                else
                {
                    return nastroj;
                }
            }
        }
        return null;
    }

    public static void add_to_orchesterUmelec(ArrayList<Hrac> orchester, Hrac umelec)
    {
        if (Hrac.dataOK)
        {
            orchester.add(umelec);
            System.out.println("HRAC PRIDANY");
        }
        else System.out.println("ZADANE CHYBNE DATA, HRAC NEPRIDANY");
    }

    public static void add_to_orchesterNastroj(ArrayList<Nastroj> orchester, Nastroj nastroj)
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

    public static void get_zoznam_hracov(ArrayList<Hrac> orchester)
    {
        for (Hrac hrac : orchester)
        {
            System.out.println(hrac.toString());
        }
    }


}
