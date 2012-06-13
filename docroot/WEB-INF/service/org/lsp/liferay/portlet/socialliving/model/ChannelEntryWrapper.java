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

package org.lsp.liferay.portlet.socialliving.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ChannelEntry}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ChannelEntry
 * @generated
 */
public class ChannelEntryWrapper implements ChannelEntry,
	ModelWrapper<ChannelEntry> {
	public ChannelEntryWrapper(ChannelEntry channelEntry) {
		_channelEntry = channelEntry;
	}

	public Class<?> getModelClass() {
		return ChannelEntry.class;
	}

	public String getModelClassName() {
		return ChannelEntry.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("channelEntryId", getChannelEntryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("comments", getComments());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long channelEntryId = (Long)attributes.get("channelEntryId");

		if (channelEntryId != null) {
			setChannelEntryId(channelEntryId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}
	}

	/**
	* Returns the primary key of this channel entry.
	*
	* @return the primary key of this channel entry
	*/
	public long getPrimaryKey() {
		return _channelEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this channel entry.
	*
	* @param primaryKey the primary key of this channel entry
	*/
	public void setPrimaryKey(long primaryKey) {
		_channelEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the channel entry ID of this channel entry.
	*
	* @return the channel entry ID of this channel entry
	*/
	public long getChannelEntryId() {
		return _channelEntry.getChannelEntryId();
	}

	/**
	* Sets the channel entry ID of this channel entry.
	*
	* @param channelEntryId the channel entry ID of this channel entry
	*/
	public void setChannelEntryId(long channelEntryId) {
		_channelEntry.setChannelEntryId(channelEntryId);
	}

	/**
	* Returns the group ID of this channel entry.
	*
	* @return the group ID of this channel entry
	*/
	public long getGroupId() {
		return _channelEntry.getGroupId();
	}

	/**
	* Sets the group ID of this channel entry.
	*
	* @param groupId the group ID of this channel entry
	*/
	public void setGroupId(long groupId) {
		_channelEntry.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this channel entry.
	*
	* @return the company ID of this channel entry
	*/
	public long getCompanyId() {
		return _channelEntry.getCompanyId();
	}

	/**
	* Sets the company ID of this channel entry.
	*
	* @param companyId the company ID of this channel entry
	*/
	public void setCompanyId(long companyId) {
		_channelEntry.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this channel entry.
	*
	* @return the user ID of this channel entry
	*/
	public long getUserId() {
		return _channelEntry.getUserId();
	}

	/**
	* Sets the user ID of this channel entry.
	*
	* @param userId the user ID of this channel entry
	*/
	public void setUserId(long userId) {
		_channelEntry.setUserId(userId);
	}

	/**
	* Returns the user uuid of this channel entry.
	*
	* @return the user uuid of this channel entry
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _channelEntry.getUserUuid();
	}

	/**
	* Sets the user uuid of this channel entry.
	*
	* @param userUuid the user uuid of this channel entry
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_channelEntry.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this channel entry.
	*
	* @return the user name of this channel entry
	*/
	public java.lang.String getUserName() {
		return _channelEntry.getUserName();
	}

	/**
	* Sets the user name of this channel entry.
	*
	* @param userName the user name of this channel entry
	*/
	public void setUserName(java.lang.String userName) {
		_channelEntry.setUserName(userName);
	}

	/**
	* Returns the create date of this channel entry.
	*
	* @return the create date of this channel entry
	*/
	public java.util.Date getCreateDate() {
		return _channelEntry.getCreateDate();
	}

	/**
	* Sets the create date of this channel entry.
	*
	* @param createDate the create date of this channel entry
	*/
	public void setCreateDate(java.util.Date createDate) {
		_channelEntry.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this channel entry.
	*
	* @return the modified date of this channel entry
	*/
	public java.util.Date getModifiedDate() {
		return _channelEntry.getModifiedDate();
	}

	/**
	* Sets the modified date of this channel entry.
	*
	* @param modifiedDate the modified date of this channel entry
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_channelEntry.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the comments of this channel entry.
	*
	* @return the comments of this channel entry
	*/
	public java.lang.String getComments() {
		return _channelEntry.getComments();
	}

	/**
	* Sets the comments of this channel entry.
	*
	* @param comments the comments of this channel entry
	*/
	public void setComments(java.lang.String comments) {
		_channelEntry.setComments(comments);
	}

	public boolean isNew() {
		return _channelEntry.isNew();
	}

	public void setNew(boolean n) {
		_channelEntry.setNew(n);
	}

	public boolean isCachedModel() {
		return _channelEntry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_channelEntry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _channelEntry.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _channelEntry.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_channelEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _channelEntry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_channelEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ChannelEntryWrapper((ChannelEntry)_channelEntry.clone());
	}

	public int compareTo(
		org.lsp.liferay.portlet.socialliving.model.ChannelEntry channelEntry) {
		return _channelEntry.compareTo(channelEntry);
	}

	@Override
	public int hashCode() {
		return _channelEntry.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.lsp.liferay.portlet.socialliving.model.ChannelEntry> toCacheModel() {
		return _channelEntry.toCacheModel();
	}

	public org.lsp.liferay.portlet.socialliving.model.ChannelEntry toEscapedModel() {
		return new ChannelEntryWrapper(_channelEntry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _channelEntry.toString();
	}

	public java.lang.String toXmlString() {
		return _channelEntry.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_channelEntry.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ChannelEntry getWrappedChannelEntry() {
		return _channelEntry;
	}

	public ChannelEntry getWrappedModel() {
		return _channelEntry;
	}

	public void resetOriginalValues() {
		_channelEntry.resetOriginalValues();
	}

	private ChannelEntry _channelEntry;
}