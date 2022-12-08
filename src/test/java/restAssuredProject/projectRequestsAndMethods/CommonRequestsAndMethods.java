package restAssuredProject.projectRequestsAndMethods;

import framework.BaseAPIRequests;
import restAssuredProject.pojo.Posts.PostsPojo;

public class CommonRequestsAndMethods<T> extends BaseAPIRequests {

    T object;
    protected String uriOfEntity;

    public CommonRequestsAndMethods(T object) {
        this.object = object;
        if (this.object instanceof PostsPojo) {
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
}

