package edu.matc.halloween;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;


public class RileysHouse {

    private final Logger logger = Logger.getLogger(this.getClass());

    int lineLimit;
    List<TrickOrTreater> listKids;

    public RileysHouse()
    {
        lineLimit = 10;
        listKids = new LinkedList<TrickOrTreater>();
    }

    public void giveCandy()
    {
        TrickOrTreater kid;
        synchronized (listKids)
        {

            while(listKids.size()==0)
            {
                logger.info("Riley watches TV");
                try
                {
                    listKids.wait();
                }
                catch(InterruptedException iex)
                {
                    iex.printStackTrace();
                }
            }
            logger.info("Riley answers the door");
            kid = (TrickOrTreater) ((LinkedList<?>)listKids).poll();
        }
        try
        {
            logger.info("Riley gives candy to " +  kid.getName());
            TimeUnit.SECONDS.sleep(3);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
    }

    public void add(TrickOrTreater kid)
    {

        logger.info(kid.getName() + " is created");

        synchronized (listKids)
        {
            if(listKids.size() == lineLimit)
            {
                logger.info("Too many children in line for " + kid.getName());
                return ;
            }

            ((LinkedList<TrickOrTreater>)listKids).offer(kid);
            logger.info(kid.getName() + " rings the doorbell");

            if(listKids.size()==1)
                listKids.notify();
        }
    }
}


