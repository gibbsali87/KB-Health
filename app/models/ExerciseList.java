package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Exerciselist extends Model
{
  public String name;
  @OneToMany(cascade = CascadeType.ALL)
  public List<Exercise> exercises = new ArrayList<Exercise>();
  public int duration;

  public Exerciselist(String name, int duration)
  {
    this.name = name;
    this.duration = duration;
  }
}