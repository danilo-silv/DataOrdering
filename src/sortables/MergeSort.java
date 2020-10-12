package sortables;

import util.Sort;

public class MergeSort extends Sort{
     int[] tempArray;

    public MergeSort(int[] array){
        super(array);
        tempArray = new int[array.length];
    }

    @Override
    public void sort(){
        mergeSort(0, array.length-1);
    }

    private void mergeSort(int initialIndex, int finalIndex){
        if(initialIndex < finalIndex){
            int arrayMiddle = (initialIndex + finalIndex) / 2;
            mergeSort(initialIndex, arrayMiddle);
            mergeSort(arrayMiddle + 1, finalIndex);
            interpolate(array, initialIndex, arrayMiddle, finalIndex);
        }
    }

    private void interpolate(int[] vector, int initialIndex, int arrayMiddle, int finalIndex){
        int i;
        int j;
        for(i = initialIndex; i <= arrayMiddle; i++){
            tempArray[i] = vector[i];
        }
        for(j = arrayMiddle + 1; j <= finalIndex; j++){
            tempArray[finalIndex+arrayMiddle+1-j] = vector[j];
        }

        i = initialIndex;
        j = finalIndex;

        for(int k = initialIndex; k <= finalIndex; k++){
            comparisonsNumber++;
            if(tempArray[i] <= tempArray[j]){
                vector[k] = tempArray[i];
                i++;
            }else{
                vector[k] = tempArray[j];
                j--;
            }
        }
    }

    @Override
    public void sortAndPrint(){
        System.out.println(getClass().getSimpleName());
        super.sortAndPrint();
    } 
}
