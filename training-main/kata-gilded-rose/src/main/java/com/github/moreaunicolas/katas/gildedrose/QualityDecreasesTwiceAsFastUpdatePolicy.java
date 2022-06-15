package com.github.moreaunicolas.katas.gildedrose;

import static com.github.moreaunicolas.katas.gildedrose.ItemOperations.decreaseQuality;

class QualityDecreasesTwiceAsFastUpdatePolicy extends DefaultUpdatePolicy {

    @Override
    void updateQuality(Item item) {
        decreaseQuality(item);
        decreaseQuality(item);
    }
}
