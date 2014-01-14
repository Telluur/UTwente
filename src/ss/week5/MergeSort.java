package ss.week5;

import java.util.LinkedList;
import java.util.List;

public class MergeSort {

    public static void main(String args[]) {
        LinkedList<String> list = new LinkedList<String>();
        list.add("z");
        list.add("c");
        list.add("d");
        list.add("b");
        list.add("f");
        list.add("g");
        list.add("e");
        list.add("l");
        list.add("k");
        list.add("j");
        list.add("i");
        list.add("h");
        System.out.println(new MergeSort().mergeSort(list));
    }

    public LinkedList<String> mergeSort(List<String> list) {
        int length = list.size();
        LinkedList<String> r = new LinkedList<>();

        //return the list if length is 0 or 1
        if (length <= 1) {
            return new LinkedList<>(list);
        } else {
            int index = (int) length / 2;
            // Implementation with linkedlists is horrible anyway, might as well make sublists & instantiate more things:
            LinkedList<String> s = mergeSort(list.subList(0, index));
            LinkedList<String> f = mergeSort(list.subList(index, length));

            //local variables
            int fi = 0;
            int si = 0;

            while (fi < f.size() && si < s.size()) {
                if (f.get(fi).compareTo(s.get(si)) < 0) {
                    r.add(f.get(fi));
                    fi++;
                } else {
                    r.add(s.get(si));
                    si++;
                }
            }

            if (fi < f.size()) {
                r.addAll(f.subList(fi, f.size()));
            } else if (si < s.size()) {
                r.addAll(s.subList(si, s.size()));
            }
        }
        return r;
    }
}