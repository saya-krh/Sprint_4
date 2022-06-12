import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountSpacePositionTest {
    private final String name;
    private final boolean expected;

    public AccountSpacePositionTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getNameData() {
        return new Object[][]{
                {" Булка", false},//пробел в начале
                {"Булка ", false},//пробел в конце
                {" Булка ", false},//пробелы и в начале и в конце
                {"Французская Булка", true},//пробел в середине
                {" Французская Булка ", false},//пробелы в начале, в середине и в конце
        };
    }

    @Test
    public void differentSpacePositionTest() {
        Account account = new Account(name);

        assertEquals("Неккоректное расположение пробела в поле 'Имя'", expected, account.checkNameToSpacePosition(name));
    }
}