package A11_20.A15_ThreeSum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GYC
 * 2020/6/22 15:00
 *  如果list的元素是Integer，那么List的hashcode相同意味着List中的元素相同
 */
public class hashCodeTest {
    public static void main(String[] args) {
        List<Integer> aList = new ArrayList<>();
        aList.add(1);
        aList.add(2);
        aList.add(3);

        System.out.println(aList.hashCode());

        List<Integer> bList = new ArrayList<>();
        bList.add(1);
        bList.add(2);
        bList.add(3);

        System.out.println(bList.hashCode());

        Integer a = 2;
        System.out.println(a.hashCode());
    }
}
