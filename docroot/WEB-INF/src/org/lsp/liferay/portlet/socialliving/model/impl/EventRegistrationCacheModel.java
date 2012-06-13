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

import org.lsp.liferay.portlet.socialliving.model.EventRegistration;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing EventRegistration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see EventRegistration
 * @generated
 */
public class EventRegistrationCacheModel implements CacheModel<EventRegistration>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{eventRegistrationId=");
		sb.append(eventRegistrationId);
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
		sb.append(", eventEntryId=");
		sb.append(eventEntryId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", comments=");
		sb.append(comments);
		sb.append("}");

		return sb.toString();
	}

	public EventRegistration toEntityModel() {
		EventRegistrationImpl eventRegistrationImpl = new EventRegistrationImpl();

		eventRegistrationImpl.setEventRegistrationId(eventRegistrationId);
		eventRegistrationImpl.setCompanyId(companyId);
		eventRegistrationImpl.setGroupId(groupId);
		eventRegistrationImpl.setUserId(userId);

		if (userName == null) {
			eventRegistrationImpl.setUserName(StringPool.BLANK);
		}
		else {
			eventRegistrationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			eventRegistrationImpl.setCreateDate(null);
		}
		else {
			eventRegistrationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			eventRegistrationImpl.setModifiedDate(null);
		}
		else {
			eventRegistrationImpl.setModifiedDate(new Date(modifiedDate));
		}

		eventRegistrationImpl.setEventEntryId(eventEntryId);
		eventRegistrationImpl.setStatus(status);

		if (comments == null) {
			eventRegistrationImpl.setComments(StringPool.BLANK);
		}
		else {
			eventRegistrationImpl.setComments(comments);
		}

		eventRegistrationImpl.resetOriginalValues();

		return eventRegistrationImpl;
	}

	public long eventRegistrationId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long eventEntryId;
	public int status;
	public String comments;
}