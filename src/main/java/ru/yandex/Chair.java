package ru.yandex;

import ru.yandex.constants.Constants;
import ru.yandex.exeption.AutoTestException;

import java.util.Objects;

public class Chair {

    private static final int COST = 6;

    private String material;
    private String design;

    private int size;
    private int cost;

    private boolean isHeating;

    public Chair(String material, String design, int size, int cost, boolean isHeating) {
        this.material = material;
        this.design = design;
        this.size = size;
        this.cost = cost;
        this.isHeating = isHeating;
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

    public boolean getHeating() {
        return isHeating;
    }

    public double costPrice() {
        int result = getHeating() ? 1000 : 0;

        switch (getDesign()) {
            case Constants.MINIMALISM:
                return size * COST * 0.1 + result;
            case Constants.BAROQUE:
                return size * COST * 0.2 + result;
            case Constants.HIGH_TECH:
                return size * COST * 0.3 + result;
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
        Chair chair = (Chair) o;
        return size == chair.size &&
                cost == chair.cost &&
                isHeating == chair.isHeating &&
                Objects.equals(material, chair.material) &&
                Objects.equals(design, chair.design);
    }

    @Override
    public int hashCode() {
        return Objects.hash(material, design, size, cost, isHeating);
    }

    @Override
    public String toString() {
        return "Стул " + (getHeating() ? "с подогревом," : "")
                + " с размером " + size
                + ", выполненный в дизайне " + design
                + " и стоимостью " + cost
                + " рублей";
    }
}
