package com.sobyanin.kart.service;

import com.sobyanin.kart.model.DriverWithKartAndGroup;

import java.util.List;

public interface KartRandomizerService {

    List<DriverWithKartAndGroup> generateKarts(List<String> drivers, List<String> karts);
}
