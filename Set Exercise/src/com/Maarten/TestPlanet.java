package com.Maarten;

public class TestPlanet {
    private final String name;
    private final SoortLichaam soortLichaam;

    public enum SoortLichaam {
        PLANEET,
        STER,
        MAAN
    }

    public TestPlanet(String name, SoortLichaam soortLichaam) {
        this.name = name;
        this.soortLichaam = soortLichaam;
    }
}
