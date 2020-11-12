package com.company;

public class StrunovyNastroj extends Nastroj
{
    private int pocetStrun;
    private String ladenie;

    public StrunovyNastroj(String druh, double cena, String zvuk, int pocet, int pocetStrun, String ladenie)
    {
        super(druh, cena, zvuk, pocet);
        setPocetStrun(pocetStrun);
        setLadenie(ladenie);
    }

    public int getPocetStrun()
    {
        return pocetStrun;
    }

    public void setPocetStrun(int pocetStrun)
    {
        if (pocetStrun > 0 && pocetStrun < Integer.MAX_VALUE)
        {
            this.pocetStrun = pocetStrun;
        }
        else dataOK = false;
    }

    public String getLadenie()
    {
        return ladenie;
    }

    public void setLadenie(String ladenie)
    {

        if (ladenie.length() == pocetStrun && checkLetters(ladenie))
        {
            this.ladenie = ladenie;
        }
        else dataOK = false;

    }

    private boolean checkLetters(String ladenie)
    {
        boolean check = true;
        for (int i = 0; i < ladenie.length(); i++)
        {
            if (!(ladenie.charAt(i) == 'A') && !(ladenie.charAt(i) >= 'C' && ladenie.charAt(i) <= 'H'))
            {
                check = false;
                break;
            }
        }
        return check;
    }

    @Override
    public String toString()
    {
        return "StrunovyNastroj{" + super.toString() +
                "pocetStrun=" + pocetStrun +
                ", ladenie='" + ladenie + '\'' +
                '}';
    }

    protected String getType()
    {
        return "s,";
    }

    @Override
    public String saveData()
    {
        return super.saveData() + "," + pocetStrun + "," + ladenie;
    }
}
