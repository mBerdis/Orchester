package com.company;

public class RytmickyNastroj extends Nastroj
{
    private int pocetZvukov;

    public RytmickyNastroj(String druh, double cena, String zvuk, int pocet, int pocetZvukov)
    {
        super(druh, cena, zvuk, pocet);
        setPocetZvukov(pocetZvukov);
    }

    public int getPocetZvukov()
    {
        return pocetZvukov;
    }

    public void setPocetZvukov(int pocetZvukov)
    {
        if (pocetZvukov>0&&pocetZvukov<Integer.MAX_VALUE)
        {
            this.pocetZvukov = pocetZvukov;
        }
        else dataOK=false;
    }

    @Override
    public String toString()
    {
        return "RytmickyNastroj{"+super.toString() +
                "pocetZvukov=" + pocetZvukov +
                '}';
    }
    protected String getType()
    {
        return "r,";
    }

    @Override
    public String saveData()
    {
        return super.saveData() +"," +pocetZvukov;
    }
}

