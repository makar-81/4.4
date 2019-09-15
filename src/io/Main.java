package io;

/**
 * Created by emakarov on 27.01.2016.
 */

import java.util.*;

/**
 * Created by emakarov on 27.01.2016.
 */
import java.io.*;

public class Main {
    public static void main(String[] args) {
        // put your code here
        //try {
            BufferedReader br;
            BufferedWriter bw;
            String temp;

            //FileReader fr = new FileReader("./test1.txt");
            //FileWriter wr = new FileWriter("./test2.txt");

            //bw = new BufferedWriter(wr);
            //br = new BufferedReader(fr);

            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));

            //Map<String, Integer> store = new HashMap<String, Integer>();
            Map<Integer,String> keys = new HashMap<Integer,String>();
            ArrayList<String> myArrayList = new ArrayList<String>();

            // Map<String, Integer> count = new HashMap<String, Integer>();
            int key = 0;

            int mass_count[] = {0};
            try {
                Integer key2= new Integer(0);
                while ((temp = br.readLine()) != null) {
                    int pos1 = temp.indexOf("\t");
                    while (!temp.isEmpty()) {

                        String word1 = "", word2="";
                        if (pos1 > 0) {
                            key2 = key2.parseInt(temp.substring(0, pos1));
                            word1 = temp.substring(0, pos1) + temp.substring(pos1 + 1, temp.length());
                            word2= temp.substring(pos1 + 1, temp.length());
                            temp = "";
                        }
                        if (!keys.containsValue(word2)) {
                            keys.put(key,word2);
                            key = key + 1;
                        }

                        if (!myArrayList.contains(word1)) myArrayList.add(word1);
                    }


                }
                for (int i =0;i<keys.size();i++){
                    int count = 0;
                    for (int k = 1; k<=key2; k++){
                        count = count + Collections.frequency(myArrayList, k+keys.get(i));
                    }
                      System.out.println(keys.get(i) + "\t" + count + "\n");
                      bw.write(keys.get(i) + "\t" + count + "\n");
                      bw.flush();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        } /*catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
