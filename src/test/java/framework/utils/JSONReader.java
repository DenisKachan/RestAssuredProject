package framework.utils;

import framework.BaseAPIRequests;
import lombok.extern.log4j.Log4j2;

import java.io.FileNotFoundException;
import java.io.FileReader;

@Log4j2
public class JSONReader <T>{

    T object;
    BaseAPIRequests baseAPIRequests = new BaseAPIRequests();

    public JSONReader(T object) {
        this.object = object;
    }

    public T getDataFromJsonFile(String dataFileName) throws FileNotFoundException {
        log.info("Get JSON entity from file {}",dataFileName);
        return (T) baseAPIRequests.gson.fromJson(new FileReader((baseAPIRequests.configReader.getProperty("directoryForTestData") + dataFileName)),
                object.getClass());
    }
}
