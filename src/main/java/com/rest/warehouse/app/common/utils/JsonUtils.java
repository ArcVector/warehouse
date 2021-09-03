/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Administrator
 */
public class JsonUtils {
    
    private static final Logger LOG = LoggerFactory.getLogger(SearchUtils.class);
    private static final ObjectMapper MAPPER = new ObjectMapper();
    
    public static <T> T parse(String jsonSearchCriteriaString, Class<T> searchCriteriaClass)
    {
        T searchCriteria = null;
        try
        {
            searchCriteria = MAPPER.readValue(jsonSearchCriteriaString, searchCriteriaClass);
        }
        catch(IOException e)
        {
            LOG.info("Something went wrong while parsing stringified JSON", e);
        }
        return searchCriteria;
        
    }
}
