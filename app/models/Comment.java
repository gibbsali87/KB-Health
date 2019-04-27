package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

import java.util.Date;

@Entity
public class Comment extends Model
{
    public String comment;
    Date date;

    public Comment(String comment, Date date)
    {
        this.comment = comment;
        this.date = date;
    }
}
