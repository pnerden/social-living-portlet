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

package org.lsp.liferay.portlet.socialliving.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.lsp.liferay.portlet.socialliving.model.EventRegistration;

/**
 * The persistence interface for the event registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventRegistrationPersistenceImpl
 * @see EventRegistrationUtil
 * @generated
 */
public interface EventRegistrationPersistence extends BasePersistence<EventRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EventRegistrationUtil} to access the event registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the event registration in the entity cache if it is enabled.
	*
	* @param eventRegistration the event registration
	*/
	public void cacheResult(
		org.lsp.liferay.portlet.socialliving.model.EventRegistration eventRegistration);

	/**
	* Caches the event registrations in the entity cache if it is enabled.
	*
	* @param eventRegistrations the event registrations
	*/
	public void cacheResult(
		java.util.List<org.lsp.liferay.portlet.socialliving.model.EventRegistration> eventRegistrations);

	/**
	* Creates a new event registration with the primary key. Does not add the event registration to the database.
	*
	* @param eventRegistrationId the primary key for the new event registration
	* @return the new event registration
	*/
	public org.lsp.liferay.portlet.socialliving.model.EventRegistration create(
		long eventRegistrationId);

	/**
	* Removes the event registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventRegistrationId the primary key of the event registration
	* @return the event registration that was removed
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException if a event registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.EventRegistration remove(
		long eventRegistrationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException;

	public org.lsp.liferay.portlet.socialliving.model.EventRegistration updateImpl(
		org.lsp.liferay.portlet.socialliving.model.EventRegistration eventRegistration,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the event registration with the primary key or throws a {@link org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException} if it could not be found.
	*
	* @param eventRegistrationId the primary key of the event registration
	* @return the event registration
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException if a event registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.EventRegistration findByPrimaryKey(
		long eventRegistrationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException;

	/**
	* Returns the event registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eventRegistrationId the primary key of the event registration
	* @return the event registration, or <code>null</code> if a event registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.EventRegistration fetchByPrimaryKey(
		long eventRegistrationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the event registrations where eventEntryId = &#63;.
	*
	* @param eventEntryId the event entry ID
	* @return the matching event registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.lsp.liferay.portlet.socialliving.model.EventRegistration> findByEventEntryId(
		long eventEntryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the event registrations where eventEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param eventEntryId the event entry ID
	* @param start the lower bound of the range of event registrations
	* @param end the upper bound of the range of event registrations (not inclusive)
	* @return the range of matching event registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.lsp.liferay.portlet.socialliving.model.EventRegistration> findByEventEntryId(
		long eventEntryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the event registrations where eventEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param eventEntryId the event entry ID
	* @param start the lower bound of the range of event registrations
	* @param end the upper bound of the range of event registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching event registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.lsp.liferay.portlet.socialliving.model.EventRegistration> findByEventEntryId(
		long eventEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first event registration in the ordered set where eventEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param eventEntryId the event entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event registration
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException if a matching event registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.EventRegistration findByEventEntryId_First(
		long eventEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException;

	/**
	* Returns the last event registration in the ordered set where eventEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param eventEntryId the event entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event registration
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException if a matching event registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.EventRegistration findByEventEntryId_Last(
		long eventEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException;

	/**
	* Returns the event registrations before and after the current event registration in the ordered set where eventEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param eventRegistrationId the primary key of the current event registration
	* @param eventEntryId the event entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next event registration
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException if a event registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.EventRegistration[] findByEventEntryId_PrevAndNext(
		long eventRegistrationId, long eventEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException;

	/**
	* Returns the event registration where userId = &#63; and eventEntryId = &#63; or throws a {@link org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException} if it could not be found.
	*
	* @param userId the user ID
	* @param eventEntryId the event entry ID
	* @return the matching event registration
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException if a matching event registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.EventRegistration findByU_ME(
		long userId, long eventEntryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException;

	/**
	* Returns the event registration where userId = &#63; and eventEntryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param eventEntryId the event entry ID
	* @return the matching event registration, or <code>null</code> if a matching event registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.EventRegistration fetchByU_ME(
		long userId, long eventEntryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the event registration where userId = &#63; and eventEntryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param eventEntryId the event entry ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching event registration, or <code>null</code> if a matching event registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.EventRegistration fetchByU_ME(
		long userId, long eventEntryId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the event registrations where eventEntryId = &#63; and status = &#63;.
	*
	* @param eventEntryId the event entry ID
	* @param status the status
	* @return the matching event registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.lsp.liferay.portlet.socialliving.model.EventRegistration> findByME_S(
		long eventEntryId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the event registrations where eventEntryId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param eventEntryId the event entry ID
	* @param status the status
	* @param start the lower bound of the range of event registrations
	* @param end the upper bound of the range of event registrations (not inclusive)
	* @return the range of matching event registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.lsp.liferay.portlet.socialliving.model.EventRegistration> findByME_S(
		long eventEntryId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the event registrations where eventEntryId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param eventEntryId the event entry ID
	* @param status the status
	* @param start the lower bound of the range of event registrations
	* @param end the upper bound of the range of event registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching event registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.lsp.liferay.portlet.socialliving.model.EventRegistration> findByME_S(
		long eventEntryId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first event registration in the ordered set where eventEntryId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param eventEntryId the event entry ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event registration
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException if a matching event registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.EventRegistration findByME_S_First(
		long eventEntryId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException;

	/**
	* Returns the last event registration in the ordered set where eventEntryId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param eventEntryId the event entry ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event registration
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException if a matching event registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.EventRegistration findByME_S_Last(
		long eventEntryId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException;

	/**
	* Returns the event registrations before and after the current event registration in the ordered set where eventEntryId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param eventRegistrationId the primary key of the current event registration
	* @param eventEntryId the event entry ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next event registration
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException if a event registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.EventRegistration[] findByME_S_PrevAndNext(
		long eventRegistrationId, long eventEntryId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException;

	/**
	* Returns all the event registrations.
	*
	* @return the event registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.lsp.liferay.portlet.socialliving.model.EventRegistration> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.lsp.liferay.portlet.socialliving.model.EventRegistration> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the event registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of event registrations
	* @param end the upper bound of the range of event registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of event registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.lsp.liferay.portlet.socialliving.model.EventRegistration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the event registrations where eventEntryId = &#63; from the database.
	*
	* @param eventEntryId the event entry ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEventEntryId(long eventEntryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the event registration where userId = &#63; and eventEntryId = &#63; from the database.
	*
	* @param userId the user ID
	* @param eventEntryId the event entry ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByU_ME(long userId, long eventEntryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException;

	/**
	* Removes all the event registrations where eventEntryId = &#63; and status = &#63; from the database.
	*
	* @param eventEntryId the event entry ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByME_S(long eventEntryId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the event registrations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of event registrations where eventEntryId = &#63;.
	*
	* @param eventEntryId the event entry ID
	* @return the number of matching event registrations
	* @throws SystemException if a system exception occurred
	*/
	public int countByEventEntryId(long eventEntryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of event registrations where userId = &#63; and eventEntryId = &#63;.
	*
	* @param userId the user ID
	* @param eventEntryId the event entry ID
	* @return the number of matching event registrations
	* @throws SystemException if a system exception occurred
	*/
	public int countByU_ME(long userId, long eventEntryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of event registrations where eventEntryId = &#63; and status = &#63;.
	*
	* @param eventEntryId the event entry ID
	* @param status the status
	* @return the number of matching event registrations
	* @throws SystemException if a system exception occurred
	*/
	public int countByME_S(long eventEntryId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of event registrations.
	*
	* @return the number of event registrations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}