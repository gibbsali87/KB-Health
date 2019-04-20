package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Exercise extends Model
{
  public String type;
  public String location;
  public int duration;
  
  public Exercise(String type, String location, int duration)
  {
    this.type = type;
    this.location = location;
    this.duration = duration;
  }
}