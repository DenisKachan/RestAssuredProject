package restAssuredProject.projectRequestsAndMethods;

import framework.BaseAPIRequests;
import restAssuredProject.dto.Posts.Posts;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class CommonRequestsAndMethods<T> extends BaseAPIRequests {

    T object;
    protected String uriOfEntity;

    public CommonRequestsAndMethods(T object) {
        this.object = object;
        if (this.object instanceof Posts) {
            uriOfEntity = "uriForPosts";
        } else {
            uriOfEntity = "uriForUsers";
        }
    }

    public T getEntity(String numberOfEntity, int statusCode) {
        return (T) gson.fromJson(get(configReader.getProperty(uriOfEntity) + numberOfEntity, statusCode),
                object.getClass());
    }

    public T[] getAllEntities(int statusCode) {
        return (T[]) gson.fromJson(get(configReader.getProperty(uriOfEntity), statusCode),
                object.getClass().arrayType());
    }

    public void createNewEntity(T object, int statusCode) {
        post(gson.toJson(object), configReader.getProperty(uriOfEntity), statusCode);
    }

    public T getDataFromJsonFile(String dataFileName) throws FileNotFoundException {
        return (T) gson.fromJson(new FileReader((configReader.getProperty("directoryForTestData") + dataFileName)),
                object.getClass());
    }
}

