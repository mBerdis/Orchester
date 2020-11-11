package com.company;

public class SlacikovyNastroj extends StrunovyNastroj
{
    private String sekcia;

    public SlacikovyNastroj(String druh, double cena, String zvuk, int pocet, int pocetStrun, String ladenie, String sekcia)
    {
        super(druh, cena, zvuk, pocet, pocetStrun, ladenie);
        setSekcia(sekcia);
    }

    public String getSekcia()
    {
        return sekcia;
    }

    public void setSekcia(String sekcia)
    {

        if (!sekcia.equals(""))
        {
            this.sekcia = sekcia;
        }
        else dataOK=false;
    }

    @Override
    public String toString()
    {
        return "SlacikovyNastroj{"+super.toString() +
                "Sekcia='" + sekcia + '\'' +
                '}';
    }
    protected String getType()
    {
        return "S,";
    }

    @Override
    public String saveData()
    {
        return super.saveData() +"," +sekcia;
    }
}
