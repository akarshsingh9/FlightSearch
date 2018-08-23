package com.codeinpython.flightsearch;

public class SearchedModelClass {

    /*
    *   SearchedModelClass - model class for searched items that will be placed in recyclerview
    *   After searching SQLite database the result is passed in list via SearchedModelClass
    *   getter defined
    *   Constructor is important
     */

    private int flightImage;
    private String fromCode;
    private String toCode;
    private String deptTime;
    private String arrTime;
    private String hrs;
    private String price;
    private String flightName;

    SearchedModelClass(int flightImage,String flightName,String fromCode,String toCode,String deptTime,String arrTime,String hrs,String price)
    {
        this.flightImage = flightImage;
        this.flightName = flightName;
        this.fromCode = fromCode;
        this.toCode = toCode;
        this.deptTime = deptTime;
        this.arrTime = arrTime;
        this.hrs = hrs;
        this.price = price;

    }

    public int getFlightImage() {
        return flightImage;
    }

    public String getArrTime() {
        return arrTime;
    }

    public String getDeptTime() {
        return deptTime;
    }

    public String getFlightName() {
        return flightName;
    }

    public String getFromCode() {
        return fromCode;
    }

    public String getHrs() {
        return hrs;
    }

    public String getPrice() {
        return price;
    }

    public String getToCode() {
        return toCode;
    }

}
