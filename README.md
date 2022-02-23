# Librodata - Gestiunea si livrarea de carti electronice

### Codreanu Dan 321CB
---

## Description
This project is build to manage a simplified version of an online book shop responsible of delivering books to it's customers.

The program can:
* Read the informations about the necessary entities for the program from given files
* Establish connections between data, also from files
* Find books, countries in which books are available, languages of books, common books for 2 retailers and all books for 2 retailers based on given searching values 
***

## Functionality

After all the data is loaded from the files, the searching functionality of the project can be used. There are 5 Searching methods to use after an Administration instance is created:

```Java
// pRetailers is a PublishingRetailers array
// languages is a languages array
Administration library = new Administration(pRetailers, languages);
```
#### Examples of usages for the 5 searching methods:

* getBooksForPublishingRetailerID
```Java
Book[] books = library.getBooksForPublishingRetailerID(retailerID);
```
* getLanguagesForPublishingRetailerID

```Java
Language[] languagesForRetailer = library.getLanguagesForPublishingRetailerID(retailerID);
```
* getCountriesForBookID
```Java
Country[] countriesForBook = library.getCountriesForBookID(bookID);
```
* getCommonBooksForRetailerIDs
```Java
Book[] commonBooks = library.getCommonBooksForRetailerIDs(retailerID1, retailerID2);
```
* getAllBooksForRetailerID's
```Java
Book[] allBooks = library.getAllBooksForRetailerIDs(retailerID1, retailerID2);
```
***

## Class Structure
1. Main Scheme Classes
    * Book -> connected to Author, Language
    * EditorialGroup -> connected to Book
    * PublishingBrand -> connected to Book
    * IPublishingArtifact -> implemented by Book, EditorialGroup, PublishingBrand :: Connected to PublishingRetailer 
    * Country -> connected to PublishingRetailer
    * SearchableItem ->  extended by Author, Book, Country, EditorialGroup, Language, PublishingBrand, PublishingRetailer
2. Utilitary Classes
    * ReadFromFile
    * EstablishConnections
    * TestWriter
    * Utils
3. Administrative Classes
    * LibraryHub
    * Administration
***

## Brief Class Descriptions
* Administration - Class containing the implementations for searching methods
* Author,Book, Country, EditorialGroup, Language, PublishingBrand, PublishingRetailer - Classes that model their specific entity
* EstablishConnections - Class that contain methods which establish the connections between two entities
* IPublishingArtifact - Interface that contains the Publish() method used by Book, EditorialGroup and PublishingBrand
* LibraryHub - the main Class that initiates the program and where tests are efectuated
* ReadFromFile - Class that 
contains methods to create the needed entities by getting their attributes from files
* SearchabeItem - Class that contains an ID used by every entity and a searching method for every entity to use
* TestsWriter - Class containing methods to run and store test results
* Utils - Class that contains a method for generating a book info block used by EditorialGroups and PublishingRetailers
***

## Brief Searching Methods Descriptions

* getBooksForPublishingRetailerID - returns an array of unique books from the retailer with the specified ID
* getLanguagesForPublishingRetailerID - returns an array of unique languages that the retailer with the specified ID has
* getCountriesForBookID - returns an array of unique countries in which can be found the book with the specified ID
* getCommonBooksForRetailerIDs - returns an array of unique books that are common for the Retailers with the specified IDs
* getAllBooksForRetailerIDs - returns an array of unique books from both retailers with specified IDs
***

### Tests and Initial Files
* Initial files are in the src/init folder
* All the test results are in the src/tests folder