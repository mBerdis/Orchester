package com.company;

import javax.swing.text.html.ObjectView;

public class Nastroj implements VieZniet
{
    private String druh;
    private double cena;
    private String zvuk;
    private int pocet;
    private int dostupnyPocet;
    public static boolean dataOK = true;


    public Nastroj(String druh, double cena, String zvuk, int pocet)
    {
        dataOK = true;
        setDruh(druh);
        setCena(cena);
        setZvuk(zvuk);
        setPocet(pocet);
        dostupnyPocet=pocet;
    }

    public String getDruh()
    {
        return druh;
    }

    public void setDruh(String druh)
    {
        if (!druh.equals(""))
        {
            this.druh = druh;
        }
        else dataOK = false;
    }

    public double getCena()
    {
        return cena;
    }

    public void setCena(double cena)
    {
        if (cena > -1 && cena < Double.MAX_VALUE)
        {
            this.cena = cena;
        }
        else dataOK = false;

    }

    public String getZvuk()
    {
        return zvuk;
    }

    public void setZvuk(String zvuk)
    {
        if (!zvuk.equals(""))
        {
            this.zvuk = zvuk;
        }
        else dataOK = false;

    }

    public int getPocet()
    {
        return pocet;
    }

    public void setPocet(int pocet)
    {
        if (pocet > 0 && pocet < Integer.MAX_VALUE)
        {
            this.pocet = pocet;
        }
        else dataOK = false;
    }

    public int getDostupnyPocet()
    {
        return dostupnyPocet;
    }

    public void setDostupnyPocet(int dostupnyPocet)
    {
        this.dostupnyPocet = dostupnyPocet;
    }

    @Override
    public String toString()
    {
        return "Nastroj{" +
                "druh='" + druh + '\'' +
                ", cena=" + cena +
                ", zvuk='" + zvuk + '\'' +
                ", pocet=" + pocet +
                '}';
    }

    protected String getType()
    {
        return "n,";
    }

    public String saveData()
    {
        return getType() + druh + "," + cena + "," + zvuk + "," + pocet;
    }

    @Override
    public String zaznej()
    {
        return getZvuk();
    }
}
