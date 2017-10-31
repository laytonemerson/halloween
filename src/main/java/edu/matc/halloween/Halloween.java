package edu.matc.halloween;

public class Halloween {


    public static void main( String[] args ) {

        RileysHouse house = new RileysHouse();

        Riley riley = new Riley(house);
        TrickOrTreaterGenerator totGen = new TrickOrTreaterGenerator(house);

        Thread rileyThread = new Thread(riley);
        Thread genThread = new Thread(totGen);
        genThread.start();
        rileyThread.start();

    }

}