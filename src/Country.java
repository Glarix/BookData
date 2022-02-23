public class Country extends SearchableItem{
    private String countryCode;

    public Country(int ID){
        super(ID);
    }

    public Country(int ID, String countryCode) {
        super(ID);
        this.countryCode = countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    @Override
    public String toString(){
        return this.countryCode;
    }


}
