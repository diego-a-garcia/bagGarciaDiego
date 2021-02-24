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

      public ResizeableArrayBag(int desiredCapacity) {

            @SuppressWarnings("unchecked")

            T[] tempBag = (T[]) new Object[desiredCapacity];

            bag = tempBag;

            numberOfEntries = 0;

      }

      public ResizeableArrayBag() {

            this(DEFAULT_CAPACITY);

      }

      public boolean add(T anEntry) {

            if (isArrayFull()) {

                  doubleCapacity();

            } 

            this.bag[this.numberOfEntries] = anEntry;

            this.numberOfEntries++;

            return true;

      }

      

      private void doubleCapacity() {

            int newLength = 2 * this.bag.length;

            this.bag = Arrays.copyOf(this.bag, newLength);

      }

      public T[] toArray() {

            @SuppressWarnings("unchecked")

            T[] result = (T[]) new Object[numberOfEntries]; 

            for (int index = 0; index < numberOfEntries; index++) {

                  result[index] = bag[index];

            }

            return result;

      }

      public T remove() {

            T result = removeEntry(numberOfEntries - 1);

            return result;

      }

      public boolean remove(T anEntry) {

            int index = getIndexOf(anEntry);

            T result = removeEntry(index);

            return anEntry.equals(result);

      }

     

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

      public void clear() {

            while (!isEmpty())

                  remove();

      }

      public int getFrequencyOf(T anEntry) {

            int counter = 0;

            for (int index = 0; index < numberOfEntries; index++) {

                  if (anEntry.equals(bag[index])) {

                        counter++;

                  } 

            } 

            return counter;

      }

      public int getCurrentSize() {

            return numberOfEntries;

      }

      public boolean isArrayFull() {

            return numberOfEntries == bag.length;

      }

      public boolean contains(T anEntry) {

            return getIndexOf(anEntry) != -1;

      }

      public boolean isEmpty() {

            return numberOfEntries == 0;

      }

      @Override

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

      @Override

      public BagInterface<T> intersection(BagInterface<T> other) {

            ResizeableArrayBag<T> result = new ResizeableArrayBag<T>();

            

            for (int i = 0; i < numberOfEntries; i++) {

                  T item = bag[i];

                 

                  if (!result.contains(item) && other.contains(item)) {

                        

                        int common_count = Math.min(getFrequencyOf(item),

                                    other.getFrequencyOf(item));

                      

                        for (int j = 0; j < common_count; j++) {

                              result.add(item);

                        }

                  }

            }

            return result;

      }

      @Override

      public BagInterface<T> difference(BagInterface<T> other) {

            ResizeableArrayBag<T> result = new ResizeableArrayBag<T>();

            for (int i = 0; i < numberOfEntries; i++) {

                  T item = bag[i];

                 

                  if (!result.contains(item)) {

                        

                        int difference = getFrequencyOf(item)

                                    - other.getFrequencyOf(item);

                        

                        for (int j = 0; j < difference; j++) {

                              result.add(item);

                        }

                  }

            }

            return result;

      }

}
