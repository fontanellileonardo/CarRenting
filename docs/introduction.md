# Application documentation - Introduction
The task that we realized is a Car Renting application, where users can register, search for available cars and place reservations with a graphic interface.
Also, we have implemented a feedback functionality, that allows the Customer to leave a mark and a comment to the Renting services.
A customer can register and log in, after the log in he is able to place reservations and delete them and also to leave a feedback.
An employer is able to register and log in as well, but differently from the previous case, he’s able to add or delete cars from the available roster. Moreover, in the interface, an Employer has many functionalities: Car Manager, User Table, Feedback Table, Reservation Table.
In the Car Manager he can select a car in the list and delete one of them.
In the User Table he can consult the list of registered Customer to the system.
In the Feedback Table he can view the feedbacks left by the Customer and he’s able to filter them by mark.
In the Reservation Table the Employer has the possibility to have a summary of the reservation and it’s also able to filter them by the licence plate of the cars.

## Requirements
### Functional Requirements
The system is able to store the vehicle records. A vehicle record includes license plate, vendor, branch, seat number, kilometers, price and removed status. Seat number are 2, 4, 5 or 6. Branches are Firenze or Pisa. Removed field can be true or false and depends if the car has been removed from the system by an Employer.
The system is able to store the feedback records. A feedback record includes the id of the feedback, the mark, comment, data, the fiscal code of the user.
The system stores the reservation records. A reservation record includes the id of the reservation, license plate, fiscal code, pick-up date and delivery date.
The system stores the user record that includes name, surname, email, nickname, password, fiscal code and status. The status of the user can be employer or customer.
The system provides an employer interface where only him is able to access. In this interface he can view all the existing cars in a table whose columns are: license plate, vendor, seat number, location, kilometers, day price, status. By selecting a row, he/she can delete an existing car and this is permitted only if the car has no pending reservations. In the same interface he has the possibility to add new cars by compiling a form. When a car’s license plate that refers to a previously removed car is inserted, we assume that it refers to the same car as before. The values of Kilometers, Location and Price are updated with the new ones but the Vendor and Number of Seats have to remain the same.
In addition, the Employer interface allows to view all the registered customers in a table whose columns are: fiscal code, nickname, name, surname, email.
Another possibility is to show the feedbacks table whose columns are: fiscal code, nickname, date, mark and comment. In this table the employer can filter the feedbacks by specifying a maximum mark.
Finally, he can view a reservations table whose columns are: fiscal code, license plate, pickup date and delivery date. In this table he can search the reservations associated to a specific license plate.
The system provides a log-in/registration interface. In order to register to the system, a user must fill a form indicating Name, Surname, Fiscal Code, Nickname, Email, Password and its status witch can be Customer or Employer. It is assumed that no Customer registers as Employer.
The system provides a customer interface that allows to search the available cars by specifying the renting period, the pickup location and the number of seats. The available cars are shown through a table whose columns are: vendor, seat number, kilometres and day price, then he can rent a car by selecting one of the rows.
In this interface it is also possible to view all the reservations associated to the logged customer in a table whose columns are: license plate, pickup date and delivery date. He can delete one of the pending reservations by selecting the corresponding row. Reservations and cancellations must be carried out at least one day in advance. Customers can return the car on the same day they picked it up.
Finally, there is the feedback table where the customer can see the feedbacks left by customers. The columns of the table are: nickname, date, mark and comment. Moreover, he can add a feedback by selecting a mark and writing a comment.

### Non-Functional Requirements
The system is designed in order to be user friendly, it has a graphical interface that is simple and intuitive and guide the user to make the right choice by showing also messages in case of errors.
The system manages the passwords in a secure way because it encrypts the passwords using SHA- 1 when the user inserts them, so the passwords are sent to the DB already encrypted. This is done in order to prevent sniffing and to store them already encrypted.
In addition the system uses a specific user to connect to the DB, in this way the application has limited privileges on the DB in particular it can only modify the specific DB dedicated for the application.