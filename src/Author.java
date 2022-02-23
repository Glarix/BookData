public class Author extends SearchableItem{
    private String firstName;
    private String lastName;

    public Author(int ID){
        super(ID);
    }

    public Author(int ID, String firstName, String lastName) {
        super(ID);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
