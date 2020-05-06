import attractions.*;
import behaviours.IReviewed;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.*;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

  private ThemePark themepark;
  private ArrayList<Attraction> attractions;
  private  ArrayList<Stall> stalls;
  CandyflossStall candyflossStall;
  IceCreamStall iceCreamStall;
  TobaccoStall tobaccoStall;
  Park park;
  Playground playground;
  Dodgems dodgems;
  RollerCoaster rollerCoaster;
  Visitor littleJimmy;
  Visitor mrTall;

  @Before
  public void before(){
    candyflossStall = new CandyflossStall("Candy Land", "Harry Belafonte", ParkingSpot.A1, 4);
    iceCreamStall = new IceCreamStall("Dream Cones", "Vanilla Ice", ParkingSpot.A4, 5);
    tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 5);
    dodgems = new Dodgems("Bumper Cars", 5);
    park = new Park("Leafy Meadows", 9);
    playground = new Playground("Fun Zone", 7);
    rollerCoaster = new RollerCoaster("Blue Ridge", 10);
    littleJimmy = new Visitor(10, 124, 20);
    mrTall = new Visitor(25, 220, 50);
    attractions = new ArrayList<>();
    stalls = new ArrayList<>();
    themepark = new ThemePark(attractions, stalls);
  }

  @Test
  public void canAddAttraction(){
    attractions.add(dodgems);
    attractions.add(park);
    attractions.add(playground);
    attractions.add(rollerCoaster);
    assertEquals(4, themepark.getAttractionCount());
  }

  @Test
  public void canAddStalls(){
    stalls.add(candyflossStall);
    stalls.add(iceCreamStall);
    stalls.add(tobaccoStall);
    assertEquals(3, themepark.getStallCount());
  }

  @Test
  public void canGetReviewed(){
    stalls.add(candyflossStall);
    attractions.add(playground);
    ArrayList<IReviewed> reviewed = new ArrayList<>();
    reviewed.add(candyflossStall);
    reviewed.add(playground);
    assertEquals(reviewed, themepark.getAllReviewed());
  }

  @Test
  public void canVisit(){
    themepark.visit(littleJimmy, playground);
    assertEquals(1, littleJimmy.getVisitedAttractionsCount());
    assertEquals(1, playground.getVisitCount());
  }

  @Test
  public void canGetAllReviews() {
    themepark.addAttraction(playground);
    themepark.addAttraction((dodgems));
    HashMap<String, Integer> expectedResult = new HashMap<String, Integer>();
    expectedResult.put("Fun Zone", 7);
    expectedResult.put("Bumper Cars", 5);
    assertEquals(expectedResult, themepark.getAllReviews());
  }

  @Test
    public void canGetAllAllowedFor(){
      themepark.addAttraction(playground);
      themepark.addAttraction((dodgems));
      themepark.addAttraction((park));
      themepark.addAttraction((rollerCoaster));
      themepark.addStall(candyflossStall);
      themepark.addStall(iceCreamStall);
      themepark.addStall(tobaccoStall);
     ArrayList<IReviewed> expectedResults = new ArrayList<IReviewed>();
     expectedResults.add(playground);
      assertEquals(expectedResults, themepark.getAllAllowedFor(littleJimmy));
    }

}
