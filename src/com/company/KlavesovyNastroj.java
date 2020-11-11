package com.company;

public class KlavesovyNastroj extends Nastroj
{
    private int pocetKlavesov;

    public KlavesovyNastroj(String druh, double cena, String zvuk, int pocet, int pocetKlavesov)
    {
        super(druh, cena, zvuk, pocet);
        setPocetKlavesov(pocetKlavesov);
    }

    public int getPocetKlavesov()
    {
        return pocetKlavesov;
    }

    public void setPocetKlavesov(int pocetKlavesov)
    {
        if (pocetKlavesov>0&&pocetKlavesov<Integer.MAX_VALUE)
        {
            this.pocetKlavesov = pocetKlavesov;
        }
        else dataOK=false;
    }

    @Override
    public String toString()
    {
        return "KlavesovyNastroj{"+super.toString() +
                "pocetKlavesov=" + pocetKlavesov +
                '}';
    }

    protected String getType()
    {
        return "k,";
    }

    @Override
    public String saveData()
    {
        return super.saveData() +"," +pocetKlavesov;
    }
}
