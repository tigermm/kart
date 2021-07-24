package com.sobyanin.kart.controller;

import com.sobyanin.kart.model.DriverWithKartAndGroup;
import com.sobyanin.kart.model.DriversAndKarts;
import com.sobyanin.kart.service.KartRandomizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KartRandomizerController {

    @Autowired
    private KartRandomizerService kartRandomizerService;

    @PostMapping(path = "/api/kart/generate")
    public List<DriverWithKartAndGroup> randomizeKarts(@RequestBody DriversAndKarts driversAndKarts) {
        return kartRandomizerService.generateKarts(driversAndKarts.getDrivers(), driversAndKarts.getKarts());
    }
}
