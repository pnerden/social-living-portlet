/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.lsp.liferay.portlet.socialliving.events.util;

/**
 * @author Brian Wing Shun Chan
 * @author Patrick Nerden
 */
public interface EventConstants {

	public static final int STATUS_MAYBE = 2;

	public static final int STATUS_NO = 0;

	public static final int STATUS_YES = 1;

	public static final int VISIBILITY_DEFAULT = 0;
	
	public static final int VISIBILITY_ALL = 1;

    public static final int VISIBILITY_GROUP = 2;

    public static final int VISIBILITY_OTHERGROUPS = 3;
    
    public static final String ADD_EVENT = "ADD_EVENT";
    
    public static final int FILTER_ALL_EVENTS = 1;
    
    public static final int FILTER_MY_EVENTS = 2;
    
    public static final int DEFAULT_DISPLAY_MAP_ON_VIEW = 0;
    public static final int DISPLAY_MAP_ON_VIEW = 1;
    public static final int DO_NOT_DISPLAY_MAP_ON_VIEW = 2;
    
    public static final String DEFAULT_LATITUDE = "50.653409319479486";
	public static final String DEFAULT_LONGITUDE = "3.0843311548233032";
	public static final String DEFAULT_ZOOM = "6";
	public static final String DEFAULT_VIEW_ZOOM = "18";
	public static final String DEFAULT_LOCATION = "120 Avenue de la République, 59700, Marcq-en-Barœul, Nord, Nord-Pas-de-Calais, France";
    public static final int ACTION_SEARCHMAP = 1;
	
}