package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Commentlist extends Model
{
    public String comment;
    @OneToMany(cascade = CascadeType.ALL)
    public List<Comment> comments = new ArrayList<Comment>();
    Date date;

    public Commentlist(String comment, Date date)
    {
        this.comment = comment;
        this.date = date;
    }
}
