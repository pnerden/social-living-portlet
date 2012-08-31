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

<%@ include file="/events_map/init.jsp" %>

<%
List<EventEntry> eventEntries = EventEntryServiceUtil.getEventEntries(themeDisplay, EventConstants.FILTER_ALL_EVENTS, displayVisibility, ActionKeys.VIEW);

if (eventEntries.size() > 0) {
	List<GeolocalizationPlot> plotList = new Vector<GeolocalizationPlot>();
			 
	Iterator<EventEntry> iter = eventEntries.iterator();
	while (iter.hasNext()) {
		GeolocalizationPlot plot = new GeolocalizationPlot();
		EventEntry entry = iter.next();
		Group entryGroup = GroupLocalServiceUtil.getGroup(entry.getGroupId());
				
		PortletURL viewEventEntryURL = renderResponse.createRenderURL();

		viewEventEntryURL.setWindowState(WindowState.MAXIMIZED);
		viewEventEntryURL.setParameter("mvcPath", "/common/view_entry.jsp");
		viewEventEntryURL.setParameter("eventEntryId", String.valueOf(entry.getEventEntryId()));
		
		plot.setDescription(StringEscapeUtils.escapeJavaScript(EventsMapPortletUtil.getEventPlotDescription(entry, entryGroup, viewEventEntryURL, themeDisplay, request)));
		plot.setLatitude(entry.getLatitude());
		plot.setLongitude(entry.getLongitude());
		plotList.add(plot);
	}
	%>
	
	<lsp-osm:map startLatitude="<%= defaultlatitude %>" startLongitude="<%= defaultlongitude %>" startZoom="<%= defaultzoom %>" plotList="<%= plotList %>" mapWidth="450" mapHeight="450" />

<%
} else {
	%>
	
	<span class="portlet-msg-info">
		<liferay-ui:message key="no-event-could-be-found" />
	</span>
	
	<%
}
%>