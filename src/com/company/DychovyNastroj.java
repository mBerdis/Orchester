package com.company;

public class DychovyNastroj extends Nastroj
{
    private int pocetDier;
    private String ladenie;

    public DychovyNastroj(String druh, double cena, String zvuk, int pocet, int pocetDier, String ladenie)
    {
        super(druh, cena, zvuk, pocet);
        setPocetDier(pocetDier);
        setLadenie(ladenie);
    }

    public int getPocetDier()
    {
        return pocetDier;
    }

    public void setPocetDier(int pocetDier)
    {
        if (pocetDier>0&&pocetDier<Integer.MAX_VALUE)
        {
            this.pocetDier = pocetDier;
        }
        else dataOK=false;
    }

    public String getLadenie()
    {
        return ladenie;
    }

    public void setLadenie(String ladenie)
    {
        this.ladenie = ladenie;
        if (ladenie.length()==1 && checkLetters(ladenie))
        {
            this.ladenie=ladenie;
        }
        else dataOK=false;
    }

    public boolean checkLetters(String ladenie)
    {
        boolean check=true;
        for (int i = 0; i < ladenie.length(); i++)
        {
            if (!(ladenie.charAt(i) == 'A') && !(ladenie.charAt(i) >= 'C' && ladenie.charAt(i) <= 'H')) {
                check = false;
                break;
            }
        }
        return check;
    }

    @Override
    public String toString()
    {
        return "DychovyNastroj{" +super.toString()+
                "pocetDier=" + pocetDier +
                ", ladenie='" + ladenie + '\'' +
                '}';
    }
}
