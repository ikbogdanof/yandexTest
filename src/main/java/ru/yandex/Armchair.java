package ru.yandex;

import ru.yandex.constants.Constants;
import ru.yandex.exeption.AutoTestException;

import java.util.Objects;

public class Armchair {
    private static final int COST = 5;

    private String material;
    private String design;

    private int size;
    private int cost;

    public Armchair(String material, String design, int size, int cost) {
        this.material = material;
        this.design = design;
        this.size = size;
        this.cost = cost;
    }

    public static int getCOST() {
        return COST;
    }

    public String getMaterial() {
        return material;
    }

    public String getDesign() {
        return design;
    }

    public int getSize() {
        return size;
    }

    public int getCost() {
        return cost;
    }

    public double costPrice() {

        switch (getDesign()) {
            case Constants.MINIMALISM:
                return size * COST * 0.1;
            case Constants.BAROQUE:
                return size * COST * 0.2;
            case Constants.HIGH_TECH:
                return size * COST * 0.3;
            default:
                throw new AutoTestException("Дизайн '" + getDesign() + "' не поддерживается");
        }
    }

    public double profit() {
        return cost - costPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Armchair armchair = (Armchair) o;
        return size == armchair.size &&
                cost == armchair.cost &&
                material.equals(armchair.material) &&
                design.equals(armchair.design);
    }

    @Override
    public int hashCode() {
        return Objects.hash(material, design, size, cost);
    }

    @Override
    public String toString() {
        return "Кресло с размером " + size + ", выполненное в дизайне " + design + " и стоимостью " + cost + " рублей";
    }
}
