package com.github.moreaunicolas.katas.gildedrose;

class UpdatePolicies {

    private static final UpdatePolicy
        DEFAULT = new DefaultUpdatePolicy(),
        LEGENDARY_ITEM = new LegendaryItemUpdatePolicy(),
        QUALITY_INCREASES_OVER_TIME = new QualityIncreasesOverTimeUpdatePolicy(),
        BACKSTAGE_PASS = new BackstagePassUpdatePolicy(),
        QUALITY_DECREASES_TWICE_AS_FAST = new QualityDecreasesTwiceAsFastUpdatePolicy();

    UpdatePolicy findApplicableUpdatePolicy(Item item) {
        if (isSulfuras(item)) {
            return LEGENDARY_ITEM;
        } else if (isAgedBrie(item)) {
            return QUALITY_INCREASES_OVER_TIME;
        } else if (isBackstagePass(item)) {
            return BACKSTAGE_PASS;
        } else if (isConjured(item)) {
            return QUALITY_DECREASES_TWICE_AS_FAST;
        }
        return DEFAULT;
    }

    private static boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private static boolean isBackstagePass(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private static boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private static boolean isConjured(Item item) {
        return item.name.startsWith("Conjured ");
    }
}
