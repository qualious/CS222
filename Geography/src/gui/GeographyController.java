package gui;

import geography.*;

public class GeographyController {
    private Country country;
    private GeographyView view;

    public GeographyController(Country country) {
        this.country = country;
        this.view = new GeographyView(this);
    }

    public GeographyView getView() {
        return view;
    }
}
