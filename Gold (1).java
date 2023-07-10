class Gold implements Tier {  //child class
  private int totalMiles;
  private int totalCancelledFlights;
  private int totalFlights;

  /*
    @param totalMiles
    @param totalCancelledFlights

    class constructor: it will set the classes total miles and total cancelled 
    flights
  */

  public Gold(int totalMiles, int totalCancelledFlights)
  {
    this.totalMiles = totalMiles;
    this.totalCancelledFlights = totalCancelledFlights;
  }

  /*
    @return totalMiles
    getter method
  */
  @Override
  public int getMiles()
  {
    return totalMiles;
  }

  /*
    @return totalCancelledFlights
    getter method
  */
  @Override
  public int getCancelledFlights() 
  {
    return totalCancelledFlights;
  }

  /*
    @return totalFlights
    getter method
  */
  @Override
  public int getFlights()
  {
    return totalFlights;
  }

  /*
    @return "Gold"
    returns the words "Gold" when the passenger has greater than or equal to 25 cancelled flights and less than 50 cancelled flights
  */
  
  @Override
  public String toString()
  {
    return "Gold";
  }

   /*
    @param isCancelled
    if boolean is true and flight is cancelled then incremement cancelled flights,
    find the total number of miles by multiplying cancelled flights by 1000
    and then incrementing the total number of flights whether or not its been cancelled
  */
  @Override
  public void addFlight(boolean isCancelled)
  {
    if(isCancelled)
    {
      totalCancelledFlights++;
      totalMiles = totalCancelledFlights * 1000;   
    }
      totalFlights++;
  }
}
