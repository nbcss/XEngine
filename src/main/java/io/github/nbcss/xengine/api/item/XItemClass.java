package io.github.nbcss.xengine.api.item;

import io.github.nbcss.xengine.api.block.XBlock;
import io.github.nbcss.xengine.core.item.type.BaseItemClass;
import io.github.nbcss.xengine.core.item.type.BlockItemClass;

public interface XItemClass {
    static XItemClass base(){
        return BaseItemClass.INSTANCE;
    }
    static XItemClass block(XBlock block){
        return BlockItemClass.of(block);
    }
}
