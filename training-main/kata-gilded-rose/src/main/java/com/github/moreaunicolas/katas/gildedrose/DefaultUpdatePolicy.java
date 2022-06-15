package com.github.moreaunicolas.katas.gildedrose;

import static com.github.moreaunicolas.katas.gildedrose.ItemOperations.*;

class DefaultUpdatePolicy implements UpdatePolicy {

    @Override
    public final void update(Item item) {
        decreaseSellIn(item);
        updateQuality(item);
        if (isAfterSellInDate(item)) {
            updateQualityAfterSellInDate(item);
        }
    }

    void updateQuality(Item item) {
        decreaseQuality(item);
    }

    void updateQualityAfterSellInDate(Item item) {
        updateQuality(item);
    }
}
