package api.restful.model.collection;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import api.restful.model.views.Views;

public class Item {
    @JsonView(Views.Public.class)
    private List<Feature> features;
    @JsonView(Views.Public.class)
    private int numberMatched;
    @JsonView(Views.Public.class)
    private int numberReturned;
    @JsonView(Views.Public.class)
    private String type;

    public Item() { }

    public Item(List<Feature> features, int numberMatched, int numberReturned, String type) {
        this.features = features;
        this.numberMatched = numberMatched;
        this.numberReturned = numberReturned;
        this.type = type;
    }

    public List<Feature> getFeatures() {
        return this.features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public int getNumberMatched() {
        return this.numberMatched;
    }

    public void setNumberMatched(int numberMatched) {
        this.numberMatched = numberMatched;
    }

    public int getNumberReturned() {
        return this.numberReturned;
    }

    public void setNumberReturned(int numberReturned) {
        this.numberReturned = numberReturned;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}