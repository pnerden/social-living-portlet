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
 * This class is a wrapper for {@link EventEntryLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       EventEntryLocalService
 * @generated
 */
public class EventEntryLocalServiceWrapper implements EventEntryLocalService,
	ServiceWrapper<EventEntryLocalService> {
	public EventEntryLocalServiceWrapper(
		EventEntryLocalService eventEntryLocalService) {
		_eventEntryLocalService = eventEntryLocalService;
	}

	/**
	* Adds the event entry to the database. Also notifies the appropriate model listeners.
	*
	* @param eventEntry the event entry
	* @return the event entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.EventEntry addEventEntry(
		org.lsp.liferay.portlet.socialliving.model.EventEntry eventEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventEntryLocalService.addEventEntry(eventEntry);
	}

	/**
	* Creates a new event entry with the primary key. Does not add the event entry to the database.
	*
	* @param eventEntryId the primary key for the new event entry
	* @return the new event entry
	*/
	public org.lsp.liferay.portlet.socialliving.model.EventEntry createEventEntry(
		long eventEntryId) {
		return _eventEntryLocalService.createEventEntry(eventEntryId);
	}

	/**
	* Deletes the event entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventEntryId the primary key of the event entry
	* @return the event entry that was removed
	* @throws PortalException if a event entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.EventEntry deleteEventEntry(
		long eventEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventEntryLocalService.deleteEventEntry(eventEntryId);
	}

	/**
	* Deletes the event entry from the database. Also notifies the appropriate model listeners.
	*
	* @param eventEntry the event entry
	* @return the event entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.EventEntry deleteEventEntry(
		org.lsp.liferay.portlet.socialliving.model.EventEntry eventEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventEntryLocalService.deleteEventEntry(eventEntry);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _eventEntryLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _eventEntryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventEntryLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventEntryLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.lsp.liferay.portlet.socialliving.model.EventEntry fetchEventEntry(
		long eventEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventEntryLocalService.fetchEventEntry(eventEntryId);
	}

	/**
	* Returns the event entry with the primary key.
	*
	* @param eventEntryId the primary key of the event entry
	* @return the event entry
	* @throws PortalException if a event entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.EventEntry getEventEntry(
		long eventEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventEntryLocalService.getEventEntry(eventEntryId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the event entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of event entries
	* @param end the upper bound of the range of event entries (not inclusive)
	* @return the range of event entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.lsp.liferay.portlet.socialliving.model.EventEntry> getEventEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventEntryLocalService.getEventEntries(start, end);
	}

	/**
	* Returns the number of event entries.
	*
	* @return the number of event entries
	* @throws SystemException if a system exception occurred
	*/
	public int getEventEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventEntryLocalService.getEventEntriesCount();
	}

	/**
	* Updates the event entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eventEntry the event entry
	* @return the event entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.EventEntry updateEventEntry(
		org.lsp.liferay.portlet.socialliving.model.EventEntry eventEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventEntryLocalService.updateEventEntry(eventEntry);
	}

	/**
	* Updates the event entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eventEntry the event entry
	* @param merge whether to merge the event entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the event entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.EventEntry updateEventEntry(
		org.lsp.liferay.portlet.socialliving.model.EventEntry eventEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventEntryLocalService.updateEventEntry(eventEntry, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _eventEntryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_eventEntryLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _eventEntryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public org.lsp.liferay.portlet.socialliving.model.EventEntry addEventEntry(
		long groupId, long userId, java.lang.String title,
		java.lang.String description, int startDateMonth, int startDateDay,
		int startDateYear, int startDateHour, int startDateMinute,
		int endDateMonth, int endDateDay, int endDateYear, int endDateHour,
		int endDateMinute, int totalAttendees, int maxAttendees, double price,
		byte[] thumbnail, int visibility, java.lang.String latitude,
		java.lang.String longitude, java.lang.String location)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventEntryLocalService.addEventEntry(groupId, userId, title,
			description, startDateMonth, startDateDay, startDateYear,
			startDateHour, startDateMinute, endDateMonth, endDateDay,
			endDateYear, endDateHour, endDateMinute, totalAttendees,
			maxAttendees, price, thumbnail, visibility, latitude, longitude,
			location);
	}

	public org.lsp.liferay.portlet.socialliving.model.EventEntry deleteEventEntry(
		long companyId, long eventEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventEntryLocalService.deleteEventEntry(companyId, eventEntryId);
	}

	public org.lsp.liferay.portlet.socialliving.model.EventEntry getEventEntry(
		long companyId, long eventEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventEntryLocalService.getEventEntry(companyId, eventEntryId);
	}

	public java.util.List<org.lsp.liferay.portlet.socialliving.model.EventEntry> getEventEntries(
		long companyId, long groupId, int visibility)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventEntryLocalService.getEventEntries(companyId, groupId,
			visibility);
	}

	public java.util.List<org.lsp.liferay.portlet.socialliving.model.EventEntry> getEventEntriesByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventEntryLocalService.getEventEntriesByCompany(companyId);
	}

	public java.util.List<org.lsp.liferay.portlet.socialliving.model.EventEntry> getEventEntriesByGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventEntryLocalService.getEventEntriesByGroup(companyId, groupId);
	}

	public java.util.List<org.lsp.liferay.portlet.socialliving.model.EventEntry> getEventEntriesByAllButGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventEntryLocalService.getEventEntriesByAllButGroup(groupId);
	}

	public java.util.List<org.lsp.liferay.portlet.socialliving.model.EventEntry> getEventEntriesByUser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _eventEntryLocalService.getEventEntriesByUser(userId);
	}

	public org.lsp.liferay.portlet.socialliving.model.EventEntry updateEventEntry(
		long userId, long eventEntryId, java.lang.String title,
		java.lang.String description, int startDateMonth, int startDateDay,
		int startDateYear, int startDateHour, int startDateMinute,
		int endDateMonth, int endDateDay, int endDateYear, int endDateHour,
		int endDateMinute, int totalAttendees, int maxAttendees, double price,
		byte[] thumbnail, int visibility, java.lang.String latitude,
		java.lang.String longitude, java.lang.String location)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventEntryLocalService.updateEventEntry(userId, eventEntryId,
			title, description, startDateMonth, startDateDay, startDateYear,
			startDateHour, startDateMinute, endDateMonth, endDateDay,
			endDateYear, endDateHour, endDateMinute, totalAttendees,
			maxAttendees, price, thumbnail, visibility, latitude, longitude,
			location);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public EventEntryLocalService getWrappedEventEntryLocalService() {
		return _eventEntryLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedEventEntryLocalService(
		EventEntryLocalService eventEntryLocalService) {
		_eventEntryLocalService = eventEntryLocalService;
	}

	public EventEntryLocalService getWrappedService() {
		return _eventEntryLocalService;
	}

	public void setWrappedService(EventEntryLocalService eventEntryLocalService) {
		_eventEntryLocalService = eventEntryLocalService;
	}

	private EventEntryLocalService _eventEntryLocalService;
}