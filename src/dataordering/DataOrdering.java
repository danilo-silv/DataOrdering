package dataordering;

/**
 *
 * @author danilo
 * this project is to measure the performance of the ordering of vectors and lists
 */
public class DataOrdering {

    public static void main(String[] args) {
          DynamicList DynamicList = new DynamicList();
        
        DynamicList.add(5, 0);
        DynamicList.add(6, 1);
        DynamicList.add(7, 2);
        DynamicList.add(8, 3);
        DynamicList.add(9, 4);
        
        System.out.println(DynamicList.imprimir());
        
        DynamicList.add(15, 2);
        
        System.out.println(DynamicList.imprimir());
        
        System.out.println("Existe o número 9: " + DynamicList.exist(9));
        
        System.out.println("A lista está vazia: " + DynamicList.isEmpty());
        
        DynamicList.set(1, 1); 
        
        System.out.println(DynamicList.imprimir());
    }
    
}
