interface Tier {              //using interface will achieve abstraction
  public int getMiles();
  public int getCancelledFlights();
  public int getFlights();
  public void addFlight(boolean isCancelled);  
}

