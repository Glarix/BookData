import java.util.Arrays;

public class EditorialGroup extends SearchableItem implements IPublishingArtifact{
    private String name;
    private Book[] books;

    public EditorialGroup(int ID){
        super(ID);
        books = new Book[0];
    }

    public EditorialGroup(int ID, String name) {
        super(ID);
        this.name = name;
        books = new Book[0];
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
     * the editorial group and about all of their books
     * @return the String containing the information
     */
    @Override
    public String Publish() {
        StringBuilder toReturn = new StringBuilder("<xml>\n\t");
        toReturn.append("<editorialGroup>\n\t\t");
        toReturn.append("<ID>").append(super.getID()).append("</ID>\n\t\t");
        toReturn.append("<Name>").append(this.name).append("</name>\n\t");
        toReturn.append("</editorialGroup>\n\t").append("<books>\n");
        for (Book b:this.books){
            toReturn.append(Utils.bookToString(b).toString());
        }
        toReturn.append("\t</books>\n").append("</xml>\n");
        return toReturn.toString();
    }

}
