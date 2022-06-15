package com.github.moreaunicolas.katas.gildedrose;

import static com.github.moreaunicolas.katas.gildedrose.ItemOperations.increaseQuality;

class BackstagePassUpdatePolicy extends DefaultUpdatePolicy {

    @Override
    void updateQuality(Item item) {
        increaseQuality(item);
        if (item.sellIn < 10) {
            increaseQuality(item);
        }
        if (item.sellIn < 5) {
            increaseQuality(item);
        }
    }

    @Override
    void updateQualityAfterSellInDate(Item item) {
        item.quality = 0;
    }
}
