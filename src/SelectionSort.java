/**
 * Created by fallb on 2016/3/3.
 */
public class SelectionSort extends Sort {
    protected SelectionSort(Comparable[] array) {
        super(array);
    }

    @Override
    public void sort() {
        int smallIndex = 0;
        int arrayLength = array.length;
        for (int i = 0; i < arrayLength; i++) {
            smallIndex =i;
            for (int j = i + 1; j < arrayLength; j++) {
                if (less(array[smallIndex], array[j])) {
                    smallIndex = j;
                }
            }
            exch(i,smallIndex);
        }

    }

    @Override
    public boolean less(Comparable front, Comparable last) {
        return front.compareTo(last) < 0;
    }

    public static void main(String[] args){
        Integer[] array = {8, 9, 5, 1, 7, 3};
        SelectionSort selectionSort = new SelectionSort(array);
        selectionSort.sort();
        selectionSort.show();
    }
}
