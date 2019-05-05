package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.joda.time.DateTime;
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
  public float height;

  @OneToMany(cascade = CascadeType.ALL)
  public List<Comment> comments = new ArrayList<Comment>();

  public void setDate(Date date) {
    this.date = date;
  }

  public Date getDate() {
    return date;
  }

  public Assessment(Date date, float weight, float chest, float thigh, float upperArm, float waist, float hips, String comment, float height)
  {
    setDate(date);
    this.weight = weight;
    this.chest = chest;
    this.thigh = thigh;
    this.upperArm = upperArm;
    this.waist = waist;
    this.hips = hips;
    this.comment = comment;
    this.height = height;
  }

}