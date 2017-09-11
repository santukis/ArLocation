package com.david.arlocation.aritem.boundary;


import com.david.arlocation.aritem.model.ArItem;
import com.david.arlocation.view.model.MarkerRenderer;
import com.david.arlocation.view.components.OnArItemClickListener;
import com.david.arlocation.view.components.OnClusterClickListener;

public interface ConfigManager<T extends ArItem> {

    void setMarkerRenderer(MarkerRenderer<T> markerRenderer);

    void setOnArItemClickListener(OnArItemClickListener<T> listener);

    void setOnClusterClickListener(OnClusterClickListener<T> listener);
}
