package api.restful.model.collection;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonView;
import api.restful.model.views.Views;

import api.restful.model.geojson.Geometry;
import api.restful.model.geojson.Properties;

public class Feature {
    @JsonView(Views.Internal.class)
    private Long id;
    @JsonView({Views.Public.class, Views.Internal.class})
    private List<Asset> assets;
    @JsonView(Views.Internal.class)
    private List<Double> bbox;
    @JsonView(Views.Internal.class)
    private String collection;
    @JsonView(Views.Internal.class)
    private Geometry geometry;
    @JsonView(Views.Internal.class)
    private Properties properties;
    @JsonView(Views.Internal.class)
    private String type;

    public Feature() { }

    public Feature(Long id, List<Asset> assets, List<Double> bbox, String collection, Geometry geometry, Properties properties, String type) {
        this.id = id;
        this.assets = assets;
        this.bbox = bbox;
        this.collection = collection;
        this.geometry = geometry;
        this.properties = properties;
        this.type = type;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Asset> getAssets() {
        return this.assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }

    public List<Double> getBbox() {
        return this.bbox;
    }

    public void setBbox(List<Double> bbox) {
        this.bbox = bbox;
    }

    public String getCollection() {
        return this.collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public Geometry getGeometry() {
        return this.geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public Properties getProperties() {
        return this.properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}