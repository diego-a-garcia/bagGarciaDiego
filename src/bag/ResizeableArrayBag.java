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

public class ResizeableArrayBag<T> implements BagInterface<T> {

      private T[] bag;

      private static final int DEFAULT_CAPACITY = 25;

      private int numberOfEntries;
      //creates a bag
      public ResizeableArrayBag(int desiredCapacity) {

            @SuppressWarnings("unchecked")

            T[] tempBag = (T[]) new Object[desiredCapacity];

            bag = tempBag;

            numberOfEntries = 0;

      }
      //creates a bag with the default capacity
      public ResizeableArrayBag() {

            this(DEFAULT_CAPACITY);

      }
      //adds an entry to the bag and doubles the size of it if it is full
      public boolean add(T anEntry) {

            if (isArrayFull()) {

                  doubleCapacity();

            } 

            this.bag[this.numberOfEntries] = anEntry;

            this.numberOfEntries++;

            return true;

      }

      
      //doubles the capacity of the bag
      private void doubleCapacity() {

            int newLength = 2 * this.bag.length;

            this.bag = Arrays.copyOf(this.bag, newLength);

      }
      //makes an array out of the bag
      public T[] toArray() {

            @SuppressWarnings("unchecked")

            T[] result = (T[]) new Object[numberOfEntries]; 

            for (int index = 0; index < numberOfEntries; index++) {

                  result[index] = bag[index];

            }

            return result;

      }
      //removes an item from the array
      public T remove() {

            T result = removeEntry(numberOfEntries - 1);

            return result;

      }
      //removes a specific item from the bag
      public boolean remove(T anEntry) {

            int index = getIndexOf(anEntry);

            T result = removeEntry(index);

            return anEntry.equals(result);

      }

     
      //gets the index of a desired entry in the bag
      private int getIndexOf(T anEntry) {

            int where = -1;

            boolean found = false;

            int index = 0;

            while (!found && (index < numberOfEntries)) {

                  if (anEntry.equals(bag[index])) {

                        found = true;

                        where = index;

                  } 

                  index++;

            } 

            return where;

      }

      
      //removes a specific entry given the index from the bag
      private T removeEntry(int givenIndex) {

            T result = null;

            if (!isEmpty() && (givenIndex >= 0)) {

                  result = bag[givenIndex]; 

                  int lastIndex = numberOfEntries - 1;

                  bag[givenIndex] = bag[lastIndex]; 

                  bag[lastIndex] = null; 

                  numberOfEntries--;

            } 
            return result;

      }
      //clears the whole bag
      public void clear() {

            while (!isEmpty())

                  remove();

      }
      //gets the frequency of an item in the bag
      public int getFrequencyOf(T anEntry) {

            int counter = 0;

            for (int index = 0; index < numberOfEntries; index++) {

                  if (anEntry.equals(bag[index])) {

                        counter++;

                  } 

            } 

            return counter;

      }
      //gets the current size of the bag
      public int getCurrentSize() {

            return numberOfEntries;

      }
      //checks if the array is full
      public boolean isArrayFull() {

            return numberOfEntries == bag.length;

      }
      //checks if the bag contains a certain item
      public boolean contains(T anEntry) {

            return getIndexOf(anEntry) != -1;

      }
      //checks if the bag is empty
      public boolean isEmpty() {

            return numberOfEntries == 0;

      }

      @Override
      //returns the union of two bags
      public BagInterface<T> union(BagInterface<T> other) {

            ResizeableArrayBag<T> result = new ResizeableArrayBag<T>();

            for (int i = 0; i < numberOfEntries; i++) {
                result.add(bag[i]);
            }

            for (Object ob : other.toArray()) {
                result.add((T) ob);
            }

            return result;

      }
      //returns the intersection of two bags
      @Override

      public BagInterface<T> intersection(BagInterface<T> x) {

            ResizeableArrayBag<T> result = new ResizeableArrayBag<T>();

            for (int i = 0; i < numberOfEntries; i++) {

                  T item = bag[i];

                 if (!result.contains(item) && x.contains(item)) {

                      int common_count = Math.min(getFrequencyOf(item),x.getFrequencyOf(item));

                      for (int j = 0; j < common_count; j++) {
                            result.add(item);
                      }

                  }

            }

            return result;

      }
      //returns difference of two bags
      @Override
        public BagInterface<T> difference(BagInterface<T> other) {
            ResizeableArrayBag<T> result = new ResizeableArrayBag<T>();
            for (int i = 0; i < numberOfEntries; i++) {
                T item = bag[i];
                if (!result.contains(item)) {
                    int difference = getFrequencyOf(item) - other.getFrequencyOf(item);
                        for (int j = 0; j < difference; j++) {
                        result.add(item);
                        }

                  }

            }

            return result;

      }

}
