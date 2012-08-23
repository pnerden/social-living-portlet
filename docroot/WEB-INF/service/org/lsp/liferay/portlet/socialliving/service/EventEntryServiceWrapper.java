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

package org.lsp.liferay.portlet.socialliving.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link EventEntryService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       EventEntryService
 * @generated
 */
public class EventEntryServiceWrapper implements EventEntryService,
	ServiceWrapper<EventEntryService> {
	public EventEntryServiceWrapper(EventEntryService eventEntryService) {
		_eventEntryService = eventEntryService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _eventEntryService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_eventEntryService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _eventEntryService.invokeMethod(name, parameterTypes, arguments);
	}

	public org.lsp.liferay.portlet.socialliving.model.EventEntry addEventEntry(
		long groupId, long userId, java.lang.String title,
		java.lang.String description, int startDateMonth, int startDateDay,
		int startDateYear, int startDateHour, int startDateMinute,
		int endDateMonth, int endDateDay, int endDateYear, int endDateHour,
		int endDateMinute, int totalAttendees, int maxAttendees, double price,
		byte[] thumbnail, int visibility, java.lang.String latitude,
		java.lang.String longitude, java.lang.String location,
		boolean withSpouse, boolean withChildren)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventEntryService.addEventEntry(groupId, userId, title,
			description, startDateMonth, startDateDay, startDateYear,
			startDateHour, startDateMinute, endDateMonth, endDateDay,
			endDateYear, endDateHour, endDateMinute, totalAttendees,
			maxAttendees, price, thumbnail, visibility, latitude, longitude,
			location, withSpouse, withChildren);
	}

	public org.lsp.liferay.portlet.socialliving.model.EventEntry deleteEventEntry(
		long companyId, long eventEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventEntryService.deleteEventEntry(companyId, eventEntryId);
	}

	public org.lsp.liferay.portlet.socialliving.model.EventEntry getEventEntry(
		long companyId, long eventEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventEntryService.getEventEntry(companyId, eventEntryId);
	}

	public java.util.List<org.lsp.liferay.portlet.socialliving.model.EventEntry> getEventEntries(
		com.liferay.portal.theme.ThemeDisplay themeDisplay, int filter,
		int visibility)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventEntryService.getEventEntries(themeDisplay, filter,
			visibility);
	}

	public java.util.List<org.lsp.liferay.portlet.socialliving.model.EventEntry> getEventEntries(
		com.liferay.portal.theme.ThemeDisplay themeDisplay, int filter,
		int visibility, java.lang.String permissionLevel)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventEntryService.getEventEntries(themeDisplay, filter,
			visibility, permissionLevel);
	}

	public java.util.List<org.lsp.liferay.portlet.socialliving.model.EventEntry> getEventEntries(
		com.liferay.portal.theme.ThemeDisplay themeDisplay, int filter,
		int visibility, java.lang.String permissionLevel, boolean inTheFuture)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventEntryService.getEventEntries(themeDisplay, filter,
			visibility, permissionLevel, inTheFuture);
	}

	public int getVisibility(
		org.lsp.liferay.portlet.socialliving.model.EventEntry eventEntry)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventEntryService.getVisibility(eventEntry);
	}

	public org.lsp.liferay.portlet.socialliving.model.EventEntry updateEventEntry(
		long userId, long eventEntryId, java.lang.String title,
		java.lang.String description, int startDateMonth, int startDateDay,
		int startDateYear, int startDateHour, int startDateMinute,
		int endDateMonth, int endDateDay, int endDateYear, int endDateHour,
		int endDateMinute, int totalAttendees, int maxAttendees, double price,
		byte[] thumbnail, int visibility, java.lang.String latitude,
		java.lang.String longitude, java.lang.String location,
		boolean withSpouse, boolean withChildren)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventEntryService.updateEventEntry(userId, eventEntryId, title,
			description, startDateMonth, startDateDay, startDateYear,
			startDateHour, startDateMinute, endDateMonth, endDateDay,
			endDateYear, endDateHour, endDateMinute, totalAttendees,
			maxAttendees, price, thumbnail, visibility, latitude, longitude,
			location, withSpouse, withChildren);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public EventEntryService getWrappedEventEntryService() {
		return _eventEntryService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedEventEntryService(EventEntryService eventEntryService) {
		_eventEntryService = eventEntryService;
	}

	public EventEntryService getWrappedService() {
		return _eventEntryService;
	}

	public void setWrappedService(EventEntryService eventEntryService) {
		_eventEntryService = eventEntryService;
	}

	private EventEntryService _eventEntryService;
}