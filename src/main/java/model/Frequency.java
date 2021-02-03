package model;

/**
 * @author David Andersson
 *
 * This Frequency, class represents a single signal, that will be received by the device
 */
public class Frequency {
    private int absoluteFrequency;
    private int cumulatedFrequency;

    public Frequency(int v, int cumulatedFrequency) {
        setAbsoluteFrequency(v);
        setCumulatedFrequency(cumulatedFrequency);
    }

    public int getAbsoluteFrequency() {
        return absoluteFrequency;
    }

    public void setAbsoluteFrequency(int absoluteFrequency) {
        this.absoluteFrequency = absoluteFrequency;
    }

    public int getCumulatedFrequency() {
        return cumulatedFrequency;
    }

    public void setCumulatedFrequency(int cumulatedFrequency) {
        this.cumulatedFrequency = cumulatedFrequency;
    }

}

