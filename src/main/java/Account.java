import org.apache.commons.lang3.StringUtils;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        int spaceCount = StringUtils.countMatches(name, " ");
        return name.length() >= 3 && name.length() <= 19 && spaceCount == 1 && !(name.startsWith(" ") | name.endsWith(" "));

    }

    }