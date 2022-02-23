import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public abstract class TestsWriter {

    /**
     * Method for testing GetBooks method
     * @param library the instance of administration
     * @param retailerID the ID of the retailer to get the books from
     */
    public static void writeTestGetBooks(Administration library, int retailerID){
        String path = "src/tests/testGetBooks" + retailerID + ".out";
        Book[] books = library.getBooksForPublishingRetailerID(retailerID);
        if (books == null) return;

        try {
            FileWriter file = new FileWriter(path);

            BufferedWriter output = new BufferedWriter(file);
            for (Book b:books){
                if (b != null)
                    output.write(b.Publish() + "\n");
            }
            output.close();
        }
        catch (Exception e){
            e.getStackTrace();
        }
    }

    /**
     * Method for testing GetLanguages method
     * @param library the instance of administration
     * @param retailerID the ID of the retailer to get the languages from
     */
    public static void writeTestGetLanguages(Administration library, int retailerID){
        String path = "src/tests/testGetLanguages" + retailerID + ".out";
        Language[] languagesForRetailer = library.getLanguagesForPublishingRetailerID(retailerID);
        if (languagesForRetailer == null) return;


        try {
            FileWriter file = new FileWriter(path);

            BufferedWriter output = new BufferedWriter(file);
            for (Language l:languagesForRetailer){
                if (l != null)
                    output.write(l.getName() + "\n");
            }
            output.close();
        }
        catch (Exception e){
            e.getStackTrace();
        }
    }

    /**
     * Method for testing GetCountries method
     * @param library the instance of administration
     * @param bookID the ID of the book to get the countries from
     */
    public static void writeTestGetCountries(Administration library, int bookID){
        String path = "src/tests/testGetCountries" + bookID + ".out";
        Country[] countriesForBook = library.getCountriesForBookID(bookID);
        if (countriesForBook == null) return;


        try {
            FileWriter file = new FileWriter(path);

            BufferedWriter output = new BufferedWriter(file);
            for (Country c:countriesForBook){
                if (c != null)
                    output.write(c.getCountryCode() + "\n");
            }
            output.close();
        }
        catch (Exception e){
            e.getStackTrace();
        }
    }

    /**
     * Method to test GetCommonBooks method
     * @param library the instance of administration
     * @param retailerID1 the ID for first retailer
     * @param retailerID2 the ID for second retailer
     */
    public static void writeTestGetCommonBooks(Administration library, int retailerID1, int retailerID2){
        String path = "src/tests/testGetCommonBooks" + retailerID1 + "-" + retailerID2 + ".out";
        Book[] commonBooks = library.getCommonBooksForRetailerIDs(retailerID1, retailerID2);
        if (commonBooks == null) return;

        try {
            FileWriter file = new FileWriter(path);

            BufferedWriter output = new BufferedWriter(file);
            for (Book b:commonBooks){
                if (b != null)
                    output.write(b.Publish() + "\n");
            }
            output.close();
        }
        catch (Exception e){
            e.getStackTrace();
        }
    }

    /**
     * Method to test GetAllBooks method
     * @param library the instance of administration
     * @param retailerID1 the ID for first retailer
     * @param retailerID2 the ID for second retailer
     */
    public static void writeTestGetAllBooks(Administration library, int retailerID1, int retailerID2){
        String path = "src/tests/testGetAllBooks" + retailerID1 + "-" + retailerID2 + ".out";
        Book[] allBooks = library.getAllBooksForRetailerIDs(retailerID1, retailerID2);
        if (allBooks == null) return;

        try {
            FileWriter file = new FileWriter(path);

            BufferedWriter output = new BufferedWriter(file);
            for (Book b:allBooks){
                if (b != null)
                    output.write(b.Publish() + "\n");
            }
            output.close();
        }
        catch (Exception e){
            e.getStackTrace();
        }
    }

}
