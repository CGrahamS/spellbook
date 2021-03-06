package com.cgrahams.spellbook.model;

import java.util.ArrayList;

public class Spell {
    String name;
    String casting_time;
    String components;
    String description;
    String duration;
    int level;
    String range;
    String school;
    boolean ritual;

    public Spell() {}

    public Spell(String name, String casting_time, String components, String description, String duration, int level, String range, String school, boolean ritual) {
        this.name = name;
        this.casting_time = casting_time;
        this.components = components;
        this.description = description;
        this.duration = duration;
        this.level = level;
        this.range = range;
        this.school = school;
        this.ritual = ritual;
    }

    public Spell(String name, int level, boolean ritual) {
        this.name = name;
        this.level = level;
        this.ritual = ritual;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCastingTime() {
        return casting_time;
    }

    public void setCastingTime(String castingTime) {
        this.casting_time = castingTime;
    }

    public String getComponents() {
        return components;
    }

    public void setComponents(String components) {
        this.components = components;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public boolean isRitual() {
        return ritual;
    }

    public void setRitual(boolean ritual) {
        this.ritual = ritual;
    }

    public static ArrayList<Spell> createSpellsList(int numSpells) {
        ArrayList<Spell> spells = new ArrayList<>();

        for (int i = 0; i < numSpells; i++) {
            spells.add(new Spell("Spell" + i, i, true));
        }
        return spells;
    }
}