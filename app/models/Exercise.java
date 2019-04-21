package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Exercise extends Model
{
  public String name;
  public String location;
  public int duration;
  
  public Exercise(String name, String location, int duration)
  {
    this.name = name;
    this.location = location;
    this.duration = duration;
  }
}