package sortables;

import util.Sort;

/**
 *
 * @author danilo
 */
public class SelectionSort extends Sort{
     public SelectionSort(int[] array) {
        super(array);
    }

    @Override
    public void sort() {
        int size = array.length;
        int minimum;

        for(int i = 0; i < size -1; i++){
            minimum = i;
            for(int j = i + 1; j < size; j++){
                comparisonsNumber++;
                if(array[j] < array[minimum]){
                    minimum = j;
                }
            }
            invertItems(i, minimum);
        }
    }

    @Override
    public void sortAndPrint(){
        System.out.println(getClass().getSimpleName());
        super.sortAndPrint();
    }
}
