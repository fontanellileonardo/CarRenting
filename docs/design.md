# Application documentation - Design
## Use case diagram
![Use case diagram](/Images/usecase.png)
The main actors of the system are the Employer and the Customer.
Both ones can register to the system, login and logout and browse the feedbacks of the customers.
They can also browse the cars, the Employer can browse through all system’s cars, the Customers instead can search through only the available ones in a certain period.
In addition, both the actors can browse the reservations in the system, but the Employer can see all the ones in the system, instead the Customer can see only the ones associated to him.
There are actions that can be computed only from a specific type of actor, in fact the Employer can add or delete a car and he can browse the customers registered. On the other side, the customer can add a feedback.

## Analysis classes diagram
![Analisys classes diagram](/Images/analysisclasses.png)
The User class has a one to many relationship with the Feedback class, because each user can write many feedbacks about his experience with the system but each feedback is associated with only one user.
In addition, the User class has a one to many relationship with the Reservation class, because each user can reserve zero or many cars but each reservation is associated with only one user.
The Car class has a one to many relationship because each car can be reserved by zero or many users (in different periods) but each reservation is associated with only one car.

## Software Architecture
The system is composed by a client application which is divided into a front-end and a business layer.
![Software Architecture](/Images/architecture.png)
The last one is connected to a remote relational database where are stored all the information. The architecture of the client is implemented in JAVA.
The Frontend is composed by the graphic interfaces for the Customer and the Employer that are realized with JavaFX libraries.
That classes are responsible to take the inputs of the users for all the operations permitted and then they send the data to the business layer. When the user inserts the credentials, the password is encrypted with SHA-1 algorithm.
The business layer is the one that satisfies the requests coming from the interface using JPA or both JPA and Riak to perform queries on the remote database. At the end of the operations, it returns the results to the graphic interface. This layer is composed by RentHandler class, JPAHandleDB class and RiakHandleDB class.
