package tests;

import org.junit.Assert;
import org.junit.Test;
import ru.yandex.Armchair;
import ru.yandex.Chair;
import ru.yandex.Stool;
import ru.yandex.constants.Constants;

public class TestFurniture {

    @Test()
    public void costPrice() {
        Armchair armchairMinimalism = new Armchair("дерево", Constants.MINIMALISM, 20, 5000);
        Armchair armchairBaroque = new Armchair("металл", Constants.BAROQUE, 30, 10000);
        Armchair armchairHighTech = new Armchair("пластик", Constants.HIGH_TECH, 20, 20000);

        Assert.assertEquals(10.0, armchairMinimalism.costPrice(), 0);
        Assert.assertEquals(30.0, armchairBaroque.costPrice(), 0);
        Assert.assertEquals(30.0, armchairHighTech.costPrice(), 0);

        Chair chairWithHeating = new Chair("дерево", Constants.MINIMALISM, 20, 5000, true);
        Chair chairWithoutHeating = new Chair("дерево", Constants.MINIMALISM, 20, 5000, false);

        Assert.assertEquals(1012.0, chairWithHeating.costPrice(), 0);
        Assert.assertEquals(12.0, chairWithoutHeating.costPrice(), 0);

        Stool stoolBaroque = new Stool("дерево", Constants.BAROQUE, 10, 500);

        Assert.assertEquals(14.0, stoolBaroque.costPrice(), 0);
    }

    @Test()
    public void profit() {
        Armchair armchairMinimalism = new Armchair("дерево", Constants.MINIMALISM, 20, 5000);
        Armchair armchairBaroque = new Armchair("металл", Constants.BAROQUE, 30, 10000);
        Armchair armchairHighTech = new Armchair("пластик", Constants.HIGH_TECH, 20, 20000);

        Assert.assertEquals(4990.0, armchairMinimalism.profit(), 0);
        Assert.assertEquals(9970.0, armchairBaroque.profit(), 0);
        Assert.assertEquals(19970.0, armchairHighTech.profit(), 0);

        Chair chairWithHeating = new Chair("дерево", Constants.MINIMALISM, 20, 5000, true);
        Chair chairWithoutHeating = new Chair("дерево", Constants.MINIMALISM, 20, 5000, false);

        Assert.assertEquals(3988.0, chairWithHeating.profit(), 0);
        Assert.assertEquals(4988.0, chairWithoutHeating.profit(), 0);

        Stool stoolBaroque = new Stool("дерево", Constants.BAROQUE, 10, 500);

        Assert.assertEquals(486.0, stoolBaroque.profit(), 0);
    }
}
