/**
 * Created by fallb on 2016/3/7.
 */
public class MergeSortUp extends MergeSort {


    protected MergeSortUp(Comparable[] array) {
        super(array);
    }

    @Override
    public void sort() {
        int length = array.length;
        helperArray = new Comparable[length];
        for (int dist = 1; dist < length; dist *= 2) {
            for (int lo = 0; lo < length - dist; lo += 2 * dist) {
                merge(lo, lo + dist - 1, Math.min(lo + dist + dist - 1, length - 1));
            }
        }
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{6, 5, 1, 3, 4, 2};
        MergeSortUp sort = new MergeSortUp(array);
        sort.sort();
        sort.show();
    }


}
