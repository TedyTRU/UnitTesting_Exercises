package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private static final Person[] PEOPLE = new Person[]{
            new Person(1, "A"),
            new Person(2, "B"),
            new Person(3, "C"),
    };
    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }

    @Test
    public void when_correctElementsArePassed_then_createDatabaseInstance() throws OperationNotSupportedException {

        Assert.assertEquals(PEOPLE.length, database.getElements().length);
        Assert.assertArrayEquals(PEOPLE, database.getElements());

    }

    @Test(expected = OperationNotSupportedException.class)
    public void when_elementsMoreThan16PassedToConstructor_then_exceptionThrown() throws OperationNotSupportedException {
        new Database(new Person[17]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void when_elementsLessPassedToConstructor_then_exceptionIsThrown() throws OperationNotSupportedException {
        new Database();
    }

    @Test
    public void when_validElementsPassToAdd_then_elementIsAddedOnLastPosition() throws OperationNotSupportedException {

        Person expectedPerson = new Person(4, "D");
        database.add(expectedPerson);
        Person actualPerson = database.getElements()[database.getElements().length - 1];

        Assert.assertEquals(PEOPLE.length + 1, database.getElements().length);
        Assert.assertEquals(expectedPerson.getId(), actualPerson.getId());
        Assert.assertEquals(expectedPerson.getUsername(), actualPerson.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void when_invalidElementPassedToAdd_then_exceptionIsThrown() throws OperationNotSupportedException {

        database.add(null);

    }

    @Test
    public void when_remove_then_lastElementIsRemoved() throws OperationNotSupportedException {

        database.remove();
        Person[] actualPeople = database.getElements();
        Person expectedPerson = PEOPLE[PEOPLE.length - 2];
        Person actualPerson = actualPeople[database.getElements().length - 1];

        Assert.assertEquals(PEOPLE.length - 1, actualPeople.length);
        Assert.assertEquals(actualPerson.getId(), expectedPerson.getId());
        Assert.assertEquals(actualPerson.getUsername(), expectedPerson.getUsername());

    }

    @Test(expected = OperationNotSupportedException.class)
    public void when_elementsIsEmptyAndRemove_then_exceptionIsThrown() throws OperationNotSupportedException {
        database = new Database(new Person(5, "E"));
        database.remove();
        database.remove();
    }


}