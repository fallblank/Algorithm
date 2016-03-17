/**
 * Created by fallb on 2016/3/17.
 * 记数排序，排序对象为数字
 * 改排序不具备适用性，当数组中的元素有较大元素时，计数数组会变得特别大
 */
public class CountSort {
    int[] originArray, countArray, resultArray;

    public CountSort(int[] array) {
        originArray = array;
        resultArray = new int[originArray.length];
        int max = 0;
        for (int i : originArray) {
            if (i > max) max = i;
        }
        countArray = new int[max + 1];
    }

    public int[] sort() {
        //初始化计数数组的值为0
        for (int i = 0; i < countArray.length; i++) {
            countArray[i] = 0;
        }
        //计数统计开始
        for (int i = 0; i < originArray.length; i++) {
            countArray[originArray[i]] += 1;
        }
        //计算小于等于相应值的个数
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }
        /**
         * 根据上一步得到的基数结果安排新的位置，记住结果中的小标应是countArray[originArray[i]]-1，
         *因为countArray[originArray[i]]记录的是小于等于originArray[i]的个数，新位置是从0开始的，所以要减一
         *倒序的目的是保证相等元素在新数组中也是安装原数组中的顺序出现，即保证数组排序是stable的
         */
        for (int i = originArray.length - 1; i >= 0; i--) {
            resultArray[countArray[originArray[i]]-1] = originArray[i];
            countArray[originArray[i]] -= 1;
        }
        return resultArray;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 9, 10, 8, 4};
        CountSort countSort = new CountSort(array);
        int[] result = countSort.sort();
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

}
