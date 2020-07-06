package api.restful.model.collection;

import com.fasterxml.jackson.annotation.JsonView;
import api.restful.model.views.Views;

public class Asset {
    @JsonView(Views.Public.class)
    private String name;
    @JsonView(Views.Internal.class)
    private String href;

    public Asset() {}

    public Asset(String name, String href) {
        this.name = name;
        this.href = href;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return this.href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}