class ExecutivePlatinum implements Tier {
  private int totalMiles;
  private int totalCancelledFlights;
  private int totalFlights;

  /*
    @param totalMiles
    @param totalCancelledFlights

    class constructor: it will set the classes total miles and total cancelled 
    flights
  */
  
  public ExecutivePlatinum(int totalMiles, int totalCancelledFlights)
  {
    this.totalMiles = totalMiles;
    this.totalCancelledFlights = totalCancelledFlights;
  }

  /*
    @return totalMiles
    getter method
  */
  
  public int getMiles()
  {
    return totalMiles;
  }

  /*
    @return totalCancelledFlights
    getter method
  */

  public int getCancelledFlights()
  {
    return totalCancelledFlights;
  }

  /*
    @return totalFlights
    getter method
  */
  
  public int getFlights()
  {
    return totalFlights;
  }

  /*
    @return "Executive Platinum"
    returns the words "Executive Platinum" when the passenger has greater than 100 cancelled flights
  */
  
  @Override
  public String toString()
  {
    return "Executive Platinum";
  }

  /*
    @param isCancelled
    if boolean is true and flight is cancelled then incremement cancelled flights,
    find the total number of miles by multiplying cancelled flights by 1000
    and then incrementing the total number of flights whether or not its been                cancelled
  */
  
  public void addFlight(boolean isCancelled)
  {
    //System.out.println("Hello from exec plat");
    if(isCancelled)
    {
      totalCancelledFlights++;
      totalMiles = totalCancelledFlights * 1000; 
    }
      totalFlights++;
  }
}
