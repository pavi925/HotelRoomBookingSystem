# 🏨 Hotel Room Booking System

A Java-based console application that simulates a hotel room booking system. The application allows users to manage hotel room reservations through a menu-driven interface. It demonstrates the use of Object-Oriented Programming (OOP), collections, exception handling, and Java's Date-Time API.

---

## 📌 Project Overview

The Hotel Room Booking System enables hotel staff to:

- Check guests into available rooms
- View all room details
- Search rooms by status or room type
- Update booking information
- Check guests out
- Validate check-in dates
- Display only available rooms based on the selected room type

This project was developed using Java and IntelliJ IDEA.

---

## ✨ Features

### ✅ Check-In
- Select a room type (Single, Double, Deluxe, Suite)
- Display all available rooms of the selected type
- Enter guest details
- Validate check-in date (dd-MM-yyyy)
- Book the selected room

### ✅ View All Rooms
- Displays complete information of every room
- Room Number
- Guest Name
- Room Type
- Check-In Date
- Booking Status

### ✅ Search by Status
Search rooms based on:
- Available
- Booked

### ✅ Search by Room Type
Search rooms by:
- Single
- Double
- Deluxe
- Suite

### ✅ Update Booking
Update an existing booking by modifying:
- Guest Name
- Room Type
- Check-In Date

### ✅ Check-Out
- Checks out the guest
- Clears guest details
- Marks the room as **Available**
- Prevents checking out an already available room

### ✅ Date Validation
Uses Java's Date-Time API to validate dates.

Example:

```
30-06-2026 ✔
31-02-2026 ✘
```

---

## 🛠 Technologies Used

- Java
- IntelliJ IDEA
- Java Collections (ArrayList)
- Object-Oriented Programming (OOP)
- Exception Handling
- Java Time API

---

## 📂 Project Structure

```
HotelRoomBookingSystem
│
├── src
│   ├── Main.java
│   ├── HotelManager.java
│   └── Room.java
│
└── README.md
```

---

## 📋 Room Entity Fields

| Field | Data Type | Description |
|--------|-----------|-------------|
| roomNo | int | Unique room number |
| guestName | String | Guest name |
| roomType | String | Single / Double / Deluxe / Suite |
| checkInDate | String | Guest check-in date |
| status | String | Available / Booked |

---

## ▶️ How to Run

### Using IntelliJ IDEA

1. Clone the repository

```
git clone <repository-url>
```

2. Open the project in IntelliJ IDEA.

3. Open `Main.java`.

4. Click **Run** or press **Shift + F10**.

---

### Using Command Line

Compile:

```
javac *.java
```

Run:

```
java Main
```

---

## 📷 Sample Menu

```
===== HOTEL ROOM BOOKING SYSTEM =====

1. Check In
2. View All Rooms
3. Search by Status
4. Search by Room Type
5. Update Booking
6. Check Out
7. Exit
```

---

## 📖 Concepts Used

- Classes and Objects
- Constructors
- Encapsulation
- ArrayList
- Loops
- Conditional Statements
- Methods
- Exception Handling
- Date Validation
- Object-Oriented Programming

---

## 🚀 Future Enhancements

- Customer Login
- Admin Login
- Room Pricing
- Payment Module
- Database Integration (MySQL)
- File Storage
- Booking History
- Room Availability Calendar
- Online Reservation System

---

## 📄 License

This project was developed for educational purposes as part of an academic assignment.

---

### ⭐ Thank you for visiting our project!
