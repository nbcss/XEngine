package io.github.nbcss.xengine.api.item;

import io.github.nbcss.xengine.core.item.ItemSettings;

public interface XItemSettings {
    XItemSettings group(XItemGroup group);

    static XItemSettings of(){
        return ItemSettings.of();
    }
}
