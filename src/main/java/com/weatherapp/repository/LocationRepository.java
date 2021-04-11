package com.weatherapp.repository;

import com.weatherapp.input.UserInput;
import com.weatherapp.model.Localization;
import com.weatherapp.output.UserOutput;

import java.util.ArrayList;
import java.util.List;

public class LocationRepository {

    public List<Localization> localizations = new ArrayList<>();
    UserInput userInput = new UserInput();
    UserOutput userOutput = new UserOutput();

    public void addLocation() {
        userInput.inputNewLocation(localizations);
    }

    public void showAllLocations() {
        userOutput.outputAllLocations(localizations);
    }

    public void findByLocationName() {
        userInput.inputLocationName(localizations);
    }


}
