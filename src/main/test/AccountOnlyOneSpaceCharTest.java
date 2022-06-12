import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountOnlyOneSpaceCharTest {
    private final String name;
    private final boolean expected;

    public AccountOnlyOneSpaceCharTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getNameData() {
        return new Object[][]{
                {"Французскаябулка", false},//0 пробелов
                {"Французская Булка", true},//1 пробелов
                {"Вкусная французская булка", false},//2 пробела
        };
    }

    @Test
    public void differentSpaceCountTest() {
        Account account = new Account(name);

        assertEquals("Неккоректное кол-во пробелов в поле 'Имя'", expected, account.checkNameToOnlyOneSpaceChar(name));
    }
}