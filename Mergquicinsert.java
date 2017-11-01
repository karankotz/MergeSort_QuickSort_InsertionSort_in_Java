

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 @Author Karan
 */
//Class for the insertion sort Algorithm
class insertionsort 
{
	  //insertion sort method
      void insertion_sort(ArrayList<Long> elements9) 
      {
        Long key;
        int i, j;
        int n = elements9.size();
        //loop over the elements from 1 to n 
        for (i = 1; i < n; i++) 
        {
            //assign the key value as the second(1th index as 0th is first) element in the arraylist
            key = elements9.get(i);
            j = i - 1;
            //start comparing the key element and then re-order the array and insert the key at the correct position
            while (j >= 0 && elements9.get(j) > key) 
            {
                elements9.set(j+1, elements9.get(j));
                j = j - 1;

            }
            //insert the key at the correct position
            elements9.set(j+1,key);
        }
    }
     
}
//Class for the Mergesort Algorithm
class Mergesort
{
    // Merges two subarrays of length mid-lindex+1 and rindex-mid
    void merge(ArrayList<Long> elements1, int lindex, int mid, int rindex)
    {
 
        // Create the two auxillary arrayslists Left and Right arrays 
        
    
        Long Left[] = new Long [mid-lindex+1];
        Long Right[] = new Long [rindex-mid];
 
        //Copy data to two of the auxillary arrays  from the main array
      
        for (int i=0; i<Left.length; ++i)
            Left[i] = elements1.get(lindex+i);
        
        for (int j=0; j<Right.length; ++j)
            Right[j] = elements1.get(mid + 1+ j);
 
 
        //Merge the auxillary arrays
 
        
        int i = 0, j = 0;
 
        // Set the index of merged subarry array
        int m_index = lindex;
        
        //Store the length of the teo subarrays in the variables 
        int nL = Left.length;
        int nR = Right.length;
        //check both the arrays have the length that is less than untill they
        //are full
        while (i < nL && j < nR)
        {
            if (Left[i] <= Right[j])
            {
                elements1.set(m_index, Left[i]);
                i++;
            }
            else
            {
                elements1.set(m_index,  Right[j]);
                j++;
            }
            m_index++;
        }
 
        //After we are done with the merging there will be some remaining elements that we need to 
        // copy to the merged array
        //copy the remaining elements of the Left array 
        while (i < nL)
        {
            elements1.set(m_index,  Left[i]);
            i++;
            m_index++;
        }
 
        // Copy remaining elements of the Right array
        
        while (j < nR)
        {
            elements1.set(m_index,  Right[j]);
            j++;
            m_index++;
        }
    }
 
    // Mergesort method that takes the input of the last and the first index of the list
    // merge()
    void mergesort(ArrayList<Long> elements1, int lindex, int rindex)
    {
        if (lindex < rindex)
        {
            // Find the middle point
            int mid = (lindex+rindex)/2;
 
            // Sort first and second halves
            
            mergesort(elements1, lindex, mid);
            mergesort(elements1, mid+1, rindex);
 
            // Merge the sorted halves
            merge(elements1, lindex, mid, rindex);
        }
        
        
    }
  
}

//Class for the Quick sort Algorithms 
class Quicksort{
     //used to partition the array by choosing the last element as the pivot
    //and the first element position as the partition index 
    int partition(ArrayList<Long> elements, int start, int end)
    {
        //initialize the last element of the arraylist as the pivot
        Long pivot =  elements.get(end); 
        int partition_index = (start-1); // index of smaller element
        for (int i=start; i<=end-1; i++)
        {
            // arrange the lesser than elements to the left of the pivot
            // and greater than pivot elements to the right of the pivot
            if (elements.get(i) <= pivot)
            {
                partition_index++;
                // swap arr[i] and arr[partition_index] in the arraylists 
                Long temp = elements.get(partition_index);
                elements.set(partition_index, elements.get(i));
                elements.set(i, temp);
                
                
                
            }
        }
 
        // swap end element with the partition_index element
        Long temp = elements.get(partition_index + 1);
        elements.set(partition_index+1, elements.get(end));
        elements.set(end, temp);
        return (partition_index+1);
    }
 
 
    /* function that implements QuickSort()*/
    void quicksort(ArrayList<Long> elements, int start, int end)
    {
        //int pindex;
        if (start < end)
        {
           //calculate the partition index with the use of the function defined as the partition
             int pindex = partition(elements, start, end);
           
 
            // Recursive calls to sort the elements 
            quicksort(elements, start, pindex-1);
            quicksort(elements, pindex+1, end);
        }
    }
    
    
}
//Main Class 
public class Mergquicinsert {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
         
    PrintWriter pw = new PrintWriter(new File("Plot1.csv"));
    StringBuilder sb = new StringBuilder();
            //Write the size of the inputs to the csv files with the respective headers.
          
            
            sb.append("No of inputs Quick Sort Non-Decreasing ");
            sb.append(',');
            sb.append("Time");
            sb.append(',');
            
            sb.append("No of inputs Merge Sort Non-Decreasing");
            sb.append(',');
            sb.append("Time");
            sb.append(',');
            
            sb.append("No of inputs Insertion Sort Non-Decreasing");
            sb.append(',');
            sb.append("Time");
            sb.append(',');
    //run the loop to sort the random inputs for the quic, merge and insertion sort
   //since 20*500 = 10000	
    for (int lp = 1; lp <= 20; lp++) 
    {
            //int lp = 1;
            
            
            
             //variables for the Random input  
         double Avg = 0;
         double Avg_merg =0;
         double Avg_insert =0;
         
         
         
         //variables for the Random input  
         double sum = 0;
         double sum_merg=0;
         double sum_insert=0;
        

            
            //run the whole of the logic for the 10 times to get the average time of the 10 runs for the 
            //random inputs
            
            for(int k =0; k <10;k++)
            {
            File fout = new File("insert.txt");
            FileOutputStream fos = new FileOutputStream(fout);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            bw.flush();
            Random generator = new Random();
         
            int roll;
            int li;
            for ( li = 1; li <= (lp * 500); li++)
            {
                    //generate a random number and make it unique by adding kp1 
                    
                    roll = generator.nextInt(li);
                    //convert the roll to the string as it will be an integer before writing to the file.
                    String stry = Integer.toString(roll);
                    //write to the file out.txt
                    bw.write(stry);
                    //only set the newline after the last line so that the blank values are not read.
                     if (li < (lp * 500)) {
                    bw.newLine();
                      }
                    
             }
            bw.close();
            //System.out.println("Li Value"+li);
      
            int counter  =0;
            String lineContents;
      
       Scanner s = new Scanner(new File("insert.txt"));
       //declare the arraylists for reading the random integeres generated to the file 
       ArrayList<Long> elements = new ArrayList<Long>();
       ArrayList<Long> elements1 = new ArrayList<Long>();
       ArrayList<Long> elements2 = new ArrayList<Long>();
       
       while (s.hasNext())
       {
       
       //add the elements in the three lists for the quick, merge and the sort
        long add_k = s.nextLong();

       elements.add(add_k);
       elements1.add(add_k);
       elements2.add(add_k);
       counter++;
       }
  
       s.close();
    
      //Quick sort Sum calculation to find the average running time of 10 readings
     Quicksort q  = new Quicksort();
     double startTime = (double) System.currentTimeMillis();
    
      //call to quick sort
     q.quicksort(elements, 0, elements.size()- 1);
     
    
     
     double stopTime = (double) System.currentTimeMillis();
     double elapsedTime_ins = stopTime - startTime;

     sum= sum + elapsedTime_ins;
     
     
     
     //Merge Sort Sum Calculation to find the average running time of 10 readings
     Mergesort merg  = new Mergesort();
     double startTime_merg = (double) System.currentTimeMillis();
     //call to merge sort 
     merg.mergesort(elements1, 0, elements1.size()- 1);
     
     double stopTime_merg = (double) System.currentTimeMillis();
     double elapsedTime_ins_merg = stopTime_merg - startTime_merg;
      
     sum_merg= sum_merg + elapsedTime_ins_merg;
     
     //Insertion Sort Time Sum calculation to find the avg time of the 10 readings
     insertionsort ins  = new insertionsort();
     double startTime_insert = (double) System.currentTimeMillis();
     //call to insertion sort 
     ins.insertion_sort(elements2);
     
     double stopTime_insert = (double) System.currentTimeMillis();
     double elapsedTime_insert = stopTime_insert - startTime_insert;
     sum_insert= sum_insert + elapsedTime_insert;
     
     
     
     
      /*    for(int h = 0; h<elements1.size();h++)
           {
            System.out.println( elements1.get(h));
           }*/
      
  }
            Avg = sum/10;
            Avg_merg = sum_merg/10;
            Avg_insert = sum_insert/10;
            
            //Write to the string builder for the Random input Averges 
            sb.append("" + lp * 500 + "");
            sb.append(',');
            sb.append("" + Avg + "");
            sb.append(',');
              
            sb.append("" + lp * 500 + "");
            sb.append(',');
            sb.append("" + Avg_merg + "");
            sb.append(',');
            
            sb.append("" + lp * 500 + "");
            sb.append(',');
            sb.append("" + Avg_insert + "");
            sb.append('\n');
           
   
            
            
                
 }
//Fnally write to th file Plot1.csv
    pw.write(sb.toString());
    pw.close();
    
    //run the loop for the Non Decreasing Order Integers
     StringBuilder sb1 = new StringBuilder();
     PrintWriter pw1 = new PrintWriter(new File("Plot2.csv"));
	 //run the loop to sort the non decreasing order inputs for the quick, merge and insertion sort
   //since 20*500 = 10000	
     for (int lp1 = 1; lp1 <= 20; lp1++) 
    {
         
        
         
         //for non decreasing input
         double Avg1 = 0;
         double Avg_merg1 = 0;
         double Avg_insert1 =0;
        
         
         //for non decreasing input
         double sum1 = 0;
         double sum_merg1 =0;
         double sum_insert1 = 0;
         
            
            //run the whole of the logic for the 10 times to get the average time of the 10 runs for the 
              
            for(int k =0; k <10;k++)
            {
            File fout1 = new File("insert1.txt");
            FileOutputStream fos1 = new FileOutputStream(fout1);
            BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(fos1));
            bw1.flush();
            Random generator = new Random();
         
            int roll;
            int li1;
            int kp1 = 0;
            for ( li1 = 1; li1 <= (lp1 * 500); li1++)
            {
                    //generate a random number and make it unique by adding kp1 
                    
                    roll = kp1;
                    //convert the roll to the string as it will be an integer be		    fore writing to the file.
                    String stry = Integer.toString(roll);
                    //write to the file out.txt
                    bw1.write(stry);
                    //only set the newline after the last line so that the blank 		    values are not read.
                     if (li1 < (lp1 * 500)) 
		      {
                    	bw1.newLine();
                      }
                     kp1 = kp1 + 6;
                    
             }
            bw1.close();
            //System.out.println("Li Value"+li);
      
            int counter  =0;
      
       Scanner s = new Scanner(new File("insert1.txt"));
       //Declare the three array lists for the quick, merge and the insertion sort 
       ArrayList<Long> elements3 = new ArrayList<Long>();
       ArrayList<Long> elements4 = new ArrayList<Long>();
       ArrayList<Long> elements5 = new ArrayList<Long>();
       
       while (s.hasNext())
       {
       
       //three lists for the quick, merge and the sort
       long add_k = s.nextLong();
	//store the elements in the three lists 
       elements3.add(add_k);
       elements4.add(add_k);
       elements5.add(add_k);
  
       counter++;
       }
     
       s.close();
    
      //Quick sort Sum calculation to find the avg of 10 readings 
     Quicksort q  = new Quicksort();
     double startTime1 = (double) System.currentTimeMillis();
     //call to quick sort 
     q.quicksort(elements3, 0, elements3.size()- 1);
     
     double stopTime1 = (double) System.currentTimeMillis();
     double elapsedTime_ins1 = stopTime1 - startTime1;

     sum1= sum1 + elapsedTime_ins1;
    
     
     //Merge Sort time Sum Calculation to find the avg of 10 readings 
     Mergesort merg  = new Mergesort();
     double startTime_merg1 = (double) System.currentTimeMillis();
     //Call to merge sort
     merg.mergesort(elements4, 0, elements4.size()- 1);
     
     double stopTime_merg1 = (double) System.currentTimeMillis();
     double elapsedTime_ins_merg1 = stopTime_merg1 - startTime_merg1;

     sum_merg1= sum_merg1 + elapsedTime_ins_merg1;
     
     //Insertion Sort Time Sum calculation to find the avg of 10 readings 
     //call to the insertion sort
     insertionsort ins  = new insertionsort();
     double startTime_insert1 = (double) System.currentTimeMillis();
     
     ins.insertion_sort(elements5);
     
     double stopTime_insert1 = (double) System.currentTimeMillis();
     double elapsedTime_insert1 = stopTime_insert1 - startTime_insert1;
     
     sum_insert1= sum_insert1 + elapsedTime_insert1;
     
      
  }
	    //Calculate the Average
            Avg1 = sum1/10.0;
            Avg_merg1 = sum_merg1/10.0;
            Avg_insert1 = sum_insert1/10.0;
            
            //Write to the string builder for the Random input Averges 
            sb1.append("" + lp1 * 500 + "");
            sb1.append(',');
            sb1.append("" + Avg1 + "");
            sb1.append(',');
              
            sb1.append("" + lp1 * 500 + "");
            sb1.append(',');
            sb1.append("" + Avg_merg1 + "");
            sb1.append(',');
            
            sb1.append("" + lp1 * 500 + "");
            sb1.append(',');
            sb1.append("" + Avg_insert1 + "");
            sb1.append('\n');
           
   
            
            
                
 }
 //Write to the .csv output file Plot2.csv
    pw1.write(sb1.toString());
    pw1.close();
    
   //Next Code is to calculate the Avg time for the Decreasing  order inputs.
   //initialize the string builder and print writer objects for the Plot3.csv file
   StringBuilder sb2 = new StringBuilder();
     PrintWriter pw2 = new PrintWriter(new File("Plot3.csv"));
   //run the loop to sort the non decreasing order inputs for the quick, merge and insertion sort
   //since 20*500 = 10000	
     for (int lp2 = 1; lp2 <= 20; lp2++) 
    {
         
        
         
         //for decreasing input
         double Avg2 = 0;
         double Avg_merg2 = 0;
         double Avg_insert2 =0;
        
         
         //for decreasing input
         double sum2 = 0;
         double sum_merg2 =0;
         double sum_insert2 = 0;
         
            
            //run the whole of the logic for the 10 times to get the average time of the 10 runs for the 
              
            for(int k2 =0; k2 <10;k2++)
            {
            //object to the file insert2.txt
            File fout2 = new File("insert2.txt");
            FileOutputStream fos2 = new FileOutputStream(fout2);
            BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(fos2));
            bw2.flush();
        
         
            int roll;
            int li2;
            int random_decr = 100000;
            for ( li2 = 1; li2 <= (lp2 * 500); li2++)
            {
                    //generate a random number and make it unique by adding kp1 
                    
                    roll = random_decr;
                    //convert the roll to the string as it will be an integer before writing to the file.
                    String stry = Integer.toString(roll);
                    //write to the file out.txt
                    bw2.write(stry);
                    //only set the newline after the last line so that the blank values are not read.
                     if (li2 < (lp2 * 500)) {
                    bw2.newLine();
                      }
                     //to define the decreasing order logic subtract the numeric integer
                     random_decr = random_decr - 1;
                    
             }
            bw2.close();
            //System.out.println("Li Value"+li);
      
            int counter  =0;
      
       Scanner s = new Scanner(new File("insert2.txt"));
       
       ArrayList<Long> elements6 = new ArrayList<Long>();
       ArrayList<Long> elements7 = new ArrayList<Long>();
       ArrayList<Long> elements8 = new ArrayList<Long>();
       
       while (s.hasNext())
       {
       
       //three lists for the quick, merge and the sort
       long add_k = s.nextLong();
       elements6.add(add_k);
       elements7.add(add_k);
       elements8.add(add_k);
       //System.out.println(list.get(counter));
       counter++;
       }
     
       s.close();
    
      //Quick sort Time Sum calculation to find the avg time of the 10 runs 
     Quicksort q2  = new Quicksort();
     double startTime2 = (double) System.currentTimeMillis();
     //call to quick sort 
     q2.quicksort(elements6, 0, elements6.size()- 1);
     
     double stopTime2 = (double) System.currentTimeMillis();
     double elapsedTime_ins2 = stopTime2 - startTime2;

     sum2 = sum2 + elapsedTime_ins2;
     
     
     //Merge Sort Time Sum Calculation to find the avg time of the 10 runs 
     Mergesort merg2  = new Mergesort();
     double startTime_merg2 = (double) System.currentTimeMillis();
     //call to merge sort 
     merg2.mergesort(elements7, 0, elements7.size()- 1);
     
     double stopTime_merg2 = (double) System.currentTimeMillis();
     double elapsedTime_ins_merg2 = stopTime_merg2 - startTime_merg2;

     sum_merg2 = sum_merg2 + elapsedTime_ins_merg2;
     
     //Insertion Sort Time Sum calculation to find the avg time of the 10 runs
     insertionsort ins2  = new insertionsort();
     double startTime_insert2 = (double) System.currentTimeMillis();
     //call to insertion sort
     ins2.insertion_sort(elements8);
     
     double stopTime_insert2 = (double) System.currentTimeMillis();
     double elapsedTime_insert2 = stopTime_insert2 - startTime_insert2;
     
     sum_insert2= sum_insert2 + elapsedTime_insert2;
     

      
  }
            //calculate the average
            Avg2 = sum2/10.0;
            Avg_merg2 = sum_merg2/10.0;
            Avg_insert2 = sum_insert2/10.0;
            
            //Write to the string builder for the Random input Averges 
            sb2.append("" + lp2 * 500 + "");
            sb2.append(',');
            sb2.append("" + Avg2 + "");
            sb2.append(',');
              
            sb2.append("" + lp2 * 500 + "");
            sb2.append(',');
            sb2.append("" + Avg_merg2 + "");
            sb2.append(',');
            
            sb2.append("" + lp2 * 500 + "");
            sb2.append(',');
            sb2.append("" + Avg_insert2 + "");
            sb2.append('\n');
           
   
            
            
                
 }
    //Finally write to the Plot3.csv
    pw2.write(sb2.toString());
    pw2.close();
     
     
        
    }
    
}

