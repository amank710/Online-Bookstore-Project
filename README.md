# Aman's Bookstore

## An Online Bookstore


I have decided to create an **online bookstore** application as my personal project. This will allow people to browse 
purchase books from the comfort of their homes.

There are a large variety of books to choose from in this online store. These books are all reasonably priced with various **discount** options available. The bookstore is based out of Vancouver and is able to deliver to a 
number of large cities in Canada.

I have always been interested in reading. During the COVID-19 pandemic it became difficult to venture out to physical book stores
to purchase books. I found that there were not many online stores that were **both** *user-friendly* and *explicitly dedicated to selling books.*
Thus, I felt strongly about trying to create a ***user-friendly online bookstore.***

### User Stories

- As a user, I want to be able to view the discounts I can avail
- As a user, I want to be able to browse the available books by genre
- As a user, I want to be able to add books to my cart
- As a user, I want to be able to add multiple copies of the same book to my cart
- As a user, I want to be able to view my bill at any given moment
- As a user, I want to be able to pay the bill through credit card transaction
- As a user, I want to be able to exit the application at any point of time
- As a user, I want to be able to enter my desired address for the delivery of the books
- As a user, I want to be able to save my cart to file
- As a user, I want to be able to be able to load my cart from file 


### Phase 4: Task 2

I have chosen to make one of the classes in my model class robust. I added the "InavalidAmountException"
and the "NegativeQuantityException" in the exceptions package.
I have made the "Cart" class robust. There are 2 methods in this class that I modified.
These methods are the "addToCart" method and the "discount" method.
The exception thrown by the "addToCart" method is being caught in either the "BookstoreGUI" class or 
the "JsonReader" class.
The exception thrown by the "discount" method is being caught in the "BookstoreGUI" class.

### Phase 4: Task 3

- If I had more time to work on this project I would store the books available for sale as an
enumeration insead of different self-referential fields in the Book class. 
- I would also store the different cities available for delivery in an enumeration insead of different 
self-referential fields in the City class. 
- Right now the Bookstore GUI is temporarily keeping track of which book is being added to the cart
at some given moment. I would try to remove this association between BookstoreGUI and Book, and either 
remove the relation between the two completely or make it a dependance relationship instead.
- Since each customer has a unique cart, I would remove the association between BookstoreGUI and Cart. I would then make
and association relationship between Customer and Cart. This would allow the UI to be associated with less of 
the backend implementation.