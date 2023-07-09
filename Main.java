public class Main {
    public static void main(String[] args){
        // Создание объектов MyArrayList и MyLinkedList
        MyList<Integer> myArrayList = new MyArrayList<>();
        MyList<Integer> myLinkedList = new MyLinkedList<>();

        // Добавление элементов в MyArrayList
        myArrayList.add(5);
        myArrayList.add(2);
        myArrayList.add(8);
        myArrayList.add(1);
        myArrayList.add(4);

        // Добавление элементов в MyLinkedList
        myLinkedList.add(5);
        myLinkedList.add(2);
        myLinkedList.add(8);
        myLinkedList.add(1);
        myLinkedList.add(4);

        // Вывод исходных списков
        System.out.println("Исходный MyArrayList: " + myArrayList);
        System.out.println("Исходный MyLinkedList: " + myLinkedList);

        // Сортировка списков
        myArrayList.sort();
        myLinkedList.sort();

        // Вывод отсортированных списков
        System.out.println("Отсортированный MyArrayList: " + myArrayList);
        System.out.println("Отсортированный MyLinkedList: " + myLinkedList);
    }
    }
}
