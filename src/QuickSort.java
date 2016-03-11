/**
 * Created by fallb on 2016/3/11.
 */
public class QuickSort extends Sort {
    protected QuickSort(Comparable[] array) {
        super(array);
    }

    @Override
    public void sort() {
        sort(0, array.length - 1);
    }

    private void sort(int lo, int hi) {
        if (lo >= hi) return;
        int j = patition(lo, hi);
        sort(lo, j - 1);
        sort(j + 1, hi);
    }

    private int patition(int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = array[lo];
        while (true) {
            while (less(array[++i],v)) if (i == hi) break;
            while (less(v, array[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(i, j);
        }
        exch(lo,j);
        return j;
    }

    @Override
    public boolean less(Comparable front, Comparable last) {
        return front.compareTo(last) < 0;
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{8, 5, 9, 7, 54, 12};
        QuickSort sort = new QuickSort(array);
        sort.sort();
        sort.show();
    }
}
