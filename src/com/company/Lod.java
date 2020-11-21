package com.company;

public class Lod implements VieZniet
{
    private int dlzka;
    private int rychlost;

    public Lod(int dlzka, int rychlost)
    {
        setDlzka(dlzka);
        setRychlost(rychlost);
    }

    public int getDlzka()
    {
        return dlzka;
    }

    public void setDlzka(int dlzka)
    {
        if (dlzka > 0 && dlzka < Integer.MAX_VALUE)
        {
            this.dlzka = dlzka;
        }
    }

    public int getRychlost()
    {
        return rychlost;
    }

    public void setRychlost(int rychlost)
    {
        if (rychlost > 0 && rychlost < Integer.MAX_VALUE)
        {
            this.rychlost = rychlost;
        }
    }

    @Override
    public String toString()
    {
        return "Lod{" +
                "dlzka=" + dlzka +
                ", rychlost=" + rychlost +
                '}';
    }

    @Override
    public String zaznej()
    {
        return "Túúút";
    }


}
