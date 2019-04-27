package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserDetails extends User{

    private float height;
    private float startWeight;
    private String chosenPackage;
    private String comment;

    public UserDetails(String firstname, String lastname,String gender,String email, String password, String address,
                        float height, float startWeight, String chosenPackage, String comment) {
        super(firstname, lastname,gender, email,password,address );
        setHeight(height);
        setStartWeight(startWeight);
        setChosenPackage(chosenPackage);
        setComment(comment);
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height)
    {
        this.height = height ;
    }

    public float getStartWeight() {
        return startWeight;
    }

    public void setStartWeight(float startWeight) {
        this.startWeight = startWeight ;
    }

    public String getChosenPackage() {
        return chosenPackage;
    }

    public void setChosenPackage(String chosenPackage)
    {
        this.chosenPackage = chosenPackage;
    }

    public void setComment(String comment){this.comment = comment;}

    public String getComment(){return comment;}

    @OneToMany(cascade = CascadeType.ALL)
    public List<UserDetails> userDetailsList = new ArrayList<UserDetails>();


}
