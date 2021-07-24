package com.sobyanin.kart.service.impl;

import com.sobyanin.kart.model.DriverWithKartAndGroup;
import com.sobyanin.kart.service.KartRandomizerService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class KartRandomizerServiceImpl implements KartRandomizerService {

    @Override
    public List<DriverWithKartAndGroup> generateKarts(List<String> drivers, List<String> karts) {
        int groups = getGroupsCount(drivers, karts);
        List<DriverWithKartAndGroup> results = new LinkedList<>();

        List<Integer> indexes = new LinkedList<>();
        int count = 0;
        for (String driver: drivers) {
            results.add(new DriverWithKartAndGroup(driver));
            indexes.add(count++);
        }

        int driversInGroupDefault = drivers.size() / groups;
        for (int i = 1; i <= groups; i++) {
            List<String> kartsToChooseForQualification = new LinkedList<>(karts);
            List<String> kartsToChooseForRace = new LinkedList<>(karts);
            int driversInGroup = i == groups ? drivers.size() - (driversInGroupDefault * (i - 1)) : driversInGroupDefault;
            for (int j = 0; j < driversInGroup; j++) {
                DriverWithKartAndGroup driver = results.get(indexes.remove((int) (Math.random() * (indexes.size() - 1))));
                driver.setGroup(i);
                driver.setKartQualification(kartsToChooseForQualification.remove((int) (Math.random() * (kartsToChooseForQualification.size() - 1))));
                int raceKartIndex = (int) (Math.random() * (kartsToChooseForRace.size() - 1));

                while (kartsToChooseForRace.get(raceKartIndex).equals(driver.getKartQualification())
                        || (kartsToChooseForRace.size() == 2
                        && kartsToChooseForRace.contains(kartsToChooseForQualification.get(0))
                        && !kartsToChooseForQualification.get(0).equals(kartsToChooseForRace.get(raceKartIndex)))) {
                    if (kartsToChooseForRace.size() == 2
                            && kartsToChooseForRace.contains(kartsToChooseForQualification.get(0))
                            && !kartsToChooseForQualification.get(0).equals(kartsToChooseForRace.get(raceKartIndex))) {
                        raceKartIndex = 1 - raceKartIndex;
                    } else {
                        raceKartIndex = (int) (Math.random() * (kartsToChooseForRace.size() - 1));
                    }
                }

                driver.setKartRace(kartsToChooseForRace.remove(raceKartIndex));
            }
        }

        return results;
    }

    private int getGroupsCount(List<String> drivers, List<String> karts) {
        int groups = drivers.size() > karts.size() ? drivers.size() / karts.size() : 1;
        if (groups * karts.size() < drivers.size()) {
            groups++;
        }
        return groups;
    }

}
