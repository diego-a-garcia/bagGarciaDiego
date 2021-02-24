/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bag;

/**
 *
 * @author diego
 */
import java.util.Arrays;

/**
 *
 * @author diego
 */
public class ArrayBagTest {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

            // creating two bags

            BagInterface<String> b1 = new ResizeableArrayBag<String>();

            BagInterface<String> b2 = new ResizeableArrayBag<String>();

            // adding some strings

            b1.add("d");

            b1.add("i");

            b1.add("e");

            b1.add("g");

            b1.add("o");

            b1.add("g");

            b2.add("a");

            b2.add("r");

            b2.add("c");

            b2.add("i");

            b2.add("a");

            b2.add("d");

            b2.add("g");

           

            System.out.println("bag1: " + Arrays.toString(b1.toArray()));

            System.out.println("bag2: " + Arrays.toString(b2.toArray()));

            

            System.out.println("bag1 union bag2: "

                        + Arrays.toString(b1.union(b2).toArray()));

            System.out.println("bag1 intersection bag2: "

                        + Arrays.toString(b1.intersection(b2).toArray()));

            System.out.println("bag1 difference bag2: "

                        + Arrays.toString(b1.difference(b2).toArray()));

      }

}