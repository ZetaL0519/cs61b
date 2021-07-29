import org.junit.Test;
import static org.junit.Assert.*;

public class TestArrayDequeGold {

    @Test
    public void testDeque(){
        StudentArrayDeque<Integer>student = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();
        StringBuilder msg = new StringBuilder();
        int s = 0;

        for (int i = 0; i < 100; i++){
            double random = StdRandom.uniform();
            if(i % 5 == 0){
                msg.append("size()\n");
                assertEquals(msg.toString(), solution.size(), student.size());
            }
            if(random < 0.25){
                student.addFirst(i);
                solution.addFirst(i);
                msg.append("addFirst(" + i +")\n");
                s++;
                assertEquals(msg.toString(), solution.get(0), student.get(0));
            }

            else if(random < 0.5){
                student.addLast(i);
                solution.addLast(i);
                msg.append("addLast(" + i +")\n");
                s++;
                assertEquals(msg.toString(), solution.get(s-1), student.get(s-1));
            }

            else if(random < 0.75){
                if(solution.isEmpty()){
                    assertTrue(student.isEmpty());
                    continue;
                }
                int actual = student.removeFirst();
                int expected = solution.removeFirst();
                msg.append("removeFirst(" + i +")\n");
                s--;
                assertEquals(msg.toString(), actual, expected);

            }

            else {
                if(solution.isEmpty()){
                    assertTrue(student.isEmpty());
                    continue;
                }
                int actual = student.removeLast();
                int expected = solution.removeLast();
                msg.append("removeLast(" + i +")\n");
                s--;
                assertEquals(msg.toString(), actual, expected);

            }
        }


    }
}
