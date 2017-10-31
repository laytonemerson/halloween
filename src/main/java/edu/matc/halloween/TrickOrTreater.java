package edu.matc.halloween;

import java.util.Date;

public class TrickOrTreater implements Runnable {

    String name;
    Date inTime;
 
    RileysHouse house;
 
    public TrickOrTreater(RileysHouse house) {
        this.house = house;
    }
 
    public String getName() {
        return name;
    }
 
    public Date getInTime() {
        return inTime;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }
 
    public void run()
    {
        getCandy();
    }

    private synchronized void getCandy()
    {
        house.add(this);
    }
}
