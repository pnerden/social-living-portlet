<%--
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
--%>

<%@ include file="/events/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");
String portletNameSpaceLatitude = portletNameSpace + "defaultlatitude";
String portletNameSpaceLongitude = portletNameSpace + "defaultlongitude";
String portletNameSpaceZoom = portletNameSpace + "defaultzoom";
String portletNameSpaceLocation = portletNameSpace + "defaultlocation";
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:layout>
	<aui:column columnWidth="33" first="true">
		<aui:form action="<%= configurationURL %>" method="post" name="fm">
			<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
			<aui:input name="redirect" type="hidden" value="<%= redirect %>" />

			<aui:fieldset>
				<aui:select label="visibility-to-display" name="preferences--displayVisibility--">
					<aui:option label="<%= LanguageUtil.get(pageContext, \"visibility-all\") %>" selected="<%= displayVisibility==EventConstants.VISIBILITY_ALL %>" value="<%= EventConstants.VISIBILITY_ALL %>" />
					<aui:option label="<%= LanguageUtil.get(pageContext, \"visibility-group\") %>" selected="<%= displayVisibility==EventConstants.VISIBILITY_GROUP || displayVisibility==EventConstants.VISIBILITY_DEFAULT %>" value="<%= EventConstants.VISIBILITY_GROUP %>" />
					<aui:option label="<%= LanguageUtil.get(pageContext, \"visibility-othergroups\") %>" selected="<%= displayVisibility==EventConstants.VISIBILITY_OTHERGROUPS %>" value="<%= EventConstants.VISIBILITY_OTHERGROUPS %>" />
				</aui:select>
			</aui:fieldset>
			<aui:fieldset>
				<aui:select label="display-map-on-view" name="preferences--displaymaponview--">
					<aui:option label="<%= LanguageUtil.get(pageContext, \"display-map-on-view\") %>" selected="<%= displaymaponview==EventConstants.DISPLAY_MAP_ON_VIEW || displaymaponview==EventConstants.DEFAULT_DISPLAY_MAP_ON_VIEW %>" value="<%= EventConstants.DISPLAY_MAP_ON_VIEW %>" />
					<aui:option label="<%= LanguageUtil.get(pageContext, \"do-not-display-map-on-view\") %>" selected="<%= displaymaponview==EventConstants.DO_NOT_DISPLAY_MAP_ON_VIEW %>" value="<%= EventConstants.DO_NOT_DISPLAY_MAP_ON_VIEW %>" />
				</aui:select>
			</aui:fieldset>
			<aui:fieldset>
				<liferay-ui:icon-help message="default-map-position-help" />
				<aui:input name="preferences--defaultlatitude--" label="default-latitude" type="text" value="<%= defaultlatitude %>" />
				<aui:input name="preferences--defaultlongitude--" label="default-longitude" type="text" value="<%= defaultlongitude %>" />
				<aui:input name="preferences--defaultzoom--" label="default-zoom" type="text" value="<%= defaultzoom %>" />
				<aui:input name="preferences--defaultlocation--" label="default-location" type="text" value="<%= defaultlocation %>" />
			</aui:fieldset>
	
			<aui:button-row>
				<aui:button type="submit" />
			</aui:button-row>
		</aui:form>
	</aui:column>
	
	<aui:column columnWidth="66" last="true">
		<span class="portlet-msg-info"><liferay-ui:message key="center-the-map-to-the-default-view-you-want" /></span>
		<lsp-osm:map occurenceId="0" startLatitude="<%= defaultlatitude %>" startLongitude="<%= defaultlongitude %>" startZoom="<%= defaultzoom %>" locationMarkerActive="true" locationLatitudeFieldIdBind="<%= portletNameSpaceLatitude %>" locationLongitudeFieldIdBind="<%= portletNameSpaceLongitude %>" locationZoomFieldIdBind="<%= portletNameSpaceZoom %>" locationLocationFieldIdBind="<%= portletNameSpaceLocation %>" />
	</aui:column>
</aui:layout>