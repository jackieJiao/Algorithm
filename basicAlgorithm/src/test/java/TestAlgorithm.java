public class TestAlgorithm {

    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 50};
        quickSort(a);

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }


    // 插入排序
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];

            int j = i - 1;
            while (j >= 0 && arr[j] > insertValue) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = insertValue;

//            for (int j = i - 1; j >= 0; j--) {
//                if (arr[j] > insertValue) {
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }

        }
    }

    // 选择排序
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

            int min = arr[i];
            int posite = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    posite = j;
                }
            }

            arr[posite] = arr[i];
            arr[i] = min;
        }
    }

    // 冒泡排序
    public static void bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int i1 = 0; i1 < arr.length - i; i1++) {

                if (arr[i1] > arr[i1 + 1]) {
                    int temp = arr[i1];
                    arr[i1] = arr[i1 + 1];
                    arr[i1 + 1] = temp;
                }
            }
        }
    }

    // 快速排序
    public static void quickSort(int[] arr) {
        int middle = quick_sort(arr, 0, arr.length - 1);
        quick_sort(arr, 0, middle - 1);
        quick_sort(arr, middle + 1, arr.length - 1);
    }

    private static int quick_sort(int[] arr, int low, int high) {

        int temp = arr[low];
        while (low < high) {
            while (low < high && arr[high] < temp) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] > temp) {
                low++;
            }
            arr[high] = arr[low];
        }

        arr[low] = temp;

        return low;
    }
}
