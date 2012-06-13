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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * The utility for the event entry remote service. This utility wraps {@link org.lsp.liferay.portlet.socialliving.service.impl.EventEntryServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventEntryService
 * @see org.lsp.liferay.portlet.socialliving.service.base.EventEntryServiceBaseImpl
 * @see org.lsp.liferay.portlet.socialliving.service.impl.EventEntryServiceImpl
 * @generated
 */
public class EventEntryServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.lsp.liferay.portlet.socialliving.service.impl.EventEntryServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static org.lsp.liferay.portlet.socialliving.model.EventEntry addEventEntry(
		long groupId, long userId, java.lang.String title,
		java.lang.String description, int startDateMonth, int startDateDay,
		int startDateYear, int startDateHour, int startDateMinute,
		int endDateMonth, int endDateDay, int endDateYear, int endDateHour,
		int endDateMinute, int totalAttendees, int maxAttendees, double price,
		byte[] thumbnail, int visibility, java.lang.String latitude,
		java.lang.String longitude, java.lang.String location)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addEventEntry(groupId, userId, title, description,
			startDateMonth, startDateDay, startDateYear, startDateHour,
			startDateMinute, endDateMonth, endDateDay, endDateYear,
			endDateHour, endDateMinute, totalAttendees, maxAttendees, price,
			thumbnail, visibility, latitude, longitude, location);
	}

	public static org.lsp.liferay.portlet.socialliving.model.EventEntry deleteEventEntry(
		long companyId, long eventEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEventEntry(companyId, eventEntryId);
	}

	public static org.lsp.liferay.portlet.socialliving.model.EventEntry getEventEntry(
		long companyId, long eventEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEventEntry(companyId, eventEntryId);
	}

	public static java.util.List<org.lsp.liferay.portlet.socialliving.model.EventEntry> getEventEntries(
		com.liferay.portal.theme.ThemeDisplay themeDisplay, int filter,
		int visibility)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEventEntries(themeDisplay, filter, visibility);
	}

	public static int getVisibility(
		org.lsp.liferay.portlet.socialliving.model.EventEntry eventEntry)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getVisibility(eventEntry);
	}

	public static org.lsp.liferay.portlet.socialliving.model.EventEntry updateEventEntry(
		long userId, long eventEntryId, java.lang.String title,
		java.lang.String description, int startDateMonth, int startDateDay,
		int startDateYear, int startDateHour, int startDateMinute,
		int endDateMonth, int endDateDay, int endDateYear, int endDateHour,
		int endDateMinute, int totalAttendees, int maxAttendees, double price,
		byte[] thumbnail, int visibility, java.lang.String latitude,
		java.lang.String longitude, java.lang.String location)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateEventEntry(userId, eventEntryId, title, description,
			startDateMonth, startDateDay, startDateYear, startDateHour,
			startDateMinute, endDateMonth, endDateDay, endDateYear,
			endDateHour, endDateMinute, totalAttendees, maxAttendees, price,
			thumbnail, visibility, latitude, longitude, location);
	}

	public static void clearService() {
		_service = null;
	}

	public static EventEntryService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EventEntryService.class.getName());

			if (invokableService instanceof EventEntryService) {
				_service = (EventEntryService)invokableService;
			}
			else {
				_service = new EventEntryServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(EventEntryServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(EventEntryService service) {
	}

	private static EventEntryService _service;
}