package user.domain;

import java.util.HashMap;
import java.util.Map;

public enum ClientType {
    NORMAL("Ordinary client"),
    VIP("Super client");

    private String description;

    private static Map<String, ClientType> stringDescriptionEnumItemMap;

    static {
        stringDescriptionEnumItemMap = new HashMap<>();
        for (ClientType item : ClientType.values()) {
            stringDescriptionEnumItemMap.put(item.name(), item);
        }
    }

    ClientType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
