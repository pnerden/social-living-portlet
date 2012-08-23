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

package org.lsp.liferay.portlet.socialliving.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.lsp.liferay.portlet.socialliving.events.util.EventConstants;
import org.lsp.liferay.portlet.socialliving.model.EventEntry;
import org.lsp.liferay.portlet.socialliving.service.base.EventEntryServiceBaseImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.ResourcePermission;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * The implementation of the event entry remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.lsp.liferay.portlet.socialliving.service.EventEntryService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see org.lsp.liferay.portlet.socialliving.service.base.EventEntryServiceBaseImpl
 * @see org.lsp.liferay.portlet.socialliving.service.EventEntryServiceUtil
 */
public class EventEntryServiceImpl extends EventEntryServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.lsp.liferay.portlet.socialliving.service.EventEntryServiceUtil} to access the event entry remote service.
	 */
	
	public EventEntry addEventEntry(
			long groupId, long userId, String title, String description, int startDateMonth,
			int startDateDay, int startDateYear, int startDateHour,
			int startDateMinute, int endDateMonth, int endDateDay,
			int endDateYear, int endDateHour, int endDateMinute,
			int totalAttendees, int maxAttendees, double price,
			byte[] thumbnail, int visibility,
			String latitude, String longitude, String location,
			boolean withSpouse, boolean withChildren)
		throws PortalException, SystemException {

		PermissionChecker permissionChecker = getPermissionChecker();
		if (permissionChecker.hasPermission(groupId, "org.lsp.liferay.portlet.socialliving.event", groupId, EventConstants.ADD_EVENT)) {
			return eventEntryLocalService.addEventEntry(groupId, userId, title, description, startDateMonth, startDateDay, startDateYear, startDateHour, startDateMinute, endDateMonth, endDateDay, endDateYear, endDateHour, endDateMinute, totalAttendees, maxAttendees, price, thumbnail, visibility, latitude, longitude, location, withSpouse, withChildren);
		}
		throw new PortalException("You have no right to add this resource");
	}
	
	public EventEntry deleteEventEntry(long companyId, long eventEntryId)
			throws PortalException, SystemException {
		PermissionChecker permissionChecker = getPermissionChecker();
		EventEntry result = eventEntryLocalService.getEventEntry(eventEntryId, companyId);
		if (permissionChecker.hasPermission(result.getGroupId(), EventEntry.class.getName(), eventEntryId, ActionKeys.DELETE)) {
			return eventEntryLocalService.deleteEventEntry(companyId, eventEntryId);
		}
		throw new PortalException("You have no right to delete this resource");
	}
	
	public EventEntry getEventEntry(long companyId, long eventEntryId) throws PortalException, SystemException {
		EventEntry result = eventEntryLocalService.getEventEntry(companyId, eventEntryId); 
		if (filterByPermission(result, ActionKeys.VIEW)) {
			return result;
		}
		throw new PortalException("You have no right to access this resource");
	}
	
	public List<EventEntry> getEventEntries(ThemeDisplay themeDisplay, int filter, int visibility) throws SystemException, PortalException {
		return getEventEntries(themeDisplay, filter, visibility ,ActionKeys.VIEW);
	}
	
	public List<EventEntry> getEventEntries(ThemeDisplay themeDisplay, int filter, int visibility, String permissionLevel) throws SystemException, PortalException {
		return getEventEntries(themeDisplay, filter, visibility, permissionLevel, true);
	}
	
	public List<EventEntry> getEventEntries(ThemeDisplay themeDisplay, int filter, int visibility, String permissionLevel, boolean inTheFuture) throws SystemException, PortalException {
		switch (filter) {
		case EventConstants.FILTER_MY_EVENTS:
			return getEventEntriesByUserId(themeDisplay.getUserId(), permissionLevel);
		case EventConstants.FILTER_ALL_EVENTS:
			return getEventEntries(themeDisplay, visibility, permissionLevel, inTheFuture);
		default:
			return null;
		}
	}
	
	public int getVisibility(EventEntry eventEntry) throws SystemException, PortalException {
		List<ResourcePermission> list = ResourcePermissionLocalServiceUtil.getResourcePermissions(eventEntry.getCompanyId(), EventEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(eventEntry.getEventEntryId()));
		
		int result = EventConstants.VISIBILITY_ALL;
		long siteMemberRoleId = RoleLocalServiceUtil.getRole(eventEntry.getCompanyId(), "Site Member").getRoleId();
		
		Iterator<ResourcePermission> iter = list.iterator();
		while (iter.hasNext()) {
			ResourcePermission p = iter.next();
			if (p.getRoleId() == siteMemberRoleId) {
				result = EventConstants.VISIBILITY_GROUP;
			}
		}
		return result;
	}
	
	public EventEntry updateEventEntry(
			long userId, long eventEntryId, String title, String description,
			int startDateMonth, int startDateDay, int startDateYear,
			int startDateHour, int startDateMinute, int endDateMonth,
			int endDateDay, int endDateYear, int endDateHour, int endDateMinute,
			int totalAttendees, int maxAttendees, double price,
			byte[] thumbnail, int visibility,
			String latitude, String longitude, String location,
			boolean withSpouse, boolean withChildren)
		throws PortalException, SystemException {

		PermissionChecker permissionChecker = getPermissionChecker();
		EventEntry eventEntry = eventEntryLocalService.getEventEntry(eventEntryId);
		if (permissionChecker.hasPermission(eventEntry.getGroupId(), EventEntry.class.getName(), eventEntry.getEventEntryId(), ActionKeys.UPDATE)) {
			return eventEntryLocalService.updateEventEntry(userId, eventEntryId, title, description, startDateMonth, startDateDay, startDateYear, startDateHour, startDateMinute, endDateMonth, endDateDay, endDateYear, endDateHour, endDateMinute, totalAttendees, maxAttendees, price, thumbnail, visibility, latitude, longitude, location, withSpouse, withChildren);
		}
		throw new PortalException("You have no right to update this resource");
	}
	
	private List<EventEntry> getEventEntriesByUserId(long userId, String permissionLevel) throws SystemException, PortalException {
		return filterByPermission(eventEntryLocalService.getEventEntriesByUser(userId), ActionKeys.UPDATE);	
	}
	
	private List<EventEntry> getEventEntries(ThemeDisplay themeDisplay, int displayVisibility, String permissionLevel, boolean inTheFuture) throws SystemException, PortalException {
		
		long companyId = themeDisplay.getCompanyId();
		long groupId = themeDisplay.getScopeGroupIdOrLiveGroupId();
		
		List<EventEntry> result = eventEntryLocalService.getEventEntries(companyId, groupId, displayVisibility, inTheFuture);
		
		return filterByPermission(result, permissionLevel);

	}
	
	private List<EventEntry> filterByPermission(List<EventEntry> input, String permissionLevel) throws PortalException, SystemException {
		
		List<EventEntry> result = new Vector<EventEntry>();
		
		Iterator<EventEntry> iter = input.iterator();
		while (iter.hasNext()) {
			EventEntry e = iter.next();
			if (filterByPermission(e, permissionLevel)) {
				result.add(e);
			}
		}
		return result;
	}
	
	private boolean filterByPermission(EventEntry e, String permissionLevel) throws PrincipalException {
		if (getPermissionChecker().hasPermission(e.getGroupId(), EventEntry.class.getName(), e.getEventEntryId(), permissionLevel)) {
			return true;
		}
		return false;
	}	
}