package dataordering;

import util.Sort;
import lists.DynamicList;
import sortables.BubbleSort;
import sortables.InsertionSort;
import sortables.SelectionSort;
import sortables.MergeSort;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author danilo this project is to measure the performance of the ordering of
 * vectors and lists
 */
public class DataOrdering {

    public static void main(String[] args) {
        int[] sizes = {4};
        int vectorsNumber = 4;

        for (int size : sizes) {
            sortLists(size, vectorsNumber);
        }
    }

    public static void sortLists(int listSize, int vectorsNumber) {
        int[] array = new int[listSize];
        DynamicList listSortable = new DynamicList();
        ArrayList<Sort> algorithms = new ArrayList<>();

        algorithms.add(new BubbleSort(array));
        algorithms.add(new InsertionSort(array));
        algorithms.add(new SelectionSort(array));
        algorithms.add(new MergeSort(array));

        System.out.println("\n-----------------------------------------\n"
                + "List size: " + listSize
                + "\nNumber of arrays: " + vectorsNumber + "\n-----------------------------------------\n");
        for (Sort sortable : algorithms) {
            sortSingleList(sortable, listSortable, vectorsNumber);
        }
    }

    public static void sortSingleList(Sort sortable, DynamicList list, int vectorsNumber) {
        long averageComparisons = 0;
        System.out.println("****** " + sortable.getClass().getSimpleName() + " ******");
        System.out.println("LISTA é vazia: " + list.isEmpty());
        for (int i = 0; i < vectorsNumber; i++) {
            System.out.println("ARRAY:" + (i + 1));
            sortable.comparisonsNumber = 0;
            randomize(sortable.array, list);
            System.out.println("LISTA BEFORE: " + list.imprimir());
            sortable.sortAndPrint();
//            sortable.sortAndRuntime(i + 1);
            averageComparisons += sortable.comparisonsNumber;

            for (int j = 0; j < sortable.array.length; j++) {
               list.remove(0);
            }
            
            System.out.println("LISTA AFTER: " + list.imprimir());
        }

        averageComparisons = averageComparisons / vectorsNumber;
        System.out.print("Average Comparisons: " + averageComparisons);
        System.out.println("\n-----------------------------------------");
        System.out.println();
    }

    public static void randomize(int[] v, DynamicList list) {
        Random random = new Random();
        for (int i = 0; i < v.length; i++) {
            v[i] = random.nextInt(11);
            list.add(v[i]);
        }
    }

}
