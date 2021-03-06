package com.vkadam.moneymanager.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyAccountContent {
    
    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();
    
    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();
    
    static {
        // Add 3 sample items.
        addItem(new DummyItem("1", "Account 1"));
        addItem(new DummyItem("2", "Account 2"));
        addItem(new DummyItem("3", "Account 3"));
    }
    
    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }
    
    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public String id;
        public String name;
        
        public DummyItem(String id, String content) {
            this.id = id;
            this.name = content;
        }
        
        @Override
        public String toString() {
            return name;
        }
    }
}
