//package sorting;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
//public class TournamentSort
//{
//    private int index;
//
//    public long findMin(ArrayList<Long> num,int n)
//    {
//        long min=num.get(0),x=0,firstNum=0,secondNum=0;
//
//        for(int i=1 ; i<n-1 ; i+=2)
//        {
//            firstNum=num.get(i);
//            secondNum=num.get(i+1);
//            x=Math.min(firstNum,secondNum);
//            if(x<min)
//                min=x;
//        }
//        if(num.get(n-1)<min)
//            min=num.get(n-1);
//        index=num.indexOf((long)min);
//        return min;
//    }
//    public void tournamentSort(int NumberOfChunks) throws FileNotFoundException, IOException
//    {
//        String str="";
//        int n=0;
//        ArrayList<Long> list=new ArrayList();
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("E://File//mainFile.txt"));
//        BufferedReader bufferedReader[] = new BufferedReader[NumberOfChunks];
//
//        for (int i = 0; i <NumberOfChunks ; i++)
//        {
//            bufferedReader[i] = new BufferedReader(new FileReader("E://File//file" + i + ".txt"));
//            list.add(Long.parseLong(bufferedReader[i].readLine()));
//        }
//
//        long min = findMin(list, list.size());
//        bufferedWriter.append(String.valueOf(min));
//        bufferedWriter.newLine();
//        int y=0;
//        while(n!=NumberOfChunks)
//        {
//            str = bufferedReader[index].readLine();
//            if (str != null)
//                list.set(index, Long.parseLong(str));
//            else if(str == null)
//            {
//                list.set(index, Long.MAX_VALUE);
//                n++;
//            }
//            min = findMin(list, list.size());
//
//            if(min!=Long.MAX_VALUE)
//            {
//                bufferedWriter.append(String.valueOf(min));
//                bufferedWriter.newLine();
//            }
//            if(min==-1000)
//                y++;
//
//        }
//        System.out.println(y);
//        bufferedWriter.close();
//    }
//    public boolean check(ArrayList li)
//    {
//        int p=0;
//        for(int i=0 ; i<li.size() ;i++)
//        {
//            if(li.get(i).equals(Long.MAX_VALUE))
//                p++;
//            else {
//                p = -1;
//                break;
//            }
//        }
//        if(p==li.size())
//            return true;
//        else
//            return false;
//    }
//
//    public void show() throws IOException
//    {
//        Scanner in=new Scanner(new FileReader("E://mainFile.txt"));
//        while(in.hasNext())
//            System.out.print(in.nextLine()+"  ");
//    }
//    public void readFile()throws IOException
//    {
//        int b[]=new int[5];
//        for(int i=0 ; i<2 ; i++)
//        {
//            BufferedReader bufferedReader = new BufferedReader(new FileReader("E://File//file"+i+".txt"));
//            for(int j=0 ; j<5 ; j++)
//                b[j]=Integer.parseInt(bufferedReader.readLine());
//        }
//
//
//    }
//}






package sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TournamentSort
{
    private int index;

    public long findMin(ArrayList<Long> num,int n)
    {
        long min=num.get(0),x=0,firstNum=0,secondNum=0;

        for(int i=1 ; i<n-1 ; i+=2)
        {
            firstNum=num.get(i);
            secondNum=num.get(i+1);
            x=Math.min(firstNum,secondNum);
            if(x<min)
                min=x;
        }
        if(num.get(n-1)<min)
            min=num.get(n-1);
        index=num.indexOf((long)min);
        return min;
    }
    public long findMin1(long[] num,int n)
    {
        long min=num[0],x=0,firstNum=0,secondNum=0;

        index=0;
        for(int i=1 ; i<n-1 ; i+=2)
        {
            firstNum=num[i];
            secondNum=num[i+1];
            x=Math.min(firstNum,secondNum);
            if(x<min) {
                min = x;
                if(min==num[i])
                    index=i;
                else
                    index=i+1;
            }
        }
        if(num[n-1]<min) {
            min = num[n - 1];
            index=n-1;
        }
        //index=num.indexOf((long)min);
        return min;
    }
    public void tournamentSort(int NumberOfChunks) throws FileNotFoundException, IOException
    {

        String str="";
        int n=0;
        ArrayList<Long> list=new ArrayList();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("E://File//mainFile.txt"));
        BufferedReader bufferedReader[] = new BufferedReader[NumberOfChunks];

        for (int i = 0; i <NumberOfChunks ; i++)
        {
            bufferedReader[i] = new BufferedReader(new FileReader("E://File//file" + i + ".txt"));
            list.add(Long.parseLong(bufferedReader[i].readLine()));
        }

        long min = findMin(list, list.size());
        bufferedWriter.append(String.valueOf(min));
        bufferedWriter.newLine();
        int y=0;
        while(n!=NumberOfChunks)
//        while(list.size()>0)
        {
            str = bufferedReader[index].readLine();
            if (str != null)
                list.set(index, Long.parseLong(str));
            else if(str == null)
            {
                list.set(index, Long.MAX_VALUE);
                //list.remove(index);
                n++;
            }
            min = findMin(list, list.size());

            if(min!=Long.MAX_VALUE)
            {
                bufferedWriter.append(String.valueOf(min));
                bufferedWriter.newLine();
            }
        }
        System.out.println(y);
        bufferedWriter.close();
    }
    public void tournamentSort1(int NumberOfChunks) throws FileNotFoundException, IOException
    {

        String str="";
        int n=0;
        long a[]=new long[NumberOfChunks];
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("E://File//mainFile.txt"));
        BufferedReader bufferedReader[] = new BufferedReader[NumberOfChunks];

        for (int i = 0; i <NumberOfChunks ; i++)
        {
            bufferedReader[i] = new BufferedReader(new FileReader("E://File//file" + i + ".txt"));
            a[i]=Long.parseLong(bufferedReader[i].readLine());
        }
        long min = findMin1(a, a.length);
        bufferedWriter.append(String.valueOf(min));
        bufferedWriter.newLine();

        while(n!=NumberOfChunks)
        {
            str = bufferedReader[index].readLine();
            if (str != null)
                a[index]=Long.parseLong(str);
                //list.set(index, Long.parseLong(str));
            else if(str == null)
            {
                a[index]=Long.MAX_VALUE;
                n++;
            }
            min = findMin1(a, a.length);

            if(min!=Long.MAX_VALUE)
            {
                bufferedWriter.append(String.valueOf(min));
                bufferedWriter.newLine();
            }
        }
        bufferedWriter.close();
    }
}
