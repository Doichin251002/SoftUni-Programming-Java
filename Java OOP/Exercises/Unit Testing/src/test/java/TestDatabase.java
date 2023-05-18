import org.junit.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestDatabase {
    private static final int CAPACITY = 16;

    @Test
    public void testDatabaseCtor() throws OperationNotSupportedException {
        Integer[] expectedElements = {10, 11, 12, 13, 14, 15};
        Database database = new Database(expectedElements);

        Integer [] actualElements = database.getElements();

        assertEquals(expectedElements.length, actualElements.length);
        assertArraysEqualTo(expectedElements.length, expectedElements, actualElements);
    }

    @Test
    public void testDatabaseCtorInitializes16Capacity() throws OperationNotSupportedException, NoSuchFieldException, IllegalAccessException {
        Integer[] elements = {10, 11, 12, 13, 14, 15};
        Database database = new Database(elements);

        Field elementsField = Database.class.getDeclaredField("elements");
        elementsField.setAccessible(true);
        Integer [] array = (Integer[]) elementsField.get(database);
        int arraySize = array.length;

        assertEquals(CAPACITY, arraySize);
    }
    
    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseCtorWithMoreThan16Elements() throws OperationNotSupportedException {
        Integer [] bigArray = new Integer[CAPACITY + 1];

        new Database(bigArray);
    }

    @Test
    public void testDatabaseCtorWIthLessThan16Elements() {
        Integer [] smallArray = new Integer[0];

        boolean threw = false;
        try {
            new Database(smallArray);
        } catch (Throwable t) {
            assertEquals(OperationNotSupportedException.class, t.getClass());
            threw = true;
        }

        assertTrue(threw);
    }

    @Test
    public void testAddToDatabase() throws OperationNotSupportedException {
        Integer[] initialElements = {10, 11, 12, 13, 14, 15};
        Database database = new Database(initialElements);

        database.add(16);

        Integer[] actualElements = database.getElements();
        assertEquals(6 + 1, actualElements.length);
        assertArraysEqualTo(5, initialElements, actualElements);
        assertEquals(16, (int)actualElements[initialElements.length]);
    }

    @Test
    public void testAddSingleElementToDatabase() throws OperationNotSupportedException {
        Integer[] initialElement = {10};
        Database database = new Database(initialElement);

        database.add(11);

        Integer[] actualElements = database.getElements();
        assertEquals(1 + 1, actualElements.length);
        assertArraysEqualTo(1, initialElement, actualElements);
        assertEquals(11, (int)actualElements[initialElement.length]);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testAddElementToFullDatabase() throws OperationNotSupportedException {
        Integer[] initialElements = new Integer[16];
        Database database = new Database(initialElements);

        database.add(17);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddNullElementToDatabase() throws OperationNotSupportedException {
        Integer[] initialElements = {10, 11, 12, 13, 14, 15};
        Database database = new Database(initialElements);

        database.add(null);
    }

    @Test
    public void testRemoveToDatabase() throws OperationNotSupportedException {
        Integer[] initialElements = {10, 11, 12, 13, 14, 15};
        Database database = new Database(initialElements);

        database.remove();

        Integer [] actualElements = database.getElements();
        assertEquals(initialElements.length - 1, actualElements.length);
        assertArraysEqualTo(actualElements.length, initialElements, actualElements);
    }

    @Test
    public void testRemoveSingleElementFromDatabase() throws OperationNotSupportedException {
        Integer[] initialElements = {10};
        Database database = new Database(initialElements);

        database.remove();

        Integer [] actualElements = database.getElements();
        assertEquals(0, actualElements.length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveElementFromEmptyDatabase() throws OperationNotSupportedException {
        Database database = new Database();

        database.remove();
    }

    @Test
    public void testGetElements() throws OperationNotSupportedException {
        Integer[] expectedElements = {10, 11, 12, 13, 14, 15};
        Database database = new Database(expectedElements);

        Integer [] actualElements = database.getElements();

        assertEquals(expectedElements.length, actualElements.length);
        assertArraysEqualTo(actualElements.length, expectedElements, actualElements);
    }

    private void assertArraysEqualTo(int length, Integer[] expectedElements, Integer[] actualElements) {
        for (int i = 0; i < length; i++) {
            assertEquals("Mismatch at " + i, expectedElements[i], actualElements[i]);
        }
    }
}
