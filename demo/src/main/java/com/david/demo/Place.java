package com.david.demo;



import com.david.arlocation.aritem.model.ArItem;
import com.david.arlocation.aritem.model.GeoLocation;

import java.util.Arrays;
import java.util.List;

public class Place implements ArItem {

    private String name;
    private GeoLocation coordinate;

    public Place(String name, GeoLocation coordinate) {
        this.name = name;
        this.coordinate = coordinate;
    }

    public String getName() {
        return name;
    }

    @Override
    public GeoLocation getLocation() {
        return coordinate;
    }


    private static List<Place> places = Arrays.asList(
            new Place("Museo Arqueológico", new GeoLocation(43.362754, -5.842297, 140)),
            new Place("Monte Naranco", new GeoLocation(43.383549, -5.865823, 200)),
            new Place("La Catedral", new GeoLocation(43.362475, -5.843577, 225)),
            new Place("La Corte", new GeoLocation(43.362955, -5.842311, 229)),
            new Place("Parque San Francisco", new GeoLocation(43.361828, -5.850143, 190)),
            new Place("Parque Purificación Tomás", new GeoLocation(43.372865, -5.874974, 350)),
            new Place("La Monxina", new GeoLocation(43.378803, -5.817458, 220)),
            new Place("El Conceyín", new GeoLocation(43.384717, -5.819262, 150)),
            new Place("Lugones", new GeoLocation(43.400645, -5.810789, 100)),
            new Place("Campo Futbol Lugones", new GeoLocation(43.406132, -5.821003, 120)));


    public static List<Place> getPlaces() {
        return places;
    }
}
