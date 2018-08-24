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

![screenshot_1535114011](https://user-images.githubusercontent.com/18751913/44584973-52d83900-a7c8-11e8-9a37-6ec0816aba19.png)

2. Date Picker for selecting departure date

![screenshot_1535114036](https://user-images.githubusercontent.com/18751913/44584999-6daaad80-a7c8-11e8-97a9-4a627139e454.png)

3. User enter city codes in from and to which will be used to search in SQLite database as well. Press "Search Flight" Button.

![screenshot_1535114047](https://user-images.githubusercontent.com/18751913/44585018-7d29f680-a7c8-11e8-9f16-09d39aa80d52.png)

4. Search Result is generated in RecyclerView with flight Image, name, dept time, arrival time, hours, price

![screenshot_1535114070](https://user-images.githubusercontent.com/18751913/44585044-90d55d00-a7c8-11e8-86aa-a63187d313ea.png)

5. When user selects any flight a new activity or screen open that has details regarding the flight and total fare is calculated. 
Press "Book Flight" Button to store details in database and generate a Toast that booking was successful.

![screenshot_1535114077](https://user-images.githubusercontent.com/18751913/44585061-a054a600-a7c8-11e8-92c4-a04e52a63420.png)

6. 

![screenshot_1535114080](https://user-images.githubusercontent.com/18751913/44585080-b5313980-a7c8-11e8-8ea8-c0af9ed3c754.png)


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

**Update: I have changed the UI and APK at 6:05 PM on 24/08/2018. I have updated the README accordingly.**

That's all
==============================================================================================================
