package models;

import javax.persistence.Entity;


import org.joda.time.DateTime;
import play.db.jpa.Model;

import java.util.Date;


@Entity
public class Assessment extends Model
{
    private Long id;
    public Date date;
    public float height;
    public float weight;
    public float chest;
    public float thigh;
    public float upperArm;
    public float waist;
    public float hips;



    public Assessment(Long id, Date date, float height, float weight, float chest, float thigh, float upperArm, float waist, float hips)
    {
        this.id = id;
        this.date=date;
        this.height=height;
        this.weight=weight;
        this.chest=chest;
        this.thigh=thigh;
        this.upperArm=upperArm;
        this.waist=waist;
        this.hips=hips;
    }
}
