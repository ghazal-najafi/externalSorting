package sorting;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        //ran();
        Scanner input = new Scanner(System.in);
        String filePath=input.next();
        long startTime= System.currentTimeMillis();
        Chunks chunk = new Chunks();
        chunk.divide(filePath);
        long endTime = System.currentTimeMillis();
        System.out.println("time" + (endTime - startTime));
    }
    public static void ran()throws Exception
    {
        long min=-1000_000_000,max=1000_000_000;
        long num=0;

        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("file.txt"));

        for(int i=0 ; i<1000_000_000 ; i++)
        {
            num=(long) (Math.random()*((max-min)+1))+min;
            bufferedWriter.write(String.valueOf(num));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
}