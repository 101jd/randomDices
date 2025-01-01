package org.example.random.repo;

import org.example.random.model.cubes.Cube;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Repository
public class CubeList {
    private final List<Cube> cubes = new ArrayList<>();

    public List<Integer> getCubesRolls() {
        return cubes.stream()
                .map(cube -> new Random().nextInt(1, cube.getSides() + 1))
                .collect(Collectors.toList());
    }

    public void clear(){
        cubes.clear();
    }

    public void add(Cube cube){
        cubes.add(cube);
    }
}
