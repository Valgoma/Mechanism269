import java.io.File;import java.io.FileNotFoundException;
import java.io.IOException;import java.nio.file.Files;
import java.nio.file.Path;import java.util.Arrays;
import java.util.Scanner;
public class Main{
    public static void main(String[] args) throws IOException    {
        Scanner sc = new Scanner(new File("INPUT.TXT"));
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();
        if (line2.length() > line1.length())
        { String tmp = line1;
            line1 = line2;
            line2 = tmp;            }
        char[] arrayline1 = line1.toCharArray();
        char[] arrayline2 = line2.toCharArray();
        int [] array1 = new int[arrayline1.length];
        for (int i=0; i <arrayline1.length; i++)
        {
            array1[i] = Character.getNumericValue(arrayline1[i]);
        }
        int [] array2 = new int[arrayline2.length];
        for (int i=0; i <arrayline2.length; i++)
        {
            array2[i] = Character.getNumericValue(arrayline2[i]);
        }
        int j = 0;
        int i = 0;
        int sdvig = 0;
        outer:
        while (i<array2.length && j <array1.length)
        {
            System.out.println(j +""+ i);
            if (array1[j] + array2[i] > 3)
            {
                System.out.println(j + "equal " + i);
                System.out.println(array1[j] + "hm " + array2[i]);
                sdvig++;
                j=sdvig;
                i =0;
                continue outer;
            }
            else
            {
                System.out.println(j + " not equal" + i);
                j++;
                i++;
            }
        }
        if (j> array1.length)
        {
            outer2:
            for (int k=1; k <arrayline2.length; k++)
            {
                if (array1[array1.length-array2.length+k] + array2[k-1] > 3)
                {
                    System.out.println(j + "equal " + i);
                    System.out.println(array1[j] + "hm " + array2[i]);
                    sdvig++;
                    j=sdvig;
                    i =0;
                    continue outer2;
                }
                else if (array1[0] + array2[k] > 3)
                {
                    System.out.println(j + " not equal" + i);
                    k ++;
                    continue outer2;
                }
                else
                {
                    System.out.println(j + " not equal" + i);
                    j++;
                    i++;
                }
            }
        }
        // for (i=0; i< array2.length-1; i++)
        System.out.println(sdvig + " end " + i);
        int dlina;
        if (sdvig < array1.length-array2.length)
        {
            dlina = array1.length;
        }        else
        {
            dlina = sdvig + array2.length;
        }
        System.out.println("длина " + dlina);
         String s = String.valueOf(dlina);
        Files.writeString(Path.of("OUTPUT.TXT"), s);   }
}