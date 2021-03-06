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

![step1](https://user-images.githubusercontent.com/18751913/44585677-bb281a00-a7ca-11e8-98f7-de4cb81e1b05.PNG)

2. Date Picker for selecting departure date

![step2](https://user-images.githubusercontent.com/18751913/44585678-bcf1dd80-a7ca-11e8-9809-c3817035f9e6.PNG)

3. User enter city codes in from and to which will be used to search in SQLite database as well. Press "Search Flight" Button.

![step3](https://user-images.githubusercontent.com/18751913/44585680-bf543780-a7ca-11e8-8947-3fc1ac7a4db5.PNG)

4. Search Result is generated in RecyclerView with flight Image, name, dept time, arrival time, hours, price

![step4](https://user-images.githubusercontent.com/18751913/44585681-c1b69180-a7ca-11e8-869d-d96413ff9251.PNG)

5. When user selects any flight a new activity or screen open that has details regarding the flight and total fare is calculated. 
Press "Book Flight" Button to store details in database and generate a Toast that booking was successful.

![step5](https://user-images.githubusercontent.com/18751913/44585682-c3805500-a7ca-11e8-87f3-97c7a98fdb76.PNG)

6. 

![step6](https://user-images.githubusercontent.com/18751913/44585683-c5e2af00-a7ca-11e8-98bc-40f234c30c57.PNG)


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
 
 Currently you can select from
      * BOM - Mumbai
      * MAA - Chennai
      * DEL - Delhi
      * BLR - Bangalore
      * AHM - Ahmedabad
      * CCU - Kolkata
      * PAT - Patna
 Departure Dates: 25/8/2018,26/8/2018,27/8/2018,28/8/2018,29/8/2018,30/8/2018
  

**Update: I have changed the UI and APK at 6:05 PM on 24/08/2018. I have updated the README accordingly.**

That's all
==============================================================================================================
