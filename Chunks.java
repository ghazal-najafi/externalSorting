package sorting;

import java.io.*;
import java.util.Arrays;

public class Chunks
{
    public int count;
    public final int capacity=50000000;
    public int chunkNum;

    public int d1()throws Exception
    {
        long num[]=new long[capacity];

        MergeSort sort=new MergeSort();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("E://File//newfile.txt"));

        int numberCount=0,fileCount=0;
        String number=bufferedReader.readLine();
        while(number!=null)
        {
            while(numberCount<capacity && number!=null)
            {
                num[numberCount] = Long.valueOf(number);
                number = bufferedReader.readLine();
                numberCount++;
            }
            int mid=numberCount/2;
            long f[]=Arrays.copyOfRange(num,0,mid);

//            for(int i=0 ; i<f.length ; i++)
//                System.out.print(f[i]+"  ");
//            System.out.println();
            long s[]=Arrays.copyOfRange(num,mid,numberCount);

//            for(int i=0 ; i<s.length ; i++)
//                System.out.print(s[i]+"  ");
//            System.out.println();

//            MultiThreading thread = new MultiThreading(f);
//            MultiThreading thread1 = new MultiThreading(s);
//            thread.start();
//            thread1.start();
//            thread.join();
//            thread1.join();

            sort.mergeSort(f);
            sort.mergeSort(s);
//            for(int i=0 ; i<s.length ; i++)
//                System.out.print(s[i]+"  ");
//            System.out.println();
//            for(int i=0 ; i<f.length ; i++)
//                System.out.print(f[i]+"  ");
//            System.out.println();


            long h[]=new long[numberCount];
           // Arrays.sort(num);
            sort.merge(f,s,h);
            System.out.println("*"+h[0]+"   "+num[0]);

            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("E://File//file"+fileCount+".txt"));

            for(int j=0 ; j<numberCount ; j++)
            {
                bufferedWriter.write(String.valueOf(h[j]));
                bufferedWriter.newLine();
            }
            fileCount++;
            numberCount=0;
            bufferedWriter.close();
        }
        chunkNum=fileCount;
        return chunkNum;
    }
    public int divide() throws IOException
    {
        long num[]=new long[capacity];

        MergeSort sort=new MergeSort();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("E://File//newfile.txt" ));

//        for(int i=0 ; i<chunkNum ; i++)
//        {
//            for(int j=0 ; j<capacity ; j++)
//                num[j]=Long.parseLong(bufferedReader.readLine());
//
//            sort.mergeSort(num);
//
//            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("file"+i+".txt"));
//
//            for(int j=0 ; j<num.length ; j++)
//            {
//                bufferedWriter.write(String.valueOf(num[j]));
//                bufferedWriter.newLine();
//            }
//            bufferedWriter.close();
//        }

        int numberCount=0,fileCount=0;
        String number=bufferedReader.readLine();
        while(number!=null)
        {
            while(numberCount<capacity && number!=null)
            {
                num[numberCount] = Long.valueOf(number);
                number = bufferedReader.readLine();
                numberCount++;
            }
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("E://File//file"+fileCount+".txt"));

            if(numberCount==num.length)
            {
                sort.mergeSort(num);
                for(int j=0 ; j<numberCount; j++)
                {
                    bufferedWriter.write(String.valueOf(num[j]));
                    bufferedWriter.newLine();
                }
            }
            else if(numberCount<num.length)
            {
                long a[]= Arrays.copyOfRange(num, 0, numberCount);
                sort.mergeSort(a);
                for(int j=0 ; j<numberCount ; j++)
                {
                    bufferedWriter.write(String.valueOf(a[j]));
                    bufferedWriter.newLine();
                }
            }
//            else
//            {
//                long a[]= Arrays.copyOfRange(num, 0, numberCount);
//                sort.mergeSort(a);
//                BufferedWriter writer = new BufferedWriter(new FileWriter("mainFile1.txt"));
//                for(int j=0 ; j<numberCount ; j++)
//                {
//                    writer.write(String.valueOf(a[j]));
//                    writer.newLine();
//                }
//                writer.close();
//            }
            fileCount++;
            numberCount=0;
            bufferedWriter.close();
        }
        chunkNum=fileCount;
        return chunkNum;
    }
    public int getCapacity()
    {
        return capacity;
    }
    public int getChunkNum()
    {
        return chunkNum;
    }
}
