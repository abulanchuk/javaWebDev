package edu.epam.task2.selector.impl;

import edu.epam.task2.entity.CustomCube;
import edu.epam.task2.entity.CustomPoint;
import edu.epam.task2.factory.CubeFactory;
import edu.epam.task2.warehouse.Warehouse;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.*;

public class SelectorImplTest {
    CustomCube cube;

    @BeforeTest
    public void setUp() {
        cube = CubeFactory.getInstance().createCubeFromOnePoint(new CustomPoint(0, 0, 0), 4);
        Warehouse.getInstance().putCubeParameters(cube.getCustomCubeId(), 96, 64);
    }

    @Test
    public void testAreaFromRangeSelectorShouldNotSelect() {
        AreaFromRangeSelectorImpl areaFromRangeSelector = new AreaFromRangeSelectorImpl(3, 30);
        boolean isSelect = areaFromRangeSelector.shouldSelect(cube);
        assertFalse(isSelect);
    }

    @Test
    public void testAreaFromRangeSelectorShouldSelect() {
        AreaFromRangeSelectorImpl areaFromRangeSelector = new AreaFromRangeSelectorImpl(3, 255);
        boolean isSelect = areaFromRangeSelector.shouldSelect(cube);
        assertTrue(isSelect);
    }

    @Test
    public void testIdSelectorShouldSelect() {
        Set<Long> idsToSelect = new HashSet<>();
        idsToSelect.add(cube.getCustomCubeId());
        idsToSelect.add(376L);
        IdSelectorImpl idSelector = new IdSelectorImpl(idsToSelect);
        boolean containCube = idSelector.shouldSelect(cube);
        assertTrue(containCube);
    }

   @Test
    public void testIdSelectorShouldNotSelect() {
        Set<Long> idsToSelect = new HashSet<>();
        idsToSelect.add(268L);
        idsToSelect.add(376L);
        IdSelectorImpl idSelector = new IdSelectorImpl(idsToSelect);

        boolean containCube = idSelector.shouldSelect(cube);
        assertFalse(containCube);
    }

  @Test
    public void testPointInARangeImplShouldSelect(){
        PointInARangeImpl pointInARange = new PointInARangeImpl(1,9,1,9,1,9);
        boolean selectOrNot = pointInARange.shouldSelect(cube);
        assertFalse(selectOrNot);
    }
    @Test
    public void testPointInARangeImplShouldNotSelect(){
        PointInARangeImpl pointInARange = new PointInARangeImpl(0,9,0,9,0,9);
        boolean selectOrNot = pointInARange.shouldSelect(cube);
        assertFalse(selectOrNot);
    }

    @Test
    public void testVolumeSelectorImplShouldNotSelect(){
        VolumeSelectorImpl volumeSelector = new VolumeSelectorImpl(20);
        boolean shouldSelectOrNot = volumeSelector.shouldSelect(cube);
        assertFalse(shouldSelectOrNot);
    }

    @Test
    public void testVolumeSelectorImplShouldNSelect(){
        VolumeSelectorImpl volumeSelector = new VolumeSelectorImpl(100);
        boolean shouldSelectOrNot = volumeSelector.shouldSelect(cube);
        assertTrue(shouldSelectOrNot);
    }
}