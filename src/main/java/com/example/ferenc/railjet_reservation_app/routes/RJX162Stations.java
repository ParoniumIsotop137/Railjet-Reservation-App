package com.example.ferenc.railjet_reservation_app.routes;

public enum RJX162Stations {

    BUDAPESTKELETI("Budapest-Keleti 6:40",0), BUDAPESTKELENFOLD("Budapest-Kelenföld 6:55",1),TATABANYA("Tatabánya 7:26",2),GYOR("Győr 8:02", 3),MOSONMAGYAROVAR("Mosonmagyaróvár 8:20",4), HEGYESHALOM("Hegyeshalom 8:32",5),WIENHBF("Wien Hbf 9:30",6),WIENMEIDLING("Wien-Meidling 9:37",7),STPOLTEN("St. Pölten Hbf 10:00",8),LINZ("Linz Hbf 10:46",9),SALZBURG("Salzburg Hbf 11:56",10),KUFSTEIN("Kustein 13:09",11), WORGL("Wörgl 13:19",12), INNSBRUCK("Innsbruck Hbf 13:47",13),OTZTAL("Ötztal 14:12",14), LANDECK("Landeck-Zams 14:33",15),STANTON("St. Anton am Arlberg 14:57",16),BLUDENZ("Bludenz 15:31",17), FELDKIRCH("Feldkirch 15:48",18), BUCHS("Buchs SG 16:11",19), SARGANS("Sargans 16:23",20), ZURICH("Zürich Hbf 17:20",21);

    private final String name;
    private final int id;

    RJX162Stations(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public static RJX162Stations getStation(String StationName){

        for (RJX162Stations item: RJX162Stations.values())
        {
            if(StationName.equals(item.getName()) || item.name.equals(StationName)){
                return item;
            }

        }
        return null;
    }
}
