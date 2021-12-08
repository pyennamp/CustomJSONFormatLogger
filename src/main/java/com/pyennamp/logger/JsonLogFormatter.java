package com.pyennamp.logger;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import java.util.*;
import static net.logstash.logback.argument.StructuredArguments.value;
import static net.logstash.logback.marker.Markers.appendEntries;
import static net.logstash.logback.marker.Markers.appendRaw;

/**
 * This program log inputs passed to JSON format as output in the console
 * @author Prashanth
 * @version 1.0
 * @since 2021-12-05
 */

public class JsonLogFormatter {
    private static final Logger log= LoggerFactory.getLogger("JsonLogFormatter");

    public void setGlobalPropertiesForLog(Map Props){
        MDC.clear();
        MDC.setContextMap(Props);
    }

    public void reLogInfo(String KeyField,String ValField,String message){
        /**
         * pass key,value and a message for logging
         */
        JSONObject getEpochSecond = new JSONObject();
        getEpochSecond.put("epochSecond",java.time.Instant.now().getEpochSecond());
        String instant = getEpochSecond.toString();
        log.info(message,appendRaw("instant",instant),value(KeyField,ValField));
    }

    public void reLogMapInfo(Map Props,String message){
        /**
         * pass key,value pairs and a message for logging
         */
        JSONObject getEpochSecond = new JSONObject();
        getEpochSecond.put("epochSecond",java.time.Instant.now().getEpochSecond());
        String instant = getEpochSecond.toString();
        log.info(message,appendRaw("instant",instant),appendEntries(Props));
    }

    public void reLogError(String KeyField,String ValField,String message){
        /**
         * pass key,value and a message for logging
         */
        JSONObject getEpochSecond = new JSONObject();
        getEpochSecond.put("epochSecond",java.time.Instant.now().getEpochSecond());
        String instant = getEpochSecond.toString();
        log.error(message,appendRaw("instant",instant),value(KeyField,ValField));
    }

    public void reLogMapError(Map Props,String message){
        /**
         * pass key,value pairs and a message for logging
         */
        JSONObject getEpochSecond = new JSONObject();
        getEpochSecond.put("epochSecond",java.time.Instant.now().getEpochSecond());
        String instant = getEpochSecond.toString();
        log.error(message,appendRaw("instant",instant),appendEntries(Props));
    }

}
