package ru.yandex;

import ru.yandex.constants.Constants;
import ru.yandex.exeption.AutoTestException;

import java.util.Objects;

public class Stool {


    private static final int COST = 7;

    private String material;
    private String design;

    private int size;
    private int cost;

    public Stool(String material, String design, int size, int cost) {
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
        Stool stool = (Stool) o;
        return size == stool.size &&
                cost == stool.cost &&
                material.equals(stool.material) &&
                design.equals(stool.design);
    }

    @Override
    public int hashCode() {
        return Objects.hash(material, design, size, cost);
    }

    @Override
    public String toString() {
        return "Табуретка с размером " + size + ", выполненная в дизайне " + design + " и стоимостью " + cost + " рублей";
    }
}
