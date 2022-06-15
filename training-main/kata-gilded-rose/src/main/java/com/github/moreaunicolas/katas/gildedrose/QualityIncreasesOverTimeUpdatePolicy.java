package com.github.moreaunicolas.katas.gildedrose;

import static com.github.moreaunicolas.katas.gildedrose.ItemOperations.increaseQuality;

class QualityIncreasesOverTimeUpdatePolicy extends DefaultUpdatePolicy {

    void updateQuality(Item item) {
        increaseQuality(item);
    }
}
