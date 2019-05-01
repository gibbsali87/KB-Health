package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Assessmentlist extends Model
{
    public String week;
    Date date;
    @OneToMany(cascade = CascadeType.ALL)
    public List<Assessment> assessments = new ArrayList<Assessment>();


    public Assessmentlist(String week, Date date)
    {
        this.week = week;
        this.date = date;
    }

}
