package io.github.nbcss.xengine.api.block;

import io.github.nbcss.xengine.core.block.type.BaseBlockClass;
import io.github.nbcss.xengine.core.block.type.CustomBlockClass;
import io.github.nbcss.xengine.utils.TriggerHandler;

public interface XBlockClass {
    static XBlockClass base(){
        return BaseBlockClass.INSTANCE;
    }

    static XBlockClass custom(TriggerHandler handler){
        return CustomBlockClass.of(handler);
    }
}