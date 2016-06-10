package com.example.tj.tagfragment.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample rightTaste for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {


    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();



    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {
//        // Add some sample items.
//        for (int i = 1; i <= dummyItems.length; i++) {
//            addItem(createDummyItem(i));
//        }
        ITEMS.add(new DummyItem("순함","매움",0));
        ITEMS.add(new DummyItem("싱겁","짭짤",0));
        ITEMS.add(new DummyItem("당조절","당땡김",0));
        ITEMS.add(new DummyItem("무자극","상큼",0));
        ITEMS.add(new DummyItem("부드럼","바삭",0));
        ITEMS.add(new DummyItem("국물x","국물o",0));
        ITEMS.add(new DummyItem("담백","기름기",0));

    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.leftTaste, item);
    }





    /**
     * A dummy item representing a piece of rightTaste.
     */
    public static class DummyItem {
        public final String leftTaste;
        public final String rightTaste;
        public final int degree;

        public DummyItem(String leftTaste, String rightTaste, int degree) {
            this.leftTaste = leftTaste;
            this.rightTaste = rightTaste;
            this.degree = degree;
        }


    }
}
