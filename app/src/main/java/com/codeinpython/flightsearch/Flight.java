package com.codeinpython.flightsearch;

//POJO Class for SQLite Database
@SuppressWarnings("FieldCanBeLocal")
class Flight {

    private String flightName;
    private String deptDate;
    private String deptTime;
    private String arrTime;
    private String hrs;
    private String fromCode;
    private String toCode;
    private String price;

    Flight(String flightName,String deptDate,String deptTime,String arrTime,String hrs,String fromCode,String toCode,String price)
    {
        this.flightName = flightName;
        this.deptDate = deptDate;
        this.deptTime = deptTime;
        this.arrTime = arrTime;
        this.hrs = hrs;
        this.fromCode = fromCode;
        this.toCode = toCode;
        this.price = price;

    }


    //Columns
    public static final String FLIGHT_ID = "id";
    public static final String FLIGHT_NAME = "flightname";
    public static final String PRICE = "price";
    public static final String DEPT_TIME="depttime";
    public static final String ARR_TIME="arrtime";
    public static final String HOURS = "hours";
    public static final String DEPT_DATE = "deptdate";
    public static final String FROM_CODE = "fromcode";
    public static final String TO_CODE = "tocode";

    //DB
    public static final String DB_NAME = "flight_searchDB";
    public static final String TB_NAME = "flight_searchTB";
    public static final int DB_VERSION=1;

    //Create TB
    public static final String CREATE_TB = "CREATE TABLE "+TB_NAME+"("
            +FLIGHT_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            +FLIGHT_NAME+ " TEXT NOT NULL,"
            +DEPT_DATE+" TEXT NOT NULL,"
            +DEPT_TIME+ " TEXT NOT NULL,"
            +ARR_TIME+ " TEXT NOT NULL,"
            +HOURS+ " TEXT NOT NULL,"
            +FROM_CODE+" TEXT NOT NULL,"
            +TO_CODE+" TEXT NOT NULL,"
            +PRICE+ " TEXT NOT NULL);";

    //DROP TB
    static final String DROP_TB="DROP TABLE IF EXISTS "+TB_NAME;

}
