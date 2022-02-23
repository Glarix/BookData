import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public abstract class ReadFromFile {

    /**
     * Method that inserts an object into a given array on the given position and returns the array
     * @param array the array in which the object is inserted
     * @param pos the position to insert the object
     * @param o the object to be inserted
     * @return the updated array
     */
    public static Object[] addInArrayObject(Object[] array, int pos, Object o){
        array = Arrays.copyOf(array, array.length + 1);
        array[pos] = o;
        return array;
    }

    private static Calendar createADate(String info){
        Date theDate = null;
        try {
            theDate = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH).parse(info);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(theDate);
        return cal1;
    }
    /**
     * Method that reads a file line by line and creates an array of Objects
     * initialized with the parameters from file
     * Possible types of objects to be created:
     * [0]Book, [1]Author;
     * [2]Country, [3]Editorial Group;
     * [4]Language, [5]Publishing Brand;
     * [6]Publishing Retailer
     * @param path the location of the file
     * @param typeOfElement type of the object to be created with the parameters from the file
     * @return an array containing all the objects created after reading the whole file
     * @throws IOException
     */
    public static Object[] readFromFile(String path, int typeOfElement) throws IOException {
        Object[] arrayOfElements = new Object[0];
        int i = 0;

        File file = new File(path);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            // Eliminating the first (header) line
            line = br.readLine();
            while ((line = br.readLine()) != null) {

                //Separating the parameters from the line
                String[] info = line.split("###");
                Object o = null;

                //Checking which type of instance needs to be created and initializing it with the given parameters
                switch (typeOfElement){
                    case 0:
                        Calendar cal1 = createADate(info[7]);
                        o = new Book(Integer.parseInt(info[0]), info[1], info[2], info[3], Integer.parseInt(info[4]),
                                info[5], Integer.parseInt(info[6]), cal1);
                        break;
                    case 1:
                        o = new Author(Integer.parseInt(info[0]), info[1], info[2]);
                        break;
                    case 2:
                        o = new Country(Integer.parseInt(info[0]), info[1]);
                        break;
                    case 3:
                        o = new EditorialGroup(Integer.parseInt(info[0]), info[1]);
                        break;
                    case 4:
                        o = new Language(Integer.parseInt(info[0]), info[1], info[2]);
                        break;
                    case 5:

                        o = new PublishingBrand(Integer.parseInt(info[0]), info[1]);
                        break;
                    case 6:
                        o = new PublishingRetailer(Integer.parseInt(info[0]), info[1]);
                        break;
                }

                //Inserting the element into the Object array
                arrayOfElements = addInArrayObject(arrayOfElements, i, o);
                i++;
            }
        }
        return arrayOfElements;
    }

    /**
     * Method to read from a file line by line and create an
     * array of Books created with the parameters from file
     * @param path the location of the file
     * @return an array of the created Book instances
     */
    public static Book[] readBooks(String path){
        //the code for Book type
        int typeOfElement = 0;
        Object[] objectsOfBooks = null;
        try {
            objectsOfBooks = readFromFile(path, typeOfElement);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int len = objectsOfBooks.length;
        Book[] books = new Book[len];
        for (int i = 0; i < len; i++){
            books[i] = (Book) objectsOfBooks[i];
        }
        return books;
    }

    /**
     * Method to read from a file line by line and create an
     * array of Authors created with the parameters from file
     * @param path the location of the file
     * @return an array of the created Author instances
     */
    public static Author[] readAuthors(String path){
        //the code for Author type
        int typeOfElement = 1;
        Object[] objectsOfAuthors = null;
        try {
            objectsOfAuthors = readFromFile(path, typeOfElement);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int len = objectsOfAuthors.length;
        Author[] authors = new Author[len];
        for (int i = 0; i < len; i++){
            authors[i] = (Author) objectsOfAuthors[i];
        }
        return authors;
    }

    /**
     * Method to read from a file line by line and create an
     * array of Countries created with the parameters from file
     * @param path the location of the file
     * @return an array of the created Country instances
     */
    public static Country[] readCountries(String path){
        //the code for Country type
        int typeOfElement = 2;
        Object[] objectsOfCountries = null;
        try {
            objectsOfCountries = readFromFile(path, typeOfElement);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int len = objectsOfCountries.length;
        Country[] countries = new Country[len];
        for (int i = 0; i < len; i++){
            countries[i] = (Country) objectsOfCountries[i];
        }
        return countries;
    }

    /**
     * Method to read from a file line by line and create an
     * array of Editorial Groups created with the parameters from file
     * @param path the location of the file
     * @return an array of the created Editorial Group instances
     */
    public static EditorialGroup[] readEditorials(String path){
        //the code for Editorial Group type
        int typeOfElement = 3;
        Object[] objectsOfEditorials = null;
        try {
            objectsOfEditorials = readFromFile(path, typeOfElement);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int len = objectsOfEditorials.length;
        EditorialGroup[] editorials = new EditorialGroup[len];
        for (int i = 0; i < len; i++){
            editorials[i] = (EditorialGroup) objectsOfEditorials[i];
        }
        return editorials;
    }

    /**
     * Method to read from a file line by line and create an
     * array of Languages created with the parameters from file
     * @param path the location of the file
     * @return an array of the created Language instances
     */
    public static Language[] readLanguages(String path){
        //the code for Language type
        int typeOfElement = 4;
        Object[] objectsOfLanguages = null;
        try {
            objectsOfLanguages = readFromFile(path, typeOfElement);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int len = objectsOfLanguages.length;
        Language[] languages = new Language[len];
        for (int i = 0; i < len; i++){
            languages[i] = (Language) objectsOfLanguages[i];
        }
        return languages;
    }

    /**
     * Method to read from a file line by line and create an
     * array of Publishing Brands created with the parameters from file
     * @param path the location of the file
     * @return an array of the created Publishing Brand instances
     */
    public static PublishingBrand[] readPublishingBrands(String path){
        //the code for Publishing Brand type
        int typeOfElement = 5;
        Object[] objectsOfPBrands = null;
        try {
            objectsOfPBrands = readFromFile(path, typeOfElement);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int len = objectsOfPBrands.length;
        PublishingBrand[] pBrands = new PublishingBrand[len];
        for (int i = 0; i < len; i++){
            pBrands[i] = (PublishingBrand) objectsOfPBrands[i];
        }
        return pBrands;
    }

    /**
     * Method to read from a file line by line and create an
     * array of Publishing Retailers created with the parameters from file
     * @param path the location of the file
     * @return an array of the created Publishing Retailer instances
     */
    public static PublishingRetailer[] readPublishingRetailers(String path){
        //the code for Publishing Retailer type
        int typeOfElement = 6;
        Object[] objectsOfPRerailers = null;
        try {
            objectsOfPRerailers = readFromFile(path, typeOfElement);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int len = objectsOfPRerailers.length;
        PublishingRetailer[] pRetailers = new PublishingRetailer[len];
        for (int i = 0; i < len; i++){
            pRetailers[i] = (PublishingRetailer) objectsOfPRerailers[i];
        }
        return pRetailers;
    }
}
