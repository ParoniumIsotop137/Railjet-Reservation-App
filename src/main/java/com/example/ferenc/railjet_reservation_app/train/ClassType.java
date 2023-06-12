package com.example.ferenc.railjet_reservation_app.train;

import com.example.ferenc.railjet_reservation_app.routes.RJX162Stations;

public enum ClassType {

    PREMIUM("Premium"), BUSINESS("Business"), ECONOMY("Economy");

    private final String className;

    ClassType(String className) {
        this.className = className;
    }


    public static ClassType GetClassType(String name){

        for (ClassType item: ClassType.values())
        {
            if(name.equals(item.toString()) || item.toString().equals(name)){
                return item;
            }

        }
        return null;
    }

    @Override
    public String toString() {
        return className;
    }
}
