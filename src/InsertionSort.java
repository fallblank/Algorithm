/**
 * Created by fallb on 2016/3/3.
 */
public class InsertionSort extends Sort {

    protected InsertionSort(Comparable[] array) {
        super(array);
    }

    @Override
    public void sort() {
        int length = array.length;
        for (int i = 1;i<length;i++){
            for (int j=i;j>0;j--){
                if (less(array[j-1],array[j])) exch(j-1,j);
                else break;
            }
        }

    }

    @Override
    public boolean less(Comparable front, Comparable last) {
        return front.compareTo(last)>0;
    }

    public static void main(String args[]){
        Integer[] array = {8,9,5,1,7,3};
        InsertionSort insertionSort = new InsertionSort(array);
        insertionSort.sort();
        insertionSort.show();

    }
}
