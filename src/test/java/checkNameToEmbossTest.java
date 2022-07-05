import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class checkNameToEmbossTest{

    private final String name;
    private final boolean expected;

    public checkNameToEmbossTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getNameTest() {
        return new Object[][]{
                {"Французскаябулка", false},//0 пробелов
                {"Французская Булка", true},//1 пробел
                {"Вкусная французская булка", false},//2 пробела
                {" Булка", false},//пробел в начале
                {"Булка ", false},//пробел в конце
                {" Булка ", false},//пробелы и в начале и в конце
                {"Французская Булка", true},//пробел в середине
                {" Французская Булка ", false},//пробелы в начале, в середине и в конце
                {"Бу", false},//2 символа
                {"Б л", true},//3 символа
                {"Французская Булкааа", true},//19 символа
                {"Французская Булкаааа", false},//20 символа
        };
    }

    @Test
    public void shouldCheckNameToRequirements() {
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();

        assertEquals("Чтото сломала", expected, actual);
    }
}
