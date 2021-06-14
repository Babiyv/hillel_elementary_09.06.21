package lesson2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List arrayList = new ArrayList<>();
        System.out.println(arrayList.isEmpty());
        arrayList.add("element");
        arrayList.add("element1");
        System.out.println(arrayList.isEmpty());
        System.out.println(arrayList.size());
        System.out.println(arrayList.contains("element"));
        System.out.println(arrayList.remove("element"));
        System.out.println(arrayList.size());
        System.out.println(arrayList);


        List linkedList = new LinkedList();
        System.out.println(linkedList.isEmpty());
        linkedList.add("element");
        linkedList.add("element");
        System.out.println(linkedList.isEmpty());
        System.out.println(linkedList.size());
        System.out.println(linkedList.contains("element"));
        System.out.println(linkedList.remove("element"));
        System.out.println(linkedList.size());
        System.out.println(linkedList);


        Set set = new HashSet();
        System.out.println(set);
        set.addAll(linkedList); // - почистит дублирующие значения из линкедЛиста (оставит только уникальные значения);
        System.out.println(set);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(set);


        Map map = new HashMap();
        map.put("key", "value1");
        map.put(1, "value2");

        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println(map.get(1));
        System.out.println(map.get("key"));
        System.out.println(map.remove("key")); // - возвращает значения которое мы удалили по ключу;
        System.out.println(map.remove(1, "value2")); // - возвращает булевское значение после удаления;

    }
}
