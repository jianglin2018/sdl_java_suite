package com.smartdevicelink.proxy.rpc;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.smartdevicelink.proxy.RPCStruct;
import com.smartdevicelink.proxy.rpc.enums.DisplayType;
import com.smartdevicelink.proxy.rpc.enums.MediaClockFormat;
import com.smartdevicelink.util.DebugTool;
/**
 * Contains information about the display for the SDL system to which the application is currently connected.
  * <p><b> Parameter List
 * <table border="1" rules="all">
 * 		<tr>
 * 			<th>Name</th>
 * 			<th>Type</th>
 * 			<th>Description</th>
 * 			<th>SmartDeviceLink Ver. Available</th>
 * 		</tr>
 * 		<tr>
 * 			<td>displayType</td>
 * 			<td>DisplayType</td>
 * 			<td>The type of display
 *			</td>
 * 			<td>SmartDeviceLink 1.0</td>
 * 		</tr>
 * 		<tr>
 * 			<td>textField</td>
 * 			<td>TextField[]</td>
 * 			<td>An array of TextField structures, each of which describes a field in the HMI which the application can write to using operations such as <i>{@linkplain Show}</i>, <i>{@linkplain SetMediaClockTimer}</i>, etc. 
 *					 This array of TextField structures identify all the text fields to which the application can write on the current display (identified by DisplayType ).
 * 			</td>
 * 			<td>SmartDeviceLink 1.0</td>
 * 		</tr>
 *     <tr>
 * 			<td>mediaClockFormats</td>
 * 			<td>MediaClockFormat[]</td>
 * 			<td>An array of MediaClockFormat elements, defining the valid string formats used in specifying the contents of the media clock field</td>
 * 			<td>SmartDeviceLink 1.0</td>
 * 		</tr>
 *     <tr>
 * 			<td>graphicSupported</td>
 * 			<td>Boolean</td>
 * 			<td>The display's persistent screen supports referencing a static or dynamic image.</td>
 * 			<td>SmartDeviceLink 2.0</td>
 * 		</tr>
 * </table>
 * @since SmartDeviceLink 1.0
 */
public class DisplayCapabilities extends RPCStruct {
	public static final String displayType = "displayType";
	public static final String mediaClockFormats = "mediaClockFormats";
	public static final String textFields = "textFields";
	public static final String imageFields = "imageFields";
    public static final String graphicSupported = "graphicSupported";
    public static final String screenParams = "screenParams";
    public static final String templatesAvailable = "templatesAvailable";
    public static final String numCustomPresetsAvailable = "numCustomPresetsAvailable";
	/**
	 * Constructs a newly allocated DisplayCapabilities object
	 */
    public DisplayCapabilities() { }
    /**
     * Constructs a newly allocated DisplayCapabilities object indicated by the Hashtable parameter
     * @param hash The Hashtable to use
     */    
    public DisplayCapabilities(Hashtable hash) {
        super(hash);
    }
    /**
     * Get the type of display
     * @return the type of display
     */    
    public DisplayType getDisplayType() {
        Object obj = store.get(DisplayCapabilities.displayType);
        if (obj instanceof DisplayType) {
            return (DisplayType) obj;
        } else if (obj instanceof String) {
            DisplayType theCode = null;
            try {
                theCode = DisplayType.valueForString((String) obj);
            } catch (Exception e) {
            	DebugTool.logError("Failed to parse " + getClass().getSimpleName() + "." + DisplayCapabilities.displayType, e);
            }
            return theCode;
        }
        return null;
    }
    /**
     * Set the type of display
     * @param displayType the display type
     */    
    public void setDisplayType( DisplayType displayType ) {
        if (displayType != null) {
            store.put(DisplayCapabilities.displayType, displayType );
        }
    }
    /**
     *Get an array of TextField structures, each of which describes a field in the HMI which the application can write to using operations such as <i>{@linkplain Show}</i>, <i>{@linkplain SetMediaClockTimer}</i>, etc. 
     *	 This array of TextField structures identify all the text fields to which the application can write on the current display (identified by DisplayType ).
     * @return the List of textFields
     */    
    public List<TextField> getTextFields() {
        if (store.get(DisplayCapabilities.textFields) instanceof List<?>) {
        	List<?> list = (List<?>)store.get(DisplayCapabilities.textFields);
	        if (list != null && list.size() > 0) {
	            Object obj = list.get(0);
	            if (obj instanceof TextField) {
	                return (List<TextField>) list;
	            } else if (obj instanceof Hashtable) {
	            	List<TextField> newList = new ArrayList<TextField>();
	                for (Object hashObj : list) {
	                    newList.add(new TextField((Hashtable)hashObj));
	                }
	                return newList;
	            }
	        }
        }
        return null;
    }
    /**
     * Set an array of TextField structures, each of which describes a field in the HMI which the application can write to using operations such as <i>{@linkplain Show}</i>, <i>{@linkplain SetMediaClockTimer}</i>, etc. 
     *	 This array of TextField structures identify all the text fields to which the application can write on the current display (identified by DisplayType ).
     * @param textFields the List of textFields
     */    
    public void setTextFields( List<TextField> textFields ) {
        if (textFields != null) {
            store.put(DisplayCapabilities.textFields, textFields );
        }
    }
    
    
    
    public List<TextField> getImageFields() {
        if (store.get(DisplayCapabilities.imageFields) instanceof List<?>) {
        	List<?> list = (List<?>)store.get(DisplayCapabilities.imageFields);
	        if (list != null && list.size() > 0) {
	            Object obj = list.get(0);
	            if (obj instanceof TextField) {
	                return (List<TextField>) list;
	            } else if (obj instanceof Hashtable) {
	            	List<TextField> newList = new ArrayList<TextField>();
	                for (Object hashObj : list) {
	                    newList.add(new TextField((Hashtable)hashObj));
	                }
	                return newList;
	            }
	        }
        }
        return null;
    }
  
    public void setImageFields( List<TextField> imageFields ) {
        if (imageFields != null) {
            store.put(DisplayCapabilities.imageFields, imageFields );
        }
        else
        {
        	store.remove(DisplayCapabilities.imageFields);
        }
    }    
    
    public Integer getNumCustomPresetsAvailable() {
        return (Integer) store.get(DisplayCapabilities.numCustomPresetsAvailable);
    }
 
    public void setNumCustomPresetsAvailable(Integer numCustomPresetsAvailable) {
        if (numCustomPresetsAvailable != null) {
            store.put(DisplayCapabilities.numCustomPresetsAvailable, numCustomPresetsAvailable);
        }
        else
        {
        	store.remove(DisplayCapabilities.numCustomPresetsAvailable);
        }
    }
      
    /**
     * Get an array of MediaClockFormat elements, defining the valid string formats used in specifying the contents of the media clock field
     * @return the Veotor of mediaClockFormat
     */    
    public List<MediaClockFormat> getMediaClockFormats() {
        if (store.get(DisplayCapabilities.mediaClockFormats) instanceof List<?>) {
        	List<?> list = (List<?>)store.get(DisplayCapabilities.mediaClockFormats);
	        if (list != null && list.size() > 0) {
	            Object obj = list.get(0);
	            if (obj instanceof MediaClockFormat) {
	                return (List<MediaClockFormat>) list;
	            } else if (obj instanceof String) {
	            	List<MediaClockFormat> newList = new ArrayList<MediaClockFormat>();
	                for (Object hashObj : list) {
	                    String strFormat = (String)hashObj;
	                    MediaClockFormat toAdd = null;
	                    try {
	                        toAdd = MediaClockFormat.valueForString(strFormat);
	                    } catch (Exception e) {
	                        DebugTool.logError("Failed to parse MediaClockFormat from " + getClass().getSimpleName() + "." + DisplayCapabilities.mediaClockFormats, e);
	                    }
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
     * Set an array of MediaClockFormat elements, defining the valid string formats used in specifying the contents of the media clock field
     * @param mediaClockFormats the List of MediaClockFormat
     */    
    public void setMediaClockFormats( List<MediaClockFormat> mediaClockFormats ) {
        if (mediaClockFormats != null) {
            store.put(DisplayCapabilities.mediaClockFormats, mediaClockFormats );
        }
    }
    
    /**
     * set the display's persistent screen supports.
     * @param graphicSupported
     * @since SmartDeviceLink 2.0
     */
    public void setGraphicSupported(Boolean graphicSupported) {
    	if (graphicSupported != null) {
    		store.put(DisplayCapabilities.graphicSupported, graphicSupported);
    	} else {
    		store.remove(DisplayCapabilities.graphicSupported);
    	}
    }
    
    /**
     * Get the display's persistent screen supports.
     * @return Boolean get the value of graphicSupported
     * @since SmartDeviceLink 2.0
     */
    public Boolean getGraphicSupported() {
    	return (Boolean) store.get(DisplayCapabilities.graphicSupported);
    }
    
    public List<String> getTemplatesAvailable() {
        if (store.get(DisplayCapabilities.templatesAvailable) instanceof List<?>) {
        	List<?> list = (List<?>)store.get( DisplayCapabilities.templatesAvailable);
        	if (list != null && list.size() > 0) {
        		Object obj = list.get(0);
        		if (obj instanceof String) {
                	return (List<String>) list;
        		}
        	}
        }
        return null;
    }   
    
    public void setTemplatesAvailable(List<String> templatesAvailable) {
        if (templatesAvailable != null) {
            store.put(DisplayCapabilities.templatesAvailable, templatesAvailable);
        }
        else
        {
        	store.remove(DisplayCapabilities.templatesAvailable);
        }        
    }
        
    public void setScreenParams(ScreenParams screenParams) {
        if (screenParams != null) {
            store.put(DisplayCapabilities.screenParams, screenParams);
        } else {
            store.remove(DisplayCapabilities.screenParams);
        }
    }

    public ScreenParams getScreenParams() {
        Object obj = store.get(DisplayCapabilities.screenParams);
        if (obj instanceof ScreenParams) {
            return (ScreenParams) obj;
        } else if (obj instanceof Hashtable) {
            try {
                return new ScreenParams((Hashtable) obj);
            } catch (Exception e) {
                DebugTool.logError("Failed to parse " + getClass().getSimpleName() + "." + DisplayCapabilities.screenParams, e);
            }
        }
        return null;
    }     
}
