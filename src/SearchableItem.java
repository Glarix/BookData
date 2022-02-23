public class SearchableItem {
    private int ID;

    public SearchableItem(int ID){
        this.ID = ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }


    /**
     * Method to check if this instance has the same ID as the one searched for
     * @param ID the ID that is searched
     * @return true if IDs are equal, else false
     */
    public boolean findByID(int ID) {
        if (this.ID == ID)
            return true;
        return false;
    }
}
