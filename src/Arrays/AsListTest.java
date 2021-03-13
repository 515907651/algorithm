package Arrays;

import java.util.Arrays;
import java.util.List;

public class AsListTest {
    //asList转数组为list的使用
    public static void main(String[] args) {
        String[] strings = {"good","bad"};
        List<String> list = Arrays.asList(strings);
        list.add("dasdas");
        System.out.println(list);
    }
}
