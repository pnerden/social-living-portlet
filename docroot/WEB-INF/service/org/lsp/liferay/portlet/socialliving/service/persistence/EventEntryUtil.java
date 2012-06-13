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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.lsp.liferay.portlet.socialliving.model.EventEntry;

import java.util.List;

/**
 * The persistence utility for the event entry service. This utility wraps {@link EventEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventEntryPersistence
 * @see EventEntryPersistenceImpl
 * @generated
 */
public class EventEntryUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(EventEntry eventEntry) {
		getPersistence().clearCache(eventEntry);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EventEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EventEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EventEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static EventEntry update(EventEntry eventEntry, boolean merge)
		throws SystemException {
		return getPersistence().update(eventEntry, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static EventEntry update(EventEntry eventEntry, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(eventEntry, merge, serviceContext);
	}

	/**
	* Caches the event entry in the entity cache if it is enabled.
	*
	* @param eventEntry the event entry
	*/
	public static void cacheResult(
		org.lsp.liferay.portlet.socialliving.model.EventEntry eventEntry) {
		getPersistence().cacheResult(eventEntry);
	}

	/**
	* Caches the event entries in the entity cache if it is enabled.
	*
	* @param eventEntries the event entries
	*/
	public static void cacheResult(
		java.util.List<org.lsp.liferay.portlet.socialliving.model.EventEntry> eventEntries) {
		getPersistence().cacheResult(eventEntries);
	}

	/**
	* Creates a new event entry with the primary key. Does not add the event entry to the database.
	*
	* @param eventEntryId the primary key for the new event entry
	* @return the new event entry
	*/
	public static org.lsp.liferay.portlet.socialliving.model.EventEntry create(
		long eventEntryId) {
		return getPersistence().create(eventEntryId);
	}

	/**
	* Removes the event entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventEntryId the primary key of the event entry
	* @return the event entry that was removed
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException if a event entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.EventEntry remove(
		long eventEntryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException {
		return getPersistence().remove(eventEntryId);
	}

	public static org.lsp.liferay.portlet.socialliving.model.EventEntry updateImpl(
		org.lsp.liferay.portlet.socialliving.model.EventEntry eventEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(eventEntry, merge);
	}

	/**
	* Returns the event entry with the primary key or throws a {@link org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException} if it could not be found.
	*
	* @param eventEntryId the primary key of the event entry
	* @return the event entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException if a event entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.EventEntry findByPrimaryKey(
		long eventEntryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException {
		return getPersistence().findByPrimaryKey(eventEntryId);
	}

	/**
	* Returns the event entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eventEntryId the primary key of the event entry
	* @return the event entry, or <code>null</code> if a event entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.EventEntry fetchByPrimaryKey(
		long eventEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(eventEntryId);
	}

	/**
	* Returns the event entry where companyId = &#63; and eventEntryId = &#63; or throws a {@link org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException} if it could not be found.
	*
	* @param companyId the company ID
	* @param eventEntryId the event entry ID
	* @return the matching event entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException if a matching event entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.EventEntry findByEntryFinder(
		long companyId, long eventEntryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException {
		return getPersistence().findByEntryFinder(companyId, eventEntryId);
	}

	/**
	* Returns the event entry where companyId = &#63; and eventEntryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param eventEntryId the event entry ID
	* @return the matching event entry, or <code>null</code> if a matching event entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.EventEntry fetchByEntryFinder(
		long companyId, long eventEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEntryFinder(companyId, eventEntryId);
	}

	/**
	* Returns the event entry where companyId = &#63; and eventEntryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param eventEntryId the event entry ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching event entry, or <code>null</code> if a matching event entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.EventEntry fetchByEntryFinder(
		long companyId, long eventEntryId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEntryFinder(companyId, eventEntryId,
			retrieveFromCache);
	}

	/**
	* Returns all the event entries where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching event entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.socialliving.model.EventEntry> findByGlobalFinder(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGlobalFinder(companyId, groupId);
	}

	/**
	* Returns a range of all the event entries where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of event entries
	* @param end the upper bound of the range of event entries (not inclusive)
	* @return the range of matching event entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.socialliving.model.EventEntry> findByGlobalFinder(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGlobalFinder(companyId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the event entries where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of event entries
	* @param end the upper bound of the range of event entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching event entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.socialliving.model.EventEntry> findByGlobalFinder(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGlobalFinder(companyId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first event entry in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException if a matching event entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.EventEntry findByGlobalFinder_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException {
		return getPersistence()
				   .findByGlobalFinder_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last event entry in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException if a matching event entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.EventEntry findByGlobalFinder_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException {
		return getPersistence()
				   .findByGlobalFinder_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the event entries before and after the current event entry in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param eventEntryId the primary key of the current event entry
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next event entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException if a event entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.EventEntry[] findByGlobalFinder_PrevAndNext(
		long eventEntryId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException {
		return getPersistence()
				   .findByGlobalFinder_PrevAndNext(eventEntryId, companyId,
			groupId, orderByComparator);
	}

	/**
	* Returns all the event entries where groupId &ne; &#63;.
	*
	* @param groupId the group ID
	* @return the matching event entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.socialliving.model.EventEntry> findByAllButGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAllButGroupId(groupId);
	}

	/**
	* Returns a range of all the event entries where groupId &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of event entries
	* @param end the upper bound of the range of event entries (not inclusive)
	* @return the range of matching event entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.socialliving.model.EventEntry> findByAllButGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAllButGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the event entries where groupId &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of event entries
	* @param end the upper bound of the range of event entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching event entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.socialliving.model.EventEntry> findByAllButGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAllButGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first event entry in the ordered set where groupId &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException if a matching event entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.EventEntry findByAllButGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException {
		return getPersistence()
				   .findByAllButGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last event entry in the ordered set where groupId &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException if a matching event entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.EventEntry findByAllButGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException {
		return getPersistence()
				   .findByAllButGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the event entries before and after the current event entry in the ordered set where groupId &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param eventEntryId the primary key of the current event entry
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next event entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException if a event entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.EventEntry[] findByAllButGroupId_PrevAndNext(
		long eventEntryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException {
		return getPersistence()
				   .findByAllButGroupId_PrevAndNext(eventEntryId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the event entries where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching event entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.socialliving.model.EventEntry> findByGroupId(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(companyId, groupId);
	}

	/**
	* Returns a range of all the event entries where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of event entries
	* @param end the upper bound of the range of event entries (not inclusive)
	* @return the range of matching event entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.socialliving.model.EventEntry> findByGroupId(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(companyId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the event entries where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of event entries
	* @param end the upper bound of the range of event entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching event entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.socialliving.model.EventEntry> findByGroupId(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(companyId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first event entry in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException if a matching event entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.EventEntry findByGroupId_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException {
		return getPersistence()
				   .findByGroupId_First(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the last event entry in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException if a matching event entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.EventEntry findByGroupId_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException {
		return getPersistence()
				   .findByGroupId_Last(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the event entries before and after the current event entry in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param eventEntryId the primary key of the current event entry
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next event entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException if a event entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.EventEntry[] findByGroupId_PrevAndNext(
		long eventEntryId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(eventEntryId, companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the event entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching event entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.socialliving.model.EventEntry> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Returns a range of all the event entries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of event entries
	* @param end the upper bound of the range of event entries (not inclusive)
	* @return the range of matching event entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.socialliving.model.EventEntry> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the event entries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of event entries
	* @param end the upper bound of the range of event entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching event entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.socialliving.model.EventEntry> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first event entry in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException if a matching event entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.EventEntry findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last event entry in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException if a matching event entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.EventEntry findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the event entries before and after the current event entry in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param eventEntryId the primary key of the current event entry
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next event entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException if a event entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.EventEntry[] findByCompanyId_PrevAndNext(
		long eventEntryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(eventEntryId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the event entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching event entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.socialliving.model.EventEntry> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the event entries where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of event entries
	* @param end the upper bound of the range of event entries (not inclusive)
	* @return the range of matching event entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.socialliving.model.EventEntry> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the event entries where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of event entries
	* @param end the upper bound of the range of event entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching event entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.socialliving.model.EventEntry> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first event entry in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException if a matching event entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.EventEntry findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last event entry in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException if a matching event entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.EventEntry findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the event entries before and after the current event entry in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param eventEntryId the primary key of the current event entry
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next event entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException if a event entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.EventEntry[] findByUserId_PrevAndNext(
		long eventEntryId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException {
		return getPersistence()
				   .findByUserId_PrevAndNext(eventEntryId, userId,
			orderByComparator);
	}

	/**
	* Returns all the event entries.
	*
	* @return the event entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.socialliving.model.EventEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<org.lsp.liferay.portlet.socialliving.model.EventEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the event entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of event entries
	* @param end the upper bound of the range of event entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of event entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.socialliving.model.EventEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the event entry where companyId = &#63; and eventEntryId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param eventEntryId the event entry ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEntryFinder(long companyId, long eventEntryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException {
		getPersistence().removeByEntryFinder(companyId, eventEntryId);
	}

	/**
	* Removes all the event entries where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGlobalFinder(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGlobalFinder(companyId, groupId);
	}

	/**
	* Removes all the event entries where groupId &ne; &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAllButGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAllButGroupId(groupId);
	}

	/**
	* Removes all the event entries where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(companyId, groupId);
	}

	/**
	* Removes all the event entries where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Removes all the event entries where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Removes all the event entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of event entries where companyId = &#63; and eventEntryId = &#63;.
	*
	* @param companyId the company ID
	* @param eventEntryId the event entry ID
	* @return the number of matching event entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEntryFinder(long companyId, long eventEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEntryFinder(companyId, eventEntryId);
	}

	/**
	* Returns the number of event entries where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching event entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGlobalFinder(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGlobalFinder(companyId, groupId);
	}

	/**
	* Returns the number of event entries where groupId &ne; &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching event entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAllButGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAllButGroupId(groupId);
	}

	/**
	* Returns the number of event entries where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching event entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(companyId, groupId);
	}

	/**
	* Returns the number of event entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching event entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns the number of event entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching event entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns the number of event entries.
	*
	* @return the number of event entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EventEntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EventEntryPersistence)PortletBeanLocatorUtil.locate(org.lsp.liferay.portlet.socialliving.service.ClpSerializer.getServletContextName(),
					EventEntryPersistence.class.getName());

			ReferenceRegistry.registerReference(EventEntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(EventEntryPersistence persistence) {
	}

	private static EventEntryPersistence _persistence;
}