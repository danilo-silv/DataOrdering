package util;

public abstract class Sort {

    public int[] array;
    public long comparisonsNumber = 0;

    public Sort(int[] array) {
        this.array = array;
    }

    public abstract void sort();

    public void invertItems(int p1, int p2) {
        int aux = array[p1];
        array[p1] = array[p2];
        array[p2] = aux;
    }

    public void sortAndRuntime(int idArray) {
        long startOfExecution = System.nanoTime();
        sort();
        long endOfExecution = System.nanoTime();
        System.out.println("Time sort array " + idArray + ": " + (endOfExecution - startOfExecution));
    }

    public void printArray(int[] array, String text) {
        System.out.print(text + " ");
        for (int j : array) {
            System.out.print(j + " ");
        }
    }

    public void sortAndPrint() {
        printArray(array, "Before");
        sort();
        System.out.println();
        printArray(array, "After");
        System.out.println("\nNumber of Comparisons: " + comparisonsNumber);
        System.out.println();
    }
}
