package com.weatherapp.repository;

import com.weatherapp.input.UserInput;
import com.weatherapp.model.Localization;
import com.weatherapp.output.UserOutput;

import java.util.ArrayList;
import java.util.List;

public class LocationRepository {

    public List<Localization> localizations = new ArrayList<>();
    UserInput userInterface = new UserInput();

    public void addLocation() {
        userInterface.inputNewLocation(localizations);
    }

    public void showAllLocations() {
        UserOutput.outputAllLocations(localizations);
    }


}
