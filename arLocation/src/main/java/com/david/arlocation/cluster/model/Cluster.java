package com.david.arlocation.cluster.model;


import com.david.arlocation.aritem.model.ArItem;

import java.util.Collection;

public interface Cluster <T extends ArItem> {

    CameraPosition getPosition();

    Collection<T> getItems();

    int getSize();
}
