package com.github.moreaunicolas.katas.gildedrose;

public class GildedRose {
    final Item[] items;
    private final UpdatePolicies policies;

    public GildedRose(Item[] items) {
        this.items = items;
        this.policies = new UpdatePolicies();
    }

    GildedRose(Item[] items, UpdatePolicies policies) {
        this.items = items;
        this.policies = policies;
    }

    public void updateQuality() {
        for (Item item : items) {
            UpdatePolicy updatePolicy = findApplicableUpdatePolicy(item);
            updatePolicy.update(item);
        }
    }

    private UpdatePolicy findApplicableUpdatePolicy(Item item) {
        return policies.findApplicableUpdatePolicy(item);
    }
}
