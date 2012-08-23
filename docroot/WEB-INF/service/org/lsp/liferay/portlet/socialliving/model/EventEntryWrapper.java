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
 * This class is a wrapper for {@link EventEntry}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       EventEntry
 * @generated
 */
public class EventEntryWrapper implements EventEntry, ModelWrapper<EventEntry> {
	public EventEntryWrapper(EventEntry eventEntry) {
		_eventEntry = eventEntry;
	}

	public Class<?> getModelClass() {
		return EventEntry.class;
	}

	public String getModelClassName() {
		return EventEntry.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eventEntryId", getEventEntryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("totalAttendees", getTotalAttendees());
		attributes.put("maxAttendees", getMaxAttendees());
		attributes.put("price", getPrice());
		attributes.put("thumbnailId", getThumbnailId());
		attributes.put("latitude", getLatitude());
		attributes.put("longitude", getLongitude());
		attributes.put("location", getLocation());
		attributes.put("withSpouse", getWithSpouse());
		attributes.put("withChildren", getWithChildren());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long eventEntryId = (Long)attributes.get("eventEntryId");

		if (eventEntryId != null) {
			setEventEntryId(eventEntryId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Integer totalAttendees = (Integer)attributes.get("totalAttendees");

		if (totalAttendees != null) {
			setTotalAttendees(totalAttendees);
		}

		Integer maxAttendees = (Integer)attributes.get("maxAttendees");

		if (maxAttendees != null) {
			setMaxAttendees(maxAttendees);
		}

		Double price = (Double)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		Long thumbnailId = (Long)attributes.get("thumbnailId");

		if (thumbnailId != null) {
			setThumbnailId(thumbnailId);
		}

		String latitude = (String)attributes.get("latitude");

		if (latitude != null) {
			setLatitude(latitude);
		}

		String longitude = (String)attributes.get("longitude");

		if (longitude != null) {
			setLongitude(longitude);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		Boolean withSpouse = (Boolean)attributes.get("withSpouse");

		if (withSpouse != null) {
			setWithSpouse(withSpouse);
		}

		Boolean withChildren = (Boolean)attributes.get("withChildren");

		if (withChildren != null) {
			setWithChildren(withChildren);
		}
	}

	/**
	* Returns the primary key of this event entry.
	*
	* @return the primary key of this event entry
	*/
	public long getPrimaryKey() {
		return _eventEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this event entry.
	*
	* @param primaryKey the primary key of this event entry
	*/
	public void setPrimaryKey(long primaryKey) {
		_eventEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the event entry ID of this event entry.
	*
	* @return the event entry ID of this event entry
	*/
	public long getEventEntryId() {
		return _eventEntry.getEventEntryId();
	}

	/**
	* Sets the event entry ID of this event entry.
	*
	* @param eventEntryId the event entry ID of this event entry
	*/
	public void setEventEntryId(long eventEntryId) {
		_eventEntry.setEventEntryId(eventEntryId);
	}

	/**
	* Returns the company ID of this event entry.
	*
	* @return the company ID of this event entry
	*/
	public long getCompanyId() {
		return _eventEntry.getCompanyId();
	}

	/**
	* Sets the company ID of this event entry.
	*
	* @param companyId the company ID of this event entry
	*/
	public void setCompanyId(long companyId) {
		_eventEntry.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this event entry.
	*
	* @return the group ID of this event entry
	*/
	public long getGroupId() {
		return _eventEntry.getGroupId();
	}

	/**
	* Sets the group ID of this event entry.
	*
	* @param groupId the group ID of this event entry
	*/
	public void setGroupId(long groupId) {
		_eventEntry.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this event entry.
	*
	* @return the user ID of this event entry
	*/
	public long getUserId() {
		return _eventEntry.getUserId();
	}

	/**
	* Sets the user ID of this event entry.
	*
	* @param userId the user ID of this event entry
	*/
	public void setUserId(long userId) {
		_eventEntry.setUserId(userId);
	}

	/**
	* Returns the user uuid of this event entry.
	*
	* @return the user uuid of this event entry
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventEntry.getUserUuid();
	}

	/**
	* Sets the user uuid of this event entry.
	*
	* @param userUuid the user uuid of this event entry
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_eventEntry.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this event entry.
	*
	* @return the user name of this event entry
	*/
	public java.lang.String getUserName() {
		return _eventEntry.getUserName();
	}

	/**
	* Sets the user name of this event entry.
	*
	* @param userName the user name of this event entry
	*/
	public void setUserName(java.lang.String userName) {
		_eventEntry.setUserName(userName);
	}

	/**
	* Returns the create date of this event entry.
	*
	* @return the create date of this event entry
	*/
	public java.util.Date getCreateDate() {
		return _eventEntry.getCreateDate();
	}

	/**
	* Sets the create date of this event entry.
	*
	* @param createDate the create date of this event entry
	*/
	public void setCreateDate(java.util.Date createDate) {
		_eventEntry.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this event entry.
	*
	* @return the modified date of this event entry
	*/
	public java.util.Date getModifiedDate() {
		return _eventEntry.getModifiedDate();
	}

	/**
	* Sets the modified date of this event entry.
	*
	* @param modifiedDate the modified date of this event entry
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_eventEntry.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the title of this event entry.
	*
	* @return the title of this event entry
	*/
	public java.lang.String getTitle() {
		return _eventEntry.getTitle();
	}

	/**
	* Sets the title of this event entry.
	*
	* @param title the title of this event entry
	*/
	public void setTitle(java.lang.String title) {
		_eventEntry.setTitle(title);
	}

	/**
	* Returns the description of this event entry.
	*
	* @return the description of this event entry
	*/
	public java.lang.String getDescription() {
		return _eventEntry.getDescription();
	}

	/**
	* Sets the description of this event entry.
	*
	* @param description the description of this event entry
	*/
	public void setDescription(java.lang.String description) {
		_eventEntry.setDescription(description);
	}

	/**
	* Returns the start date of this event entry.
	*
	* @return the start date of this event entry
	*/
	public java.util.Date getStartDate() {
		return _eventEntry.getStartDate();
	}

	/**
	* Sets the start date of this event entry.
	*
	* @param startDate the start date of this event entry
	*/
	public void setStartDate(java.util.Date startDate) {
		_eventEntry.setStartDate(startDate);
	}

	/**
	* Returns the end date of this event entry.
	*
	* @return the end date of this event entry
	*/
	public java.util.Date getEndDate() {
		return _eventEntry.getEndDate();
	}

	/**
	* Sets the end date of this event entry.
	*
	* @param endDate the end date of this event entry
	*/
	public void setEndDate(java.util.Date endDate) {
		_eventEntry.setEndDate(endDate);
	}

	/**
	* Returns the total attendees of this event entry.
	*
	* @return the total attendees of this event entry
	*/
	public int getTotalAttendees() {
		return _eventEntry.getTotalAttendees();
	}

	/**
	* Sets the total attendees of this event entry.
	*
	* @param totalAttendees the total attendees of this event entry
	*/
	public void setTotalAttendees(int totalAttendees) {
		_eventEntry.setTotalAttendees(totalAttendees);
	}

	/**
	* Returns the max attendees of this event entry.
	*
	* @return the max attendees of this event entry
	*/
	public int getMaxAttendees() {
		return _eventEntry.getMaxAttendees();
	}

	/**
	* Sets the max attendees of this event entry.
	*
	* @param maxAttendees the max attendees of this event entry
	*/
	public void setMaxAttendees(int maxAttendees) {
		_eventEntry.setMaxAttendees(maxAttendees);
	}

	/**
	* Returns the price of this event entry.
	*
	* @return the price of this event entry
	*/
	public double getPrice() {
		return _eventEntry.getPrice();
	}

	/**
	* Sets the price of this event entry.
	*
	* @param price the price of this event entry
	*/
	public void setPrice(double price) {
		_eventEntry.setPrice(price);
	}

	/**
	* Returns the thumbnail ID of this event entry.
	*
	* @return the thumbnail ID of this event entry
	*/
	public long getThumbnailId() {
		return _eventEntry.getThumbnailId();
	}

	/**
	* Sets the thumbnail ID of this event entry.
	*
	* @param thumbnailId the thumbnail ID of this event entry
	*/
	public void setThumbnailId(long thumbnailId) {
		_eventEntry.setThumbnailId(thumbnailId);
	}

	/**
	* Returns the latitude of this event entry.
	*
	* @return the latitude of this event entry
	*/
	public java.lang.String getLatitude() {
		return _eventEntry.getLatitude();
	}

	/**
	* Sets the latitude of this event entry.
	*
	* @param latitude the latitude of this event entry
	*/
	public void setLatitude(java.lang.String latitude) {
		_eventEntry.setLatitude(latitude);
	}

	/**
	* Returns the longitude of this event entry.
	*
	* @return the longitude of this event entry
	*/
	public java.lang.String getLongitude() {
		return _eventEntry.getLongitude();
	}

	/**
	* Sets the longitude of this event entry.
	*
	* @param longitude the longitude of this event entry
	*/
	public void setLongitude(java.lang.String longitude) {
		_eventEntry.setLongitude(longitude);
	}

	/**
	* Returns the location of this event entry.
	*
	* @return the location of this event entry
	*/
	public java.lang.String getLocation() {
		return _eventEntry.getLocation();
	}

	/**
	* Sets the location of this event entry.
	*
	* @param location the location of this event entry
	*/
	public void setLocation(java.lang.String location) {
		_eventEntry.setLocation(location);
	}

	/**
	* Returns the with spouse of this event entry.
	*
	* @return the with spouse of this event entry
	*/
	public boolean getWithSpouse() {
		return _eventEntry.getWithSpouse();
	}

	/**
	* Returns <code>true</code> if this event entry is with spouse.
	*
	* @return <code>true</code> if this event entry is with spouse; <code>false</code> otherwise
	*/
	public boolean isWithSpouse() {
		return _eventEntry.isWithSpouse();
	}

	/**
	* Sets whether this event entry is with spouse.
	*
	* @param withSpouse the with spouse of this event entry
	*/
	public void setWithSpouse(boolean withSpouse) {
		_eventEntry.setWithSpouse(withSpouse);
	}

	/**
	* Returns the with children of this event entry.
	*
	* @return the with children of this event entry
	*/
	public boolean getWithChildren() {
		return _eventEntry.getWithChildren();
	}

	/**
	* Returns <code>true</code> if this event entry is with children.
	*
	* @return <code>true</code> if this event entry is with children; <code>false</code> otherwise
	*/
	public boolean isWithChildren() {
		return _eventEntry.isWithChildren();
	}

	/**
	* Sets whether this event entry is with children.
	*
	* @param withChildren the with children of this event entry
	*/
	public void setWithChildren(boolean withChildren) {
		_eventEntry.setWithChildren(withChildren);
	}

	public boolean isNew() {
		return _eventEntry.isNew();
	}

	public void setNew(boolean n) {
		_eventEntry.setNew(n);
	}

	public boolean isCachedModel() {
		return _eventEntry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_eventEntry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _eventEntry.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _eventEntry.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_eventEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _eventEntry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_eventEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EventEntryWrapper((EventEntry)_eventEntry.clone());
	}

	public int compareTo(
		org.lsp.liferay.portlet.socialliving.model.EventEntry eventEntry) {
		return _eventEntry.compareTo(eventEntry);
	}

	@Override
	public int hashCode() {
		return _eventEntry.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.lsp.liferay.portlet.socialliving.model.EventEntry> toCacheModel() {
		return _eventEntry.toCacheModel();
	}

	public org.lsp.liferay.portlet.socialliving.model.EventEntry toEscapedModel() {
		return new EventEntryWrapper(_eventEntry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _eventEntry.toString();
	}

	public java.lang.String toXmlString() {
		return _eventEntry.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_eventEntry.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public EventEntry getWrappedEventEntry() {
		return _eventEntry;
	}

	public EventEntry getWrappedModel() {
		return _eventEntry;
	}

	public void resetOriginalValues() {
		_eventEntry.resetOriginalValues();
	}

	private EventEntry _eventEntry;
}