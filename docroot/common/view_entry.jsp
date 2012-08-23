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
Portlet portlet = PortletLocalServiceUtil.getPortletById(companyId, portletDisplay.getId());
%>

<link href="<%= request.getContextPath() %>/events/css.jsp?themeId=<%= themeDisplay.getTheme().getThemeId() %>&amp;colorSchemeId=<%= themeDisplay.getColorScheme().getColorSchemeId() %>&amp;t=<%= portlet.getTimestamp() %>" rel="stylesheet" type="text/css" />

<%
String tabs1 = ParamUtil.getString(request, "tabs1", "attending");

String redirect = ParamUtil.getString(request, "redirect");

long eventEntryId = ParamUtil.getLong(request, "eventEntryId");

EventEntry eventEntry = null;

try {
	eventEntry = EventEntryServiceUtil.getEventEntry(companyId, eventEntryId);
}
catch (NoSuchEventEntryException nsmee) {
%>

	<span class="portlet-msg-error">
		<liferay-ui:message key="the-event-could-not-be-found" />
	</span>

<%
	return;
}

EventRegistration eventRegistration = null;

try {
	eventRegistration = EventRegistrationLocalServiceUtil.getEventRegistration(themeDisplay.getUserId(), eventEntryId);
}
catch (NoSuchEventRegistrationException nsmre) {
}

int status = EventConstants.STATUS_YES;

if (eventRegistration != null) {
	status = eventRegistration.getStatus();
}

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("mvcPath", "/common/view_entry.jsp");
portletURL.setParameter("tabs1", tabs1);
portletURL.setParameter("redirect", redirect);
portletURL.setParameter("eventEntryId", String.valueOf(eventEntryId));

String thumbnailURL = null;

if (eventEntry.getThumbnailId() == 0) {
	thumbnailURL = request.getContextPath() + "/common/images/calendar.png";
}
else {
	thumbnailURL = themeDisplay.getPathImage() + "/events?img_id=" + eventEntry.getThumbnailId() + "&t=" + WebServerServletTokenUtil.getToken(eventEntry.getThumbnailId());
}

int yesTotal = EventRegistrationLocalServiceUtil.getEventRegistrationsCount(eventEntryId, EventConstants.STATUS_YES);
%>

<c:if test="<%= EventEntryServiceUtil.getVisibility(eventEntry) == EventConstants.VISIBILITY_GROUP %>">
        <span class="portlet-msg-info"><liferay-ui:message key="private" /></span>
</c:if>

<aui:layout>
	<aui:column columnWidth="33" first="true">
		<p><img alt="" src="<%= thumbnailURL %>" style="float: left; margin-right: 10px;" /></p>
		<p>
		<%
		if (eventEntry.getWithSpouse()) {
		%>
		<img alt="with-spouse" src="<%=request.getContextPath()%>/common/images/spouse-allowed.png" />
		<%
		} else {
		%>
		<img alt="without-spouse" src="<%=request.getContextPath()%>/common/images/spouse-not-allowed.png" />
		<%
		}
		%>
		&nbsp;
		<%
		if (eventEntry.getWithChildren()) {
		%>
		<img alt="with-children" src="<%=request.getContextPath()%>/common/images/children-allowed.png" />
		<%
		} else {
		%>
		<img alt="without-children" src="<%=request.getContextPath()%>/common/images/children-not-allowed.png" />
		<%
		}
		%>
		</p>
	</aui:column>
	<aui:column columnWidth="33">
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
				<td><liferay-ui:message key="from" /> : <%= dateFormatDateTime.format(eventEntry.getStartDate()) %> <br /><liferay-ui:message key="to" /> : <%= dateFormatDateTime.format(eventEntry.getEndDate()) %></td>
			</tr>
			<tr>
				<td class="eventFirstTD"><liferay-ui:message key="price" /></td>
				<td><%= (eventEntry.getPrice() > 0) ? eventEntry.getPrice() : LanguageUtil.get(pageContext, "free") %></td>
			</tr>
			<tr>
				<td class="eventFirstTD"><liferay-ui:message key="details" /></td>
				<td>
					<%
					if (eventEntry.getWithSpouse()) {
					%>
					<liferay-ui:message key="spouse-allowed" />
					<%
					} else {
					%>
					<liferay-ui:message key="spouse-not-allowed" />
					<%
					}
					%>
					<br />
					<%
					if (eventEntry.getWithChildren()) {
					%>
					<liferay-ui:message key="children-allowed" />
					<%
					} else {
					%>
					<liferay-ui:message key="children-not-allowed" />
					<%
					}
					%>
				</td>
			</tr>
		</table>
		<c:if test="<%= yesTotal > 1 %>">
			<table id="eventDetailsTable">
				<tr class="eventAltTR">
					<td class="eventFirstTD"><%= LanguageUtil.format(pageContext, "x-people-are-planning-to-attend-this-event", String.valueOf(yesTotal)) %></td>
				</tr>
			</table>
		</c:if>
		
		<c:choose>
			<c:when test="<%= themeDisplay.isSignedIn() %>">
			
				<br />
			
				<form action="<portlet:actionURL name="updateEventRegistration" />" method="post" name="<portlet:namespace />fm" onSubmit="<portlet:namespace />updateEventRegistration(); return false;">
				<input name="<portlet:namespace />redirect" type="hidden" value="<%= currentURL %>" />
				<input name="<portlet:namespace />eventEntryId" type="hidden" value="<%= eventEntryId %>" />
		
				<liferay-ui:message key="will-you-attend" />
		
				<input <%= (status == EventConstants.STATUS_YES) ? "checked" : "" %> name="<portlet:namespace />status" type="radio" value="<%= EventConstants.STATUS_YES %>" /> <liferay-ui:message key="yes" />
		
				<input <%= (status == EventConstants.STATUS_NO) ? "checked" : "" %> name="<portlet:namespace />status" type="radio" value="<%= EventConstants.STATUS_NO %>" /> <liferay-ui:message key="no" />
		
				<input <%= (status == EventConstants.STATUS_MAYBE) ? "checked" : "" %> name="<portlet:namespace />status" type="radio" value="<%= EventConstants.STATUS_MAYBE %>" /> <liferay-ui:message key="maybe" />
		
				<br /><br />
		
				<liferay-ui:input-field bean="<%= eventRegistration %>" field="comments" model="<%= EventRegistration.class %>" />
		
				<br /><br />
		
				<input type="submit" value="<liferay-ui:message key="register" />" />
		
				</form>
		
				<br />
		
				<liferay-ui:tabs
					names="attending,not-attending,maybe-attending"
					portletURL="<%= portletURL %>"
				/>
		
				<%
				int tabs1Status = EventConstants.STATUS_YES;
		
				if (tabs1.equals("not-attending")) {
					tabs1Status = EventConstants.STATUS_NO;
				}
				else if (tabs1.equals("maybe-attending")) {
					tabs1Status = EventConstants.STATUS_MAYBE;
				}
		
				SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 10, portletURL, null, null);
		
				int total = EventRegistrationLocalServiceUtil.getEventRegistrationsCount(eventEntryId, tabs1Status);
		
				searchContainer.setTotal(total);
		
				List<EventRegistration> results = EventRegistrationLocalServiceUtil.getEventRegistrations(eventEntryId, tabs1Status, searchContainer.getStart(), searchContainer.getEnd());
		
				for (EventRegistration curEventRegistration : results) {
				%>
		
					<div class="response">
						<liferay-ui:user-display
							displayStyle="<%= 2 %>"
							userId="<%= curEventRegistration.getUserId() %>"
							userName="<%= curEventRegistration.getUserName() %>"
						/>
		
						<c:if test="<%= Validator.isNotNull(curEventRegistration.getComments()) %>">
							<div class="comments">
								<%= curEventRegistration.getComments() %>
		
								<span class="indicator"></span>
							</div>
						</c:if>
					</div>
		
				<%
				}
				%>
		
				<div class="taglib-search-iterator-page-iterator-bottom">
					<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
				</div>
		
				<aui:script use="aui-base">
					var event = A.one('.social-living-portlet-events');
		
					if (event) {
						event.delegate(
							'mouseenter',
							function(event) {
								event.currentTarget.addClass('hovering');
							},
							'.response'
						);
		
						event.delegate(
							'mouseleave',
							function(event) {
								event.currentTarget.removeClass('hovering');
							},
							'.response'
						);
					}
				</aui:script>
			</c:when>
			<c:otherwise>
				<div>
					<liferay-ui:message arguments='<%= new Object[] {themeDisplay.getURLSignIn(), PortalUtil.getCreateAccountURL(request, themeDisplay)} %>' key="you-have-to-be-signed-in-to-register-for-this-event" />
				</div>
			</c:otherwise>
		</c:choose>
		
	</aui:column>
	<aui:column columnWidth="33" last="true">
		<lsp-osm:simplemap startLatitude="<%= eventEntry.getLatitude() %>" startLongitude="<%= eventEntry.getLongitude() %>" displayText="<%= StringEscapeUtils.escapeJavaScript(eventEntry.getLocation()) %>" mapWidth="384" mapHeight="384" />
	</aui:column>
</aui:layout>