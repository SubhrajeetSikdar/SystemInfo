# SystemInfo Java Application

## Description
The `SystemInfo` Java application retrieves and displays system information including the IP address, operating system details, CPU information, memory usage, file system details, and network interface statistics using the Sigar library.

## Requirements
- Java Development Kit (JDK) 1.8 or higher
- Sigar library

## Installation

### 1. Download and Install JDK
Make sure you have Java Development Kit (JDK) installed on your system. You can download it from [Oracle JDK Downloads](https://www.oracle.com/java/technologies/javase-downloads.html).

### 2. Download Sigar Library
Download the Sigar library from the [Hyperic Sigar GitHub repository](https://github.com/hyperic/sigar).

### 3. Include Sigar Library in Your Project
Add the Sigar JAR file and the native libraries to your project build path.

#### Adding Sigar JAR to Your Build Path
1. Place the `sigar.jar` file in your project's `lib` directory.
2. Add the `sigar.jar` to your build path.

#### Adding Native Libraries
Extract the native libraries from the Sigar distribution and place them in a directory that is included in your system's library path.

## Usage

### Running the Application
1. Clone or download the source code from the repository.
2. Ensure that the Sigar library (both JAR and native libraries) is included in your project's build path.
3. Compile and run the `SystemInfo.java` file.



## Output
- Operating System Detail
- IP address
- CPU Information
- Memory Information
- File System Information
- Network Interface Information
-System Uptime
 
#### Compilation
```bash
javac -cp .:lib/sigar.jar SystemInfo.java






IP address: 192.168.1.2
OS: Windows 10
OS Version: 10.0
Architecture: amd64
User: JohnDoe

CPU Info:
Vendor: Intel
Model: Core(TM) i7-9700K CPU @ 3.60GHz
Mhz: 3600

Memory Info:
Total: 16384 MB
Used: 8192 MB
Free: 8192 MB

File System:
Device: C:
Total: 500000000 KB
Used: 250000000 KB
Free: 250000000 KB

Network Interface:
Interface: eth0
Address: 192.168.1.2
MAC Address: 00:1A:2B:3C:4D:5E
RX Packets:




