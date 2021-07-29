package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private static final Integer[] ELEMENTS = new Integer[]{4, 6, 19, 32, 5};
    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(ELEMENTS);
    }

    @Test
    public void when_correctElementsArePassed_then_createDatabaseInstance() throws OperationNotSupportedException {
        // arrange
        //Integer[] elements = new Integer[]{4, 6, 19, 32, 5};
        // act
        //Database database = new Database(elements);
        // assert
        Assert.assertEquals(ELEMENTS.length, database.getElements().length);
        Assert.assertArrayEquals(ELEMENTS, database.getElements());

    }

    @Test(expected = OperationNotSupportedException.class)
    public void when_elementsMoreThan16PassedToConstructor_then_exceptionThrown() throws OperationNotSupportedException {
        new Database(new Integer[17]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void when_elementsLessPassedToConstructor_then_exceptionIsThrown() throws OperationNotSupportedException {
        new Database();
    }

    @Test
    public void when_validElementsPassToAdd_then_elementIsAddedOnLastPosition() throws OperationNotSupportedException {

        int element = 15;
        database.add(element);
        Integer element1 = database.getElements()[database.getElements().length - 1];

        Assert.assertEquals(ELEMENTS.length + 1, database.getElements().length);
        Assert.assertEquals(Integer.valueOf(element), element1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void when_invalidElementPassedToAdd_then_exceptionIsThrown() throws OperationNotSupportedException {

        database.add(null);

    }

    @Test
    public void when_remove_then_lastElementIsRemoved() throws OperationNotSupportedException {

        database.remove();
        Integer[] elements1 = database.getElements();

        Assert.assertEquals(ELEMENTS.length - 1, elements1.length);
        Assert.assertEquals(ELEMENTS[ELEMENTS.length - 2], elements1[elements1.length - 1]);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void when_elementsIsEmptyAndRemove_then_exceptionIsThrown() throws OperationNotSupportedException {
        database = new Database(new Integer[1]);
        database.remove();
        database.remove();
    }

}