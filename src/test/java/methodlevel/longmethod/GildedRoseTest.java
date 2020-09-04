package methodlevel.longmethod;

import methodlevel.Item;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

    private Item[] items;
    private GildedRose app;


    @BeforeEach
    public void setup() {
        items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };

        app = new GildedRose(items);
    }

    @AfterEach
    public void teardown() {
        this.items = null;
        this.app = null;
    }


    public void test(Item expected, Item actual) {
        assertEquals(expected.name, actual.name);
        assertEquals(expected.sellIn, actual.sellIn);
        assertEquals(expected.quality, actual.quality);
    }

    public void testAll(Item[] expected, Item[] actual) {
        for(int i = 0; i < expected.length; i++) {
            test(expected[i], actual[i]);
        }
    }

    public void updateQuality(int days) {
        for (int i = 0; i< days; i++) {
            app.updateQuality();
        }
    }

    @DisplayName("========== day 0 ===============")
    @Test
    public void day0() {
        updateQuality(0);
        Item[] expected = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("Conjured Mana Cake", 3, 6) };
        testAll(expected, items);
    }

    @DisplayName("========== day 1 ===============")
    @Test
    public void day1() {
        final int days = 1;
        updateQuality(days);
        Item[] expected = new Item[] {
                new Item("+5 Dexterity Vest", 9, 19),
                new Item("Aged Brie", 1, 1),
                new Item("Elixir of the Mongoose", 4, 6),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 14, 21),
                new Item("Backstage passes to a TAFKAL80ETC concert", 9, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", 4, 50),
                new Item("Conjured Mana Cake", 2, 5) };
        testAll(expected, items);
    }

    @DisplayName("========== day 2 ===============")
    @Test
    public void day2() {
        final int days = 2;
        updateQuality(days);
        Item[] expected = new Item[] {
                new Item("+5 Dexterity Vest", 8, 18),
                new Item("Aged Brie", 0, 2),
                new Item("Elixir of the Mongoose", 3, 5),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 13, 22),
                new Item("Backstage passes to a TAFKAL80ETC concert", 8, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", 3, 50),
                new Item("Conjured Mana Cake", 1, 4) };
        testAll(expected, items);
    }

    @DisplayName("========== day 3 ===============")
    @Test
    public void day3() {
        final int days = 3;
        updateQuality(days);
        Item[] expected = new Item[] {
                new Item("+5 Dexterity Vest", 7, 17),
                new Item("Aged Brie", -1, 4),
                new Item("Elixir of the Mongoose", 2, 4),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 12, 23),
                new Item("Backstage passes to a TAFKAL80ETC concert", 7, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", 2, 50),
                new Item("Conjured Mana Cake", 0, 3) };
        testAll(expected, items);
    }

    @DisplayName("========== day 4 ===============")
    @Test
    public void day4() {
        final int days = 4;
        updateQuality(days);
        Item[] expected = new Item[] {
                new Item("+5 Dexterity Vest", 6, 16),
                new Item("Aged Brie", -2, 6),
                new Item("Elixir of the Mongoose", 1, 3),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 11, 24),
                new Item("Backstage passes to a TAFKAL80ETC concert", 6, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", 1, 50),
                new Item("Conjured Mana Cake", -1, 1) };
        testAll(expected, items);
    }

    @DisplayName("========== day 5 ===============")
    @Test
    public void day5() {
        final int days = 5;
        updateQuality(days);
        Item[] expected = new Item[] {
                new Item("+5 Dexterity Vest", 5, 15),
                new Item("Aged Brie", -3, 8),
                new Item("Elixir of the Mongoose", 0, 2),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 25),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50),
                new Item("Conjured Mana Cake", -2, 0) };
        testAll(expected, items);
    }

    @DisplayName("========== day 6 ===============")
    @Test
    public void day6() {
        final int days = 6;
        updateQuality(days);
        Item[] expected = new Item[] {
                new Item("+5 Dexterity Vest", 4, 14),
                new Item("Aged Brie", -4, 10),
                new Item("Elixir of the Mongoose", -1, 0),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 9, 27),
                new Item("Backstage passes to a TAFKAL80ETC concert", 4, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0),
                new Item("Conjured Mana Cake", -3, 0) };
        testAll(expected, items);
    }

    @DisplayName("========== day 7 ===============")
    @Test
    public void day7() {
        final int days = 7;
        updateQuality(days);
        Item[] expected = new Item[] {
                new Item("+5 Dexterity Vest", 3, 13),
                new Item("Aged Brie", -5, 12),
                new Item("Elixir of the Mongoose", -2, 0),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 8, 29),
                new Item("Backstage passes to a TAFKAL80ETC concert", 3, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", -2, 0),
                new Item("Conjured Mana Cake", -4, 0) };
        testAll(expected, items);
    }

    @DisplayName("========== day 8 ===============")
    @Test
    public void day8() {
        final int days = 8;
        updateQuality(days);
        Item[] expected = new Item[] {
                new Item("+5 Dexterity Vest", 2, 12),
                new Item("Aged Brie", -6, 14),
                new Item("Elixir of the Mongoose", -3, 0),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 7, 31),
                new Item("Backstage passes to a TAFKAL80ETC concert", 2, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", -3, 0),
                new Item("Conjured Mana Cake", -5, 0) };
        testAll(expected, items);
    }

    @DisplayName("========== day 9 ===============")
    @Test
    public void day9() {
        final int days = 9;
        updateQuality(days);
        Item[] expected = new Item[] {
                new Item("+5 Dexterity Vest", 1, 11),
                new Item("Aged Brie", -7, 16),
                new Item("Elixir of the Mongoose", -4, 0),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 6, 33),
                new Item("Backstage passes to a TAFKAL80ETC concert", 1, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", -4, 0),
                new Item("Conjured Mana Cake", -6, 0) };
        testAll(expected, items);
    }

    @DisplayName("========== day 10 ===============")
    @Test
    public void day10() {
        final int days = 10;
        updateQuality(days);
        Item[] expected = new Item[] {
                new Item("+5 Dexterity Vest", 0, 10),
                new Item("Aged Brie", -8, 18),
                new Item("Elixir of the Mongoose", -5, 0),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 35),
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", -5, 0),
                new Item("Conjured Mana Cake", -7, 0) };
        testAll(expected, items);
    }

    @DisplayName("========== day 11 ===============")
    @Test
    public void day11() {
        final int days = 11;
        updateQuality(days);
        Item[] expected = new Item[] {
                new Item("+5 Dexterity Vest", -1, 8),
                new Item("Aged Brie", -9, 20),
                new Item("Elixir of the Mongoose", -6, 0),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 4, 38),
                new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0),
                new Item("Backstage passes to a TAFKAL80ETC concert", -6, 0),
                new Item("Conjured Mana Cake", -8, 0) };
        testAll(expected, items);
    }

}