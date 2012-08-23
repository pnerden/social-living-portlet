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

package org.lsp.liferay.portlet.socialliving.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.lsp.liferay.portlet.socialliving.model.EventEntry;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing EventEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see EventEntry
 * @generated
 */
public class EventEntryCacheModel implements CacheModel<EventEntry>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{eventEntryId=");
		sb.append(eventEntryId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", totalAttendees=");
		sb.append(totalAttendees);
		sb.append(", maxAttendees=");
		sb.append(maxAttendees);
		sb.append(", price=");
		sb.append(price);
		sb.append(", thumbnailId=");
		sb.append(thumbnailId);
		sb.append(", latitude=");
		sb.append(latitude);
		sb.append(", longitude=");
		sb.append(longitude);
		sb.append(", location=");
		sb.append(location);
		sb.append(", withSpouse=");
		sb.append(withSpouse);
		sb.append(", withChildren=");
		sb.append(withChildren);
		sb.append("}");

		return sb.toString();
	}

	public EventEntry toEntityModel() {
		EventEntryImpl eventEntryImpl = new EventEntryImpl();

		eventEntryImpl.setEventEntryId(eventEntryId);
		eventEntryImpl.setCompanyId(companyId);
		eventEntryImpl.setGroupId(groupId);
		eventEntryImpl.setUserId(userId);

		if (userName == null) {
			eventEntryImpl.setUserName(StringPool.BLANK);
		}
		else {
			eventEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			eventEntryImpl.setCreateDate(null);
		}
		else {
			eventEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			eventEntryImpl.setModifiedDate(null);
		}
		else {
			eventEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			eventEntryImpl.setTitle(StringPool.BLANK);
		}
		else {
			eventEntryImpl.setTitle(title);
		}

		if (description == null) {
			eventEntryImpl.setDescription(StringPool.BLANK);
		}
		else {
			eventEntryImpl.setDescription(description);
		}

		if (startDate == Long.MIN_VALUE) {
			eventEntryImpl.setStartDate(null);
		}
		else {
			eventEntryImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			eventEntryImpl.setEndDate(null);
		}
		else {
			eventEntryImpl.setEndDate(new Date(endDate));
		}

		eventEntryImpl.setTotalAttendees(totalAttendees);
		eventEntryImpl.setMaxAttendees(maxAttendees);
		eventEntryImpl.setPrice(price);
		eventEntryImpl.setThumbnailId(thumbnailId);

		if (latitude == null) {
			eventEntryImpl.setLatitude(StringPool.BLANK);
		}
		else {
			eventEntryImpl.setLatitude(latitude);
		}

		if (longitude == null) {
			eventEntryImpl.setLongitude(StringPool.BLANK);
		}
		else {
			eventEntryImpl.setLongitude(longitude);
		}

		if (location == null) {
			eventEntryImpl.setLocation(StringPool.BLANK);
		}
		else {
			eventEntryImpl.setLocation(location);
		}

		eventEntryImpl.setWithSpouse(withSpouse);
		eventEntryImpl.setWithChildren(withChildren);

		eventEntryImpl.resetOriginalValues();

		return eventEntryImpl;
	}

	public long eventEntryId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String description;
	public long startDate;
	public long endDate;
	public int totalAttendees;
	public int maxAttendees;
	public double price;
	public long thumbnailId;
	public String latitude;
	public String longitude;
	public String location;
	public boolean withSpouse;
	public boolean withChildren;
}