package test;

import com.cl.test.model.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author chen lian
 * @date 2021年12月06日 9:46
 */
public class TestIterator {

    public static void main(String[] args) {
        List<Student> detials = new ArrayList<>();
        detials.add(null);

        Iterator<Student> iterator = detials.iterator();
        while(iterator.hasNext()) {
            Student curr = iterator.next();


            //合并之后，删除当前对象
            //iterator.remove(curr);
            //iterator.remove();
            detials.remove(curr);
        }
    }

}
