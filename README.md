## Robot  
  
This is a small program for a robot controller. It’s a simple robot that can
walk around in a room where the floor is represented as a number of fields in a
wire mesh.  
  
To run the program you need to have java and maven installed.  
  
Run in terminal:  
Clone the repository  
Step into the target/classes folder  
Type: java Main  
  
Test in terminal:  
Step into the root folder (robot)  
Type: mvn clean test  
  
  
Improvement suggestion:  
If I had more time on this assignment I would be a bit kinder when validating user input; 
- invalid navigation command could be skipped and the program would move on to execute the next command.
- option could be added to try again in case of user input exceptions, and at the end of executing the program.
