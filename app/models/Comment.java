package models;

import javax.persistence.Entity;
import play.db.jpa.Model;
import java.util.Date;



@Entity
public class Comment extends Model
{
    public Date date;
    public String comment;

    public Comment(Date date,String comment)
    {
        this.date = date;
        this.comment = comment;
    }
}
