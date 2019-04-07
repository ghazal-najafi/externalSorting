package sorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main
{

    public static void main(String[] args) throws Exception
    {
//        RandomNumbers randomNumbers = new RandomNumbers(1000_000_000);
//        randomNumbers.produceNumbers();

        long t1=System.currentTimeMillis();

        Chunks chunk = new Chunks();
        int n=chunk.divide();


         //if(n != 1)
        
        TournamentSort tournamentSort = new TournamentSort();
        tournamentSort.tournamentSort1(n);
        

        long t2=System.currentTimeMillis();
        System.out.println("time" + (t2-t1));
    }
}
