package fr.Townland.Main.TabList;

public enum RankList {

    //set les ranks
    IJOUEUR(0,0,"§7[JOUEUR] ","§r >> "),
    HFER(1,1,"§8[Fer] ","§r >> "),
    GOR(2,2,"§e[OR] ","§r "),
    FDIAMANT(3,3,"§b[Diamant] ","§r >> "),
    EMODOTEST(4,4,"§a[MODOTEST] ","§r >> "),
    DMODO(5,5,"§a[MODO] ","§r >> "),
    CSUPERMODO(6,6,"§2[SUPERMODO] ","§r >> "),
    BADMIN(7,7,"§4[ADMIN] ","§r >> " ),
    AFONDATEUR(8,8,"§1[Fondateur] ","§r >> ");

    int id;
    int power;
    String prefix;
    String space;

    private RankList(int id,int power,String prefix,String space) {
        this.id = id;
        this.power = power;
        this.prefix = prefix;
        this.space = space;
    }

    //methodes getter
    public int getPower() {
        return power;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getName(){
        return this.toString();
    }

    public String getSpace() {
        return space;
    }

    public int getId() {
        return id;
    }
}
