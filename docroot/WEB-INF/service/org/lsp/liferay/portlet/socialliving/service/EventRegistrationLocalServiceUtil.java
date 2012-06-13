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
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the event registration local service. This utility wraps {@link org.lsp.liferay.portlet.socialliving.service.impl.EventRegistrationLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventRegistrationLocalService
 * @see org.lsp.liferay.portlet.socialliving.service.base.EventRegistrationLocalServiceBaseImpl
 * @see org.lsp.liferay.portlet.socialliving.service.impl.EventRegistrationLocalServiceImpl
 * @generated
 */
public class EventRegistrationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.lsp.liferay.portlet.socialliving.service.impl.EventRegistrationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the event registration to the database. Also notifies the appropriate model listeners.
	*
	* @param eventRegistration the event registration
	* @return the event registration that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.EventRegistration addEventRegistration(
		org.lsp.liferay.portlet.socialliving.model.EventRegistration eventRegistration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addEventRegistration(eventRegistration);
	}

	/**
	* Creates a new event registration with the primary key. Does not add the event registration to the database.
	*
	* @param eventRegistrationId the primary key for the new event registration
	* @return the new event registration
	*/
	public static org.lsp.liferay.portlet.socialliving.model.EventRegistration createEventRegistration(
		long eventRegistrationId) {
		return getService().createEventRegistration(eventRegistrationId);
	}

	/**
	* Deletes the event registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventRegistrationId the primary key of the event registration
	* @return the event registration that was removed
	* @throws PortalException if a event registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.EventRegistration deleteEventRegistration(
		long eventRegistrationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEventRegistration(eventRegistrationId);
	}

	/**
	* Deletes the event registration from the database. Also notifies the appropriate model listeners.
	*
	* @param eventRegistration the event registration
	* @return the event registration that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.EventRegistration deleteEventRegistration(
		org.lsp.liferay.portlet.socialliving.model.EventRegistration eventRegistration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEventRegistration(eventRegistration);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static org.lsp.liferay.portlet.socialliving.model.EventRegistration fetchEventRegistration(
		long eventRegistrationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchEventRegistration(eventRegistrationId);
	}

	/**
	* Returns the event registration with the primary key.
	*
	* @param eventRegistrationId the primary key of the event registration
	* @return the event registration
	* @throws PortalException if a event registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.EventRegistration getEventRegistration(
		long eventRegistrationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEventRegistration(eventRegistrationId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the event registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of event registrations
	* @param end the upper bound of the range of event registrations (not inclusive)
	* @return the range of event registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.socialliving.model.EventRegistration> getEventRegistrations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEventRegistrations(start, end);
	}

	/**
	* Returns the number of event registrations.
	*
	* @return the number of event registrations
	* @throws SystemException if a system exception occurred
	*/
	public static int getEventRegistrationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEventRegistrationsCount();
	}

	/**
	* Updates the event registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eventRegistration the event registration
	* @return the event registration that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.EventRegistration updateEventRegistration(
		org.lsp.liferay.portlet.socialliving.model.EventRegistration eventRegistration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEventRegistration(eventRegistration);
	}

	/**
	* Updates the event registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eventRegistration the event registration
	* @param merge whether to merge the event registration with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the event registration that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.EventRegistration updateEventRegistration(
		org.lsp.liferay.portlet.socialliving.model.EventRegistration eventRegistration,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEventRegistration(eventRegistration, merge);
	}

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

	public static org.lsp.liferay.portlet.socialliving.model.EventRegistration getEventRegistration(
		long userId, long eventEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEventRegistration(userId, eventEntryId);
	}

	public static java.util.List<org.lsp.liferay.portlet.socialliving.model.EventRegistration> getEventRegistrations(
		long eventEntryId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getEventRegistrations(eventEntryId, status, start, end);
	}

	public static int getEventRegistrationsCount(long eventEntryId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEventRegistrationsCount(eventEntryId, status);
	}

	public static org.lsp.liferay.portlet.socialliving.model.EventRegistration updateEventRegistration(
		long userId, long eventEntryId, int status, java.lang.String comments)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateEventRegistration(userId, eventEntryId, status,
			comments);
	}

	public static void clearService() {
		_service = null;
	}

	public static EventRegistrationLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EventRegistrationLocalService.class.getName());

			if (invokableLocalService instanceof EventRegistrationLocalService) {
				_service = (EventRegistrationLocalService)invokableLocalService;
			}
			else {
				_service = new EventRegistrationLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(EventRegistrationLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(EventRegistrationLocalService service) {
	}

	private static EventRegistrationLocalService _service;
}