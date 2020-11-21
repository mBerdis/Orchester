package com.company;

import java.io.*;
import java.util.ArrayList;

public class main
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<Nastroj> orchesterNastroje = new ArrayList<>();
        ArrayList<Hrac> orchesterUmelci = new ArrayList<>();

        nacitaj_zo_suboru(orchesterUmelci, orchesterNastroje);

        System.out.println("--------------------NASTROJE-----------------\n");
        get_zoznam_nastrojov(orchesterNastroje);

        System.out.println("\n---------------------UMELCI------------------\n");
        get_zoznam_hracov(orchesterUmelci);

        System.out.println("\n--------------OBSADENIE ORCHESTRA------------\n");
        get_obsadenie_orchestra(orchesterUmelci);

        System.out.println("\n---------------MATERIALNE NAKLADY------------\n");
        System.out.println(get_materialne_naklady(orchesterNastroje) + " €\n");

        System.out.println("--------------ORCHESTRALNA SKLADBA-----------\n");
        zahraj_skladbu(orchesterNastroje);

        System.out.println("\n-----------------CENA VYSTUPENIA-------------\n");
        get_cena_vystupenia(orchesterNastroje, orchesterUmelci);

        ulozenie_do_suboru(orchesterNastroje, orchesterUmelci);

        System.out.println("\n------------------MEGA KONCERT---------------\n");
        ArrayList<VieZniet> koncert = new ArrayList<>();
        Lod lod = new Lod(300, 90);
        koncert.add(lod);
        koncert.add(orchesterNastroje.get(0));
        
        for (VieZniet znej : koncert)
        {
            System.out.println(znej.zaznej());
        }

    }

    public static Nastroj zistiDruhNastroja(String str, ArrayList<Nastroj> nastroje)
    {
        for (Nastroj nastroj : nastroje)
        {
            if (str.contains(nastroj.getDruh()) && nastroj.getDostupnyPocet()!=0)
            {
                if (nastroj instanceof SlacikovyNastroj)
                {
                    if (str.equals(((SlacikovyNastroj) nastroj).getSekcia()) && nastroj.getDostupnyPocet()!=0)
                    {
                        nastroj.setDostupnyPocet(nastroj.getDostupnyPocet()-1);
                        return nastroj;
                    }
                }
                else
                {
                    nastroj.setDostupnyPocet(nastroj.getDostupnyPocet()-1);
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

    public static void get_obsadenie_orchestra(ArrayList<Hrac> orchesterUmelci)
    {
        for (Hrac hrac : orchesterUmelci)
        {
            if (hrac.getNastroj() != null)
                if (hrac.getNastroj() instanceof SlacikovyNastroj)
                    System.out.println(hrac.getMeno() + " " + hrac.getPriezvisko() + " - " + ((SlacikovyNastroj) hrac.getNastroj()).getSekcia());
                else
                    System.out.println(hrac.getMeno() + " " + hrac.getPriezvisko() + " - " + hrac.getNastroj().getDruh());

        }
    }

    public static void get_cena_vystupenia(ArrayList<Nastroj> orchesterN, ArrayList<Hrac> orchesterU)
    {
        double sumaZaH = 0;
        for (Hrac hrac : orchesterU)
        {
            sumaZaH += hrac.getHodinovaSadzba();
        }
        System.out.println("Cena za nastroje: " + get_materialne_naklady(orchesterN) + " €\n"
                + "Naklady na umelcov za hodinu: " + sumaZaH + " €");
    }

    public static void ulozenie_do_suboru(ArrayList<Nastroj> orchesterN, ArrayList<Hrac> orchesterU) throws IOException
    {
        BufferedWriter bw = new BufferedWriter(new FileWriter("orchester.dat"));

        for (Nastroj nastroj : orchesterN)
        {
            bw.write(nastroj.saveData() + "\n");
        }
        for (Hrac hrac : orchesterU)
        {
            bw.write(hrac.saveData() + "\n");
        }
        bw.close();

    }

    public static void nacitaj_zo_suboru(ArrayList<Hrac> orchesterUmelci, ArrayList<Nastroj> orchesterNastroje) throws IOException
    {
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
    }


}
