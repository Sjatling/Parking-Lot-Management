# 🚗 Parking Lot Management System  
A simple, command-line based Parking Lot Management System implemented in *Java*.  
This project allows users to create parking slots of different vehicle sizes, park vehicles, exit vehicles, and view parking status in real time.

---

## 📌 Features

### ✅ Core Features
- Add parking slots for:
  - *SMALL*
  - *LARGE*
  - *OVERSIZE*
- Park vehicles based on size availability.
- Automatically assigns the next available slot.
- Exit parked vehicles and free the slot.
- Display current parking status.
- View help commands.
- Fully interactive CLI menu.

---

## 🧱 Project Structure
Parking-Lot-Management/
│
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── example/
│                   └── parking/
│                       ├── ParkingLotApp.java
│                       ├── ParkingLot.java
│                       ├── ParkingSlot.java
│                       ├── Vehicle.java
│                       └── VehicleSize.java
│
├── bin/        # (Generated compiled .class files)
├── README.md

---

## 🛠 How to Compile and Run

### *1️⃣ Compile the project*

Open terminal inside Parking-Lot-Management folder and run:

javac -d bin src/main/java/com/example/parking/*.java  

Sample Run

Welcome to Parking Lot Management!

Enter number of SMALL slots: 2
Enter number of LARGE slots: 3
Enter number of OVERSIZE slots: 1

Available commands:
PARK <plate> <SMALL|LARGE|OVERSIZE>
EXIT <plate>
STATUS
HELP
QUIT

Enter command: PARK ABC123 SMALL
Parked ABC123 (SMALL) in slot 1

Enter command: STATUS
Slot 1 -> ABC123 (SMALL)
Slot 2 -> EMPTY
...

📚 Classes Overview

🔸 Vehicle.java

Represents a vehicle with:
	•	plate number
	•	vehicle size

🔸 VehicleSize.java

Enum with 3 sizes:
	•	SMALL
	•	LARGE
	•	OVERSIZE

🔸 ParkingSlot.java

Represents an individual slot and stores:
	•	slot ID
	•	vehicle size allowed
	•	parked vehicle

🔸 ParkingLot.java

Controls:
	•	All slots
	•	Parking logic
	•	Unparking logic
	•	Status reporting

🔸 ParkingLotApp.java

Main CLI application:
	•	Loads scanner
	•	Reads user commands
	•	Executes parking operations

Commands Available

Command
Description
PARK <plate> <size>
Parks a vehicle in an appropriate slot
EXIT <plate>
Removes a vehicle from its slot
STATUS
Shows all parked vehicles and slot information
HELP
Shows list of commands
QUIT
Exit the program

💻 Tech Stack
	•	Java 17+
	•	OOP (Object-Oriented Programming)
	•	CLI (Command-Line Interface)

⸻

🌟 Future Enhancements (Optional Ideas)
	•	Save parking state to a file.
	•	Add timestamps for calculating parking fees.
	•	Implement REST API version using Spring Boot.
	•	Add GUI dashboard.
