import java.util.Arrays;
import java.util.HashMap;

public class Administration {
    private final PublishingRetailer[] pRetailers;
    private final Language[] languages;

    public Administration(PublishingRetailer[] pRetailers, Language[] languages) {
        this.pRetailers = pRetailers;
        this.languages = languages;
    }

    /**
     * Method to check if a book is in an array or not
     * @param books the array of books
     * @param ID the bookID to check if it's in array
     * @return false if the book exists, true if not exists
     */
    private boolean checkBookArray(Book[] books, int ID){
        for (Book b:books)
            if (b.getID() == ID)
                return false;

        return true;
    }

    /**
     * Method to insert a book in array
     * @param bArray the array to insert in
     * @param item the book to be inserted
     * @return the updated array
     */
    private Book[] addToBookArray(Book[] bArray, Book item) {
        bArray= Arrays.copyOf(bArray, bArray.length + 1);
        int pos = bArray.length;
        bArray[pos - 1] = item;
        return  bArray;
    }

    /**
     * Method to get all the artifacts from a specific publishingRetailer
     * @param publishingRetailerID the ID of the publishingRetailer
     * @return an array of the retailer's artifacts
     */
    private IPublishingArtifact[] getArtifactsFromRetailerID(int publishingRetailerID){
        PublishingRetailer myPRetailer = null;
        for (PublishingRetailer i : pRetailers) {
            if (i.findByID(publishingRetailerID)) {
                myPRetailer = i;
                break;
            }
        }

        if (myPRetailer == null) return null;

        return myPRetailer.getPublishingArtifacts();

    }

    /**
     * Methot to get all the unique books from a specific publishingRetailer
     * @param publishingRetailerID the ID of the publishingRetailer that we need
     * @return the array containing all the unique books from retailer
     */
    public Book[] getBooksForPublishingRetailerID(int publishingRetailerID) {
        Book[] booksOfRetailer = new Book[0];

        IPublishingArtifact[] artifacts = getArtifactsFromRetailerID(publishingRetailerID);
        if (artifacts == null) return null;
        // For each book from retailer check if there is no copy of it already and insert in array
        for (IPublishingArtifact art : artifacts) {
            if (art instanceof Book) {
                int bID = ((Book) art).getID();
                if (checkBookArray(booksOfRetailer, bID)) {
                    booksOfRetailer = addToBookArray(booksOfRetailer, (Book) art);
                }
            }else if (art instanceof EditorialGroup) {
                Book[] EditorialBooks = ((EditorialGroup) art).getBooks();
                for (Book b : EditorialBooks) {
                    int bID = b.getID();
                    if (checkBookArray(booksOfRetailer, bID)) {
                        booksOfRetailer = addToBookArray(booksOfRetailer, b);
                    }
                }
            }else {
                Book[] PBrandBooks = ((PublishingBrand) art).getBooks();
                for (Book b : PBrandBooks) {
                    int bID = b.getID();
                    if (checkBookArray(booksOfRetailer, bID)) {
                        booksOfRetailer = addToBookArray(booksOfRetailer, b);
                    }
                }
            }
        }

        return booksOfRetailer;
    }

    /**
     * Method to find a reference to the language with the given ID
     * @param languageID the ID of the required language
     * @return the found language
     */
    private Language findLanguageByID(int languageID){
        for (Language l:this.languages){
            if (l.getID() == languageID)
                return l;
        }
        return null;
    }

    /**
     * Method to check if a language is in an array
     * @param languageID the ID of the needed language
     * @param array the array of languages to check in
     * @return false if the array contains language / true if it does not
     */
    private boolean checkLanguageArray(int languageID, Language[] array){
        for (Language l:array){
            if (l.getID() == languageID){
                return false;
            }
        }
        return true;
    }

    /**
     * Method to add a language to a language array
     * @param lArray the array to add the language to
     * @param item the language to be inserted
     * @return the updated array
     */
    private Language[] addToLanguageArray(Language[] lArray, Language item){
        lArray = Arrays.copyOf(lArray, lArray.length + 1);
        int pos = lArray.length;
        lArray[pos - 1] = item;
        return lArray;
    }

    /**
     * Method to get all the unique languages from a specific publishingRetailer
     * @param publishingRetailerID the ID of the publishingRetailer
     * @return an array containing all the languages
     */
    public Language[] getLanguagesForPublishingRetailerID(int publishingRetailerID){
        Language[] languagesOfRetailer = new Language[0];

        IPublishingArtifact[] artifacts = getArtifactsFromRetailerID(publishingRetailerID);
        if (artifacts == null) return null;

        // For each book check for the language and if is unique insert it in array
        for (IPublishingArtifact art : artifacts) {
            int langID;
            if (art instanceof Book) {
                langID = ((Book) art).getLanguageID();
                if (checkLanguageArray(langID, languagesOfRetailer)){
                    Language languageToAdd = findLanguageByID(langID);
                    languagesOfRetailer = addToLanguageArray(languagesOfRetailer, languageToAdd);
                }
            }else if (art instanceof EditorialGroup) {
                Book[] EditorialBooks = ((EditorialGroup) art).getBooks();
                for (Book b : EditorialBooks) {
                    langID = b.getLanguageID();
                    if (checkLanguageArray(langID, languagesOfRetailer)){
                        Language languageToAdd = findLanguageByID(langID);
                        languagesOfRetailer = addToLanguageArray(languagesOfRetailer, languageToAdd);
                    }
                }
            }else {
                Book[] PBrandBooks = ((PublishingBrand) art).getBooks();
                for (Book b : PBrandBooks) {
                    langID = b.getLanguageID();
                    if (checkLanguageArray(langID, languagesOfRetailer)){
                        Language languageToAdd = findLanguageByID(langID);
                        languagesOfRetailer = addToLanguageArray(languagesOfRetailer, languageToAdd);
                    }
                }
            }
        }
        return languagesOfRetailer;
    }

    /**
     * Method to check if a country exists in an array
     * @param countries the array with countries
     * @param countryID the ID of the wanted country
     * @return false if country exists / true if it does not
     */
    private boolean checkCountryArray(Country[] countries, int countryID){
        for (Country c:countries){
            if (c.findByID(countryID))
                return false;
        }
        return true;
    }

    /**
     * Method to insert a country in array
     * @param cArray the array to insert in
     * @param item the country to be inserted
     * @return the updated array
     */
    private Country[] addToCountriesArray(Country[] cArray, Country item){
        cArray = Arrays.copyOf(cArray, cArray.length + 1);
        int pos = cArray.length;
        cArray[pos - 1] = item;
        return cArray;
    }

    /**
     * Method to get all the countries a book is present in
     * @param bookID the ID of the wanted book
     * @return an array containing the countries
     */
    public Country[] getCountriesForBookID(int bookID){
        Country[] countriesForBook = new Country[0];

        for (PublishingRetailer pr:this.pRetailers){
            Book[] booksFromRetailer = getBooksForPublishingRetailerID(pr.getID());

            // If I find the book at this retailer
            if (!checkBookArray(booksFromRetailer, bookID)) {
                Country[] countriesFromRetailer = pr.getCountries();
                for (Country c : countriesFromRetailer) {
                    if (checkCountryArray(countriesForBook, c.getID())) {
                        countriesForBook = addToCountriesArray(countriesForBook, c);
                    }
                }

            }
        }
        return countriesForBook;
    }

    /**
     * Method to get all the coomon books from two retailers
     * @param retailerID1 the ID of the first retailer
     * @param retailerID2 the ID of the second retailer
     * @return the array containing the common books
     */
    public Book[] getCommonBooksForRetailerIDs(int retailerID1, int retailerID2){
        Book[] commonBooks = new Book[0];

        HashMap<Book, Integer> hm = new HashMap<>();

        //We know for sure this arrays cannot contain 2 same books in one array
        Book[] booksOfRetailer1 = getBooksForPublishingRetailerID(retailerID1);
        Book[] booksOfRetailer2 = getBooksForPublishingRetailerID(retailerID2);
        if (booksOfRetailer1 == null || booksOfRetailer2 == null) return null;

        for (Book b:booksOfRetailer1 )
            hm.put(b,1);

        for (Book b:booksOfRetailer2){
            if (hm.containsKey(b)){
                Book commonBook = b;
                commonBooks = addToBookArray(commonBooks, commonBook);
            }
        }

        return commonBooks;
    }

    /**
     * Method to get all books from retailers 1 and 2
     * @param retailerID1 the ID of the first retailer
     * @param retailerID2 the ID of the second retailer
     * @return the array containing all books
     */
    public Book[] getAllBooksForRetailerIDs(int retailerID1, int retailerID2){
        Book[] allBooks = new Book[0];

        //We know for sure this arrays cannot contain 2 same books in one array
        Book[] booksOfRetailer1 = getBooksForPublishingRetailerID(retailerID1);
        Book[] booksOfRetailer2 = getBooksForPublishingRetailerID(retailerID2);

        if (booksOfRetailer1 == null || booksOfRetailer2 == null) return null;

        HashMap<Book, Integer> hm = new HashMap<>();

        for (Book b:booksOfRetailer1 )
            hm.put(b,1);

        allBooks = Arrays.copyOf(booksOfRetailer1, booksOfRetailer1.length);

        for (Book b:booksOfRetailer2){
            if (!hm.containsKey(b)){
                allBooks = addToBookArray(allBooks, b);
            }
        }

        return allBooks;
    }

}
