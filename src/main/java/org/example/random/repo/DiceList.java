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
    private List<Integer> rolls;

    /**
     * Generates random values in bounds of dices sides for each dice in DiceList
     * Creates List of Integers for getSum() method
     * @return
     * list of rolls
     */
    public List<Integer> getDicesRolls() {
        this.rolls = dices.stream()
                .map(dice -> new Random().nextInt(1, dice.getSides() + 1))
                .collect(Collectors.toList());
        return rolls;
    }

    /**
     * May be called only after calling getDicesRolls()
     * @return
     * Summary roll of generated rolls in list or 0 if rolls wasn't generated
     */
    public int getSum(){
        if (rolls != null){
            return rolls.stream().mapToInt(i -> i).sum();
        }
        return 0;
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
