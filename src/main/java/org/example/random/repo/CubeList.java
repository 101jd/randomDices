package org.example.random.repo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CubeList {
    private final List<Integer> cubes = new ArrayList<>();

    public List<Integer> getCubes() {
        return cubes;
    }

    public void clear(){
        cubes.clear();
    }

    public void add(Integer i){
        cubes.add(i);
    }
}
