package com.company;

public class Nastroj
{
    private String druh;
    private double cena;
    private String zvuk;
    private int pocet;
    public static boolean dataOK=true;


    public Nastroj(String druh, double cena, String zvuk, int pocet)
    {
        dataOK=true;
        setDruh(druh);
        setCena(cena);
        setZvuk(zvuk);
        setPocet(pocet);
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
        else dataOK=false;
    }

    public double getCena()
    {
        return cena;
    }

    public void setCena(double cena)
    {
        if (cena>-1&&cena<Double.MAX_VALUE)
        {
            this.cena = cena;
        }
        else dataOK=false;

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
        else dataOK=false;

    }

    public int getPocet()
    {
        return pocet;
    }

    public void setPocet(int pocet)
    {
        if (pocet>0&&pocet<Integer.MAX_VALUE)
        {
            this.pocet = pocet;
        }
        else dataOK=false;
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
        return getType()+druh +"," +cena +"," +zvuk +"," +pocet;
    }
}
