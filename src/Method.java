import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Method {

    public int[] removeElement(int[] arr, int index) {

        int[] copy = new int[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i != index) {
                copy[j++] = arr[i];
            }
        }
        return copy;
    }

    public static void removeElement2(int[] arr, int index) {
        int[] arrDestination = new int[arr.length - 1];
        int remainingElement = arr.length - (index + 1);
        System.arraycopy(arr, 0, arrDestination, 0, index);
        System.arraycopy(arr, index + 1, arrDestination, index, remainingElement);
        System.out.println("Элемент-" + Arrays.toString(arrDestination));
    }

    public static void removeElement3(int[]arr, int index) {
        System.arraycopy(arr, index + 1, arr, index, arr.length - index - 1);
        System.out.println("Элементы-" + Arrays.toString(arr)); // эта фигня добавляет лишний последний элемент,хз
    }

    public static void removeElement4(int[] arr, int index) {
        List<Integer> arrayList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        arrayList.remove(index);
        System.out.println(arrayList);
    }

    public static void removeElement5(int[]arr,int index){
        List<Integer> arrayList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        List<Integer> list = arrayList.stream().filter(v -> v != index).collect(Collectors.toList());
        System.out.println(list);
    }
    public static void main(String[] args) {
        Method test=new Method();
        int[] element = test.removeElement(new int[]{1, 5, 3, 7, 3, 4, 8}, 3);
        System.out.println(Arrays.toString(element));
        removeElement2(new int[]{12, 4, 2, 6, 7, 2, 4}, 2);
        removeElement3(new int[]{1, 5, 3, 7, 9, 2, 5}, 2);
        removeElement4(new int[]{2, 5, 7, 10, 8, 2}, 3);
        removeElement5(new int[]{4, 6, 7, 3, 4, 5, 4}, 4);
    }
}
