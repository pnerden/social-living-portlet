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

package org.lsp.liferay.portlet.socialliving.service.impl;

import java.util.Date;
import java.util.List;

import org.lsp.liferay.portlet.socialliving.model.EventRegistration;
import org.lsp.liferay.portlet.socialliving.service.base.EventRegistrationLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;

/**
 * The implementation of the event registration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.lsp.liferay.portlet.socialliving.service.EventRegistrationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see org.lsp.liferay.portlet.socialliving.service.base.EventRegistrationLocalServiceBaseImpl
 * @see org.lsp.liferay.portlet.socialliving.service.EventRegistrationLocalServiceUtil
 */
public class EventRegistrationLocalServiceImpl
	extends EventRegistrationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.lsp.liferay.portlet.socialliving.service.EventRegistrationLocalServiceUtil} to access the event registration local service.
	 */
	
	public EventRegistration getEventRegistration(
			long userId, long eventEntryId)
		throws PortalException, SystemException {

		return eventRegistrationPersistence.findByU_ME(
			userId, eventEntryId);
	}

	public List<EventRegistration> getEventRegistrations(
			long eventEntryId, int status, int start, int end)
		throws SystemException {

		return eventRegistrationPersistence.findByME_S(
			eventEntryId, status, start, end);
	}

	public int getEventRegistrationsCount(long eventEntryId, int status)
		throws SystemException {

		return eventRegistrationPersistence.countByME_S(
			eventEntryId, status);
	}

	public EventRegistration updateEventRegistration(
			long userId, long eventEntryId, int status, String comments)
		throws PortalException, SystemException {

		User user = userLocalService.getUserById(userId);
		Date now = new Date();

		EventRegistration eventRegistration =
			eventRegistrationPersistence.fetchByU_ME(userId, eventEntryId);

		if (eventRegistration == null) {
			long eventRegistrationId = counterLocalService.increment();

			eventRegistration = eventRegistrationPersistence.create(
				eventRegistrationId);

			eventRegistration.setCompanyId(user.getCompanyId());
			eventRegistration.setUserId(user.getUserId());
			eventRegistration.setUserName(user.getFullName());
			eventRegistration.setCreateDate(now);
			eventRegistration.setEventEntryId(eventEntryId);
		}

		eventRegistration.setModifiedDate(now);
		eventRegistration.setStatus(status);
		eventRegistration.setComments(comments);

		eventRegistrationPersistence.update(eventRegistration, false);

		return eventRegistration;
	}
	
}