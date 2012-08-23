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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException;
import org.lsp.liferay.portlet.socialliving.model.EventRegistration;
import org.lsp.liferay.portlet.socialliving.model.impl.EventRegistrationImpl;
import org.lsp.liferay.portlet.socialliving.model.impl.EventRegistrationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the event registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventRegistrationPersistence
 * @see EventRegistrationUtil
 * @generated
 */
public class EventRegistrationPersistenceImpl extends BasePersistenceImpl<EventRegistration>
	implements EventRegistrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EventRegistrationUtil} to access the event registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EventRegistrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTENTRYID =
		new FinderPath(EventRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			EventRegistrationModelImpl.FINDER_CACHE_ENABLED,
			EventRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEventEntryId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTENTRYID =
		new FinderPath(EventRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			EventRegistrationModelImpl.FINDER_CACHE_ENABLED,
			EventRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEventEntryId",
			new String[] { Long.class.getName() },
			EventRegistrationModelImpl.EVENTENTRYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EVENTENTRYID = new FinderPath(EventRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			EventRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEventEntryId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_U_ME = new FinderPath(EventRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			EventRegistrationModelImpl.FINDER_CACHE_ENABLED,
			EventRegistrationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByU_ME",
			new String[] { Long.class.getName(), Long.class.getName() },
			EventRegistrationModelImpl.USERID_COLUMN_BITMASK |
			EventRegistrationModelImpl.EVENTENTRYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_U_ME = new FinderPath(EventRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			EventRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_ME",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ME_S = new FinderPath(EventRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			EventRegistrationModelImpl.FINDER_CACHE_ENABLED,
			EventRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByME_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ME_S = new FinderPath(EventRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			EventRegistrationModelImpl.FINDER_CACHE_ENABLED,
			EventRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByME_S",
			new String[] { Long.class.getName(), Integer.class.getName() },
			EventRegistrationModelImpl.EVENTENTRYID_COLUMN_BITMASK |
			EventRegistrationModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ME_S = new FinderPath(EventRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			EventRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByME_S",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(EventRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			EventRegistrationModelImpl.FINDER_CACHE_ENABLED,
			EventRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(EventRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			EventRegistrationModelImpl.FINDER_CACHE_ENABLED,
			EventRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			EventRegistrationModelImpl.COMPANYID_COLUMN_BITMASK |
			EventRegistrationModelImpl.USERID_COLUMN_BITMASK |
			EventRegistrationModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(EventRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			EventRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EventRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			EventRegistrationModelImpl.FINDER_CACHE_ENABLED,
			EventRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EventRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			EventRegistrationModelImpl.FINDER_CACHE_ENABLED,
			EventRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EventRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			EventRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the event registration in the entity cache if it is enabled.
	 *
	 * @param eventRegistration the event registration
	 */
	public void cacheResult(EventRegistration eventRegistration) {
		EntityCacheUtil.putResult(EventRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			EventRegistrationImpl.class, eventRegistration.getPrimaryKey(),
			eventRegistration);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_U_ME,
			new Object[] {
				Long.valueOf(eventRegistration.getUserId()),
				Long.valueOf(eventRegistration.getEventEntryId())
			}, eventRegistration);

		eventRegistration.resetOriginalValues();
	}

	/**
	 * Caches the event registrations in the entity cache if it is enabled.
	 *
	 * @param eventRegistrations the event registrations
	 */
	public void cacheResult(List<EventRegistration> eventRegistrations) {
		for (EventRegistration eventRegistration : eventRegistrations) {
			if (EntityCacheUtil.getResult(
						EventRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						EventRegistrationImpl.class,
						eventRegistration.getPrimaryKey()) == null) {
				cacheResult(eventRegistration);
			}
			else {
				eventRegistration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all event registrations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EventRegistrationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EventRegistrationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the event registration.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EventRegistration eventRegistration) {
		EntityCacheUtil.removeResult(EventRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			EventRegistrationImpl.class, eventRegistration.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(eventRegistration);
	}

	@Override
	public void clearCache(List<EventRegistration> eventRegistrations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EventRegistration eventRegistration : eventRegistrations) {
			EntityCacheUtil.removeResult(EventRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				EventRegistrationImpl.class, eventRegistration.getPrimaryKey());

			clearUniqueFindersCache(eventRegistration);
		}
	}

	protected void clearUniqueFindersCache(EventRegistration eventRegistration) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_U_ME,
			new Object[] {
				Long.valueOf(eventRegistration.getUserId()),
				Long.valueOf(eventRegistration.getEventEntryId())
			});
	}

	/**
	 * Creates a new event registration with the primary key. Does not add the event registration to the database.
	 *
	 * @param eventRegistrationId the primary key for the new event registration
	 * @return the new event registration
	 */
	public EventRegistration create(long eventRegistrationId) {
		EventRegistration eventRegistration = new EventRegistrationImpl();

		eventRegistration.setNew(true);
		eventRegistration.setPrimaryKey(eventRegistrationId);

		return eventRegistration;
	}

	/**
	 * Removes the event registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventRegistrationId the primary key of the event registration
	 * @return the event registration that was removed
	 * @throws org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException if a event registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventRegistration remove(long eventRegistrationId)
		throws NoSuchEventRegistrationException, SystemException {
		return remove(Long.valueOf(eventRegistrationId));
	}

	/**
	 * Removes the event registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the event registration
	 * @return the event registration that was removed
	 * @throws org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException if a event registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventRegistration remove(Serializable primaryKey)
		throws NoSuchEventRegistrationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EventRegistration eventRegistration = (EventRegistration)session.get(EventRegistrationImpl.class,
					primaryKey);

			if (eventRegistration == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEventRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(eventRegistration);
		}
		catch (NoSuchEventRegistrationException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected EventRegistration removeImpl(EventRegistration eventRegistration)
		throws SystemException {
		eventRegistration = toUnwrappedModel(eventRegistration);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, eventRegistration);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(eventRegistration);

		return eventRegistration;
	}

	@Override
	public EventRegistration updateImpl(
		org.lsp.liferay.portlet.socialliving.model.EventRegistration eventRegistration,
		boolean merge) throws SystemException {
		eventRegistration = toUnwrappedModel(eventRegistration);

		boolean isNew = eventRegistration.isNew();

		EventRegistrationModelImpl eventRegistrationModelImpl = (EventRegistrationModelImpl)eventRegistration;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, eventRegistration, merge);

			eventRegistration.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EventRegistrationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((eventRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTENTRYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(eventRegistrationModelImpl.getOriginalEventEntryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTENTRYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTENTRYID,
					args);

				args = new Object[] {
						Long.valueOf(eventRegistrationModelImpl.getEventEntryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTENTRYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTENTRYID,
					args);
			}

			if ((eventRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ME_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(eventRegistrationModelImpl.getOriginalEventEntryId()),
						Integer.valueOf(eventRegistrationModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ME_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ME_S,
					args);

				args = new Object[] {
						Long.valueOf(eventRegistrationModelImpl.getEventEntryId()),
						Integer.valueOf(eventRegistrationModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ME_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ME_S,
					args);
			}

			if ((eventRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(eventRegistrationModelImpl.getOriginalCompanyId()),
						Long.valueOf(eventRegistrationModelImpl.getOriginalUserId()),
						Integer.valueOf(eventRegistrationModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] {
						Long.valueOf(eventRegistrationModelImpl.getCompanyId()),
						Long.valueOf(eventRegistrationModelImpl.getUserId()),
						Integer.valueOf(eventRegistrationModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(EventRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			EventRegistrationImpl.class, eventRegistration.getPrimaryKey(),
			eventRegistration);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_U_ME,
				new Object[] {
					Long.valueOf(eventRegistration.getUserId()),
					Long.valueOf(eventRegistration.getEventEntryId())
				}, eventRegistration);
		}
		else {
			if ((eventRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_U_ME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(eventRegistrationModelImpl.getOriginalUserId()),
						Long.valueOf(eventRegistrationModelImpl.getOriginalEventEntryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U_ME, args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_U_ME, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_U_ME,
					new Object[] {
						Long.valueOf(eventRegistration.getUserId()),
						Long.valueOf(eventRegistration.getEventEntryId())
					}, eventRegistration);
			}
		}

		return eventRegistration;
	}

	protected EventRegistration toUnwrappedModel(
		EventRegistration eventRegistration) {
		if (eventRegistration instanceof EventRegistrationImpl) {
			return eventRegistration;
		}

		EventRegistrationImpl eventRegistrationImpl = new EventRegistrationImpl();

		eventRegistrationImpl.setNew(eventRegistration.isNew());
		eventRegistrationImpl.setPrimaryKey(eventRegistration.getPrimaryKey());

		eventRegistrationImpl.setEventRegistrationId(eventRegistration.getEventRegistrationId());
		eventRegistrationImpl.setCompanyId(eventRegistration.getCompanyId());
		eventRegistrationImpl.setGroupId(eventRegistration.getGroupId());
		eventRegistrationImpl.setUserId(eventRegistration.getUserId());
		eventRegistrationImpl.setUserName(eventRegistration.getUserName());
		eventRegistrationImpl.setCreateDate(eventRegistration.getCreateDate());
		eventRegistrationImpl.setModifiedDate(eventRegistration.getModifiedDate());
		eventRegistrationImpl.setEventEntryId(eventRegistration.getEventEntryId());
		eventRegistrationImpl.setStatus(eventRegistration.getStatus());
		eventRegistrationImpl.setComments(eventRegistration.getComments());

		return eventRegistrationImpl;
	}

	/**
	 * Returns the event registration with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the event registration
	 * @return the event registration
	 * @throws com.liferay.portal.NoSuchModelException if a event registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the event registration with the primary key or throws a {@link org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException} if it could not be found.
	 *
	 * @param eventRegistrationId the primary key of the event registration
	 * @return the event registration
	 * @throws org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException if a event registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventRegistration findByPrimaryKey(long eventRegistrationId)
		throws NoSuchEventRegistrationException, SystemException {
		EventRegistration eventRegistration = fetchByPrimaryKey(eventRegistrationId);

		if (eventRegistration == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					eventRegistrationId);
			}

			throw new NoSuchEventRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				eventRegistrationId);
		}

		return eventRegistration;
	}

	/**
	 * Returns the event registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the event registration
	 * @return the event registration, or <code>null</code> if a event registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventRegistration fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the event registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventRegistrationId the primary key of the event registration
	 * @return the event registration, or <code>null</code> if a event registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventRegistration fetchByPrimaryKey(long eventRegistrationId)
		throws SystemException {
		EventRegistration eventRegistration = (EventRegistration)EntityCacheUtil.getResult(EventRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				EventRegistrationImpl.class, eventRegistrationId);

		if (eventRegistration == _nullEventRegistration) {
			return null;
		}

		if (eventRegistration == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				eventRegistration = (EventRegistration)session.get(EventRegistrationImpl.class,
						Long.valueOf(eventRegistrationId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (eventRegistration != null) {
					cacheResult(eventRegistration);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(EventRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						EventRegistrationImpl.class, eventRegistrationId,
						_nullEventRegistration);
				}

				closeSession(session);
			}
		}

		return eventRegistration;
	}

	/**
	 * Returns all the event registrations where eventEntryId = &#63;.
	 *
	 * @param eventEntryId the event entry ID
	 * @return the matching event registrations
	 * @throws SystemException if a system exception occurred
	 */
	public List<EventRegistration> findByEventEntryId(long eventEntryId)
		throws SystemException {
		return findByEventEntryId(eventEntryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	public List<EventRegistration> findByEventEntryId(long eventEntryId,
		int start, int end) throws SystemException {
		return findByEventEntryId(eventEntryId, start, end, null);
	}

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
	public List<EventRegistration> findByEventEntryId(long eventEntryId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTENTRYID;
			finderArgs = new Object[] { eventEntryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTENTRYID;
			finderArgs = new Object[] {
					eventEntryId,
					
					start, end, orderByComparator
				};
		}

		List<EventRegistration> list = (List<EventRegistration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventRegistration eventRegistration : list) {
				if ((eventEntryId != eventRegistration.getEventEntryId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_EVENTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_EVENTENTRYID_EVENTENTRYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(EventRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(eventEntryId);

				list = (List<EventRegistration>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first event registration in the ordered set where eventEntryId = &#63;.
	 *
	 * @param eventEntryId the event entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event registration
	 * @throws org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException if a matching event registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventRegistration findByEventEntryId_First(long eventEntryId,
		OrderByComparator orderByComparator)
		throws NoSuchEventRegistrationException, SystemException {
		EventRegistration eventRegistration = fetchByEventEntryId_First(eventEntryId,
				orderByComparator);

		if (eventRegistration != null) {
			return eventRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventEntryId=");
		msg.append(eventEntryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventRegistrationException(msg.toString());
	}

	/**
	 * Returns the first event registration in the ordered set where eventEntryId = &#63;.
	 *
	 * @param eventEntryId the event entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event registration, or <code>null</code> if a matching event registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventRegistration fetchByEventEntryId_First(long eventEntryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EventRegistration> list = findByEventEntryId(eventEntryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last event registration in the ordered set where eventEntryId = &#63;.
	 *
	 * @param eventEntryId the event entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event registration
	 * @throws org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException if a matching event registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventRegistration findByEventEntryId_Last(long eventEntryId,
		OrderByComparator orderByComparator)
		throws NoSuchEventRegistrationException, SystemException {
		EventRegistration eventRegistration = fetchByEventEntryId_Last(eventEntryId,
				orderByComparator);

		if (eventRegistration != null) {
			return eventRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventEntryId=");
		msg.append(eventEntryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventRegistrationException(msg.toString());
	}

	/**
	 * Returns the last event registration in the ordered set where eventEntryId = &#63;.
	 *
	 * @param eventEntryId the event entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event registration, or <code>null</code> if a matching event registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventRegistration fetchByEventEntryId_Last(long eventEntryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEventEntryId(eventEntryId);

		List<EventRegistration> list = findByEventEntryId(eventEntryId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the event registrations before and after the current event registration in the ordered set where eventEntryId = &#63;.
	 *
	 * @param eventRegistrationId the primary key of the current event registration
	 * @param eventEntryId the event entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event registration
	 * @throws org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException if a event registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventRegistration[] findByEventEntryId_PrevAndNext(
		long eventRegistrationId, long eventEntryId,
		OrderByComparator orderByComparator)
		throws NoSuchEventRegistrationException, SystemException {
		EventRegistration eventRegistration = findByPrimaryKey(eventRegistrationId);

		Session session = null;

		try {
			session = openSession();

			EventRegistration[] array = new EventRegistrationImpl[3];

			array[0] = getByEventEntryId_PrevAndNext(session,
					eventRegistration, eventEntryId, orderByComparator, true);

			array[1] = eventRegistration;

			array[2] = getByEventEntryId_PrevAndNext(session,
					eventRegistration, eventEntryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EventRegistration getByEventEntryId_PrevAndNext(Session session,
		EventRegistration eventRegistration, long eventEntryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_EVENTENTRYID_EVENTENTRYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(EventRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(eventEntryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eventRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the event registration where userId = &#63; and eventEntryId = &#63; or throws a {@link org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @param eventEntryId the event entry ID
	 * @return the matching event registration
	 * @throws org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException if a matching event registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventRegistration findByU_ME(long userId, long eventEntryId)
		throws NoSuchEventRegistrationException, SystemException {
		EventRegistration eventRegistration = fetchByU_ME(userId, eventEntryId);

		if (eventRegistration == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", eventEntryId=");
			msg.append(eventEntryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEventRegistrationException(msg.toString());
		}

		return eventRegistration;
	}

	/**
	 * Returns the event registration where userId = &#63; and eventEntryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param eventEntryId the event entry ID
	 * @return the matching event registration, or <code>null</code> if a matching event registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventRegistration fetchByU_ME(long userId, long eventEntryId)
		throws SystemException {
		return fetchByU_ME(userId, eventEntryId, true);
	}

	/**
	 * Returns the event registration where userId = &#63; and eventEntryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param eventEntryId the event entry ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching event registration, or <code>null</code> if a matching event registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventRegistration fetchByU_ME(long userId, long eventEntryId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { userId, eventEntryId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_U_ME,
					finderArgs, this);
		}

		if (result instanceof EventRegistration) {
			EventRegistration eventRegistration = (EventRegistration)result;

			if ((userId != eventRegistration.getUserId()) ||
					(eventEntryId != eventRegistration.getEventEntryId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_EVENTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_U_ME_USERID_2);

			query.append(_FINDER_COLUMN_U_ME_EVENTENTRYID_2);

			query.append(EventRegistrationModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(eventEntryId);

				List<EventRegistration> list = q.list();

				result = list;

				EventRegistration eventRegistration = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_U_ME,
						finderArgs, list);
				}
				else {
					eventRegistration = list.get(0);

					cacheResult(eventRegistration);

					if ((eventRegistration.getUserId() != userId) ||
							(eventRegistration.getEventEntryId() != eventEntryId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_U_ME,
							finderArgs, eventRegistration);
					}
				}

				return eventRegistration;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_U_ME,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (EventRegistration)result;
			}
		}
	}

	/**
	 * Returns all the event registrations where eventEntryId = &#63; and status = &#63;.
	 *
	 * @param eventEntryId the event entry ID
	 * @param status the status
	 * @return the matching event registrations
	 * @throws SystemException if a system exception occurred
	 */
	public List<EventRegistration> findByME_S(long eventEntryId, int status)
		throws SystemException {
		return findByME_S(eventEntryId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	public List<EventRegistration> findByME_S(long eventEntryId, int status,
		int start, int end) throws SystemException {
		return findByME_S(eventEntryId, status, start, end, null);
	}

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
	public List<EventRegistration> findByME_S(long eventEntryId, int status,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ME_S;
			finderArgs = new Object[] { eventEntryId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ME_S;
			finderArgs = new Object[] {
					eventEntryId, status,
					
					start, end, orderByComparator
				};
		}

		List<EventRegistration> list = (List<EventRegistration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventRegistration eventRegistration : list) {
				if ((eventEntryId != eventRegistration.getEventEntryId()) ||
						(status != eventRegistration.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_EVENTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_ME_S_EVENTENTRYID_2);

			query.append(_FINDER_COLUMN_ME_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(EventRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(eventEntryId);

				qPos.add(status);

				list = (List<EventRegistration>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first event registration in the ordered set where eventEntryId = &#63; and status = &#63;.
	 *
	 * @param eventEntryId the event entry ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event registration
	 * @throws org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException if a matching event registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventRegistration findByME_S_First(long eventEntryId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchEventRegistrationException, SystemException {
		EventRegistration eventRegistration = fetchByME_S_First(eventEntryId,
				status, orderByComparator);

		if (eventRegistration != null) {
			return eventRegistration;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventEntryId=");
		msg.append(eventEntryId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventRegistrationException(msg.toString());
	}

	/**
	 * Returns the first event registration in the ordered set where eventEntryId = &#63; and status = &#63;.
	 *
	 * @param eventEntryId the event entry ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event registration, or <code>null</code> if a matching event registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventRegistration fetchByME_S_First(long eventEntryId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<EventRegistration> list = findByME_S(eventEntryId, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last event registration in the ordered set where eventEntryId = &#63; and status = &#63;.
	 *
	 * @param eventEntryId the event entry ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event registration
	 * @throws org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException if a matching event registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventRegistration findByME_S_Last(long eventEntryId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchEventRegistrationException, SystemException {
		EventRegistration eventRegistration = fetchByME_S_Last(eventEntryId,
				status, orderByComparator);

		if (eventRegistration != null) {
			return eventRegistration;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventEntryId=");
		msg.append(eventEntryId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventRegistrationException(msg.toString());
	}

	/**
	 * Returns the last event registration in the ordered set where eventEntryId = &#63; and status = &#63;.
	 *
	 * @param eventEntryId the event entry ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event registration, or <code>null</code> if a matching event registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventRegistration fetchByME_S_Last(long eventEntryId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByME_S(eventEntryId, status);

		List<EventRegistration> list = findByME_S(eventEntryId, status,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the event registrations before and after the current event registration in the ordered set where eventEntryId = &#63; and status = &#63;.
	 *
	 * @param eventRegistrationId the primary key of the current event registration
	 * @param eventEntryId the event entry ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event registration
	 * @throws org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException if a event registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventRegistration[] findByME_S_PrevAndNext(
		long eventRegistrationId, long eventEntryId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchEventRegistrationException, SystemException {
		EventRegistration eventRegistration = findByPrimaryKey(eventRegistrationId);

		Session session = null;

		try {
			session = openSession();

			EventRegistration[] array = new EventRegistrationImpl[3];

			array[0] = getByME_S_PrevAndNext(session, eventRegistration,
					eventEntryId, status, orderByComparator, true);

			array[1] = eventRegistration;

			array[2] = getByME_S_PrevAndNext(session, eventRegistration,
					eventEntryId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EventRegistration getByME_S_PrevAndNext(Session session,
		EventRegistration eventRegistration, long eventEntryId, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_ME_S_EVENTENTRYID_2);

		query.append(_FINDER_COLUMN_ME_S_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(EventRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(eventEntryId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eventRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the event registrations where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching event registrations
	 * @throws SystemException if a system exception occurred
	 */
	public List<EventRegistration> findByUserId(long companyId, long userId,
		int status) throws SystemException {
		return findByUserId(companyId, userId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the event registrations where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of event registrations
	 * @param end the upper bound of the range of event registrations (not inclusive)
	 * @return the range of matching event registrations
	 * @throws SystemException if a system exception occurred
	 */
	public List<EventRegistration> findByUserId(long companyId, long userId,
		int status, int start, int end) throws SystemException {
		return findByUserId(companyId, userId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the event registrations where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of event registrations
	 * @param end the upper bound of the range of event registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event registrations
	 * @throws SystemException if a system exception occurred
	 */
	public List<EventRegistration> findByUserId(long companyId, long userId,
		int status, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { companyId, userId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] {
					companyId, userId, status,
					
					start, end, orderByComparator
				};
		}

		List<EventRegistration> list = (List<EventRegistration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventRegistration eventRegistration : list) {
				if ((companyId != eventRegistration.getCompanyId()) ||
						(userId != eventRegistration.getUserId()) ||
						(status != eventRegistration.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_EVENTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_USERID_COMPANYID_2);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			query.append(_FINDER_COLUMN_USERID_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(EventRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(userId);

				qPos.add(status);

				list = (List<EventRegistration>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first event registration in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event registration
	 * @throws org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException if a matching event registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventRegistration findByUserId_First(long companyId, long userId,
		int status, OrderByComparator orderByComparator)
		throws NoSuchEventRegistrationException, SystemException {
		EventRegistration eventRegistration = fetchByUserId_First(companyId,
				userId, status, orderByComparator);

		if (eventRegistration != null) {
			return eventRegistration;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventRegistrationException(msg.toString());
	}

	/**
	 * Returns the first event registration in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event registration, or <code>null</code> if a matching event registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventRegistration fetchByUserId_First(long companyId, long userId,
		int status, OrderByComparator orderByComparator)
		throws SystemException {
		List<EventRegistration> list = findByUserId(companyId, userId, status,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last event registration in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event registration
	 * @throws org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException if a matching event registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventRegistration findByUserId_Last(long companyId, long userId,
		int status, OrderByComparator orderByComparator)
		throws NoSuchEventRegistrationException, SystemException {
		EventRegistration eventRegistration = fetchByUserId_Last(companyId,
				userId, status, orderByComparator);

		if (eventRegistration != null) {
			return eventRegistration;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventRegistrationException(msg.toString());
	}

	/**
	 * Returns the last event registration in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event registration, or <code>null</code> if a matching event registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventRegistration fetchByUserId_Last(long companyId, long userId,
		int status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUserId(companyId, userId, status);

		List<EventRegistration> list = findByUserId(companyId, userId, status,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the event registrations before and after the current event registration in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param eventRegistrationId the primary key of the current event registration
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event registration
	 * @throws org.lsp.liferay.portlet.socialliving.NoSuchEventRegistrationException if a event registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventRegistration[] findByUserId_PrevAndNext(
		long eventRegistrationId, long companyId, long userId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchEventRegistrationException, SystemException {
		EventRegistration eventRegistration = findByPrimaryKey(eventRegistrationId);

		Session session = null;

		try {
			session = openSession();

			EventRegistration[] array = new EventRegistrationImpl[3];

			array[0] = getByUserId_PrevAndNext(session, eventRegistration,
					companyId, userId, status, orderByComparator, true);

			array[1] = eventRegistration;

			array[2] = getByUserId_PrevAndNext(session, eventRegistration,
					companyId, userId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EventRegistration getByUserId_PrevAndNext(Session session,
		EventRegistration eventRegistration, long companyId, long userId,
		int status, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_USERID_COMPANYID_2);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		query.append(_FINDER_COLUMN_USERID_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(EventRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(userId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eventRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the event registrations.
	 *
	 * @return the event registrations
	 * @throws SystemException if a system exception occurred
	 */
	public List<EventRegistration> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<EventRegistration> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	public List<EventRegistration> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<EventRegistration> list = (List<EventRegistration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EVENTREGISTRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EVENTREGISTRATION.concat(EventRegistrationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<EventRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<EventRegistration>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the event registrations where eventEntryId = &#63; from the database.
	 *
	 * @param eventEntryId the event entry ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByEventEntryId(long eventEntryId)
		throws SystemException {
		for (EventRegistration eventRegistration : findByEventEntryId(
				eventEntryId)) {
			remove(eventRegistration);
		}
	}

	/**
	 * Removes the event registration where userId = &#63; and eventEntryId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param eventEntryId the event entry ID
	 * @return the event registration that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public EventRegistration removeByU_ME(long userId, long eventEntryId)
		throws NoSuchEventRegistrationException, SystemException {
		EventRegistration eventRegistration = findByU_ME(userId, eventEntryId);

		return remove(eventRegistration);
	}

	/**
	 * Removes all the event registrations where eventEntryId = &#63; and status = &#63; from the database.
	 *
	 * @param eventEntryId the event entry ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByME_S(long eventEntryId, int status)
		throws SystemException {
		for (EventRegistration eventRegistration : findByME_S(eventEntryId,
				status)) {
			remove(eventRegistration);
		}
	}

	/**
	 * Removes all the event registrations where companyId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId(long companyId, long userId, int status)
		throws SystemException {
		for (EventRegistration eventRegistration : findByUserId(companyId,
				userId, status)) {
			remove(eventRegistration);
		}
	}

	/**
	 * Removes all the event registrations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (EventRegistration eventRegistration : findAll()) {
			remove(eventRegistration);
		}
	}

	/**
	 * Returns the number of event registrations where eventEntryId = &#63;.
	 *
	 * @param eventEntryId the event entry ID
	 * @return the number of matching event registrations
	 * @throws SystemException if a system exception occurred
	 */
	public int countByEventEntryId(long eventEntryId) throws SystemException {
		Object[] finderArgs = new Object[] { eventEntryId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_EVENTENTRYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EVENTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_EVENTENTRYID_EVENTENTRYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(eventEntryId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EVENTENTRYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of event registrations where userId = &#63; and eventEntryId = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventEntryId the event entry ID
	 * @return the number of matching event registrations
	 * @throws SystemException if a system exception occurred
	 */
	public int countByU_ME(long userId, long eventEntryId)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId, eventEntryId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_U_ME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EVENTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_U_ME_USERID_2);

			query.append(_FINDER_COLUMN_U_ME_EVENTENTRYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(eventEntryId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_U_ME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of event registrations where eventEntryId = &#63; and status = &#63;.
	 *
	 * @param eventEntryId the event entry ID
	 * @param status the status
	 * @return the number of matching event registrations
	 * @throws SystemException if a system exception occurred
	 */
	public int countByME_S(long eventEntryId, int status)
		throws SystemException {
		Object[] finderArgs = new Object[] { eventEntryId, status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ME_S,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EVENTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_ME_S_EVENTENTRYID_2);

			query.append(_FINDER_COLUMN_ME_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(eventEntryId);

				qPos.add(status);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ME_S,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of event registrations where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching event registrations
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId(long companyId, long userId, int status)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, userId, status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_EVENTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_USERID_COMPANYID_2);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			query.append(_FINDER_COLUMN_USERID_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(userId);

				qPos.add(status);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of event registrations.
	 *
	 * @return the number of event registrations
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EVENTREGISTRATION);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the event registration persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.lsp.liferay.portlet.socialliving.model.EventRegistration")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EventRegistration>> listenersList = new ArrayList<ModelListener<EventRegistration>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EventRegistration>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(EventRegistrationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = ChannelEntryPersistence.class)
	protected ChannelEntryPersistence channelEntryPersistence;
	@BeanReference(type = EventEntryPersistence.class)
	protected EventEntryPersistence eventEntryPersistence;
	@BeanReference(type = EventRegistrationPersistence.class)
	protected EventRegistrationPersistence eventRegistrationPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_EVENTREGISTRATION = "SELECT eventRegistration FROM EventRegistration eventRegistration";
	private static final String _SQL_SELECT_EVENTREGISTRATION_WHERE = "SELECT eventRegistration FROM EventRegistration eventRegistration WHERE ";
	private static final String _SQL_COUNT_EVENTREGISTRATION = "SELECT COUNT(eventRegistration) FROM EventRegistration eventRegistration";
	private static final String _SQL_COUNT_EVENTREGISTRATION_WHERE = "SELECT COUNT(eventRegistration) FROM EventRegistration eventRegistration WHERE ";
	private static final String _FINDER_COLUMN_EVENTENTRYID_EVENTENTRYID_2 = "eventRegistration.eventEntryId = ?";
	private static final String _FINDER_COLUMN_U_ME_USERID_2 = "eventRegistration.userId = ? AND ";
	private static final String _FINDER_COLUMN_U_ME_EVENTENTRYID_2 = "eventRegistration.eventEntryId = ?";
	private static final String _FINDER_COLUMN_ME_S_EVENTENTRYID_2 = "eventRegistration.eventEntryId = ? AND ";
	private static final String _FINDER_COLUMN_ME_S_STATUS_2 = "eventRegistration.status = ?";
	private static final String _FINDER_COLUMN_USERID_COMPANYID_2 = "eventRegistration.companyId = ? AND ";
	private static final String _FINDER_COLUMN_USERID_USERID_2 = "eventRegistration.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERID_STATUS_2 = "eventRegistration.status = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "eventRegistration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EventRegistration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EventRegistration exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EventRegistrationPersistenceImpl.class);
	private static EventRegistration _nullEventRegistration = new EventRegistrationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EventRegistration> toCacheModel() {
				return _nullEventRegistrationCacheModel;
			}
		};

	private static CacheModel<EventRegistration> _nullEventRegistrationCacheModel =
		new CacheModel<EventRegistration>() {
			public EventRegistration toEntityModel() {
				return _nullEventRegistration;
			}
		};
}