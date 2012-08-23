<%@ include file="/events_management/init.jsp" %>

<%
List<EventEntry> eventEntries = EventEntryServiceUtil.getEventEntries(themeDisplay, EventConstants.FILTER_ALL_EVENTS, EventConstants.VISIBILITY_GROUP, ActionKeys.UPDATE, false);
Collections.reverse(eventEntries);
%>

<c:if test="<%= (permissionChecker.hasPermission(groupId, \"org.lsp.liferay.portlet.socialliving.event\", groupId, EventConstants.ADD_EVENT) || (permissionChecker.isGroupAdmin(groupId))) %>">

	<%
	PortletURL addEventEntryURL = renderResponse.createRenderURL();

	addEventEntryURL.setWindowState(WindowState.MAXIMIZED);

	addEventEntryURL.setParameter("mvcPath", "/common/edit_entry.jsp");
	addEventEntryURL.setParameter("redirect", currentURL);
	%>

	<input onClick='location.href = "<%= addEventEntryURL.toString() %>"' type="button" value='<liferay-ui:message key="add-event" />' />

</c:if>

<c:choose>
	<c:when test="<%= eventEntries.size() > 0 %>">
	
	<table id="eventManagementTable">
		<tr>
			<th><liferay-ui:message key="group" /></th>
			<th><liferay-ui:message key="title" /></th>
			<th><liferay-ui:message key="description" /></th>
			<th><liferay-ui:message key="event-location" /></th>
			<th><liferay-ui:message key="date" /></th>
			<th><liferay-ui:message key="price" /></th>
			<th><liferay-ui:message key="already-registered" /></th>
			<th><liferay-ui:message key="private" /> ?</th>
			<th><liferay-ui:message key="actions" /></th>
		</tr>
	
	
	
	<%
	for (int i = 0; i < eventEntries.size(); i++) {
		EventEntry eventEntry = eventEntries.get(i);
	
		int yesTotal = EventRegistrationLocalServiceUtil.getEventRegistrationsCount(eventEntry.getEventEntryId(), EventConstants.STATUS_YES);
	%>
			
				<tr>
					<td><%= GroupLocalServiceUtil.getGroup(eventEntry.getGroupId()).getName() %></td>
					<td><%= eventEntry.getTitle() %></td>
					<td><%= eventEntry.getDescription() %></td>
					<td><%= eventEntry.getLocation() %></td>
					<td><liferay-ui:message key="from" />&nbsp;:&nbsp;<%= dateFormatDateTime.format(eventEntry.getStartDate()) %><br /><liferay-ui:message key="to" />&nbsp;:&nbsp;<%= dateFormatDateTime.format(eventEntry.getEndDate()) %></td>
					<td><%= (eventEntry.getPrice() > 0) ? eventEntry.getPrice() : LanguageUtil.get(pageContext, "free") %></td>
					<td><%= String.valueOf(yesTotal) %></td>
					<td>
						<c:if test="<%= EventEntryServiceUtil.getVisibility(eventEntry) == EventConstants.VISIBILITY_GROUP %>">
							<span class="portlet-msg-info"><liferay-ui:message key="private" /></span>
						</c:if>
					</td>
					<td>
						<liferay-ui:icon-list>
						
							<%
							PortletURL viewEventEntryURL = renderResponse.createRenderURL();

							viewEventEntryURL.setWindowState(WindowState.MAXIMIZED);
							viewEventEntryURL.setParameter("mvcPath", "/common/view_entry.jsp");
							viewEventEntryURL.setParameter("eventEntryId", String.valueOf(eventEntry.getEventEntryId()));
							%>
				
							<liferay-ui:icon image="view" method="get" url="<%= viewEventEntryURL.toString() %>" />
										
						<c:if test="<%= permissionChecker.hasPermission(groupId, \"org.lsp.liferay.portlet.socialliving.event\", groupId, EventConstants.ADD_EVENT) %>">
				
							<%
							PortletURL editEventEntryURL = renderResponse.createRenderURL();
				
							editEventEntryURL.setWindowState(WindowState.MAXIMIZED);
				
							editEventEntryURL.setParameter("mvcPath", "/common/edit_entry.jsp");
							editEventEntryURL.setParameter("redirect", currentURL);
							editEventEntryURL.setParameter("eventEntryId", String.valueOf(eventEntry.getEventEntryId()));
							%>
				
							<liferay-ui:icon image="edit" method="get" url="<%= editEventEntryURL.toString() %>" />
						</c:if>
				
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
	
					</td>
				</tr>
	
			
	
	<%
	}
	%>
		</table>
	</c:when>
	
	<c:otherwise>
	
	<span class="portlet-msg-info">
		<liferay-ui:message key="no-event-could-be-found" />
	</span>
	
		
	
	</c:otherwise>
</c:choose>