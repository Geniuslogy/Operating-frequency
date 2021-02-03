package controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.Frequency;

/**
 * @author David Andersson
 *
 * This class handles all operations of the received signal.
 */
public class FrequencyOperation {
    private List<Frequency> frequency; //A sequence of frequencies

    private int v; //Cumulated frequency

    public FrequencyOperation() throws IOException {
        setFrequency(Files.lines(Paths.get("input.txt")));
    }

    /**
     * @return Sequence of List<Frequency>
     */
    public List<Frequency> getFrequency() {
        return frequency;
    }


    /**
     * @param stream
     *
     * All absolute frequency added to List<Frequency> and update the cumulated frequency.
     */
    private void setFrequency(Stream<String> stream) {
        this.frequency = stream.collect(
                Collectors.mapping(v -> IncreaseAbsoluteFrequency(Integer.parseInt(v.trim())), Collectors.toList()));
    }

    /**
     * @return First duplicate frequency
     *
     * Cumulated frequency that cannot be added to the set is duplicated frequency.
     */
    public int firstDuplicateFrequency() {
        Set<Integer> set = new HashSet<Integer>();

        Boolean proceed = true;

        //Try add all frequency to the HashSet<Integer>
        for (Frequency f : frequency) {
            if (set.add(f.getCumulatedFrequency()) == false) {
                return f.getCumulatedFrequency();
            }
        }

        int index = 0;

        //Repeat sequence the List<Frequency> until it has found the first duplicate frequency.
        while (proceed) {
            int absoluteFrequency = frequency.get(index).getAbsoluteFrequency();

            IncreaseAbsoluteFrequency(absoluteFrequency);

            //Try add a new absolute frequency to the HashSet<Integer>
            if (set.add(this.v) == false) {
                proceed = false;
            }

            index = (index == frequency.size() - 1) ? 0 : ++index;
        }

        return this.v;
    }

    /**
     * @return Cumulated frequency
     */
    public int getV() {
        return v;
    }

    /**
     * @param v
     * @return Frequency
     *
     * Cumulated frequency is updated
     */
    private Frequency IncreaseAbsoluteFrequency(int v) {
        this.v += v;

        return new Frequency(v, getV());
    }

}

