
import edu.matc.halloween.Riley;
import edu.matc.halloween.RileysHouse;
import edu.matc.halloween.TrickOrTreater;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created on 10/22/16.
 *
 * @author pwaite
 */
public class ThreadTest {

    private final Logger logger = Logger.getLogger(this.getClass());

    @Test
    public void createKidThread() throws Exception {

        RileysHouse house = new RileysHouse();

        TrickOrTreater kid = new TrickOrTreater(house);
        kid.setInTime(new Date());

        Thread kidThread = new Thread(kid);
        kid.setName("Child " + kidThread.getId());
        logger.info("Just before starting Kid");
        kidThread.start();

    }

    @Test
    public void createRileyThread() throws Exception {

        RileysHouse house = new RileysHouse();

        Riley riley = new Riley(house);

        Thread rileyThread = new Thread(riley);
        logger.info("Just before starting Riley");
        rileyThread.start();

    }

}