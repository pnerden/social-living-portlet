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

import org.lsp.liferay.portlet.socialliving.model.ChannelEntry;

import java.util.List;

/**
 * The persistence utility for the channel entry service. This utility wraps {@link ChannelEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChannelEntryPersistence
 * @see ChannelEntryPersistenceImpl
 * @generated
 */
public class ChannelEntryUtil {
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
	public static void clearCache(ChannelEntry channelEntry) {
		getPersistence().clearCache(channelEntry);
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
	public static List<ChannelEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ChannelEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ChannelEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ChannelEntry update(ChannelEntry channelEntry, boolean merge)
		throws SystemException {
		return getPersistence().update(channelEntry, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ChannelEntry update(ChannelEntry channelEntry, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(channelEntry, merge, serviceContext);
	}

	/**
	* Caches the channel entry in the entity cache if it is enabled.
	*
	* @param channelEntry the channel entry
	*/
	public static void cacheResult(
		org.lsp.liferay.portlet.socialliving.model.ChannelEntry channelEntry) {
		getPersistence().cacheResult(channelEntry);
	}

	/**
	* Caches the channel entries in the entity cache if it is enabled.
	*
	* @param channelEntries the channel entries
	*/
	public static void cacheResult(
		java.util.List<org.lsp.liferay.portlet.socialliving.model.ChannelEntry> channelEntries) {
		getPersistence().cacheResult(channelEntries);
	}

	/**
	* Creates a new channel entry with the primary key. Does not add the channel entry to the database.
	*
	* @param channelEntryId the primary key for the new channel entry
	* @return the new channel entry
	*/
	public static org.lsp.liferay.portlet.socialliving.model.ChannelEntry create(
		long channelEntryId) {
		return getPersistence().create(channelEntryId);
	}

	/**
	* Removes the channel entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param channelEntryId the primary key of the channel entry
	* @return the channel entry that was removed
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException if a channel entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.ChannelEntry remove(
		long channelEntryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException {
		return getPersistence().remove(channelEntryId);
	}

	public static org.lsp.liferay.portlet.socialliving.model.ChannelEntry updateImpl(
		org.lsp.liferay.portlet.socialliving.model.ChannelEntry channelEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(channelEntry, merge);
	}

	/**
	* Returns the channel entry with the primary key or throws a {@link org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException} if it could not be found.
	*
	* @param channelEntryId the primary key of the channel entry
	* @return the channel entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException if a channel entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.ChannelEntry findByPrimaryKey(
		long channelEntryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException {
		return getPersistence().findByPrimaryKey(channelEntryId);
	}

	/**
	* Returns the channel entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param channelEntryId the primary key of the channel entry
	* @return the channel entry, or <code>null</code> if a channel entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.ChannelEntry fetchByPrimaryKey(
		long channelEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(channelEntryId);
	}

	/**
	* Returns all the channel entries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching channel entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.socialliving.model.ChannelEntry> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the channel entries where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of channel entries
	* @param end the upper bound of the range of channel entries (not inclusive)
	* @return the range of matching channel entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.socialliving.model.ChannelEntry> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the channel entries where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of channel entries
	* @param end the upper bound of the range of channel entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching channel entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.socialliving.model.ChannelEntry> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first channel entry in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException if a matching channel entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.ChannelEntry findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last channel entry in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException if a matching channel entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.ChannelEntry findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the channel entries before and after the current channel entry in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param channelEntryId the primary key of the current channel entry
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next channel entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException if a channel entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.ChannelEntry[] findByGroupId_PrevAndNext(
		long channelEntryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(channelEntryId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the channel entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching channel entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.socialliving.model.ChannelEntry> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the channel entries where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of channel entries
	* @param end the upper bound of the range of channel entries (not inclusive)
	* @return the range of matching channel entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.socialliving.model.ChannelEntry> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the channel entries where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of channel entries
	* @param end the upper bound of the range of channel entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching channel entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.socialliving.model.ChannelEntry> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first channel entry in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException if a matching channel entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.ChannelEntry findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last channel entry in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException if a matching channel entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.ChannelEntry findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the channel entries before and after the current channel entry in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param channelEntryId the primary key of the current channel entry
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next channel entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException if a channel entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.ChannelEntry[] findByUserId_PrevAndNext(
		long channelEntryId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException {
		return getPersistence()
				   .findByUserId_PrevAndNext(channelEntryId, userId,
			orderByComparator);
	}

	/**
	* Returns all the channel entries where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @return the matching channel entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.socialliving.model.ChannelEntry> findByG_U(
		long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_U(groupId, userId);
	}

	/**
	* Returns a range of all the channel entries where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param start the lower bound of the range of channel entries
	* @param end the upper bound of the range of channel entries (not inclusive)
	* @return the range of matching channel entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.socialliving.model.ChannelEntry> findByG_U(
		long groupId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_U(groupId, userId, start, end);
	}

	/**
	* Returns an ordered range of all the channel entries where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param start the lower bound of the range of channel entries
	* @param end the upper bound of the range of channel entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching channel entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.socialliving.model.ChannelEntry> findByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_U(groupId, userId, start, end, orderByComparator);
	}

	/**
	* Returns the first channel entry in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException if a matching channel entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.ChannelEntry findByG_U_First(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException {
		return getPersistence()
				   .findByG_U_First(groupId, userId, orderByComparator);
	}

	/**
	* Returns the last channel entry in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException if a matching channel entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.ChannelEntry findByG_U_Last(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException {
		return getPersistence()
				   .findByG_U_Last(groupId, userId, orderByComparator);
	}

	/**
	* Returns the channel entries before and after the current channel entry in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param channelEntryId the primary key of the current channel entry
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next channel entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException if a channel entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.ChannelEntry[] findByG_U_PrevAndNext(
		long channelEntryId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException {
		return getPersistence()
				   .findByG_U_PrevAndNext(channelEntryId, groupId, userId,
			orderByComparator);
	}

	/**
	* Returns all the channel entries.
	*
	* @return the channel entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.socialliving.model.ChannelEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the channel entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of channel entries
	* @param end the upper bound of the range of channel entries (not inclusive)
	* @return the range of channel entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.socialliving.model.ChannelEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the channel entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of channel entries
	* @param end the upper bound of the range of channel entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of channel entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.socialliving.model.ChannelEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the channel entries where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Removes all the channel entries where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Removes all the channel entries where groupId = &#63; and userId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_U(long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_U(groupId, userId);
	}

	/**
	* Removes all the channel entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of channel entries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching channel entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of channel entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching channel entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns the number of channel entries where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @return the number of matching channel entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_U(long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_U(groupId, userId);
	}

	/**
	* Returns the number of channel entries.
	*
	* @return the number of channel entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ChannelEntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ChannelEntryPersistence)PortletBeanLocatorUtil.locate(org.lsp.liferay.portlet.socialliving.service.ClpSerializer.getServletContextName(),
					ChannelEntryPersistence.class.getName());

			ReferenceRegistry.registerReference(ChannelEntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(ChannelEntryPersistence persistence) {
	}

	private static ChannelEntryPersistence _persistence;
}