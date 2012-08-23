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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the event registration local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventRegistrationLocalServiceUtil
 * @see org.lsp.liferay.portlet.socialliving.service.base.EventRegistrationLocalServiceBaseImpl
 * @see org.lsp.liferay.portlet.socialliving.service.impl.EventRegistrationLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface EventRegistrationLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EventRegistrationLocalServiceUtil} to access the event registration local service. Add custom service methods to {@link org.lsp.liferay.portlet.socialliving.service.impl.EventRegistrationLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the event registration to the database. Also notifies the appropriate model listeners.
	*
	* @param eventRegistration the event registration
	* @return the event registration that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.EventRegistration addEventRegistration(
		org.lsp.liferay.portlet.socialliving.model.EventRegistration eventRegistration)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new event registration with the primary key. Does not add the event registration to the database.
	*
	* @param eventRegistrationId the primary key for the new event registration
	* @return the new event registration
	*/
	public org.lsp.liferay.portlet.socialliving.model.EventRegistration createEventRegistration(
		long eventRegistrationId);

	/**
	* Deletes the event registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventRegistrationId the primary key of the event registration
	* @return the event registration that was removed
	* @throws PortalException if a event registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.EventRegistration deleteEventRegistration(
		long eventRegistrationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the event registration from the database. Also notifies the appropriate model listeners.
	*
	* @param eventRegistration the event registration
	* @return the event registration that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.EventRegistration deleteEventRegistration(
		org.lsp.liferay.portlet.socialliving.model.EventRegistration eventRegistration)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

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
		throws com.liferay.portal.kernel.exception.SystemException;

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
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.lsp.liferay.portlet.socialliving.model.EventRegistration fetchEventRegistration(
		long eventRegistrationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the event registration with the primary key.
	*
	* @param eventRegistrationId the primary key of the event registration
	* @return the event registration
	* @throws PortalException if a event registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.lsp.liferay.portlet.socialliving.model.EventRegistration getEventRegistration(
		long eventRegistrationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.lsp.liferay.portlet.socialliving.model.EventRegistration> getEventRegistrations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of event registrations.
	*
	* @return the number of event registrations
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getEventRegistrationsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the event registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eventRegistration the event registration
	* @return the event registration that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.EventRegistration updateEventRegistration(
		org.lsp.liferay.portlet.socialliving.model.EventRegistration eventRegistration)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the event registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eventRegistration the event registration
	* @param merge whether to merge the event registration with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the event registration that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.EventRegistration updateEventRegistration(
		org.lsp.liferay.portlet.socialliving.model.EventRegistration eventRegistration,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.lsp.liferay.portlet.socialliving.model.EventRegistration getEventRegistration(
		long userId, long eventEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.lsp.liferay.portlet.socialliving.model.EventRegistration> getEventRegistrations(
		long eventEntryId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.lsp.liferay.portlet.socialliving.model.EventRegistration> getEventPositiveRegistrations(
		long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.lsp.liferay.portlet.socialliving.model.EventRegistration> getEventRegistrations(
		long companyId, long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getEventRegistrationsCount(long eventEntryId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	public org.lsp.liferay.portlet.socialliving.model.EventRegistration updateEventRegistration(
		long userId, long eventEntryId, int status, java.lang.String comments)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}