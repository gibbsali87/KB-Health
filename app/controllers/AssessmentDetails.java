package controllers;



import models.Assessmentlist;
import models.Assessment;
import play.Logger;
import play.mvc.Controller;
import java.util.Date;


public class AssessmentDetails extends Controller
{
    public static void index(Long id)
    {
      Assessmentlist assessmentlist = Assessmentlist.findById(id);
      Logger.info ("Assessmentlist id = " + id);
      render("assessmentlist.html", assessmentlist);
    }

  public static void deleteAssessment (Long id, Long assessmentid)
  {
    Assessmentlist assessmentlist = Assessmentlist.findById(id);
    Assessment assessment = Assessment.findById(assessmentid);
    Logger.info ("Removing" + assessment.date);
    assessmentlist.assessments.remove(assessment);
    assessmentlist.save();
    assessment.delete();
    render("assessmentlist.html", assessmentlist);
  }


  public static void addAssessment(Long id, Date date,int weight,int chest,int thigh,int upperArm,int waist,int hips)
  {
    Assessment assessment = new Assessment(date,weight,chest,thigh,upperArm,waist,hips);
    Assessmentlist assessmentlist = Assessmentlist.findById(id);
    assessmentlist.assessments.add(assessment);
    assessmentlist.save();
    redirect ("/assessmentlists/" + id);
  }

}
