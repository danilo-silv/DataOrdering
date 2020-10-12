package sortables;

import util.Sort;

public class InsertionSort extends Sort{
    
    public InsertionSort(int[] array){
        super(array);
    }

    @Override
    public void sort(){
        int size = array.length;
        int j;
        for(int i = 1; i < size; i++){
            j = i;
            while(j > 0){
                comparisonsNumber++;
                if(array[j - 1] > array[j]){
                    invertItems(j, j - 1);
                    j--;
                }else{
                    j = 0;
                }

            }
        }
    }

    @Override
    public void sortAndPrint(){
        System.out.println(getClass().getSimpleName());
        super.sortAndPrint();
    }
}
