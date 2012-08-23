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

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lsp.liferay.portlet.socialliving.EventEntryEndDateException;
import org.lsp.liferay.portlet.socialliving.EventEntryStartDateException;
import org.lsp.liferay.portlet.socialliving.events.util.EventConstants;
import org.lsp.liferay.portlet.socialliving.model.EventEntry;
import org.lsp.liferay.portlet.socialliving.service.base.EventEntryLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portal.service.ResourceLocalServiceUtil;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

/**
 * The implementation of the event entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.lsp.liferay.portlet.socialliving.service.EventEntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see org.lsp.liferay.portlet.socialliving.service.base.EventEntryLocalServiceBaseImpl
 * @see org.lsp.liferay.portlet.socialliving.service.EventEntryLocalServiceUtil
 */
public class EventEntryLocalServiceImpl extends EventEntryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.lsp.liferay.portlet.socialliving.service.EventEntryLocalServiceUtil} to access the event entry local service.
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

		User user = userLocalService.getUserById(userId);

		Date startDate = PortalUtil.getDate(
			startDateMonth, startDateDay, startDateYear, startDateHour,
			startDateMinute, user.getTimeZone(),
			new EventEntryStartDateException());

		Date endDate = PortalUtil.getDate(
			endDateMonth, endDateDay, endDateYear, endDateHour, endDateMinute,
			user.getTimeZone(), new EventEntryEndDateException());

		Date now = new Date();

		long eventEntryId = counterLocalService.increment();
		
		EventEntry eventEntry = eventEntryPersistence.create(
			eventEntryId);

		eventEntry.setCompanyId(user.getCompanyId());
		eventEntry.setGroupId(groupId);
		eventEntry.setUserId(user.getUserId());
		eventEntry.setUserName(user.getFullName());
		eventEntry.setCreateDate(now);
		eventEntry.setModifiedDate(now);
		eventEntry.setTitle(title);
		eventEntry.setDescription(description);
		eventEntry.setStartDate(startDate);
		eventEntry.setEndDate(endDate);
		eventEntry.setTotalAttendees(totalAttendees);
		eventEntry.setMaxAttendees(maxAttendees);
		eventEntry.setPrice(price);
		eventEntry.setLatitude(latitude);
		eventEntry.setLongitude(longitude);
		eventEntry.setLocation(location);
		eventEntry.setWithSpouse(withSpouse);
		eventEntry.setWithChildren(withChildren);

		if ((thumbnail != null) && (thumbnail.length > 0)) {
			eventEntry.setThumbnailId(counterLocalService.increment());
		}

		eventEntryPersistence.update(eventEntry, false);

		if ((thumbnail != null) && (thumbnail.length > 0)) {
			ImageLocalServiceUtil.updateImage(
					eventEntry.getThumbnailId(), thumbnail);
		}

		setPermissions(eventEntry, visibility);		
		
		return eventEntry;
	}

	@Override
	public EventEntry deleteEventEntry(long companyId, long eventEntryId)
		throws PortalException, SystemException {

		EventEntry eventEntry = eventEntryPersistence.findByPrimaryKey(
			eventEntryId);

		eventRegistrationPersistence.removeByEventEntryId(eventEntryId);

		ImageLocalServiceUtil.deleteImage(eventEntry.getThumbnailId());

		removePermissions(eventEntry);
		
		eventEntryPersistence.remove(eventEntry);

		return eventEntry;
	}
	
	public EventEntry getEventEntry(long companyId, long eventEntryId)
			throws PortalException, SystemException {
			return eventEntryPersistence.findByEntryFinder(companyId, eventEntryId);
	}

	public List<EventEntry> getEventEntries(long companyId, long groupId, int visibility) throws SystemException, PortalException {
		return getEventEntries(companyId, groupId, visibility, true);
	}
	
	public List<EventEntry> getEventEntries(long companyId, long groupId, int visibility, boolean inTheFuture)
            throws SystemException, PortalException {
            
		Calendar cal = Calendar.getInstance(CompanyLocalServiceUtil.getCompany(companyId).getTimeZone(), CompanyLocalServiceUtil.getCompany(companyId).getLocale());
		if (!inTheFuture) { 
			cal.set(1970, 1, 1);
		}
		
		switch (visibility) {
                       
            case EventConstants.VISIBILITY_ALL:
                    return eventEntryPersistence.findByCompanyId(companyId, cal.getTime());
            case EventConstants.VISIBILITY_GROUP:
                    return eventEntryPersistence.findByGroupId(companyId, groupId, cal.getTime());
            case EventConstants.VISIBILITY_OTHERGROUPS:
                    return eventEntryPersistence.findByAllButGroupId(groupId, cal.getTime());
            case EventConstants.VISIBILITY_DEFAULT:
            		// By default, view as if VISIBILITY_GROUP was set
            		return eventEntryPersistence.findByGroupId(companyId, groupId, cal.getTime());
            default:
                    throw new SystemException("Not Implemented VISIBILITY");
            }

    }

    public List<EventEntry> getEventEntriesByCompany(long companyId)
            throws SystemException {
    		Calendar cal = Calendar.getInstance();
    		cal.set(1970, 1, 1);
            return eventEntryPersistence.findByCompanyId(companyId, cal.getTime());
    }

    public List<EventEntry> getEventEntriesByGroup(long companyId, long groupId)
                    throws SystemException {
    	Calendar cal = Calendar.getInstance();
		cal.set(1970, 1, 1);
    	return eventEntryPersistence.findByGroupId(companyId, groupId, cal.getTime());
    }
    
    public List<EventEntry> getEventEntriesByAllButGroup(long groupId)
    		throws SystemException {
    	Calendar cal = Calendar.getInstance();
		cal.set(1970, 1, 1);
    	return eventEntryPersistence.findByAllButGroupId(groupId, cal.getTime());
    }

	public List<EventEntry> getEventEntriesByUser(long userId)
		throws SystemException {
		return eventEntryPersistence.findByUserId(userId);
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

		User user = userLocalService.getUserById(userId);

		Date startDate = PortalUtil.getDate(
			startDateMonth, startDateDay, startDateYear, startDateHour,
			startDateMinute, user.getTimeZone(),
			new EventEntryStartDateException());

		Date endDate = PortalUtil.getDate(
			endDateMonth, endDateDay, endDateYear, endDateHour, endDateMinute,
			user.getTimeZone(), new EventEntryEndDateException());

		EventEntry eventEntry = eventEntryPersistence.findByPrimaryKey(
			eventEntryId);

		eventEntry.setModifiedDate(new Date());
		eventEntry.setTitle(title);
		eventEntry.setDescription(description);
		eventEntry.setStartDate(startDate);
		eventEntry.setEndDate(endDate);
		eventEntry.setTotalAttendees(totalAttendees);
		eventEntry.setMaxAttendees(maxAttendees);
		eventEntry.setPrice(price);
		eventEntry.setLatitude(latitude);
		eventEntry.setLongitude(longitude);
		eventEntry.setLocation(location);
		eventEntry.setWithSpouse(withSpouse);
		eventEntry.setWithChildren(withChildren);

		if ((thumbnail != null) && (thumbnail.length > 0) &&
			(eventEntry.getThumbnailId() == 0)) {

			eventEntry.setThumbnailId(counterLocalService.increment());
		}

		eventEntryPersistence.update(eventEntry, false);

		if ((thumbnail != null) && (thumbnail.length > 0)) {
			ImageLocalServiceUtil.updateImage(
					eventEntry.getThumbnailId(), thumbnail);
		}
		
		setPermissions(eventEntry, visibility);

		return eventEntry;
	}
	
	private void removePermissions(EventEntry eventEntry) throws PortalException, SystemException {
		ResourceLocalServiceUtil.deleteResource(eventEntry.getCompanyId(), EventEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, eventEntry.getEventEntryId());
	}

	private void setPermissions(EventEntry eventEntry, int visibility) throws PortalException, SystemException {
		removePermissions(eventEntry);
		
		Map<Long, String[]> roleIdsToActionIds = new HashMap<Long, String[]>();
		Role userRole;
		
		switch(visibility) {
		case EventConstants.VISIBILITY_GROUP:
			userRole = RoleLocalServiceUtil.getRole(eventEntry.getCompanyId(), RoleConstants.SITE_MEMBER);
            roleIdsToActionIds.put(userRole.getRoleId(), new String[] {ActionKeys.UPDATE, ActionKeys.VIEW});
			break;
		case EventConstants.VISIBILITY_ALL:
			userRole = RoleLocalServiceUtil.getRole(eventEntry.getCompanyId(), RoleConstants.USER);
			roleIdsToActionIds.put(userRole.getRoleId(), new String[] {ActionKeys.UPDATE, ActionKeys.VIEW});
			break;
		case EventConstants.VISIBILITY_DEFAULT:
			userRole = RoleLocalServiceUtil.getRole(eventEntry.getCompanyId(), RoleConstants.USER);
			roleIdsToActionIds.put(userRole.getRoleId(), new String[] {ActionKeys.UPDATE, ActionKeys.VIEW});
			break;
		default:
			throw new PortalException("Not implemented VISIBILITY");
		}
		
		ResourcePermissionLocalServiceUtil.setResourcePermissions(eventEntry.getCompanyId(), EventEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(eventEntry.getEventEntryId()), roleIdsToActionIds);
		
	}
	
}