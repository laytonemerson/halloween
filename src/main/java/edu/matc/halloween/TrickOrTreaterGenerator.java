package edu.matc.halloween;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TrickOrTreaterGenerator implements Runnable {

    RileysHouse house;

    public TrickOrTreaterGenerator(RileysHouse house)
    {
        this.house = house;
    }

    public void run()
    {
        while(true)
        {
            TrickOrTreater kid = new TrickOrTreater(house);
            kid.setInTime(new Date());
            Thread kidThread = new Thread(kid);
            kid.setName("Child " + kidThread.getId());
            kidThread.start();

            try
            {
                TimeUnit.SECONDS.sleep((long)(Math.random()*10));
            }
            catch(InterruptedException iex)
            {
                iex.printStackTrace();
            }
        }
    }
}
