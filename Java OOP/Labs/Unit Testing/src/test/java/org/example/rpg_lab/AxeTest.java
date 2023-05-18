package org.example.rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeTest {
    private Dummy target;

    @Before
    public void setTarget() {
        this.target = new Dummy(10, 10);
    }

    @Test
    public void attackDropsDurability() {
        Axe axe = new Axe(10, 10);

        axe.attack(target);

        Assert.assertEquals(9, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void cannotAttackWithBrokenAxe() {
        Axe axe = new Axe(10, 0);

        axe.attack(target);
    }
}
