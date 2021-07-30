package p03_IteratorTest;

import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {

    @Test(expected = OperationNotSupportedException.class)
    public void when_nullElementsPassedToConstructor_then_exceptionIsThrown() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator(null);
    }

    @Test
    public void when_validElementsPassedToConstructor_then_moveReturnsCorrectBoolean() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator("wood", "river", "gold");
        assertTrue(listIterator.move());
        assertTrue(listIterator.move());
        assertFalse(listIterator.move());

    }

    @Test(expected = IllegalStateException.class)
    public void when_emptyListIterator_then_exceptionIsThrown() throws OperationNotSupportedException {
        new ListIterator().print();
    }

    @Test
    public void when_elementsInListIterator_then_print() throws OperationNotSupportedException {
        String[] elements = new String[]{"wood", "river", "gold"};
        ListIterator listIterator = new ListIterator(elements);
        for (int i = 0; listIterator.hasNext(); listIterator.move(), i++) {
            assertEquals(elements[i], listIterator.print());
        }
    }

}