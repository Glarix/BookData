import java.util.Arrays;

public class PublishingBrand extends SearchableItem implements IPublishingArtifact{
    private String name;
    private Book[] books;

    public PublishingBrand(int ID){
        super(ID);
        this.books = new Book[0];
    }

    public PublishingBrand(int ID, String name) {
        super(ID);
        this.name = name;
        this.books = new Book[0];
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public Book[] getBooks() {
        return books;
    }

    /**
     * Method to insert an item in authors array
     * @param item the item to be inserted in the array (must be instanceof Book)
     */
    public void addToArray(SearchableItem item) {
        if (item instanceof Book){
            this.books = Arrays.copyOf(this.books, this.books.length + 1);
            int pos = this.books.length;
            Book toInsert = (Book) item;
            this.books[pos - 1] = toInsert;
        }
    }

    /**
     * Method to create the string containing the necessary information about
     * the publishing brand and about all of their books
     * @return the String containing the information
     */
    @Override
    public String Publish() {
        StringBuilder toReturn = new StringBuilder("<xml>\n\t");
        toReturn.append("<publishingBrand>\n\t\t");
        toReturn.append("<ID>").append(super.getID()).append("</ID>\n\t\t");
        toReturn.append("<Name>").append(this.name).append("</name>\n\t");
        toReturn.append("</publishingBrand>\n\t").append("<books>\n");
        for (Book b:this.books){
            toReturn.append(Utils.bookToString(b).toString());
        }
        toReturn.append("\t</books>\n").append("</xml>\n");
        return toReturn.toString();
    }

}
