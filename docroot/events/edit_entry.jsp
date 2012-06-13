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

long eventEntryId = ParamUtil.getLong(request, "eventEntryId");

EventEntry eventEntry = null;

try {
	eventEntry = EventEntryServiceUtil.getEventEntry(companyId, eventEntryId);
}
catch (NoSuchEventEntryException nsmee) {
}

Calendar startDate = CalendarFactoryUtil.getCalendar(timeZone, locale);

startDate.add(Calendar.MONTH, 1);

if (eventEntry != null) {
	if (eventEntry.getStartDate() != null) {
		startDate.setTime(eventEntry.getStartDate());
	}
}

Calendar endDate = CalendarFactoryUtil.getCalendar(timeZone, locale);

endDate.add(Calendar.MONTH, 1);
endDate.add(Calendar.HOUR, 3);

if (eventEntry != null) {
	if (eventEntry.getStartDate() != null) {
		endDate.setTime(eventEntry.getEndDate());
	}
}

String latitude = defaultlatitude;
String longitude = defaultlongitude;
String zoom = defaultzoom;

if (eventEntry != null) {
	latitude = (eventEntry.getLatitude() != null) ? eventEntry.getLatitude() : defaultlatitude;
	longitude = (eventEntry.getLongitude() != null) ? eventEntry.getLongitude() : defaultlongitude;
	zoom = (eventEntry.getLatitude() != null) ? EventConstants.DEFAULT_VIEW_ZOOM : defaultzoom;
}

int visibility = EventConstants.VISIBILITY_DEFAULT;
if (eventEntry != null) {
        visibility = EventEntryServiceUtil.getVisibility(eventEntry);
}

String portletNameSpaceLatitude = portletNameSpace + "latitude";
String portletNameSpaceLongitude = portletNameSpace + "longitude";
String portletNameSpaceLocation = portletNameSpace + "location";

%>

<aui:layout>
	<aui:column columnWidth="33" first="true">
		<form action="<portlet:actionURL name="updateEventEntry"><portlet:param name="redirect" value="<%= redirect %>" /></portlet:actionURL>" enctype="multipart/form-data" method="post" name="<portlet:namespace />fm" onSubmit="<portlet:namespace />updateEventEntry(); return false;">
		<input name="<portlet:namespace />eventEntryId" type="hidden" value="<%= eventEntryId %>" />
		
		<table class="lfr-table">
		<tr>
			<td>
				<liferay-ui:message key="title" />
			</td>
			<td>
				<liferay-ui:input-field bean="<%= eventEntry %>" field="title" model="<%= EventEntry.class %>" />
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="description" />
			</td>
			<td>
				<liferay-ui:input-field bean="<%= eventEntry %>" field="description" model="<%= EventEntry.class %>" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<br />
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="event-location" />
			</td>
			<td>
				<liferay-ui:input-field bean="<%= eventEntry %>" field="location" model="<%= EventEntry.class %>" />
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="latitude" />
			</td>
			<td>
				<input type="text" name="<portlet:namespace />latitude" id="<portlet:namespace />latitude" value="<%= latitude %>" />
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="longitude" />
			</td>
			<td>
				<input type="text" name="<portlet:namespace />longitude" id="<portlet:namespace />longitude" value="<%= longitude %>" />
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="start-date" />
			</td>
			<td>
				<liferay-ui:input-field bean="<%= eventEntry %>" defaultValue="<%= startDate %>" field="startDate" model="<%= EventEntry.class %>" />
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="end-date" />
			</td>
			<td>
				<liferay-ui:input-field bean="<%= eventEntry %>" defaultValue="<%= endDate %>" field="endDate" model="<%= EventEntry.class %>" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<br />
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="max-attendees" />
			</td>
			<td>
				<liferay-ui:input-field bean="<%= eventEntry %>" field="maxAttendees" model="<%= EventEntry.class %>" />
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="price" />
			</td>
			<td>
				<liferay-ui:input-field bean="<%= eventEntry %>" field="price" model="<%= EventEntry.class %>" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<br />
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="thumbnail" />
			</td>
			<td>
				<input name="<portlet:namespace />fileName" size="50" type="file" />
			</td>
		</tr>
		<tr>
		        <td>
		                <liferay-ui:message key="visibility" />
		        </td>
		        <td>
		                <select name="<portlet:namespace />visibility">
		                        <aui:option label="<%= LanguageUtil.get(pageContext, \"visibility-group\") %>" selected="<%= visibility==EventConstants.VISIBILITY_GROUP || visibility==EventConstants.VISIBILITY_DEFAULT%>" value="<%= EventConstants.VISIBILITY_GROUP %>" />
		                        <aui:option label="<%= LanguageUtil.get(pageContext, \"visibility-all\") %>" selected="<%= visibility==EventConstants.VISIBILITY_ALL %>" value="<%= EventConstants.VISIBILITY_ALL %>" />
		                </select>
		                <liferay-ui:icon-help message="visibility-help" />
		        </td>
		</tr>
		</table>
		
		<br />
		
		<input type="submit" value="<liferay-ui:message key="save" />" />
		
		<input type="button" value="<liferay-ui:message key="cancel" />" onClick="location.href = '<%= HtmlUtil.escape(PortalUtil.escapeRedirect(redirect)) %>';" />
		
		</form>
	</aui:column>
	
	<aui:column columnWidth="66" last="true">
		<lsp-osm:map occurenceId="0" startLatitude="<%= latitude %>" startLongitude="<%= longitude %>" startZoom="<%= zoom %>" locationMarkerActive="true" locationLatitudeFieldIdBind="<%= portletNameSpaceLatitude %>" locationLongitudeFieldIdBind="<%= portletNameSpaceLongitude %>" locationLocationFieldIdBind="<%= portletNameSpaceLocation %>" mapWidth="384" mapHeight="384" />
	</aui:column>
</aui:layout>

<aui:script>
	function <portlet:namespace />updateEventEntry() {
		submitForm(document.<portlet:namespace />fm);
	};
</aui:script>