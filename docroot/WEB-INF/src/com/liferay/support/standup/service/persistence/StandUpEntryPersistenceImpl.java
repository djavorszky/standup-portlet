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

package com.liferay.support.standup.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.support.standup.NoSuchStandUpEntryException;
import com.liferay.support.standup.model.StandUpEntry;
import com.liferay.support.standup.model.impl.StandUpEntryImpl;
import com.liferay.support.standup.model.impl.StandUpEntryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the stand up entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Daniel Javorszky
 * @see StandUpEntryPersistence
 * @see StandUpEntryUtil
 * @generated
 */
public class StandUpEntryPersistenceImpl extends BasePersistenceImpl<StandUpEntry>
	implements StandUpEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StandUpEntryUtil} to access the stand up entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StandUpEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StandUpEntryModelImpl.ENTITY_CACHE_ENABLED,
			StandUpEntryModelImpl.FINDER_CACHE_ENABLED, StandUpEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StandUpEntryModelImpl.ENTITY_CACHE_ENABLED,
			StandUpEntryModelImpl.FINDER_CACHE_ENABLED, StandUpEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StandUpEntryModelImpl.ENTITY_CACHE_ENABLED,
			StandUpEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the stand up entry in the entity cache if it is enabled.
	 *
	 * @param standUpEntry the stand up entry
	 */
	public void cacheResult(StandUpEntry standUpEntry) {
		EntityCacheUtil.putResult(StandUpEntryModelImpl.ENTITY_CACHE_ENABLED,
			StandUpEntryImpl.class, standUpEntry.getPrimaryKey(), standUpEntry);

		standUpEntry.resetOriginalValues();
	}

	/**
	 * Caches the stand up entries in the entity cache if it is enabled.
	 *
	 * @param standUpEntries the stand up entries
	 */
	public void cacheResult(List<StandUpEntry> standUpEntries) {
		for (StandUpEntry standUpEntry : standUpEntries) {
			if (EntityCacheUtil.getResult(
						StandUpEntryModelImpl.ENTITY_CACHE_ENABLED,
						StandUpEntryImpl.class, standUpEntry.getPrimaryKey()) == null) {
				cacheResult(standUpEntry);
			}
			else {
				standUpEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all stand up entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StandUpEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StandUpEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the stand up entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StandUpEntry standUpEntry) {
		EntityCacheUtil.removeResult(StandUpEntryModelImpl.ENTITY_CACHE_ENABLED,
			StandUpEntryImpl.class, standUpEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StandUpEntry> standUpEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StandUpEntry standUpEntry : standUpEntries) {
			EntityCacheUtil.removeResult(StandUpEntryModelImpl.ENTITY_CACHE_ENABLED,
				StandUpEntryImpl.class, standUpEntry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new stand up entry with the primary key. Does not add the stand up entry to the database.
	 *
	 * @param entryId the primary key for the new stand up entry
	 * @return the new stand up entry
	 */
	public StandUpEntry create(long entryId) {
		StandUpEntry standUpEntry = new StandUpEntryImpl();

		standUpEntry.setNew(true);
		standUpEntry.setPrimaryKey(entryId);

		return standUpEntry;
	}

	/**
	 * Removes the stand up entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entryId the primary key of the stand up entry
	 * @return the stand up entry that was removed
	 * @throws com.liferay.support.standup.NoSuchStandUpEntryException if a stand up entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StandUpEntry remove(long entryId)
		throws NoSuchStandUpEntryException, SystemException {
		return remove(Long.valueOf(entryId));
	}

	/**
	 * Removes the stand up entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the stand up entry
	 * @return the stand up entry that was removed
	 * @throws com.liferay.support.standup.NoSuchStandUpEntryException if a stand up entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandUpEntry remove(Serializable primaryKey)
		throws NoSuchStandUpEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StandUpEntry standUpEntry = (StandUpEntry)session.get(StandUpEntryImpl.class,
					primaryKey);

			if (standUpEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStandUpEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(standUpEntry);
		}
		catch (NoSuchStandUpEntryException nsee) {
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
	protected StandUpEntry removeImpl(StandUpEntry standUpEntry)
		throws SystemException {
		standUpEntry = toUnwrappedModel(standUpEntry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, standUpEntry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(standUpEntry);

		return standUpEntry;
	}

	@Override
	public StandUpEntry updateImpl(
		com.liferay.support.standup.model.StandUpEntry standUpEntry,
		boolean merge) throws SystemException {
		standUpEntry = toUnwrappedModel(standUpEntry);

		boolean isNew = standUpEntry.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, standUpEntry, merge);

			standUpEntry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(StandUpEntryModelImpl.ENTITY_CACHE_ENABLED,
			StandUpEntryImpl.class, standUpEntry.getPrimaryKey(), standUpEntry);

		return standUpEntry;
	}

	protected StandUpEntry toUnwrappedModel(StandUpEntry standUpEntry) {
		if (standUpEntry instanceof StandUpEntryImpl) {
			return standUpEntry;
		}

		StandUpEntryImpl standUpEntryImpl = new StandUpEntryImpl();

		standUpEntryImpl.setNew(standUpEntry.isNew());
		standUpEntryImpl.setPrimaryKey(standUpEntry.getPrimaryKey());

		standUpEntryImpl.setEntryId(standUpEntry.getEntryId());
		standUpEntryImpl.setCompanyId(standUpEntry.getCompanyId());
		standUpEntryImpl.setGroupId(standUpEntry.getGroupId());
		standUpEntryImpl.setUserId(standUpEntry.getUserId());
		standUpEntryImpl.setQuantity(standUpEntry.getQuantity());
		standUpEntryImpl.setDifficulty(standUpEntry.getDifficulty());
		standUpEntryImpl.setCreateDate(standUpEntry.getCreateDate());
		standUpEntryImpl.setModifiedDate(standUpEntry.getModifiedDate());
		standUpEntryImpl.setBlocking(standUpEntry.getBlocking());
		standUpEntryImpl.setAdditionalDetails(standUpEntry.getAdditionalDetails());
		standUpEntryImpl.setStatus(standUpEntry.getStatus());

		return standUpEntryImpl;
	}

	/**
	 * Returns the stand up entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the stand up entry
	 * @return the stand up entry
	 * @throws com.liferay.portal.NoSuchModelException if a stand up entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandUpEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the stand up entry with the primary key or throws a {@link com.liferay.support.standup.NoSuchStandUpEntryException} if it could not be found.
	 *
	 * @param entryId the primary key of the stand up entry
	 * @return the stand up entry
	 * @throws com.liferay.support.standup.NoSuchStandUpEntryException if a stand up entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StandUpEntry findByPrimaryKey(long entryId)
		throws NoSuchStandUpEntryException, SystemException {
		StandUpEntry standUpEntry = fetchByPrimaryKey(entryId);

		if (standUpEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + entryId);
			}

			throw new NoSuchStandUpEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				entryId);
		}

		return standUpEntry;
	}

	/**
	 * Returns the stand up entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the stand up entry
	 * @return the stand up entry, or <code>null</code> if a stand up entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandUpEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the stand up entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entryId the primary key of the stand up entry
	 * @return the stand up entry, or <code>null</code> if a stand up entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StandUpEntry fetchByPrimaryKey(long entryId)
		throws SystemException {
		StandUpEntry standUpEntry = (StandUpEntry)EntityCacheUtil.getResult(StandUpEntryModelImpl.ENTITY_CACHE_ENABLED,
				StandUpEntryImpl.class, entryId);

		if (standUpEntry == _nullStandUpEntry) {
			return null;
		}

		if (standUpEntry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				standUpEntry = (StandUpEntry)session.get(StandUpEntryImpl.class,
						Long.valueOf(entryId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (standUpEntry != null) {
					cacheResult(standUpEntry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(StandUpEntryModelImpl.ENTITY_CACHE_ENABLED,
						StandUpEntryImpl.class, entryId, _nullStandUpEntry);
				}

				closeSession(session);
			}
		}

		return standUpEntry;
	}

	/**
	 * Returns all the stand up entries.
	 *
	 * @return the stand up entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<StandUpEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the stand up entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of stand up entries
	 * @param end the upper bound of the range of stand up entries (not inclusive)
	 * @return the range of stand up entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<StandUpEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the stand up entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of stand up entries
	 * @param end the upper bound of the range of stand up entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of stand up entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<StandUpEntry> findAll(int start, int end,
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

		List<StandUpEntry> list = (List<StandUpEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STANDUPENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STANDUPENTRY;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<StandUpEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<StandUpEntry>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the stand up entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (StandUpEntry standUpEntry : findAll()) {
			remove(standUpEntry);
		}
	}

	/**
	 * Returns the number of stand up entries.
	 *
	 * @return the number of stand up entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STANDUPENTRY);

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
	 * Initializes the stand up entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.support.standup.model.StandUpEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StandUpEntry>> listenersList = new ArrayList<ModelListener<StandUpEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StandUpEntry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StandUpEntryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = GlobalInformationPersistence.class)
	protected GlobalInformationPersistence globalInformationPersistence;
	@BeanReference(type = StandUpEntryPersistence.class)
	protected StandUpEntryPersistence standUpEntryPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_STANDUPENTRY = "SELECT standUpEntry FROM StandUpEntry standUpEntry";
	private static final String _SQL_COUNT_STANDUPENTRY = "SELECT COUNT(standUpEntry) FROM StandUpEntry standUpEntry";
	private static final String _ORDER_BY_ENTITY_ALIAS = "standUpEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StandUpEntry exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StandUpEntryPersistenceImpl.class);
	private static StandUpEntry _nullStandUpEntry = new StandUpEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StandUpEntry> toCacheModel() {
				return _nullStandUpEntryCacheModel;
			}
		};

	private static CacheModel<StandUpEntry> _nullStandUpEntryCacheModel = new CacheModel<StandUpEntry>() {
			public StandUpEntry toEntityModel() {
				return _nullStandUpEntry;
			}
		};
}