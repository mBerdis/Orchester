package com.company;

public class Hrac
{
    private String meno;
    private String priezvisko;
    private Nastroj nastroj;
    private double hodinovaSadzba;
    public static boolean dataOK=true;

    public Hrac(String meno, String priezvisko, Nastroj nastroj, double hodinovaSadzba)
    {
        dataOK=true;
        setMeno(meno);
        setPriezvisko(priezvisko);
        setNastroj(nastroj);
        setHodinovaSadzba(hodinovaSadzba);
    }

    public String getMeno()
    {
        return meno;
    }

    public void setMeno(String meno)
    {
        if (!meno.equals(""))
        {
            this.meno = meno;
        }
        else dataOK=false;
    }

    public String getPriezvisko()
    {
        return priezvisko;
    }

    public void setPriezvisko(String priezvisko)
    {
        if (!priezvisko.equals(""))
        {
            this.priezvisko = priezvisko;
        }
        else dataOK=false;

    }

    public Nastroj getNastroj()
    {
        return nastroj;
    }

    public void setNastroj(Nastroj nastroj)
    {
        this.nastroj = nastroj;
    }

    public double getHodinovaSadzba()
    {
        return hodinovaSadzba;
    }

    public void setHodinovaSadzba(double hodinovaSadzba)
    {
        if (hodinovaSadzba>-1&&hodinovaSadzba<Double.MAX_VALUE)
        {
            this.hodinovaSadzba = hodinovaSadzba;
        }
        else dataOK=false;
    }

    @Override
    public String toString()
    {
        return "Hrac{" +
                "meno='" + meno + '\'' +
                ", priezvisko='" + priezvisko + '\'' +
                ", nastroj='" + nastroj + '\'' +
                ", hodinovaSadzba=" + hodinovaSadzba +
                '}';
    }
}
