package model;

import org.junit.Assert;
import org.junit.Test;

public class FrequencyTest {

    @Test
    public void AbsoluteFrequency() {
        // Setup
        int ExpV = 0;
        // Arrange
        Frequency frequency = new Frequency(ExpV, 0);
        // Act
        int ActV = frequency.getAbsoluteFrequency();
        // Assert
        Assert.assertEquals(ExpV, ActV);
    }
}
