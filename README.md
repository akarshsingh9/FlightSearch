# Flight Search Android App - Assignment

## Requirements

1. Search Panel
  - From
  - To
  - Departure Date
  - No. of Passengers
  - Search Button
2. Listing Page
  - image of flight
  - Name of Flight
  - Deptature Time
  - Arrival Time
  - Total duration (Hours)
  - Price
  - Book Button
3. User will enter source and destination airports, dept date, no. of passengers and press search.
4. List of flights with above requirements will be displayed. Flight info will be stored in RDBMS
5. Consider all flights non-stop
6. on click on book flight - store details in database and prompt booking successful

## App ScreenShots

1. Search Panel - asking details regarding user journey

![step1](https://user-images.githubusercontent.com/18751913/44507969-36ee6d80-a6ca-11e8-9f8e-38eef9319736.PNG)

2. Date Picker for selecting departure date

![step3](https://user-images.githubusercontent.com/18751913/44508034-75842800-a6ca-11e8-9511-bfe5decc1992.PNG)

3. User enter city codes in from and to which will be used to search in SQLite database as well. Press "Search Flight" Button.

![step2](https://user-images.githubusercontent.com/18751913/44508085-9c425e80-a6ca-11e8-98a2-0d876b71a56d.PNG)

4. Search Result is generated in RecyclerView with flight Image, name, dept time, arrival time, hours, price

![step4](https://user-images.githubusercontent.com/18751913/44508208-17a41000-a6cb-11e8-931a-f7cd153aa26e.PNG)

5. When user selects any flight a new activity or screen open that has details regarding the flight and total fare is calculated. 
Press "Book Flight" Button to store details in database and generate a Toast that booking was successful.

![step5](https://user-images.githubusercontent.com/18751913/44508345-8e410d80-a6cb-11e8-8225-ad84122e23f4.PNG)

![screenshot_1535003905](https://user-images.githubusercontent.com/18751913/44526205-e6463700-a700-11e8-8c9f-829463d7ed87.png)


## Flow

- MainActivity displays the search panel where user enters **from** city code, **to** city code, **dept date** using date picker, 
number of passengers.
- During first time run of the app, Database is populated with flight details.
- Press "Search Flight" button to search for flights in database. Intent to next activity - flightSearched activity.
- flightSearched activity - gets intent values, performs search and display results in RecyclerView
- When user selects an item from RecyclerView or selects a flight. Intent to new Activity - BookActivity
- BookActivity - It displays details of user selected flight and total fare based on number of passengers. 
- Press "Book Flight" button to insert these details to database and recieve Toast message that booking was successful

## How to run the app

- An apk file is stored in apk folder. This apk file can be directly installed on your Android device and run.
- **Alternate:** You can run this app in Android Studio emulator.
1. In order to run this app in Android emulator. Download this project.
2. Open this project in Android Studio.
3. Create an emulator if you haven’t already done so. The emulator needs to be on minimum API 21: Lollipop. 
   Any screen/phone size will do. Any higher API will also work. 
4. Once your emulator is ready. Run the app. 
5. In **from** enter value: **MAA**
6. In **to** enter value: **BOM**
7. Select Dept Date as: **28/8/2018**
8. Select Passenger number: Anything from 1-9

Note: Only limited cities are added to show that the logic and flow of the app works as intended. More values can be added to populate
 the screen if needed.
 

That's all
==============================================================================================================
