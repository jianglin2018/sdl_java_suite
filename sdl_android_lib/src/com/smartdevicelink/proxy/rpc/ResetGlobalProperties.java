package com.smartdevicelink.proxy.rpc;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.smartdevicelink.protocol.enums.FunctionID;
import com.smartdevicelink.proxy.RPCRequest;
import com.smartdevicelink.proxy.rpc.enums.GlobalProperty;
/**
 * Resets the passed global properties to their default values as defined by
 * SDL
 * <p>
 * The HELPPROMPT global property default value is generated by SDL consists of
 * the first vrCommand of each Command Menu item defined at the moment PTT is
 * pressed<br/>
 * The TIMEOUTPROMPT global property default value is the same as the HELPPROMPT
 * global property default value
 * <p>
 * <b>HMILevel needs to be FULL, LIMITED or BACKGROUND</b>
 * </p>
 * 
 * @since SmartDeviceLink 1.0
 * @see SetGlobalProperties
 */
public class ResetGlobalProperties extends RPCRequest {
	public static final String KEY_PROPERTIES = "properties";
	/**
	 * Constructs a new ResetGlobalProperties object
	 */
    public ResetGlobalProperties() {
        super(FunctionID.RESET_GLOBAL_PROPERTIES.toString());
    }
	/**
	 * Constructs a new ResetGlobalProperties object indicated by the Hashtable
	 * parameter
	 * <p>
	 * 
	 * @param hash
	 *            The Hashtable to use
	 */    
    public ResetGlobalProperties(Hashtable<String, Object> hash) {
        super(hash);
    }
	/**
	 * Gets an array of one or more GlobalProperty enumeration elements
	 * indicating which global properties to reset to their default value
	 * 
	 * @return List<GlobalProperty> -an array of one or more GlobalProperty
	 *         enumeration elements
	 */    
    @SuppressWarnings("unchecked")
    public List<GlobalProperty> getProperties() {
    	if (parameters.get(KEY_PROPERTIES) instanceof List<?>) {
    		List<?> list = (List<?>)parameters.get(KEY_PROPERTIES);
	        if (list != null && list.size() > 0) {
	            Object obj = list.get(0);
	            if (obj instanceof GlobalProperty) {
	                return (List<GlobalProperty>) list;
	            } else if (obj instanceof String) {
	            	List<GlobalProperty> newList = new ArrayList<GlobalProperty>();
	                for (Object hashObj : list) {
	                    String strFormat = (String)hashObj;
	                    GlobalProperty toAdd = GlobalProperty.valueForString(strFormat);
	                    if (toAdd != null) {
	                        newList.add(toAdd);
	                    }
	                }
	                return newList;
	            }
	        }
    	}
        return null;
    }
	/**
	 * Sets an array of one or more GlobalProperty enumeration elements
	 * indicating which global properties to reset to their default value
	 * 
	 * @param properties
	 *            a List<GlobalProperty> An array of one or more
	 *            GlobalProperty enumeration elements indicating which global
	 *            properties to reset to their default value
	 *            <p>
	 *            <b>Notes: </b>Array must have at least one element
	 */    
    public void setProperties( List<GlobalProperty> properties ) {
        if (properties != null) {
            parameters.put(KEY_PROPERTIES, properties );
        } else {
        	parameters.remove(KEY_PROPERTIES);
        }
    }
}
