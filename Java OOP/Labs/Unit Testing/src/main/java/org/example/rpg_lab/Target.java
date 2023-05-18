package org.example.rpg_lab;

public interface Target {
    int getHealth();

    int giveExperience();

    void takeAttack(int attackPoints);

    boolean isDead();
}
