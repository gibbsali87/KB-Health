package models;

        import java.util.ArrayList;
        import java.util.List;

        import javax.persistence.CascadeType;
        import javax.persistence.Entity;
        import javax.persistence.OneToMany;

        import play.db.jpa.Model;

@Entity
public class Assessmentlist extends Model
{
  @OneToMany(cascade = CascadeType.ALL)
  public List<Assessment> assessments = new ArrayList<Assessment>();
  public int week;

  public Assessmentlist(int week)
  {
    this.week= week;
  }
}