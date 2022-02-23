import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Utils {

    /**
     * Method to create the string containing book information
     * designed for books from Editorial Groups and Publishing Brands
     * @param b1 the book to get the information from
     * @return the String with all the information
     */
    public static String bookToString(Book b1){
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date dt = b1.getCreatedOn().getTime();
        String strDate = sdf.format(dt);
        StringBuilder toReturn = new StringBuilder("\t\t<book>\n\t\t\t");
        toReturn.append("<title>").append(b1.getName()).append("</title>\n\t\t\t");
        toReturn.append("<subtitle>").append(b1.getSubtitle()).append("</subtitle>\n\t\t\t");
        toReturn.append("<isbn>").append(b1.getISBN()).append("</isbn>\n\t\t\t");
        toReturn.append("<pageCount>").append(b1.getPageCount()).append("</pageCount>\n\t\t\t");
        toReturn.append("<keywords>").append(b1.getKeywords()).append("</keywords>\n\t\t\t");
        toReturn.append("<languageID>").append(b1.getLanguageID()).append("</languageID>\n\t\t\t");
        toReturn.append("<createdOn>").append(strDate).append("</createdOn>\n\t\t\t");
        toReturn.append("<authors>");
        for (Author i:b1.getAuthors()){
            toReturn.append(" ").append(i.getFirstName()).append(" ").append(i.getLastName());
        }
        toReturn.append("</authors>\n\t\t");
        toReturn.append("</book>\n");
        return toReturn.toString();
    }
}
