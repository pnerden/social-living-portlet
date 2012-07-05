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

import org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException;
import org.lsp.liferay.portlet.socialliving.model.EventEntry;
import org.lsp.liferay.portlet.socialliving.model.impl.EventEntryImpl;
import org.lsp.liferay.portlet.socialliving.model.impl.EventEntryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the event entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventEntryPersistence
 * @see EventEntryUtil
 * @generated
 */
public class EventEntryPersistenceImpl extends BasePersistenceImpl<EventEntry>
	implements EventEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EventEntryUtil} to access the event entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EventEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_ENTRYFINDER = new FinderPath(EventEntryModelImpl.ENTITY_CACHE_ENABLED,
			EventEntryModelImpl.FINDER_CACHE_ENABLED, EventEntryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByEntryFinder",
			new String[] { Long.class.getName(), Long.class.getName() },
			EventEntryModelImpl.COMPANYID_COLUMN_BITMASK |
			EventEntryModelImpl.EVENTENTRYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ENTRYFINDER = new FinderPath(EventEntryModelImpl.ENTITY_CACHE_ENABLED,
			EventEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEntryFinder",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GLOBALFINDER =
		new FinderPath(EventEntryModelImpl.ENTITY_CACHE_ENABLED,
			EventEntryModelImpl.FINDER_CACHE_ENABLED, EventEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGlobalFinder",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOBALFINDER =
		new FinderPath(EventEntryModelImpl.ENTITY_CACHE_ENABLED,
			EventEntryModelImpl.FINDER_CACHE_ENABLED, EventEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGlobalFinder",
			new String[] { Long.class.getName(), Long.class.getName() },
			EventEntryModelImpl.COMPANYID_COLUMN_BITMASK |
			EventEntryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GLOBALFINDER = new FinderPath(EventEntryModelImpl.ENTITY_CACHE_ENABLED,
			EventEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGlobalFinder",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ALLBUTGROUPID =
		new FinderPath(EventEntryModelImpl.ENTITY_CACHE_ENABLED,
			EventEntryModelImpl.FINDER_CACHE_ENABLED, EventEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAllButGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_ALLBUTGROUPID =
		new FinderPath(EventEntryModelImpl.ENTITY_CACHE_ENABLED,
			EventEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByAllButGroupId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(EventEntryModelImpl.ENTITY_CACHE_ENABLED,
			EventEntryModelImpl.FINDER_CACHE_ENABLED, EventEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(EventEntryModelImpl.ENTITY_CACHE_ENABLED,
			EventEntryModelImpl.FINDER_CACHE_ENABLED, EventEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			EventEntryModelImpl.COMPANYID_COLUMN_BITMASK |
			EventEntryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(EventEntryModelImpl.ENTITY_CACHE_ENABLED,
			EventEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(EventEntryModelImpl.ENTITY_CACHE_ENABLED,
			EventEntryModelImpl.FINDER_CACHE_ENABLED, EventEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(EventEntryModelImpl.ENTITY_CACHE_ENABLED,
			EventEntryModelImpl.FINDER_CACHE_ENABLED, EventEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			EventEntryModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(EventEntryModelImpl.ENTITY_CACHE_ENABLED,
			EventEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(EventEntryModelImpl.ENTITY_CACHE_ENABLED,
			EventEntryModelImpl.FINDER_CACHE_ENABLED, EventEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(EventEntryModelImpl.ENTITY_CACHE_ENABLED,
			EventEntryModelImpl.FINDER_CACHE_ENABLED, EventEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			EventEntryModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(EventEntryModelImpl.ENTITY_CACHE_ENABLED,
			EventEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EventEntryModelImpl.ENTITY_CACHE_ENABLED,
			EventEntryModelImpl.FINDER_CACHE_ENABLED, EventEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EventEntryModelImpl.ENTITY_CACHE_ENABLED,
			EventEntryModelImpl.FINDER_CACHE_ENABLED, EventEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EventEntryModelImpl.ENTITY_CACHE_ENABLED,
			EventEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the event entry in the entity cache if it is enabled.
	 *
	 * @param eventEntry the event entry
	 */
	public void cacheResult(EventEntry eventEntry) {
		EntityCacheUtil.putResult(EventEntryModelImpl.ENTITY_CACHE_ENABLED,
			EventEntryImpl.class, eventEntry.getPrimaryKey(), eventEntry);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTRYFINDER,
			new Object[] {
				Long.valueOf(eventEntry.getCompanyId()),
				Long.valueOf(eventEntry.getEventEntryId())
			}, eventEntry);

		eventEntry.resetOriginalValues();
	}

	/**
	 * Caches the event entries in the entity cache if it is enabled.
	 *
	 * @param eventEntries the event entries
	 */
	public void cacheResult(List<EventEntry> eventEntries) {
		for (EventEntry eventEntry : eventEntries) {
			if (EntityCacheUtil.getResult(
						EventEntryModelImpl.ENTITY_CACHE_ENABLED,
						EventEntryImpl.class, eventEntry.getPrimaryKey()) == null) {
				cacheResult(eventEntry);
			}
			else {
				eventEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all event entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EventEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EventEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the event entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EventEntry eventEntry) {
		EntityCacheUtil.removeResult(EventEntryModelImpl.ENTITY_CACHE_ENABLED,
			EventEntryImpl.class, eventEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(eventEntry);
	}

	@Override
	public void clearCache(List<EventEntry> eventEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EventEntry eventEntry : eventEntries) {
			EntityCacheUtil.removeResult(EventEntryModelImpl.ENTITY_CACHE_ENABLED,
				EventEntryImpl.class, eventEntry.getPrimaryKey());

			clearUniqueFindersCache(eventEntry);
		}
	}

	protected void clearUniqueFindersCache(EventEntry eventEntry) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ENTRYFINDER,
			new Object[] {
				Long.valueOf(eventEntry.getCompanyId()),
				Long.valueOf(eventEntry.getEventEntryId())
			});
	}

	/**
	 * Creates a new event entry with the primary key. Does not add the event entry to the database.
	 *
	 * @param eventEntryId the primary key for the new event entry
	 * @return the new event entry
	 */
	public EventEntry create(long eventEntryId) {
		EventEntry eventEntry = new EventEntryImpl();

		eventEntry.setNew(true);
		eventEntry.setPrimaryKey(eventEntryId);

		return eventEntry;
	}

	/**
	 * Removes the event entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventEntryId the primary key of the event entry
	 * @return the event entry that was removed
	 * @throws org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException if a event entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventEntry remove(long eventEntryId)
		throws NoSuchEventEntryException, SystemException {
		return remove(Long.valueOf(eventEntryId));
	}

	/**
	 * Removes the event entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the event entry
	 * @return the event entry that was removed
	 * @throws org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException if a event entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventEntry remove(Serializable primaryKey)
		throws NoSuchEventEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EventEntry eventEntry = (EventEntry)session.get(EventEntryImpl.class,
					primaryKey);

			if (eventEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEventEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(eventEntry);
		}
		catch (NoSuchEventEntryException nsee) {
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
	protected EventEntry removeImpl(EventEntry eventEntry)
		throws SystemException {
		eventEntry = toUnwrappedModel(eventEntry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, eventEntry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(eventEntry);

		return eventEntry;
	}

	@Override
	public EventEntry updateImpl(
		org.lsp.liferay.portlet.socialliving.model.EventEntry eventEntry,
		boolean merge) throws SystemException {
		eventEntry = toUnwrappedModel(eventEntry);

		boolean isNew = eventEntry.isNew();

		EventEntryModelImpl eventEntryModelImpl = (EventEntryModelImpl)eventEntry;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, eventEntry, merge);

			eventEntry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EventEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((eventEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOBALFINDER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(eventEntryModelImpl.getOriginalCompanyId()),
						Long.valueOf(eventEntryModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GLOBALFINDER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOBALFINDER,
					args);

				args = new Object[] {
						Long.valueOf(eventEntryModelImpl.getCompanyId()),
						Long.valueOf(eventEntryModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GLOBALFINDER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOBALFINDER,
					args);
			}

			if ((eventEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(eventEntryModelImpl.getOriginalCompanyId()),
						Long.valueOf(eventEntryModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] {
						Long.valueOf(eventEntryModelImpl.getCompanyId()),
						Long.valueOf(eventEntryModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((eventEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(eventEntryModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] {
						Long.valueOf(eventEntryModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((eventEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(eventEntryModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] {
						Long.valueOf(eventEntryModelImpl.getUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(EventEntryModelImpl.ENTITY_CACHE_ENABLED,
			EventEntryImpl.class, eventEntry.getPrimaryKey(), eventEntry);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTRYFINDER,
				new Object[] {
					Long.valueOf(eventEntry.getCompanyId()),
					Long.valueOf(eventEntry.getEventEntryId())
				}, eventEntry);
		}
		else {
			if ((eventEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ENTRYFINDER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(eventEntryModelImpl.getOriginalCompanyId()),
						Long.valueOf(eventEntryModelImpl.getOriginalEventEntryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENTRYFINDER,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ENTRYFINDER,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTRYFINDER,
					new Object[] {
						Long.valueOf(eventEntry.getCompanyId()),
						Long.valueOf(eventEntry.getEventEntryId())
					}, eventEntry);
			}
		}

		return eventEntry;
	}

	protected EventEntry toUnwrappedModel(EventEntry eventEntry) {
		if (eventEntry instanceof EventEntryImpl) {
			return eventEntry;
		}

		EventEntryImpl eventEntryImpl = new EventEntryImpl();

		eventEntryImpl.setNew(eventEntry.isNew());
		eventEntryImpl.setPrimaryKey(eventEntry.getPrimaryKey());

		eventEntryImpl.setEventEntryId(eventEntry.getEventEntryId());
		eventEntryImpl.setCompanyId(eventEntry.getCompanyId());
		eventEntryImpl.setGroupId(eventEntry.getGroupId());
		eventEntryImpl.setUserId(eventEntry.getUserId());
		eventEntryImpl.setUserName(eventEntry.getUserName());
		eventEntryImpl.setCreateDate(eventEntry.getCreateDate());
		eventEntryImpl.setModifiedDate(eventEntry.getModifiedDate());
		eventEntryImpl.setTitle(eventEntry.getTitle());
		eventEntryImpl.setDescription(eventEntry.getDescription());
		eventEntryImpl.setStartDate(eventEntry.getStartDate());
		eventEntryImpl.setEndDate(eventEntry.getEndDate());
		eventEntryImpl.setTotalAttendees(eventEntry.getTotalAttendees());
		eventEntryImpl.setMaxAttendees(eventEntry.getMaxAttendees());
		eventEntryImpl.setPrice(eventEntry.getPrice());
		eventEntryImpl.setThumbnailId(eventEntry.getThumbnailId());
		eventEntryImpl.setLatitude(eventEntry.getLatitude());
		eventEntryImpl.setLongitude(eventEntry.getLongitude());
		eventEntryImpl.setLocation(eventEntry.getLocation());

		return eventEntryImpl;
	}

	/**
	 * Returns the event entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the event entry
	 * @return the event entry
	 * @throws com.liferay.portal.NoSuchModelException if a event entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the event entry with the primary key or throws a {@link org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException} if it could not be found.
	 *
	 * @param eventEntryId the primary key of the event entry
	 * @return the event entry
	 * @throws org.lsp.liferay.portlet.socialliving.NoSuchEventEntryException if a event entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventEntry findByPrimaryKey(long eventEntryId)
		throws NoSuchEventEntryException, SystemException {
		EventEntry eventEntry = fetchByPrimaryKey(eventEntryId);

		if (eventEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + eventEntryId);
			}

			throw new NoSuchEventEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				eventEntryId);
		}

		return eventEntry;
	}

	/**
	 * Returns the event entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the event entry
	 * @return the event entry, or <code>null</code> if a event entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the event entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventEntryId the primary key of the event entry
	 * @return the event entry, or <code>null</code> if a event entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventEntry fetchByPrimaryKey(long eventEntryId)
		throws SystemException {
		EventEntry eventEntry = (EventEntry)EntityCacheUtil.getResult(EventEntryModelImpl.ENTITY_CACHE_ENABLED,
				EventEntryImpl.class, eventEntryId);

		if (eventEntry == _nullEventEntry) {
			return null;
		}

		if (eventEntry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				eventEntry = (EventEntry)session.get(EventEntryImpl.class,
						Long.valueOf(eventEntryId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (eventEntry != null) {
					cacheResult(eventEntry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(EventEntryModelImpl.ENTITY_CACHE_ENABLED,
						EventEntryImpl.class, eventEntryId, _nullEventEntry);
				}

				closeSession(session);
			}
		}

		return eventEntry;
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
	public EventEntry findByEntryFinder(long companyId, long eventEntryId)
		throws NoSuchEventEntryException, SystemException {
		EventEntry eventEntry = fetchByEntryFinder(companyId, eventEntryId);

		if (eventEntry == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", eventEntryId=");
			msg.append(eventEntryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEventEntryException(msg.toString());
		}

		return eventEntry;
	}

	/**
	 * Returns the event entry where companyId = &#63; and eventEntryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param eventEntryId the event entry ID
	 * @return the matching event entry, or <code>null</code> if a matching event entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventEntry fetchByEntryFinder(long companyId, long eventEntryId)
		throws SystemException {
		return fetchByEntryFinder(companyId, eventEntryId, true);
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
	public EventEntry fetchByEntryFinder(long companyId, long eventEntryId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { companyId, eventEntryId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ENTRYFINDER,
					finderArgs, this);
		}

		if (result instanceof EventEntry) {
			EventEntry eventEntry = (EventEntry)result;

			if ((companyId != eventEntry.getCompanyId()) ||
					(eventEntryId != eventEntry.getEventEntryId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_EVENTENTRY_WHERE);

			query.append(_FINDER_COLUMN_ENTRYFINDER_COMPANYID_2);

			query.append(_FINDER_COLUMN_ENTRYFINDER_EVENTENTRYID_2);

			query.append(EventEntryModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(eventEntryId);

				List<EventEntry> list = q.list();

				result = list;

				EventEntry eventEntry = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTRYFINDER,
						finderArgs, list);
				}
				else {
					eventEntry = list.get(0);

					cacheResult(eventEntry);

					if ((eventEntry.getCompanyId() != companyId) ||
							(eventEntry.getEventEntryId() != eventEntryId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTRYFINDER,
							finderArgs, eventEntry);
					}
				}

				return eventEntry;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ENTRYFINDER,
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
				return (EventEntry)result;
			}
		}
	}

	/**
	 * Returns all the event entries where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching event entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<EventEntry> findByGlobalFinder(long companyId, long groupId)
		throws SystemException {
		return findByGlobalFinder(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<EventEntry> findByGlobalFinder(long companyId, long groupId,
		int start, int end) throws SystemException {
		return findByGlobalFinder(companyId, groupId, start, end, null);
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
	public List<EventEntry> findByGlobalFinder(long companyId, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOBALFINDER;
			finderArgs = new Object[] { companyId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GLOBALFINDER;
			finderArgs = new Object[] {
					companyId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<EventEntry> list = (List<EventEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventEntry eventEntry : list) {
				if ((companyId != eventEntry.getCompanyId()) ||
						(groupId != eventEntry.getGroupId())) {
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

			query.append(_SQL_SELECT_EVENTENTRY_WHERE);

			query.append(_FINDER_COLUMN_GLOBALFINDER_COMPANYID_2);

			query.append(_FINDER_COLUMN_GLOBALFINDER_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(EventEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				list = (List<EventEntry>)QueryUtil.list(q, getDialect(), start,
						end);
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
	public EventEntry findByGlobalFinder_First(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEventEntryException, SystemException {
		List<EventEntry> list = findByGlobalFinder(companyId, groupId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEventEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public EventEntry findByGlobalFinder_Last(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEventEntryException, SystemException {
		int count = countByGlobalFinder(companyId, groupId);

		List<EventEntry> list = findByGlobalFinder(companyId, groupId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEventEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public EventEntry[] findByGlobalFinder_PrevAndNext(long eventEntryId,
		long companyId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchEventEntryException, SystemException {
		EventEntry eventEntry = findByPrimaryKey(eventEntryId);

		Session session = null;

		try {
			session = openSession();

			EventEntry[] array = new EventEntryImpl[3];

			array[0] = getByGlobalFinder_PrevAndNext(session, eventEntry,
					companyId, groupId, orderByComparator, true);

			array[1] = eventEntry;

			array[2] = getByGlobalFinder_PrevAndNext(session, eventEntry,
					companyId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EventEntry getByGlobalFinder_PrevAndNext(Session session,
		EventEntry eventEntry, long companyId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTENTRY_WHERE);

		query.append(_FINDER_COLUMN_GLOBALFINDER_COMPANYID_2);

		query.append(_FINDER_COLUMN_GLOBALFINDER_GROUPID_2);

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
			query.append(EventEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eventEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the event entries where groupId &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching event entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<EventEntry> findByAllButGroupId(long groupId)
		throws SystemException {
		return findByAllButGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<EventEntry> findByAllButGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByAllButGroupId(groupId, start, end, null);
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
	public List<EventEntry> findByAllButGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ALLBUTGROUPID;
		finderArgs = new Object[] { groupId, start, end, orderByComparator };

		List<EventEntry> list = (List<EventEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventEntry eventEntry : list) {
				if ((groupId != eventEntry.getGroupId())) {
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

			query.append(_SQL_SELECT_EVENTENTRY_WHERE);

			query.append(_FINDER_COLUMN_ALLBUTGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(EventEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<EventEntry>)QueryUtil.list(q, getDialect(), start,
						end);
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
	public EventEntry findByAllButGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEventEntryException, SystemException {
		List<EventEntry> list = findByAllButGroupId(groupId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEventEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public EventEntry findByAllButGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEventEntryException, SystemException {
		int count = countByAllButGroupId(groupId);

		List<EventEntry> list = findByAllButGroupId(groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEventEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public EventEntry[] findByAllButGroupId_PrevAndNext(long eventEntryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchEventEntryException, SystemException {
		EventEntry eventEntry = findByPrimaryKey(eventEntryId);

		Session session = null;

		try {
			session = openSession();

			EventEntry[] array = new EventEntryImpl[3];

			array[0] = getByAllButGroupId_PrevAndNext(session, eventEntry,
					groupId, orderByComparator, true);

			array[1] = eventEntry;

			array[2] = getByAllButGroupId_PrevAndNext(session, eventEntry,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EventEntry getByAllButGroupId_PrevAndNext(Session session,
		EventEntry eventEntry, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTENTRY_WHERE);

		query.append(_FINDER_COLUMN_ALLBUTGROUPID_GROUPID_2);

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
			query.append(EventEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eventEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the event entries where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching event entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<EventEntry> findByGroupId(long companyId, long groupId)
		throws SystemException {
		return findByGroupId(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<EventEntry> findByGroupId(long companyId, long groupId,
		int start, int end) throws SystemException {
		return findByGroupId(companyId, groupId, start, end, null);
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
	public List<EventEntry> findByGroupId(long companyId, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { companyId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] {
					companyId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<EventEntry> list = (List<EventEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventEntry eventEntry : list) {
				if ((companyId != eventEntry.getCompanyId()) ||
						(groupId != eventEntry.getGroupId())) {
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

			query.append(_SQL_SELECT_EVENTENTRY_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_COMPANYID_2);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(EventEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				list = (List<EventEntry>)QueryUtil.list(q, getDialect(), start,
						end);
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
	public EventEntry findByGroupId_First(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEventEntryException, SystemException {
		List<EventEntry> list = findByGroupId(companyId, groupId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEventEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public EventEntry findByGroupId_Last(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEventEntryException, SystemException {
		int count = countByGroupId(companyId, groupId);

		List<EventEntry> list = findByGroupId(companyId, groupId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEventEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public EventEntry[] findByGroupId_PrevAndNext(long eventEntryId,
		long companyId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchEventEntryException, SystemException {
		EventEntry eventEntry = findByPrimaryKey(eventEntryId);

		Session session = null;

		try {
			session = openSession();

			EventEntry[] array = new EventEntryImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, eventEntry, companyId,
					groupId, orderByComparator, true);

			array[1] = eventEntry;

			array[2] = getByGroupId_PrevAndNext(session, eventEntry, companyId,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EventEntry getByGroupId_PrevAndNext(Session session,
		EventEntry eventEntry, long companyId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTENTRY_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_COMPANYID_2);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(EventEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eventEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the event entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching event entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<EventEntry> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	public List<EventEntry> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
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
	public List<EventEntry> findByCompanyId(long companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<EventEntry> list = (List<EventEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventEntry eventEntry : list) {
				if ((companyId != eventEntry.getCompanyId())) {
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

			query.append(_SQL_SELECT_EVENTENTRY_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(EventEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<EventEntry>)QueryUtil.list(q, getDialect(), start,
						end);
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
	public EventEntry findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchEventEntryException, SystemException {
		List<EventEntry> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEventEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public EventEntry findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchEventEntryException, SystemException {
		int count = countByCompanyId(companyId);

		List<EventEntry> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEventEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public EventEntry[] findByCompanyId_PrevAndNext(long eventEntryId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchEventEntryException, SystemException {
		EventEntry eventEntry = findByPrimaryKey(eventEntryId);

		Session session = null;

		try {
			session = openSession();

			EventEntry[] array = new EventEntryImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, eventEntry,
					companyId, orderByComparator, true);

			array[1] = eventEntry;

			array[2] = getByCompanyId_PrevAndNext(session, eventEntry,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EventEntry getByCompanyId_PrevAndNext(Session session,
		EventEntry eventEntry, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTENTRY_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

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
			query.append(EventEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eventEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the event entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching event entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<EventEntry> findByUserId(long userId) throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<EventEntry> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
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
	public List<EventEntry> findByUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<EventEntry> list = (List<EventEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventEntry eventEntry : list) {
				if ((userId != eventEntry.getUserId())) {
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

			query.append(_SQL_SELECT_EVENTENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(EventEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<EventEntry>)QueryUtil.list(q, getDialect(), start,
						end);
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
	public EventEntry findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchEventEntryException, SystemException {
		List<EventEntry> list = findByUserId(userId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEventEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public EventEntry findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchEventEntryException, SystemException {
		int count = countByUserId(userId);

		List<EventEntry> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEventEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public EventEntry[] findByUserId_PrevAndNext(long eventEntryId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchEventEntryException, SystemException {
		EventEntry eventEntry = findByPrimaryKey(eventEntryId);

		Session session = null;

		try {
			session = openSession();

			EventEntry[] array = new EventEntryImpl[3];

			array[0] = getByUserId_PrevAndNext(session, eventEntry, userId,
					orderByComparator, true);

			array[1] = eventEntry;

			array[2] = getByUserId_PrevAndNext(session, eventEntry, userId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EventEntry getByUserId_PrevAndNext(Session session,
		EventEntry eventEntry, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTENTRY_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

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
			query.append(EventEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eventEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the event entries.
	 *
	 * @return the event entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<EventEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<EventEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<EventEntry> findAll(int start, int end,
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

		List<EventEntry> list = (List<EventEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EVENTENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EVENTENTRY.concat(EventEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<EventEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<EventEntry>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes the event entry where companyId = &#63; and eventEntryId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param eventEntryId the event entry ID
	 * @return the event entry that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public EventEntry removeByEntryFinder(long companyId, long eventEntryId)
		throws NoSuchEventEntryException, SystemException {
		EventEntry eventEntry = findByEntryFinder(companyId, eventEntryId);

		return remove(eventEntry);
	}

	/**
	 * Removes all the event entries where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGlobalFinder(long companyId, long groupId)
		throws SystemException {
		for (EventEntry eventEntry : findByGlobalFinder(companyId, groupId)) {
			remove(eventEntry);
		}
	}

	/**
	 * Removes all the event entries where groupId &ne; &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByAllButGroupId(long groupId) throws SystemException {
		for (EventEntry eventEntry : findByAllButGroupId(groupId)) {
			remove(eventEntry);
		}
	}

	/**
	 * Removes all the event entries where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long companyId, long groupId)
		throws SystemException {
		for (EventEntry eventEntry : findByGroupId(companyId, groupId)) {
			remove(eventEntry);
		}
	}

	/**
	 * Removes all the event entries where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyId(long companyId) throws SystemException {
		for (EventEntry eventEntry : findByCompanyId(companyId)) {
			remove(eventEntry);
		}
	}

	/**
	 * Removes all the event entries where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId(long userId) throws SystemException {
		for (EventEntry eventEntry : findByUserId(userId)) {
			remove(eventEntry);
		}
	}

	/**
	 * Removes all the event entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (EventEntry eventEntry : findAll()) {
			remove(eventEntry);
		}
	}

	/**
	 * Returns the number of event entries where companyId = &#63; and eventEntryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param eventEntryId the event entry ID
	 * @return the number of matching event entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByEntryFinder(long companyId, long eventEntryId)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, eventEntryId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ENTRYFINDER,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EVENTENTRY_WHERE);

			query.append(_FINDER_COLUMN_ENTRYFINDER_COMPANYID_2);

			query.append(_FINDER_COLUMN_ENTRYFINDER_EVENTENTRYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ENTRYFINDER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of event entries where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching event entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGlobalFinder(long companyId, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GLOBALFINDER,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EVENTENTRY_WHERE);

			query.append(_FINDER_COLUMN_GLOBALFINDER_COMPANYID_2);

			query.append(_FINDER_COLUMN_GLOBALFINDER_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GLOBALFINDER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of event entries where groupId &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching event entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByAllButGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_ALLBUTGROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EVENTENTRY_WHERE);

			query.append(_FINDER_COLUMN_ALLBUTGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_ALLBUTGROUPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of event entries where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching event entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long companyId, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EVENTENTRY_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_COMPANYID_2);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of event entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching event entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyId(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EVENTENTRY_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of event entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching event entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId(long userId) throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EVENTENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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
	 * Returns the number of event entries.
	 *
	 * @return the number of event entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EVENTENTRY);

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
	 * Initializes the event entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.lsp.liferay.portlet.socialliving.model.EventEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EventEntry>> listenersList = new ArrayList<ModelListener<EventEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EventEntry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EventEntryImpl.class.getName());
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
	private static final String _SQL_SELECT_EVENTENTRY = "SELECT eventEntry FROM EventEntry eventEntry";
	private static final String _SQL_SELECT_EVENTENTRY_WHERE = "SELECT eventEntry FROM EventEntry eventEntry WHERE ";
	private static final String _SQL_COUNT_EVENTENTRY = "SELECT COUNT(eventEntry) FROM EventEntry eventEntry";
	private static final String _SQL_COUNT_EVENTENTRY_WHERE = "SELECT COUNT(eventEntry) FROM EventEntry eventEntry WHERE ";
	private static final String _FINDER_COLUMN_ENTRYFINDER_COMPANYID_2 = "eventEntry.companyId = ? AND ";
	private static final String _FINDER_COLUMN_ENTRYFINDER_EVENTENTRYID_2 = "eventEntry.eventEntryId = ?";
	private static final String _FINDER_COLUMN_GLOBALFINDER_COMPANYID_2 = "eventEntry.companyId = ? AND ";
	private static final String _FINDER_COLUMN_GLOBALFINDER_GROUPID_2 = "eventEntry.groupId = ?";
	private static final String _FINDER_COLUMN_ALLBUTGROUPID_GROUPID_2 = "eventEntry.groupId != ?";
	private static final String _FINDER_COLUMN_GROUPID_COMPANYID_2 = "eventEntry.companyId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "eventEntry.groupId = ?";
	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "eventEntry.companyId = ?";
	private static final String _FINDER_COLUMN_USERID_USERID_2 = "eventEntry.userId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "eventEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EventEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EventEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EventEntryPersistenceImpl.class);
	private static EventEntry _nullEventEntry = new EventEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EventEntry> toCacheModel() {
				return _nullEventEntryCacheModel;
			}
		};

	private static CacheModel<EventEntry> _nullEventEntryCacheModel = new CacheModel<EventEntry>() {
			public EventEntry toEntityModel() {
				return _nullEventEntry;
			}
		};
}