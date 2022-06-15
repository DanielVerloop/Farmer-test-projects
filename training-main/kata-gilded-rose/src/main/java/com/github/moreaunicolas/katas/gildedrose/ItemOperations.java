package com.github.moreaunicolas.katas.gildedrose;

enum ItemOperations {
    ;

    static void decreaseSellIn(Item item) {
        item.sellIn -= 1;
    }

    static boolean isAfterSellInDate(Item item) {
        return item.sellIn < 0;
    }

    static void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }
    }

    static void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality -= 1;
        }
    }
}
