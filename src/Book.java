import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Book extends SearchableItem implements IPublishingArtifact{
    private String name;
    private String subtitle;
    private String ISBN;
    private int pageCount;
    private String keywords;
    private int languageID;
    private Calendar createdOn;
    private Author[] authors;

    public Book(int ID){
        super(ID);
        this.authors = new Author[0];
    }


    public Book(int ID, String name, String subtitle, String ISBN,
                int pageCount, String keywords, int languageID, Calendar createdOn) {
        super(ID);
        this.name = name;
        this.subtitle = subtitle;
        this.ISBN = ISBN;
        this.pageCount = pageCount;
        this.keywords = keywords;
        this.languageID = languageID;
        this.createdOn = createdOn;
        this.authors = new Author[0];
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setLanguageID(int languageID) {
        this.languageID = languageID;
    }

    public void setCreatedOn(Calendar createdOn) {
        this.createdOn = createdOn;
    }

    public void setAuthors(Author[] authors) {
        this.authors = authors;
    }


    public String getName() {
        return name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getKeywords() {
        return keywords;
    }

    public int getLanguageID() {
        return languageID;
    }

    public Calendar getCreatedOn() {
        return createdOn;
    }

    public Author[] getAuthors() {
        return authors;
    }


    /**
     * Method to insert an item in authors array
     * @param item item to be inserted in the array(must be instanceof Author)
     */
    public void addToArray(SearchableItem item) {
        if (item instanceof Author){
            this.authors = Arrays.copyOf(this.authors, this.authors.length + 1);
            int pos = this.authors.length;
            Author toInsert = (Author) item;
            this.authors[pos - 1] = toInsert;
        }
    }

    /**
     * Method that returns a string containing all the necessary book information
     * @return the string containing the information
     */
    @Override
    public String Publish() {
        // Converting from Calendar to String
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date dt = this.createdOn.getTime();
        String strDate = sdf.format(dt);

        StringBuilder toReturn = new StringBuilder("<xml>\n\t");
        toReturn.append("<title>").append(this.name).append("</title>\n\t");
        toReturn.append("<subtitle>").append(this.subtitle).append("</subtitle>\n\t");
        toReturn.append("<isbn>").append(this.ISBN).append("</isbn>\n\t");
        toReturn.append("<pageCount>").append(this.pageCount).append("</pageCount>\n\t");
        toReturn.append("<keywords>").append(this.keywords).append("</keywords>\n\t");
        toReturn.append("<languageID>").append(this.languageID).append("</languageID>\n\t");
        toReturn.append("<createdOn>").append(strDate).append("</createdOn>\n\t");
        toReturn.append("<authors>");
        for (Author i:authors){
            toReturn.append(" ").append(i.getFirstName()).append(" ").append(i.getLastName());
        }
        toReturn.append(" </authors>\n");
        toReturn.append("</xml>");
        return toReturn.toString();
    }



}
