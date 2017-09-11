package com.david.arlocation.view.boundary;


import com.david.arlocation.aritem.boundary.ConfigManager;
import com.david.arlocation.aritem.model.ArItem;
import com.david.arlocation.view.model.Marker;

import java.util.Set;

public interface ArView<T extends ArItem> extends ConfigManager<T> {

    void addMarkers(Set<? extends Marker<T>> markers);

    void drawMarkers();

    void clearMarkers();
}
