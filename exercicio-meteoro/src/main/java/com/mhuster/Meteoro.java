package com.mhuster;

public class Meteoro {
    private String name;
    private int id;
    private String nametype;
    private String recclass;
    private Double mass;
    private String fall;
    private Integer year;
    private Double reclat;
    private Double reclong;
    private String geoLocation;

    public Meteoro(String name, int id, String nametype, String recclass, Double mass, String fall, Integer year, Double reclat, Double reclong, String geoLocation) {
        this.name = name;
        this.id = id;
        this.nametype = nametype;
        this.recclass = recclass;
        this.mass = mass;
        this.fall = fall;
        this.year = year;
        this.reclat = reclat;
        this.reclong = reclong;
        this.geoLocation = geoLocation;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getNametype() {
        return nametype;
    }

    public String getRecclass() {
        return recclass;
    }

    public Double getMass() {
        return mass;
    }

    public String getFall() {
        return fall;
    }

    public Integer getYear() {
        return year;
    }

    public Double getReclat() {
        return reclat;
    }

    public Double getReclong() {
        return reclong;
    }

    public String getGeoLocation() {
        return geoLocation;
    }

    @Override
    public String toString() {
        return String.format("Meteoro{name='%s', id=%d, nametype='%s', recclass='%s', mass=%s, fall='%s', year=%s, reclat=%s, reclong=%s, geoLocation='%s'}",
                name, id, nametype, recclass, mass, fall, year, reclat, reclong, geoLocation);
    }
}