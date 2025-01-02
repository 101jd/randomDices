package org.example.random.service;

import org.example.random.model.dices.*;
import org.example.random.repo.DiceList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiceService {

    @Autowired
    public DiceList diceList;

//    private final List<Integer> cubes = new ArrayList<>();

    /**
     * Amounts of each type of dices:
     * @param d4
     * @param d6
     * @param d8
     * @param d10
     * @param d12
     * @param d20
     * Adds all dices to repo
     */
    public void addCube(int d4, int d6, int d8, int d10, int d12, int d20){
        for (int i = 0; i < d4; i++) {
            diceList.add(Dice.D4);
        }
        for (int i = 0; i < d6; i++) {
            diceList.add(Dice.D6);
        }
        for (int i = 0; i < d8; i++) {
            diceList.add(Dice.D8);
        }
        for (int i = 0; i < d10; i++) {
            diceList.add(Dice.D10);
        }
        for (int i = 0; i < d12; i++) {
            diceList.add(Dice.D12);
        }
        for (int i = 0; i < d20; i++) {
            diceList.add(Dice.D20);
        }
    }

    public DiceList getDiceList() {
        return diceList;
    }
}
