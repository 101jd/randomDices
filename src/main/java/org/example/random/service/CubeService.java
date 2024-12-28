package org.example.random.service;

import org.example.random.model.cubes.*;
import org.example.random.repo.CubeList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CubeService {

    @Autowired
    public CubeList cubeList;

//    private final List<Integer> cubes = new ArrayList<>();

    public void addCube(int d4, int d6, int d8, int d10, int d12, int d20){
        for (int i = 0; i < d4; i++) {
            cubeList.add(new Random().nextInt(1, new D4().getSides()+1));
        }
        for (int i = 0; i < d6; i++) {
            cubeList.add(new Random().nextInt(1, new D6().getSides()+1));
        }
        for (int i = 0; i < d8; i++) {
            cubeList.add(new Random().nextInt(1, new D8().getSides()+1));
        }
        for (int i = 0; i < d10; i++) {
            cubeList.add(new Random().nextInt(1, new D10().getSides()+1));
        }
        for (int i = 0; i < d12; i++) {
            cubeList.add(new Random().nextInt(1, new D12().getSides()+1));
        }
        for (int i = 0; i < d20; i++) {
            cubeList.add(new Random().nextInt(1, new D20().getSides() + 1));
        }
    }

    public CubeList getCubeList() {
        return cubeList;
    }
}
