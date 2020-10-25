package com.company;

import java.util.ArrayList;

public class main
{

    public static void main(String[] args) {
        ArrayList<Nastroj> orchester = new ArrayList<>();
        Nastroj drumbla = new Nastroj("drumbľa",5.50,"bingwau",3);
        add_to_orchester(orchester,drumbla);
        StrunovyNastroj ukulele = new StrunovyNastroj("ukulele", 60, "brinkibrink",0,4,"DGHE");
        add_to_orchester(orchester,ukulele);
        DychovyNastroj trubka=new DychovyNastroj("Trúbka",3000.455,"tututu",1,1,"D");
        add_to_orchester(orchester,trubka);
        SlacikovyNastroj husle=new SlacikovyNastroj("Husle",998,"piiiskhiisk",4,4,"ACG","Slacikove nastroje");
        add_to_orchester(orchester,husle);
        get_zoznam_nastrojov(orchester);
        System.out.println(get_materialne_naklady(orchester));


    }
    public static void add_to_orchester(ArrayList<Nastroj> orchester,Nastroj nastroj)
    {
        if (Nastroj.dataOK)
        {
            orchester.add(nastroj);
            System.out.println("NASTROJ PRIDANY");
        }
        else System.out.println("NASTROJ NEPRIDANY TEST");

    }
    public static double get_materialne_naklady(ArrayList<Nastroj> orchester)
    {
        double cena = 0;

        for (Nastroj nastroj: orchester)
        {
            cena += nastroj.getCena() * nastroj.getPocet();
        }

        return cena;
    }

    public static void zahraj_skladbu(ArrayList<Nastroj> orchester)
    {
        for (Nastroj nastroj: orchester)
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
        for (Nastroj nastroj: orchester)
        {
            System.out.println(nastroj.toString());
        }
    }


}
