import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PriorityQueueTest {
    private static Stream<Arguments> getParams() {
        return Stream.of(
                Arguments.of(new int[]{4, 3, 2, 1}, new int[]{1, 2, 3, 5}),
                Arguments.of(new int[]{8, 6, 7, 5}, new int[]{5, 6, 7, 8}),
                Arguments.of(new int[]{9, 0, 1, 2}, new int[]{0, 1, 2, 9}),
                Arguments.of(new int[]{7, 3, 8, 1}, new int[]{1, 3, 7, 8}),
                Arguments.of(new int[]{3, 2, 5, 4}, new int[]{2, 3, 4, 5}));
    }

    @ParameterizedTest
    @MethodSource("getParams")
    public void parameterizedTest(int[] input, int[] expected) {

        PriorityQueue inputQueue = new PriorityQueue();
        for(int element: input)
            inputQueue.add(element);
        for(int element: expected)
            assertEquals(element, inputQueue.poll());
    }

    @Test
    public void initCapacityTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, ()->{
            PriorityQueue queue = new PriorityQueue(-1);
        });
    }

    @Test
    public void addInvalidDataTypeTest() {
        Exception exception = assertThrows(ClassCastException.class, ()->{
            PriorityQueue queue = new PriorityQueue();
            queue.add(1);
            queue.add("hello");
        });
    }

    @Test
    public void addNullTest() {
        Exception exception = assertThrows(NullPointerException.class, ()->{
            PriorityQueue queue = new PriorityQueue();
            queue.add(null);
        });
    }
}
