package com.pyennamp.logger;

import java.util.*;

public class TestLogger {

    public static void main(String args[]){
        JsonLogFormatter LogHandler = new JsonLogFormatter();

        Map globalConfig = new HashMap<String,String>();
        globalConfig.put("application","java");
        globalConfig.put("name","TestLogger");

        LogHandler.setGlobalPropertiesForLog(globalConfig);

        LogHandler.reLogInfo("step","info","test info method");

        Map infoPair = new HashMap<String,String>();
        infoPair.put("medthod_type","info");
        infoPair.put("method_name","reLogMapInfo");
        LogHandler.reLogMapInfo(infoPair,"test info method with key value pair");

        LogHandler.reLogError("step","info","test error method");

        Map errorPair = new HashMap<String,String>();
        errorPair.put("medthod_type","error");
        errorPair.put("method_name","reLogMapError");
        LogHandler.reLogMapError(errorPair,"test error method with key value pair");

    }
}
