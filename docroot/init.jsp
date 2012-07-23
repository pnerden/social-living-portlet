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

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://lsp.org/tld/osm" prefix="lsp-osm" %>

<%@ page import="com.liferay.portal.NoSuchUserException" %><%@
page import="com.liferay.portal.kernel.dao.search.ResultRow" %><%@
page import="com.liferay.portal.kernel.dao.search.SearchContainer" %><%@
page import="com.liferay.portal.kernel.language.LanguageUtil" %><%@
page import="com.liferay.portal.kernel.messaging.DestinationNames" %><%@
page import="com.liferay.portal.kernel.messaging.MessageBusUtil" %><%@
page import="com.liferay.portal.kernel.portlet.LiferayPortletURL" %><%@
page import="com.liferay.portal.kernel.util.CalendarFactoryUtil" %><%@
page import="com.liferay.portal.kernel.util.Constants" %><%@
page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil" %><%@
page import="com.liferay.portal.kernel.util.GetterUtil" %><%@
page import="com.liferay.portal.kernel.util.HtmlUtil" %><%@
page import="com.liferay.portal.kernel.util.ParamUtil" %><%@
page import="com.liferay.portal.kernel.util.StringPool" %><%@
page import="com.liferay.portal.kernel.util.Validator" %><%@
page import="com.liferay.portal.kernel.util.WebKeys" %><%@
page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %><%@
page import="com.liferay.portal.model.Contact" %><%@
page import="com.liferay.portal.model.Group" %><%@
page import="com.liferay.portal.model.GroupConstants" %><%@
page import="com.liferay.portal.model.Layout" %><%@
page import="com.liferay.portal.model.LayoutConstants" %><%@
page import="com.liferay.portal.model.Organization" %><%@
page import="com.liferay.portal.model.Portlet" %><%@
page import="com.liferay.portal.model.User" %><%@
page import="com.liferay.portal.security.permission.ActionKeys" %><%@
page import="com.liferay.portal.service.GroupLocalServiceUtil" %><%@
page import="com.liferay.portal.service.LayoutLocalServiceUtil" %><%@
page import="com.liferay.portal.service.OrganizationLocalServiceUtil" %><%@
page import="com.liferay.portal.service.PortletLocalServiceUtil" %><%@
page import="com.liferay.portal.service.UserLocalServiceUtil" %><%@
page import="com.liferay.portal.service.permission.UserPermissionUtil" %><%@
page import="com.liferay.portal.util.PortalUtil" %><%@
page import="com.liferay.portal.util.PortletKeys" %><%@
page import="com.liferay.portal.util.comparator.UserLoginDateComparator" %><%@
page import="com.liferay.portal.webserver.WebServerServletTokenUtil" %><%@
page import="com.liferay.portlet.PortletPreferencesFactoryUtil" %><%@
page import="com.liferay.portlet.blogs.service.BlogsStatsUserLocalServiceUtil" %><%@
page import="com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil" %><%@
page import="com.liferay.portlet.messageboards.service.MBStatsUserLocalServiceUtil" %><%@
page import="com.liferay.portlet.social.model.SocialActivity" %><%@
page import="com.liferay.portlet.social.model.SocialRelationConstants" %><%@
page import="com.liferay.portlet.social.model.SocialRequestConstants" %><%@
page import="com.liferay.portlet.social.service.SocialActivityLocalServiceUtil" %><%@
page import="com.liferay.portlet.social.service.SocialRelationLocalServiceUtil" %><%@
page import="com.liferay.portlet.social.service.SocialRequestLocalServiceUtil" %><%@
page import="org.apache.commons.lang.StringEscapeUtils" %><%@
page import="org.lsp.liferay.ext.osm.model.GeolocalizationPlot" %><%@
page import="org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException" %><%@
page import="org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException" %><%@
page import="org.lsp.liferay.portlet.socialliving.events.portlet.EventsMapPortletUtil" %><%@
page import="org.lsp.liferay.portlet.socialliving.events.util.EventConstants" %><%@
page import="org.lsp.liferay.portlet.socialliving.model.EventEntry" %><%@
page import="org.lsp.liferay.portlet.socialliving.model.EventRegistration" %><%@
page import="org.lsp.liferay.portlet.socialliving.model.ChannelEntry" %><%@
page import="org.lsp.liferay.portlet.socialliving.service.EventEntryServiceUtil" %><%@
page import="org.lsp.liferay.portlet.socialliving.service.EventEntryLocalServiceUtil" %><%@
page import="org.lsp.liferay.portlet.socialliving.service.EventRegistrationLocalServiceUtil" %><%@
page import="org.lsp.liferay.portlet.socialliving.service.ChannelEntryLocalServiceUtil" %><%@
page import="org.lsp.liferay.portlet.socialliving.util.PortletPropsValues" %><%@
page import="com.liferay.util.portlet.PortletProps" %>

<%@ page import="java.text.Format" %><%@
page import="java.text.NumberFormat" %>

<%@ page import="java.util.ArrayList" %><%@
page import="java.util.Calendar" %><%@
page import="java.util.Iterator" %><%@
page import="java.util.LinkedHashMap" %><%@
page import="java.util.List" %><%@
page import="java.util.Vector" %>

<%@ page import="javax.portlet.ActionRequest" %><%@
page import="javax.portlet.PortletPreferences" %><%@
page import="javax.portlet.PortletURL" %><%@
page import="javax.portlet.WindowState" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<%
WindowState windowState = renderRequest.getWindowState();

String currentURL = PortalUtil.getCurrentURL(request);

Group group = GroupLocalServiceUtil.getGroup(scopeGroupId);

Organization organization = null;
User user2 = null;

if (group.isOrganization()) {
	organization = OrganizationLocalServiceUtil.getOrganization(group.getClassPK());
}
else if (group.isUser()) {
	user2 = UserLocalServiceUtil.getUserById(group.getClassPK());
}

Format dateFormatDate = FastDateFormatFactoryUtil.getDate(locale, timeZone);
Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(locale, timeZone);

NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
NumberFormat percentFormat = NumberFormat.getPercentInstance(locale);
%>