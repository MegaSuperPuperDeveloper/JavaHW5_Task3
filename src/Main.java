import java.util.Arrays;

class HeapSort {
    public static void buildTree(int[] tree, int sortLength) {
        // Строим кучу из заданного массива
        for (int i = sortLength / 2 - 1; i >= 0; i--) {
            heapify(tree, sortLength, i);
        }
    }

    public static void heapify(int[] tree, int sortLength, int rootIndex) {
        int largest = rootIndex; // Инициализируем наибольший элемент как корень
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        // Если левый дочерний элемент больше корня
        if (leftChild < sortLength && tree[leftChild] > tree[largest]) {
            largest = leftChild;
        }

        // Если правый дочерний элемент больше корня
        if (rightChild < sortLength && tree[rightChild] > tree[largest]) {
            largest = rightChild;
        }

        // Если наибольший элемент не корень
        if (largest != rootIndex) {
            // Меняем местами корень и наибольший элемент
            int temp = tree[rootIndex];
            tree[rootIndex] = tree[largest];
            tree[largest] = temp;

            // Рекурсивно применяем heapify к поддереву
            heapify(tree, sortLength, largest);
        }
    }

    public static void heapSort(int[] sortArray, int sortLength) {
        // Построение кучи (перегруппировка массива)
        buildTree(sortArray, sortLength);

        // Один за другим извлекаем элементы из кучи
        for (int i = sortLength - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = sortArray[0];
            sortArray[0] = sortArray[i];
            sortArray[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(sortArray, i, 0);
        }
    }
}

// Не удаляйте и не меняйте метод Main!
public class Main {
    public static void main(String[] args) {
        int[] initArray;

        if (args.length == 0) {
            initArray = new int[]{17, 32, 1, 4, 25, 17, 0, 3, 10, 7, 64, 1};
        } else {
            initArray = Arrays.stream(args[0].split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println("Initial array:");
        System.out.println(Arrays.toString(initArray));
        HeapSort.heapSort(initArray, initArray.length);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(initArray));
    }
}