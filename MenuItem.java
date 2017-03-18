import java.util.Date;
/**
 * Created by ethankulman on 3/12/17.
 */
public class MenuItem {

    private String name;
    private int price;
    private String description;
    private String category;
    private Date isNew;

    public String getName(){
        return this.name;
    }

    public void setName(String aName){
        this.name = aName;
    }

    public int getPrice(){
        return this.price;
    }

    public void setPrice(int aPrice){
        this.price = aPrice;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String aDescription){
        this.description = aDescription;
    }

    public String getCategory() { return this.category; }

    public void setCategory(String aCategory) { this.category = aCategory; }

    public void setDateCreated(Date aNew) { this.isNew = aNew; }

    public Date getDateCreated(){ return this.isNew; }

}

