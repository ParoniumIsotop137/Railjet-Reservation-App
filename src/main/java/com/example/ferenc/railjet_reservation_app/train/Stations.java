package com.example.ferenc.railjet_reservation_app.train;

public enum Stations {

    BUDAPESTKELENFOLD("Budapest-Kelenföld",1),TATABANYA("Tatabánya",2),GYOR("Győr", 3),MOSONMAGYAROVAR("Mosonmagyaróvár",4), HEGYESHALOM("Hegyeshalom",5),WIENHBF("Wien Hbf",6),WIENMEIDLING("Wien-Meidling",7),STPOLTEN("St. Pölten Hbf",8),LINZ("Linz Hbf",9),SALZBURG("Salzburg Hbf",10),KUFSTEIN("Kustein",11), WORGL("Wörgl",12), INNSBRUCK("Innsbruck Hbf",13),OTZTAL("Ötztal",14), LANDECK("Landeck-Zams",15),STANTON("St. Anton am Arlberg",16),BLUDENZ("Bludenz",17), FELDKIRCH("Feldkirch",18), BUCHS("Buchs SG",19), SARGANS("Sargans",20), ZURICH("Zürich Hbf",21);

    private final String name;
    private final int id;

    Stations(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
