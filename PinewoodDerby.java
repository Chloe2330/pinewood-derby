// Pinewood Derby assignment: using the java scanner to read in a txt file
package jansem2;
import java.util.*;
import java.io.*;

public class PinewoodDerby
{
    public static void main (String [] args) throws FileNotFoundException
    {
        // read in the txt file
        File pinewood = new File("C:\\Users\\qil\\Desktop\\Chloe's folder\\helloworlds\\src\\jansem2\\pinewood2.txt");
        Scanner s = new Scanner(pinewood);
        int contestants = s.nextInt();
        s.nextLine();

        // two 2d arrays store the int values
        int[][] array1 = new int[contestants][5];
        int[][] array2 = new int[contestants][5];

        // first array stores contestant numbers
        for(int i = 0; i < contestants; i++)
        {
            // dummy variable to skip over the letter
            String heat = s.next();
            for(int j = 0; j < 5; j++)
            {
                int cont1 = s.nextInt();
                array1[i][j] = cont1;
            }
        }
        // second array stores contestant placement (points)
        for(int k = 0; k < contestants; k++)
        {
            // dummy variable to skip over the letter
            String heat2 = s.next();
            for(int l = 0; l < 5; l++)
            {
                int cont2 = s.nextInt();
                array2[k][l] = cont2;
            }
        }

        winners(twoArray(array1, array2, contestants));
        s.close();
    }

    public static int [] twoArray(int [][] a, int [][] b, int c)
    {
        // 1d array stores the point totals of each individual contestant
        int [] storage = new int[c];
        int add = 0;
        int compare = 1;

        // while loop compares array elements to the "compare" value, which increases through every iteration
        while(compare <= c)
        {
            // nested for loops iterate throughout the first array (contestant numbers)
            for (int row = 0; row < a.length; row++)
            {
                for (int col = 0; col < a[0].length; col++)
                {
                    // if the element is equal to the "compare" value
                    if(a[row][col] == compare)
                    {
                        // find the contestant placement in the second array and add points to "add" value
                        add = add + b[row][col];
                    }
                }
            }
            // store the final add value (point totals)
            storage[compare-1] = add;
            compare++;
            // reset the "add" value and continue to the next contestant number
            add = 0;
        }
      return storage;
    }

    public static void winners(int [] s)
    {
        // setting the max value to total number of points in the array
        int maxvalue = 0;
        for(int i = 0; i < s.length; i++)
        {
            maxvalue = maxvalue + s[i];
        }

        // first place
        int goldscore = maxvalue;
        int goldplayer = 0;
        // arraylist stores any ties (contestants with the same point total)
        ArrayList <Integer> ties1 = new ArrayList <Integer>();

        for (int i = 0; i < s.length; i++)
        {
            // record the contestant number and array index of the lowest scorer
            if (s[i] < goldscore)
            {
                goldplayer = i+1;
                goldscore = s[i];
            }
            // after the first iteration
            if(i == s.length-1)
            {
                // iterate again to look for ties (equal to the lowest scorer)
                for (int j = 0; j < s.length; j++)
                {
                    if(s[j] == goldscore)
                    {
                        ties1.add(j+1);
                        // reset index to max value to avoid duplicates when looking for other placements
                        s[j] = maxvalue;
                    }
                }
            }
        }
        // reset index to max value to avoid duplicates when looking for other placements
        s[goldplayer-1] = maxvalue;
        System.out.println("FIRST PLACE " + ties1.toString());

        // second place
        int silverscore = maxvalue;
        int silverplayer = 0;
        // arraylist stores any ties (contestants with the same point total)
        ArrayList <Integer> ties2 = new ArrayList <Integer>();

        for (int i = 0; i < s.length; i++)
        {
            // record the contestant number and array index of the lowest scorer
            if (s[i] < silverscore)
            {
                silverplayer = i+1;
                silverscore = s[i];
            }
            // after the first iteration
            if(i == s.length-1)
            {
                // iterate again to look for ties (equal to the lowest scorer)
                for (int j = 0; j < s.length; j++)
                {
                    if(s[j] == silverscore)
                    {
                        ties2.add(j+1);
                        // reset index to max value to avoid duplicates when looking for other placements
                        s[j] = maxvalue;
                    }
                }
            }
        }
        // reset index to max value to avoid duplicates when looking for other placements
        s[silverplayer-1] = maxvalue;
        System.out.println("SECOND PLACE " + ties2.toString());

        // third place
        int bronzescore = maxvalue;
        int bronzeplayer = 0;
        // arraylist stores any ties (contestants with the same point total)
        ArrayList <Integer> ties3 = new ArrayList <Integer>();

        for (int i = 0; i < s.length; i++)
        {
            // record the contestant number and array index of the lowest scorer
            if (s[i] < bronzescore)
            {
                bronzeplayer = i+1;
                bronzescore = s[i];
            }
            // after the first iteration
            if(i == s.length-1)
            {
                // iterate again to look for ties (equal to the lowest scorer)
                for (int j = 0; j < s.length; j++)
                {
                    if(s[j] == bronzescore)
                    {
                        ties3.add(j+1);
                        // reset index to max value to avoid duplicates when looking for other placements
                        s[j] = maxvalue;
                    }
                }
            }
        }
        // reset index to max value to avoid duplicates when looking for other placements
        s[bronzeplayer-1] = maxvalue;
        System.out.println("THIRD PLACE " + ties3.toString());

        // fourth place
        int hmonescore = maxvalue;
        int hmoneplayer = 0;
        // arraylist stores any ties (contestants with the same point total)
        ArrayList <Integer> ties4 = new ArrayList <Integer>();

        for (int i = 0; i < s.length; i++)
        {
            // record the contestant number and array index of the lowest scorer
            if (s[i] < hmonescore)
            {
                hmoneplayer = i+1;
                hmonescore = s[i];
            }
            // after the first iteration
            if(i == s.length-1)
            {
                // iterate again to look for ties (equal to the lowest scorer)
                for (int j = 0; j < s.length; j++)
                {
                    if(s[j] == hmonescore)
                    {
                        ties4.add(j+1);
                        // reset index to max value to avoid duplicates when looking for other placements
                        s[j] = maxvalue;
                    }
                }
            }
        }
        // reset index to max value to avoid duplicates when looking for other placements
        s[hmoneplayer-1] = maxvalue;
        System.out.println("FOURTH PLACE " + ties4.toString());

        // fifth place
        int hmtwoscore = maxvalue;
        int hmtwoplayer = 0;
        // arraylist stores any ties (contestants with the same point total)
        ArrayList <Integer> ties5 = new ArrayList <Integer>();

        for (int i = 0; i < s.length; i++)
        {
            // record the contestant number and array index of the lowest scorer
            if (s[i] < hmtwoscore)
            {
                hmtwoplayer = i+1;
                hmtwoscore = s[i];
            }
            // after the first iteration
            if(i == s.length-1)
            {
                // iterate again to look for ties (equal to the lowest scorer)
                for (int j = 0; j < s.length; j++)
                {
                    if(s[j] == hmtwoscore)
                    {
                        ties5.add(j+1);
                    }
                }
            }
        }
        s[hmtwoplayer-1] = maxvalue;
        System.out.println("FIFTH PLACE " + ties5.toString());
    }
}
