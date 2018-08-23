package com.codeinpython.flightsearch;

//POJO for Booking database
public class Book {
    private String flightName;
    private String departure;
    private String arrival;
    private String fromCode;
    private String toCode;
    private String fare;

    Book(String flightName,String departure,String arrival,String fromCode,String toCode,String fare)
    {
        this.flightName = flightName;
        this.departure = departure;
        this.arrival = arrival;
        this.fromCode = fromCode;
        this.toCode = toCode;
        this.fare = fare;

    }

    //getter methods
    public String getToCode() {
        return toCode;
    }

    public String getFromCode() {
        return fromCode;
    }

    public String getFlightName() {
        return flightName;
    }

    public String getArrival() {
        return arrival;
    }

    public String getDeparture() {
        return departure;
    }

    public String getFare() {
        return fare;
    }

    public static final String BOOK_ID = "id";
    public static final String FLIGHT_NAME = "flightname";
    public static final String PRICE = "price";
    public static final String DEPT_TIME="depttime";
    public static final String ARR_TIME="arrtime";
    public static final String FROM_CODE = "fromcode";
    public static final String TO_CODE = "tocode";

    //DB
    public static final String DB_NAME = "BookDB";
    public static final String TB_NAME = "BookTB";
    public static final int DB_VERSION=1;

    //Create TB
    public static final String CREATE_TB = "CREATE TABLE "+TB_NAME+"("
            +BOOK_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            +FLIGHT_NAME+ " TEXT NOT NULL,"
            //+DEPT_DATE+" TEXT NOT NULL,"
            +DEPT_TIME+ " TEXT NOT NULL,"
            +ARR_TIME+ " TEXT NOT NULL,"
            +FROM_CODE+" TEXT NOT NULL,"
            +TO_CODE+" TEXT NOT NULL,"
            +PRICE+ " TEXT NOT NULL);";
    //   +AIRPORT+" TEXT NOT NULL);";
    //DROP TB
    static final String DROP_TB="DROP TABLE IF EXISTS "+TB_NAME;

}
