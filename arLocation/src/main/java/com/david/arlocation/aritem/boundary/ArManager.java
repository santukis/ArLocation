package com.david.arlocation.aritem.boundary;

import com.david.arlocation.aritem.model.ArItem;

import java.util.Collection;


public interface ArManager<T extends ArItem> extends ConfigManager<T> {

    void init();

    void release();

    void addArItems(Collection<T> arItems);
}
