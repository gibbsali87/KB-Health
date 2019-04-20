package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class ExerciseList extends Model
{
  public String type;
  @OneToMany(cascade = CascadeType.ALL)
  public List<Exercise> exerciseDetails = new ArrayList<Exercise>();
  public int duration;

  public ExerciseList(String type, int duration)
  {
    this.type = type;
    this.duration = duration;
  }
}