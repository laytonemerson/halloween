package edu.matc.halloween;

import org.apache.log4j.Logger;

public class Riley implements Runnable {

    private final Logger logger = Logger.getLogger(this.getClass());

    RileysHouse house;
 
    public Riley(RileysHouse house) {
        this.house = house;
    }

    public void run()
    {
        logger.info("Trick-Or-Treating begins");
        while(true)
        {
            house.giveCandy();
        }
    }
}
