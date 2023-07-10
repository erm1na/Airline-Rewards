class PlatinumPro implements Tier {
  private int totalMiles;
  private int totalCancelledFlights;
  private int totalFlights;

  /*
    @param totalMiles
    @param totalCancelledFlights

    class constructor: it will set the classes total miles and total cancelled 
    flights
  */ 
  
  public PlatinumPro(int totalMiles, int totalCancelledFlights)
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
    @return "Platinum Pro"
    returns the words "Platinum Pro" when the passenger greater than or equal to 50 cancelled flights and less than 100 cancelled flights as well as the mileage multiplier
  */

  @Override
  public String toString()
  {
     return "Platinum Pro"; 
  }

  /*
    @param isCancelled
    if boolean is true and flight is cancelled then incremement cancelled flights,
    find the total number of miles by multiplying cancelled flights by 2000
    and then incrementing the total number of flights whether or not its been cancelled
  */
  @Override
  public void addFlight(boolean isCancelled)
  {
    if(isCancelled)
    {
      totalCancelledFlights++;
      totalMiles = totalCancelledFlights * 2000;
    }
      totalFlights++;
  }
}
