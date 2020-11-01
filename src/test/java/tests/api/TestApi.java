package tests.api;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import ru.yandex.constants.Constants;
import ru.yandex.requests.Requests;

public class TestApi {

    @Test()
    public void get() throws Exception {
        Requests request = new Requests();
        String getResult = request.getRequest("https://jsonplaceholder.typicode.com/posts");

        Assert.assertFalse("Метод GET вернул пустой результат", getResult.isEmpty());


        String getResultById = request.getRequest("https://jsonplaceholder.typicode.com/posts/1");

        Assert.assertFalse("Метод GET вернул пустой результат для id = 1", getResultById.isEmpty());

        JSONObject parsedObject = new JSONObject(getResultById);

        Assert.assertEquals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                parsedObject.get(Constants.TITLE));
    }

    @Test()
    public void post() throws Exception {
        Requests request = new Requests();
        String postResult = request.postRequest(
                "https://jsonplaceholder.typicode.com/posts", "myTest", "description", "1");

        Assert.assertFalse("Не удалось создать пользователя", postResult.isEmpty());

        JSONObject parsedObject = new JSONObject(postResult);

        Assert.assertEquals("Значение 'title' не соответсвует ожидаемому",
                "myTest", parsedObject.get(Constants.TITLE));
        Assert.assertEquals("Значение 'body' не соответсвует ожидаемому",
                "description", parsedObject.get(Constants.BODY));
        Assert.assertEquals("Значение 'userId' не соответсвует ожидаемому",
                "1", parsedObject.get(Constants.USER_ID));
    }
}
