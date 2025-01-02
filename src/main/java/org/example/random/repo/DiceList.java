package org.example.random.repo;

import org.example.random.model.cubes.Dice;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Repository
public class DiceList {
    private final List<Dice> dices = new ArrayList<>();

    /**
     * Random value in bounds of cube sides for each cube in CubeList
     * @return
     * list of rolls
     */
    public List<Integer> getCubesRolls() {
        return dices.stream()
                .map(dice -> new Random().nextInt(1, dice.getSides() + 1))
                .collect(Collectors.toList());
    }

    /**
     * Clear repo needs for new rolls by refresh page or new request
     */
    public void clear(){
        dices.clear();
    }

    /**
     * Preparing dices to roll
     * @param dice
     */
    public void add(Dice dice){
        this.dices.add(dice);
    }
}
