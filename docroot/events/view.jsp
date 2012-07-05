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
String tabs1 = ParamUtil.getString(request, "tabs1", "all-events");

int filter = (tabs1.equals("all-events")) ? EventConstants.FILTER_ALL_EVENTS : EventConstants.FILTER_MY_EVENTS;

List<EventEntry> eventEntries = EventEntryServiceUtil.getEventEntries(themeDisplay, filter, displayVisibility);
%>

<c:if test="<%= (permissionChecker.hasPermission(groupId, \"org.lsp.liferay.portlet.socialliving.event\", groupId, EventConstants.ADD_EVENT) || (permissionChecker.isGroupAdmin(groupId))) %>">

	<%
	PortletURL portletURL = renderResponse.createRenderURL();
	%>

	<liferay-ui:tabs
		names="all-events,my-events"
		param="tabs1"
		url="<%= portletURL.toString() %>"
	/>

	<%
	PortletURL addEventEntryURL = renderResponse.createRenderURL();

	addEventEntryURL.setWindowState(WindowState.MAXIMIZED);

	addEventEntryURL.setParameter("mvcPath", "/events/edit_entry.jsp");
	addEventEntryURL.setParameter("redirect", currentURL);
	%>

	<%
        if ((displayVisibility == EventConstants.VISIBILITY_GROUP) || (displayVisibility == EventConstants.VISIBILITY_DEFAULT)) {
    %>
	<input onClick='location.href = "<%= addEventEntryURL.toString() %>"' type="button" value='<liferay-ui:message key="add-event" />' />
	<%
        }
    %>

	<br /><br />
</c:if>

<c:choose>

<c:when test="<%= eventEntries.size() > 0 %>">

<%
for (int i = 0; i < eventEntries.size(); i++) {
	EventEntry eventEntry = eventEntries.get(i);

	int yesTotal = EventRegistrationLocalServiceUtil.getEventRegistrationsCount(eventEntry.getEventEntryId(), EventConstants.STATUS_YES);
	
	PortletURL viewEventEntryURL = renderResponse.createRenderURL();

	viewEventEntryURL.setWindowState(WindowState.MAXIMIZED);
	viewEventEntryURL.setParameter("mvcPath", "/events/view_entry.jsp");
	viewEventEntryURL.setParameter("eventEntryId", String.valueOf(eventEntry.getEventEntryId()));

	String thumbnailURL = null;

	if (eventEntry.getThumbnailId() == 0) {
		thumbnailURL = request.getContextPath() + "/events/images/calendar.png";
	}
	else {
		thumbnailURL = themeDisplay.getPathImage() + "/events?img_id=" + eventEntry.getThumbnailId() + "&t=" + WebServerServletTokenUtil.getToken(eventEntry.getThumbnailId());
	}
%>

<aui:layout>
	<aui:column columnWidth="<%= ((displaymaponview == EventConstants.DISPLAY_MAP_ON_VIEW) || (displaymaponview == EventConstants.DEFAULT_DISPLAY_MAP_ON_VIEW)) ? 33 : 50 %>" first="true" id="eventThumbnailColumn" >
		<a href="<%= viewEventEntryURL %>" id="eventThumbnail"><img alt="<liferay-ui:message key="view-event" />" src="<%= thumbnailURL %>" /></a>
	</aui:column>
	<aui:column columnWidth="<%= ((displaymaponview == EventConstants.DISPLAY_MAP_ON_VIEW) || (displaymaponview == EventConstants.DEFAULT_DISPLAY_MAP_ON_VIEW)) ? 33 : 50 %>" last="<%= ((displaymaponview == EventConstants.DISPLAY_MAP_ON_VIEW) || (displaymaponview == EventConstants.DEFAULT_DISPLAY_MAP_ON_VIEW)) ? false : true %>" id="eventDetailsColumn" >
		<c:if test="<%= EventEntryServiceUtil.getVisibility(eventEntry) == EventConstants.VISIBILITY_GROUP %>">
			<span class="portlet-msg-info"><liferay-ui:message key="private" /></span>
		</c:if>
		<table id="eventDetailsTable">
			<tr>
				<td class="eventFirstTD"><liferay-ui:message key="group" /></td>
				<td><%= GroupLocalServiceUtil.getGroup(eventEntry.getGroupId()).getName() %></td>
			</tr>
			<tr class="eventAltTR">
				<td class="eventFirstTD"><liferay-ui:message key="title" /></td>
				<td><%= eventEntry.getTitle() %></td>
			</tr>
			<tr>
				<td class="eventFirstTD"><liferay-ui:message key="description" /></td>
				<td><%= eventEntry.getDescription() %></td>
			</tr>
			<tr class="eventAltTR">
				<td class="eventFirstTD"><liferay-ui:message key="event-location" /></td>
				<td><%= eventEntry.getLocation() %></td>
			</tr>
			<tr>
				<td class="eventFirstTD"><liferay-ui:message key="date" /></td>
				<td><%= dateFormatDateTime.format(eventEntry.getStartDate()) %> &#150; <%= dateFormatDateTime.format(eventEntry.getEndDate()) %></td>
			</tr>
		</table>
		<c:if test="<%= yesTotal > 1 %>">
		<table id="eventDetailsTable">
			<tr class="eventAltTR">
				<td class="eventFirstTD"><%= LanguageUtil.format(pageContext, "x-people-are-planning-to-attend-this-event", String.valueOf(yesTotal)) %></td>
			</tr>
		</table>
		</c:if>

		<br />			

		<liferay-ui:icon-list>

		<c:if test="<%= permissionChecker.hasPermission(groupId, \"org.lsp.liferay.portlet.socialliving.event\", groupId, EventConstants.ADD_EVENT) %>">

			<%
			PortletURL editEventEntryURL = renderResponse.createRenderURL();

			editEventEntryURL.setWindowState(WindowState.MAXIMIZED);

			editEventEntryURL.setParameter("mvcPath", "/events/edit_entry.jsp");
			editEventEntryURL.setParameter("redirect", currentURL);
			editEventEntryURL.setParameter("eventEntryId", String.valueOf(eventEntry.getEventEntryId()));
			%>

			<liferay-ui:icon image="edit" method="get" url="<%= editEventEntryURL.toString() %>" />
		</c:if>

		<liferay-ui:icon image="join" message="register" method="get" url="<%= viewEventEntryURL.toString() %>"	/>

		<c:if test="<%= permissionChecker.hasPermission(groupId, \"org.lsp.liferay.portlet.socialliving.model.EventEntry\", eventEntry.getEventEntryId(), \"DELETE\") %>">

			<%
			PortletURL deleteEventEntryURL = renderResponse.createActionURL();

			deleteEventEntryURL.setWindowState(WindowState.MAXIMIZED);

			deleteEventEntryURL.setParameter(ActionRequest.ACTION_NAME, "deleteEventEntry");
			deleteEventEntryURL.setParameter("redirect", currentURL);
			deleteEventEntryURL.setParameter("eventEntryId", String.valueOf(eventEntry.getEventEntryId()));
			%>

			<liferay-ui:icon-delete
				url="<%= deleteEventEntryURL.toString() %>"
			/>
		</c:if>
		</liferay-ui:icon-list>
	</aui:column>
	<c:if test="<%= ((displaymaponview == EventConstants.DISPLAY_MAP_ON_VIEW) || (displaymaponview == EventConstants.DEFAULT_DISPLAY_MAP_ON_VIEW)) %>">
	<aui:column columnWidth="33" last="true" id="eventMapColumn" >
		<lsp-osm:simplemap startLatitude="<%= eventEntry.getLatitude() %>" startLongitude="<%= eventEntry.getLongitude() %>" displayText="<%= StringEscapeUtils.escapeJavaScript(eventEntry.getLocation()) %>" occurenceId="<%= i %>"/>
	</aui:column>
	</c:if>
</aui:layout>

	<c:if test="<%= (i + 1) < eventEntries.size() %>">
		<div class="separator"><!-- --></div>
	</c:if>

<%
}
%>



</c:when>

<c:otherwise>

<span class="portlet-msg-info">
	<liferay-ui:message key="no-event-could-be-found" />
</span>

</c:otherwise>

</c:choose>