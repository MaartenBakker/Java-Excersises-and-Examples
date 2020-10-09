package com.Maarten;

public abstract class Instrument {

    private String brand;
    private boolean isPlaying = false;
    private int loudness;
    private Range range;

    public Instrument(String brand, int loudness, int lowestNote, int highestNote) {
        this.brand = brand;
        this.loudness = loudness;
        this.range = new Range(lowestNote, highestNote);
    }

    public String getBrand() {
        return brand;
    }

    public int getLoudness() {
        return loudness;
    }

    public Range getRange() {
        return range;
    }


    public void play() {
        isPlaying = true;
    }

    public void stop() {
        isPlaying = false;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    private class Range {
        private int lowestNote;
        private int highestNote;

        public Range(int lowestNote, int highestNote) {
            this.lowestNote = lowestNote;
            this.highestNote = highestNote;
        }

        public int getLowestNote() {
            return lowestNote;
        }

        public int getHighestNote() {
            return highestNote;
        }

        @Override
        public String toString() {
            return "Range{" +
                    "lowestNote=" + lowestNote +
                    ", highestNote=" + highestNote +
                    '}';
        }
    }

}
