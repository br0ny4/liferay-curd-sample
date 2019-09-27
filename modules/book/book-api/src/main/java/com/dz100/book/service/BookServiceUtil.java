/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.dz100.book.service;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Book. This utility wraps
 * <code>com.dz100.book.service.impl.BookServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see BookService
 * @generated
 */
@ProviderType
public class BookServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.dz100.book.service.impl.BookServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addBook(String title, String author, double price) {
		getService().addBook(title, author, price);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static BookService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<BookService, BookService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(BookService.class);

		ServiceTracker<BookService, BookService> serviceTracker =
			new ServiceTracker<BookService, BookService>(
				bundle.getBundleContext(), BookService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}