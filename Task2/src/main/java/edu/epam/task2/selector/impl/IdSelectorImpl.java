package edu.epam.task2.selector.impl;

import edu.epam.task2.entity.CustomCube;
import edu.epam.task2.selector.Selector;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


public class IdSelectorImpl implements Selector {
    Set<Long> idsToSelect;

    public IdSelectorImpl(Collection<Long> idsToSelect) {
        this.idsToSelect = new HashSet<>(idsToSelect);
    }

    @Override
    public boolean shouldSelect(CustomCube cube) {
        return this.idsToSelect.contains(cube.getCustomCubeId());
    }
}
