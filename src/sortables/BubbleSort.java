package sortables;

import util.Sort;

public class BubbleSort extends Sort{
    
    public BubbleSort(int[] array) {
        super(array);
    }

    @Override
    public void sort(){
        int size = array.length;
        boolean inverted;
        do{
            inverted = false;
            for(int i = 1; i < size; i++){
                comparisonsNumber++;
                if(array[i - 1] > array[i]){
                    invertItems(i-1, i);
                    inverted = true;
                }
            }
        }while(inverted);
    }

    @Override
    public void sortAndPrint() {
        System.out.println(getClass().getSimpleName());
        super.sortAndPrint();
    }
}
