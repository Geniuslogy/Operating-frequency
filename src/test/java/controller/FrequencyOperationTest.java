package controller;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class FrequencyOperationTest {

    @Test
    public void Part1() throws IOException {
        // Setup
        int ExpLength = 1029;
        // Arrange
        FrequencyOperation frequencyOperation = new FrequencyOperation();
        // Act
        int ActLength = frequencyOperation.getFrequency().size();
        // Assert
        Assert.assertEquals(ExpLength, ActLength);
    }

    @Test
    public void Part2() throws IOException {
        // Setup
        int ExpCumulatedFrequency = 75108;
        // Arrange
        FrequencyOperation frequencyOperation = new FrequencyOperation();
        // Act
        int ActCumulatedFrequency = frequencyOperation.firstDuplicateFrequency();
        // Assert
        Assert.assertEquals(ExpCumulatedFrequency, ActCumulatedFrequency);
    }
}
