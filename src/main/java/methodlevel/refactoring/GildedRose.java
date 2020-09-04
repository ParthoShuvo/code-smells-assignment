package methodlevel.refactoring;

import methodlevel.Item;

import java.util.Arrays;
import java.util.List;

public class GildedRose {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if(!item.name.equals(SULFURAS)) {
                if (isNormalItem(item)) {
                    decreaseQuality(item);
                } else {
                    updateQualityForOlderItem(item);
                }

                decreaseSellInDays(item);

                if (isSellInDaysExpired(item)) {
                    updateQualityForExpiredItem(item);
                }
            }

        }
    }

    private boolean isNormalItem(Item item) {
        final List<String> SPECIAL_ITEMS = Arrays.asList(AGED_BRIE, BACKSTAGE_PASSES);
        return !SPECIAL_ITEMS.contains(item.name);
    }

    private void decreaseSellInDays(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private boolean isSellInDaysExpired(Item item) {
        return item.sellIn < 0;
    }

    private void updateQualityForExpiredItem(Item item) {
        if (isNormalItem(item)) {
            decreaseQuality(item);
        }
        if(item.name.equals(AGED_BRIE)) {
            increaseQuality(item);
            return;
        }
        if (item.name.equals(BACKSTAGE_PASSES)) {
            setQualityDropToZero(item);
        }
    }

    private void setQualityDropToZero(Item item) {
        item.quality = 0;
    }

    private void updateQualityForOlderItem(Item oldItem) {
        increaseQuality(oldItem);
        if (!oldItem.name.equals(BACKSTAGE_PASSES)) {
            return;
        }
        if (oldItem.sellIn < 11) {
            increaseQuality(oldItem);
        }
        if (oldItem.sellIn < 6) {
            increaseQuality(oldItem);
        }
    }

    private void increaseQuality(Item item) {
        if (item.name.equals(SULFURAS)) {
            return;
        }
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.name.equals(SULFURAS)) {
            return;
        }
        if (item.quality > 0) {
            item.quality--;
        }
    }
}
