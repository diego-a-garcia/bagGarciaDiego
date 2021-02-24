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
public interface BagInterface < T >

{
    //returns how big the bag is
    public int getCurrentSize();
    // returns if the bag is empty or not
    public boolean isEmpty();
    // adds a new entry to the bag
    public boolean add(T newEntry);
    //removes an entry from the bag
    public T remove();
    //removes a specific entry from the bag
    public boolean remove(T anEntry);
    //clears the whole bag
    public void clear();
    //returns the frequency of a specific value in the bag
    public int getFrequencyOf(T anEntry);
    //returns a certain value of the bag
    public boolean contains(T anEntry);
    //turns the bag into an array for the user to see
    public T[] toArray();
    //combines two bags together
    public BagInterface < T > union(BagInterface < T > otherBag);
    //returns the intersection of the two bags
    public BagInterface < T > intersection(BagInterface < T > otherBag);
    //returns the difference of two bags
    public BagInterface < T > difference(BagInterface < T > otherBag);

}