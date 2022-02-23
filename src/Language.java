public class Language {
    private int ID;
    private String code;
    private String name;

    public Language(){

    }

    public Language(int ID, String code, String name) {
        this.ID = ID;
        this.code = code;
        this.name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ID: " + this.ID + " code: " + this.code + " name: " + this.name;
    }
}
