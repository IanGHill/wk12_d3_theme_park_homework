import attractions.Attraction;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {

  private ArrayList<Attraction> attractions;
  private  ArrayList<Stall> stalls;
  private int visitorCount;
  private HashMap<String, Integer> allReviewed;

  public ThemePark(ArrayList<Attraction> attractions, ArrayList<Stall> stalls) {
    this.attractions = attractions;
    this.stalls = stalls;
    this.visitorCount = 0;
    allReviewed = new HashMap<String, Integer>();
  }

  public void addAttraction(Attraction attraction){
    this.attractions.add(attraction);
  }

  public void addStall(Stall stall){
    this.stalls.add(stall);
  }

  public int getAttractionCount(){
    return this.attractions.size();
  }

  public int getStallCount(){
    return this.stalls.size();
  }

  public ArrayList<IReviewed> getAllReviewed() {
    ArrayList<IReviewed> allReviewedStallsAndAttractions = new ArrayList<>();
    allReviewedStallsAndAttractions.addAll(stalls);
    allReviewedStallsAndAttractions.addAll((attractions));
    return allReviewedStallsAndAttractions;
  }

  public ArrayList<ISecurity> getAllSecured(){
    ArrayList<ISecurity> allSecured = new ArrayList<ISecurity>();
   for (Attraction attraction : attractions){
     if (attraction instanceof ISecurity){
       allSecured.add((ISecurity) attraction);
     }
   }

    for (Stall stall : stalls){
      if (stall instanceof ISecurity){
        allSecured.add((ISecurity) stall);
      }
    }
    return allSecured;

  }
  public HashMap<String, Integer> getAllReviews(){
    attractions.forEach(attraction -> this.allReviewed.put(attraction.getName(), attraction.getRating()));
    return allReviewed;
  }

  public void visit(Visitor visitor, Attraction attraction) {
    visitor.visitAttraction(attraction);
    attraction.incrementVisitCount();
  }

  public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor) {
    ArrayList<IReviewed> allAllowed = new ArrayList<IReviewed>();
    ArrayList<ISecurity> securedAttractions = this.getAllSecured();
    for (ISecurity secured : securedAttractions){
      if (secured.isAllowedTo(visitor)){
        allAllowed.add((IReviewed) secured);
      }
    }
    return allAllowed;
  }
}
