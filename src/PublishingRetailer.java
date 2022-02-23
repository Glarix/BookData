import java.util.Arrays;

public class PublishingRetailer extends SearchableItem{
    private String name;
    private IPublishingArtifact[] publishingArtifacts;
    private Country[] countries;

    public PublishingRetailer(int ID){
        super(ID);
        this.publishingArtifacts = new IPublishingArtifact[0];
        this.countries = new Country[0];
    }

    public PublishingRetailer(int ID, String name) {
        super(ID);
        this.name = name;
        this.publishingArtifacts = new IPublishingArtifact[0];
        this.countries = new Country[0];
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPublishingArtifacts(IPublishingArtifact[] publishingArtifacts) {
        this.publishingArtifacts = publishingArtifacts;
    }

    public void setCountries(Country[] countries) {
        this.countries = countries;
    }

    public String getName() {
        return name;
    }

    public IPublishingArtifact[] getPublishingArtifacts() {
        return publishingArtifacts;
    }

    public Country[] getCountries() {
        return countries;
    }



    //TODO functions to add a country and an artefact
    /**
     * Method to insert an item in publishingArtifacts array
     * @param item item to be inserted in the array(must be instanceof IPublishingArtifact)
     */
    public void addArtifact(SearchableItem item) {
        if (item instanceof IPublishingArtifact){
            this.publishingArtifacts = Arrays.copyOf(this.publishingArtifacts, this.publishingArtifacts.length + 1);
            int pos = this.publishingArtifacts.length;
            IPublishingArtifact artifact = (IPublishingArtifact) item;
            this.publishingArtifacts[pos - 1] = artifact;
        }
    }


    /**
     * Method to insert an item in countries array
     * @param item item to be inserted in the array(must be instanceof Country)
     */
    public void addCountry(SearchableItem item){
        if (item instanceof Country){
            this.countries = Arrays.copyOf(this.countries, this.countries.length + 1);
            int pos = this.countries.length;
            Country country = (Country) item;
            this.countries[pos - 1] = country;
        }

    }
}
