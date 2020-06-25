package com.zhanghh.wms.inventory.enums;

/**
 * @author zhanghuihuang
 * @description <pre>
 *
 * </pre>
 * @since 2020/6/25 7:29 下午
 */
public interface IEnum {
    default String getName() {
        return name();
    }

    default String name() {
        return null;
    }

    default int getIndex() {
        return ordinal();
    }

    default int ordinal() {
        return 0;
    }
}
