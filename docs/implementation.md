# Application documentation - Implementation
## JPA Implementation
The entities defined in JPA are: *User*, *Car*, *Feedback* and *Reservation*.
For all the relationships among the entities the application doesn’t use cascade parameters because each operation on the entities is isolated, so the other entities are not involved.
For example, when a new user is created, there is no need to create also a feedback associated with him/her.
For all the entities the attribute @Id is applied in the getter method so we must apply every other annotation that affects the fields of the class on the related getter methods. If instead we use @Id directly on a class field, we are specifying a direct access to the class fields. We use the first approach because using the getter and setter methods is the standard pattern.
The attribute @Column has been used for all the entities in order to specifies the names of the attributes in the tables in the DB.
[User class Code](/src/User.java)
Each field of the Entity User corresponds to a column of the table User in the database.
The fields fiscalCode, nickName and email have the unique = true attribute since they have to be unique in the user table.
The entities User and Feedback are associated through a one to many relationship, so each User has a list of Feedback objects and each Feedback has a User object. The attribute mappedBy specifies that the entity User is associated to the field user of the entity Feedback.
The fetch parameter for this relationship defined for User entity is FetchType.LAZY, since the system doesn’t need to fetch always all the feedbacks of each user.
The entities User and Reservation are associated through a one to many relationship, so each User has a list of Reservation objects and each Reservation has a User object. The attribute mappedBy specifies that the entity User is associated to the field user of the entity Reservation.
The fetch parameter in the User entity is FetchType.LAZY, because the system stores all the reservations done by the users, also the ones that are already expired, but only the active ones are shown to the customer, so it is not useful to retrieve every time all the Reservation objects associated to a User.

[Feedback class Code](/src/Feedback.java)

Each field of the Entity Feedback corresponds to a column of the table Feedback in the database. @GeneratedValue(strategy = GenerationType.IDENTITY) attribute is used to generate an auto incremental counter used for the field idFeedback.
The annotation @ManyToOne is used in order to specify that the field user is the one used in the MappedBy attribute in the User entity.
The fetch parameter for the Feedback entity is FetchType.EAGER, since the application shows the user who wrote the feedback, so it needs to retrieve the User object related to the Feedback one every time it has to show a feedback.

[Reservation class Code](/src/Reservation.java)

Each field of the Entity Reservation corresponds to a column of the table Reservation in the database.
@GeneratedValue(strategy = GenerationType.IDENTITY) attribute is used to generate an auto incremental counter used for the field id.
The annotations @ManyToOne are used in order to specify that the fields user and car are the ones used in the MappedBy attributes in the User and Car entities respectively.
The fetch parameter for the relationship with User is FetchType.EAGER, because when a Reservation is retrieved by the Employer, it is useful to have the User information to eventually search him.
The fetch parameter for the relationship with Car is FetchType.EAGER, because a customer can see his active reservations and when the system shows the reservations, it shows also the information about the cars rented.

[Car class Code](/src/Car.java)

Each field of the Entity Car corresponds to a column of the table Car in the database.
The entities Car and Reservation are associated through a one to many relationship, so each Car has a list of Reservation objects and each Reservation has a Car object. The attribute mappedBy specifies that the entity Car is associated to the field car of the entity Reservation.
The fetch parameter in the Car entity is FetchType.LAZY, because the Car, as the User in the previous relationship, has also past reservations and it is not useful to retrieve all the past reservations each time.

## Implementation Class Diagram
![Implementation class diagram 1](/Images/implementation_classs1.png)
![Implementation class diagram 2](/Images/implementation_classs2.png)

## Database Implementation
![Database Implementation](/Images/database_implementation.png)
The database is realized by using a MySQL database and the operations on it are performed by using Java Persistence API (JPA).