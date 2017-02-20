
import java.util.*;

public class Runway{


   private static int planesLanded;
   private static int planesDeparted;
   private static Averager avgWaitToLand;
   private static Averager avgWaitToDepart;
   private static int numberOfCrashes;
   private int timeToDepart;
   private double probabilityOfDepart;
   private int timeToLand;
   private double probabilityOfLanding;
   private int maxTimeBeforeCrash;
   private int simTime;
   public static int runwayTimeLeft, next, wait;
   public BooleanSource BooleanSource1;
   public BooleanSource BooleanSource2;
   Queue<Integer> landingQ = new LinkedList<Integer>();
   Queue<Integer> departingQ = new LinkedList<Integer>();

public Runway(int time, int departTime, double probTakeOff, int landTime, double probLand, int crashTime){


   avgWaitToLand = new Averager();
   avgWaitToDepart = new Averager();
   planesLanded = 0;
   planesDeparted = 0;
   numberOfCrashes = 0;
   simTime = time;
   timeToDepart = departTime;
   probabilityOfDepart = probTakeOff;
   timeToLand = landTime;
   probabilityOfLanding = probLand;
   maxTimeBeforeCrash = crashTime;
   BooleanSource1 = new BooleanSource(probabilityOfDepart);
   BooleanSource2 = new BooleanSource(probabilityOfLanding);
}

public void Simulate( ) {
    for (int currentMinute = 0; currentMinute < simTime; currentMinute++)   //simulation clock
    {
        if (BooleanSource1.query())   //see if a plane arrives and add it to queue
        {
            departingQ.add(currentMinute);
        }
        if (BooleanSource2.query()) {
            landingQ.add(currentMinute);
        }
        if (!Runway.isBusy()) {                    //if the runway is available
            if (!landingQ.isEmpty()) {             //if planes are waiting to land
                next = landingQ.remove();      //get next landing plane
                wait = currentMinute - next;
                if (wait > maxTimeBeforeCrash) {    //see if it crashed
                    numberOfCrashes++;
                } else {
                    planesLanded++;                  //land plane
                    runwayTimeLeft = timeToLand;     //make runway busy
                    avgWaitToLand.addNumber(wait);   //add wait time to averager object
                }
            } else if (!departingQ.isEmpty()) {
                next = departingQ.remove();    //get next departing plane
                wait = currentMinute - next;
                planesDeparted++;                //plane takes off
                runwayTimeLeft = timeToDepart;    //make runway busy
                avgWaitToDepart.addNumber(wait);  //add wait time to averager object
            }
        } else {
            runwayTimeLeft--;          //if the runway is busy then subtract 1 from the busy time
        }
    }
}

public static boolean isBusy( ){
	
	return (runwayTimeLeft > 0);
	
}

public static void main(String[] args){
	
	Runway r = new Runway(1440, 4, .2, 5, .1, 20);
	r.Simulate();
	
	System.out.println(planesLanded + " planes have landed.");
	System.out.println(planesDeparted + " planes have departed.");
	System.out.println(numberOfCrashes + " planes have crashed.");
	System.out.println(avgWaitToLand.average() + " mins is the average wait time to land.");
    System.out.println(avgWaitToDepart.average() + " mins is the average wait time to depart.");
	
}
	
	
		  
}
