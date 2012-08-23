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

import org.lsp.liferay.portlet.socialliving.model.ChannelEntry;

/**
 * The persistence interface for the channel entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChannelEntryPersistenceImpl
 * @see ChannelEntryUtil
 * @generated
 */
public interface ChannelEntryPersistence extends BasePersistence<ChannelEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ChannelEntryUtil} to access the channel entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the channel entry in the entity cache if it is enabled.
	*
	* @param channelEntry the channel entry
	*/
	public void cacheResult(
		org.lsp.liferay.portlet.socialliving.model.ChannelEntry channelEntry);

	/**
	* Caches the channel entries in the entity cache if it is enabled.
	*
	* @param channelEntries the channel entries
	*/
	public void cacheResult(
		java.util.List<org.lsp.liferay.portlet.socialliving.model.ChannelEntry> channelEntries);

	/**
	* Creates a new channel entry with the primary key. Does not add the channel entry to the database.
	*
	* @param channelEntryId the primary key for the new channel entry
	* @return the new channel entry
	*/
	public org.lsp.liferay.portlet.socialliving.model.ChannelEntry create(
		long channelEntryId);

	/**
	* Removes the channel entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param channelEntryId the primary key of the channel entry
	* @return the channel entry that was removed
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException if a channel entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.ChannelEntry remove(
		long channelEntryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException;

	public org.lsp.liferay.portlet.socialliving.model.ChannelEntry updateImpl(
		org.lsp.liferay.portlet.socialliving.model.ChannelEntry channelEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the channel entry with the primary key or throws a {@link org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException} if it could not be found.
	*
	* @param channelEntryId the primary key of the channel entry
	* @return the channel entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException if a channel entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.ChannelEntry findByPrimaryKey(
		long channelEntryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException;

	/**
	* Returns the channel entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param channelEntryId the primary key of the channel entry
	* @return the channel entry, or <code>null</code> if a channel entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.ChannelEntry fetchByPrimaryKey(
		long channelEntryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the channel entries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching channel entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.lsp.liferay.portlet.socialliving.model.ChannelEntry> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.lsp.liferay.portlet.socialliving.model.ChannelEntry> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.lsp.liferay.portlet.socialliving.model.ChannelEntry> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first channel entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException if a matching channel entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.ChannelEntry findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException;

	/**
	* Returns the first channel entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel entry, or <code>null</code> if a matching channel entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.ChannelEntry fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last channel entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException if a matching channel entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.ChannelEntry findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException;

	/**
	* Returns the last channel entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel entry, or <code>null</code> if a matching channel entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.ChannelEntry fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the channel entries before and after the current channel entry in the ordered set where groupId = &#63;.
	*
	* @param channelEntryId the primary key of the current channel entry
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next channel entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException if a channel entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.ChannelEntry[] findByGroupId_PrevAndNext(
		long channelEntryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException;

	/**
	* Returns all the channel entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching channel entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.lsp.liferay.portlet.socialliving.model.ChannelEntry> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.lsp.liferay.portlet.socialliving.model.ChannelEntry> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.lsp.liferay.portlet.socialliving.model.ChannelEntry> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first channel entry in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException if a matching channel entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.ChannelEntry findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException;

	/**
	* Returns the first channel entry in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel entry, or <code>null</code> if a matching channel entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.ChannelEntry fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last channel entry in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException if a matching channel entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.ChannelEntry findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException;

	/**
	* Returns the last channel entry in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel entry, or <code>null</code> if a matching channel entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.ChannelEntry fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the channel entries before and after the current channel entry in the ordered set where userId = &#63;.
	*
	* @param channelEntryId the primary key of the current channel entry
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next channel entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException if a channel entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.ChannelEntry[] findByUserId_PrevAndNext(
		long channelEntryId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException;

	/**
	* Returns all the channel entries where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @return the matching channel entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.lsp.liferay.portlet.socialliving.model.ChannelEntry> findByG_U(
		long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.lsp.liferay.portlet.socialliving.model.ChannelEntry> findByG_U(
		long groupId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.lsp.liferay.portlet.socialliving.model.ChannelEntry> findByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first channel entry in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException if a matching channel entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.ChannelEntry findByG_U_First(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException;

	/**
	* Returns the first channel entry in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel entry, or <code>null</code> if a matching channel entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.ChannelEntry fetchByG_U_First(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last channel entry in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException if a matching channel entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.ChannelEntry findByG_U_Last(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException;

	/**
	* Returns the last channel entry in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel entry, or <code>null</code> if a matching channel entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.ChannelEntry fetchByG_U_Last(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the channel entries before and after the current channel entry in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* @param channelEntryId the primary key of the current channel entry
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next channel entry
	* @throws org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException if a channel entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.socialliving.model.ChannelEntry[] findByG_U_PrevAndNext(
		long channelEntryId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException;

	/**
	* Returns all the channel entries.
	*
	* @return the channel entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.lsp.liferay.portlet.socialliving.model.ChannelEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.lsp.liferay.portlet.socialliving.model.ChannelEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.lsp.liferay.portlet.socialliving.model.ChannelEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the channel entries where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the channel entries where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the channel entries where groupId = &#63; and userId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_U(long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the channel entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of channel entries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching channel entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of channel entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching channel entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of channel entries where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @return the number of matching channel entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_U(long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of channel entries.
	*
	* @return the number of channel entries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}