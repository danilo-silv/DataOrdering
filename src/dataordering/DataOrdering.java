package dataordering;

import util.Sort;
//import lists.DynamicList;
import sortables.BubbleSort;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author danilo
 * this project is to measure the performance of the ordering of vectors and lists
 */
public class DataOrdering {

    public static void main(String[] args) {
        int[] sizes = {4};
        int vectorsNumber = 2;

        for(int size : sizes){
           sortLists(size, vectorsNumber);
        }
    }
    
    public static void sortLists(int listSize, int vectorsNumber){
        int[] array = new int[listSize];

        ArrayList<Sort> algorithms = new ArrayList<>();
        algorithms.add(new BubbleSort(array));

        System.out.println("\n---------------------------------------------------------------------------------------\n" +
                "List size: " + listSize +
                "\nNumber of arrays: " + vectorsNumber);
        for(Sort sortable : algorithms){
            sortSingleList(sortable, vectorsNumber);
        }
    }
    
    
       public static void sortSingleList(Sort sortable, int vectorsNumber){
        long averageComparisons = 0;
        for(int i = 0; i < vectorsNumber; i++){
            sortable.comparisonsNumber = 0;
            randomize(sortable.array);
            sortable.sort();
            averageComparisons += sortable.comparisonsNumber;
        }
        averageComparisons = averageComparisons / vectorsNumber;
        System.out.println("\n" + sortable.getClass().getSimpleName());
        System.out.print("Average Comparisons: " + averageComparisons);
        System.out.println();
    }

    public static void randomize(int[] v){
        Random random = new Random();
        for(int i = 0; i < v.length; i++){
            v[i] = random.nextInt(11);
        }
    }
    
}
