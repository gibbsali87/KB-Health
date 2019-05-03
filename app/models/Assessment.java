package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
public class Assessment extends Model
{

  public Date date;
  public float weight;
  public float chest;
  public float thigh;
  public float upperArm;
  public float waist;
  public float hips;
  public String comment;


    public Assessment(Date date,float weight,float chest,float thigh,float upperArm,float waist,float hips, String comment)
  {
    this.date = date;
    this.weight = weight;
    this.chest = chest;
    this.thigh = thigh;
    this.upperArm = upperArm;
    this.waist = waist;
    this.hips = hips;
    this.comment = comment;
  }
}