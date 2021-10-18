package edu.epam.task2.repository;

import edu.epam.task2.entity.CustomCube;
import edu.epam.task2.selector.Selector;
import edu.epam.task2.service.PropertiesExtractor;
import edu.epam.task2.service.impl.PropertiesExtractorImpl;

import java.util.List;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CubeRepository {
    private Set<CustomCube> cubes;

    public CubeRepository() {
        this.cubes = new HashSet<>();
    }

    public int size() {
        return cubes.size();
    }

    public boolean isEmpty() {
        return cubes.isEmpty();
    }

    public boolean add(CustomCube cube) {
        return cubes.add(cube);
    }

    public boolean remove(CustomCube cube) {
        return cubes.remove(cube);
    }


    public boolean addAll(Collection<? extends CustomCube> collection) {
        return cubes.addAll(collection);
    }

    public boolean removeAll(Collection<? extends CustomCube> collection) {
        return cubes.removeAll(collection);
    }

    public List<CustomCube> select(Selector selector) {
        return cubes.stream().filter(selector::shouldSelect).toList();
    }
}
