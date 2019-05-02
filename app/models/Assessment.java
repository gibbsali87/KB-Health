package models;

import javax.persistence.Entity;

import play.db.jpa.Model;
import java.util.Date;


@Entity
public class Assessment extends Model
{
  public Date date;
  int weight;
  int chest;
  int thigh;
  int upperArm;
  int waist;
  int hips;

  public Assessment(Date date,int weight,int chest,int thigh,int upperArm,int waist,int hips)
  {
    this.date = date;
    this.weight = weight;
    this.chest = chest;
    this.thigh = thigh;
    this.upperArm = upperArm;
    this.waist = waist;
    this.hips = hips;
  }
}