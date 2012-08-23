<%--
/**
 * Copyright (c) Patrick NERDEN. All rights reserved.
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
--%>

<%@ include file="/init.jsp" %>

<%
PortletPreferences preferences = renderRequest.getPreferences();
		 
String portletResource = ParamUtil.getString(request, "portletResource");
String portletNameSpace = "_"+request.getAttribute("PORTLET_ID")+"_";

if (Validator.isNotNull(portletResource)) {
	preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}

int displayVisibility = GetterUtil.getInteger(preferences.getValue("displayVisibility", String.valueOf(EventConstants.VISIBILITY_DEFAULT)));
String defaultlatitude = preferences.getValue("defaultlatitude", String.valueOf(EventConstants.DEFAULT_LATITUDE));
String defaultlongitude = preferences.getValue("defaultlongitude", String.valueOf(EventConstants.DEFAULT_LONGITUDE));
String defaultzoom = preferences.getValue("defaultzoom", String.valueOf(EventConstants.DEFAULT_ZOOM));

long companyId = company.getCompanyId();
long groupId = themeDisplay.getScopeGroupIdOrLiveGroupId();
String portalURL = themeDisplay.getPortalURL();
%>