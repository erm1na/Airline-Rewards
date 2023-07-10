class Passenger {
  private Tier tier;
  private boolean multiplier;
  private int ID;

 /*
    @param ID
    @param tier
    @param miles
    @param cancelledFlights

    constructor sets ID and tier. also passes through miles and cancelledflights. also sets multiplier to true indefinitely until the end of the year 
 */
  
  public Passenger(int ID, Tier tier, int miles, int cancelledFlights) 
  {
    this.ID = ID;
    this.tier = tier;
    this.multiplier = true;
  }
  
  /*
      @return ID
      getter
  */
  
  public int getID()
  {
    return ID;
  }

  /*
      @return tier.toString
      returns tier as String type
  */
  
  public String getTier()
  {
    return tier.toString();
  }

  /*
      @return tier
      returns tier object
  */
  
  public Tier getTierObj()
  {
    return tier;
  }

  /*
      setter, sets tier object to platinumPro
  */
  
  public void setPlatPro()
  {
    tier = new PlatinumPro(tier.getMiles(), tier.getCancelledFlights());
  }
  
  /*
      setter, sets tier object to setSuperExec
  */

  public void setSuperExec()
  {
    tier = new SuperExecutivePlatinum(tier.getMiles(), tier.getCancelledFlights());
  }

  /*
    @return tier.getMiles()
    return get miles of tier object
  */
  
  public int getMiles()
  {
    return tier.getMiles();
  }

  /*
    @return tier.getCancelledFlights()
    return get cancelled flights of tier object
  */
  
  public int getCancelledFlights()
  {
    return tier.getCancelledFlights();
  }

  /*
    @return multiplier
    return multiplier. if tier is gold then return false because gold doesnt have a mileage multiplier option and neither does noTier 
  */

  public boolean hasMultiplier()
  {
    if(tier instanceof Gold)
    {
      return false;
    }
    if(tier instanceof NoTier)
    {
      return false;
    }
     return multiplier;
  }

  /*
    setter, sets multiplier to whatever mult ends up as
  */
  
  public void setMult(boolean mult)
  {
    multiplier = mult; 
  }

  /*
  @param isCancelled
  if boolean isCancelled if true(flight is cancelled) then call add flight of tier object and determine what tier passenger belongs in based on the number of cancelled flights through a series of if else statements. if true then set tier object to corresponding tier
  */
  public void addFlight(boolean isCancelled)
  {
    tier.addFlight(isCancelled);  
    if(tier.getCancelledFlights() < 25)
    {
      tier = new NoTier(tier.getMiles(), tier.getCancelledFlights());
    }
    else if(tier.getCancelledFlights() >= 25 && tier.getCancelledFlights() < 50)
    {
      tier = new Gold(tier.getMiles(), tier.getCancelledFlights());   
    }
    else if(tier.getCancelledFlights() >= 50 && tier.getCancelledFlights() < 100)
    {
      tier = new Platinum(tier.getMiles(), tier.getCancelledFlights());
    }
    else
    {
      tier = new ExecutivePlatinum(tier.getMiles(), tier.getCancelledFlights());
    }
  }
}