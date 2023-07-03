LanderController contains C Code which communicates with the LanderDash application to control the parameters lander and receive data about the lander using UDP Proctol.


LanderDash is a Java application which is the Dashboard of the Lander. It receives the commands from LanderController and sends them to LunarLander.

LunarLander contains a Java Application simulating movement of the lunar lander in 2d space
A. The Architecture of the Program

The program used 5 threads and 3 semaphores. The Keyboard thread takes user input and changes the thrust and rotation of the lander, using Lander commands semaphore which manages command variables to ensure that any other thread is not changing these variables at the same time. Display thread is using three semaphores during execution, first to lock the variables associated with the condition of the lander, second which locks the state of the lander and then the command semaphore to show current thrust and rotation without interruption from the keypress.  The lander thread communicates with the lander server and uses a command semaphore when it sends commands to the server. The dashboard thread sends the condition of the lander to the server with the use of a condition semaphore to lock the variables during sending process. The data logging thread reports the condition and state of the lander and saves it to the file using appropriate semaphores. 
B. Communication Protocol

The program is using UDP protocol. The UDP has a very small transmission delay because if the packet is lost or corrupted during transmission it is not retransmitted. It makes it efficient for the Lunar lander which needs to respond fast after the user keypress. Moreover, UDP is a better protocol for broadcast and multicast transmission than TCP. It is more suitable to use UDP because the lunar lander controller needs to communicate with the dashboard and Lander server. The size of the packages is smaller than in the TCP, UDP requires less processing time and users less memory. However, UDP is unreliable because of a lack of checking packets between sender and receiver but it is a not huge issue for Lunar Lander because in this application the speed of the transmission is a more significant factor and if the data with the pressed key was lost on the way it can be easily sent again with another press of the button. 
C. Data Logging

The program logs the initial position of the lander, then it logs the new position in 5 seconds periods together with O orientation, horizontal velocity, vertical velocity, and rate of rotation. After landing or crash of the lander, the final position is logged together with the time of the flight. The program stores data of the flight in a file called ‘landerData’ with a Log extension. To measure the rate of file growth it was assumed that the average flight takes 60 seconds, after 10 test flights which took 1 min, every flight produced an average size of 2KB of data. 


(1) Go to the LanderDash_v1 folder in one terminal, and use the following command to run the Lander Dash
```
$ cd LanderDash_v1
$ java -jar LanderDash.jar
```
if this is the first time to use it, you need to build it by using 
```
$ make all
``` 

(2) Go to the LunarLander folder in a new terminal, and use the following command to run the Lunar Lander
```
$ cd LunarLander
$ java -jar LunarLander.jar
```
if this is the first time to use it, you need to build it by using 
```
$ make all
``` 

(3) Go to the LanderController folder in a new terminal, and use the following command to run the controller
```
$ cd LanderController
$ ./controller 65200 65250
```
