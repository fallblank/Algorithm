/**
 * Created by fallb on 2016/3/5.
 * 这是之上而下的归并排序算法
 */
public class MergeSort extends Sort {

    protected Comparable[] helperArray;

    protected MergeSort(Comparable[] array) {
        super(array);
    }

    @Override
    public void sort() {
        helperArray = new Comparable[array.length];
        sort(0, array.length - 1);
    }

    public void sort(int lo, int hi) {
        if (lo >= hi) return;
        int mid = (lo + hi) / 2;
        sort(lo, mid);
        sort(mid + 1, hi);
        merge(lo, mid, hi);
    }

    protected void merge(int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            helperArray[i] = array[i];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                array[k] = helperArray[j++];
            } else if (j > hi) {
                array[k] = helperArray[i++];
            } else if (less(helperArray[i], helperArray[j])) {
                array[k] = helperArray[j++];
            } else {
                array[k] = helperArray[i++];
            }
        }
    }

    @Override
    public boolean less(Comparable front, Comparable last) {
        return front.compareTo(last) > 0;
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{6, 5, 1, 3, 4, 2};
        MergeSort mergeSort = new MergeSort(array);
        mergeSort.sort();
        mergeSort.show();
    }
}
