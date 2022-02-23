import java.io.*;

public abstract class EstablishConnections {

    /**
     * Method to get a reference to an Object from an array by ID
     * @param toSearch the array to search in
     * @param ID the ID of the needed object
     * @return the reference to the found Object or null if Object not found
     */
    private static Object find(SearchableItem[] toSearch, int ID){
        Object foundElement = null;
        for (SearchableItem i:toSearch){
            if (i.findByID(ID)){
                foundElement = i;
                return foundElement;
            }
        }
        return null;
    }

    /**
     * Method that creates the connection between elements of first array and elements of second array
     * The connection is established by the data from the given file
     * Types of conections can be:
     * [0]Book-Author, [1]EditorialGroup-Book, [2]PublishingBrand-Book,
     * [3]PublishingRetailer-Book, [4]PublishingRetailer-Country, [5]PublishingRetailer-EditorialGroup,
     * [6]PublishingRetailer-PublishingBrand.
     * @param path the location of the file
     * @param entity1 first array of elements
     * @param entity2 second array of elements
     * @param typeOfConnection the code for the wanted type of connection
     */
    public static void connectTwoEntities(String path, SearchableItem[] entity1,
                                          SearchableItem[] entity2, int typeOfConnection){
        Book foundBook;
        Author foundAuthor;
        EditorialGroup foundEGroup;
        PublishingBrand foundPBrand;
        PublishingRetailer foundPRetailer;
        Country foundCountry;

        File file = new File(path);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            // Eliminating the first (header) line
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            while ((line = br.readLine()) != null) {
                //Separating the parameters from the line into an array
                String[] info = line.split("###");

                int firstEntityID = Integer.parseInt(info[0]);
                int secondEntityID = Integer.parseInt(info[1]);

                //Checking which type of connection needs to be created and creates it
                switch (typeOfConnection){
                    case 0:
                        foundBook = (Book) find(entity1, firstEntityID);
                        foundAuthor = (Author) find(entity2, secondEntityID);
                        foundBook.addToArray(foundAuthor);
                        break;
                    case 1:
                        foundEGroup = (EditorialGroup) find(entity1, firstEntityID);
                        foundBook = (Book) find(entity2, secondEntityID);
                        foundEGroup.addToArray(foundBook);
                        break;
                    case 2:
                        foundPBrand = (PublishingBrand) find(entity1, firstEntityID);
                        foundBook = (Book) find(entity2, secondEntityID);
                        foundPBrand.addToArray(foundBook);
                        break;
                    case 3:
                        foundPRetailer = (PublishingRetailer) find(entity1, firstEntityID);
                        foundBook = (Book) find(entity2, secondEntityID);
                        foundPRetailer.addArtifact(foundBook);
                        break;
                    case 4:
                        foundPRetailer = (PublishingRetailer) find(entity1, firstEntityID);
                        foundCountry = (Country) find(entity2, secondEntityID);
                        foundPRetailer.addCountry(foundCountry);
                        break;
                    case 5:
                        foundPRetailer = (PublishingRetailer) find(entity1, firstEntityID);
                        foundEGroup = (EditorialGroup) find(entity2, secondEntityID);
                        foundPRetailer.addArtifact(foundEGroup);
                        break;
                    case 6:
                        foundPRetailer = (PublishingRetailer) find(entity1, firstEntityID);
                        foundPBrand = (PublishingBrand) find(entity2, secondEntityID);
                        foundPRetailer.addArtifact(foundPBrand);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
