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

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link BookService}.
 *
 * @author Brian Wing Shun Chan
 * @see BookService
 * @generated
 */
@ProviderType
public class BookServiceWrapper
	implements BookService, ServiceWrapper<BookService> {

	public BookServiceWrapper(BookService bookService) {
		_bookService = bookService;
	}

	@Override
	public void addBook(String title, String author, double price) {
		_bookService.addBook(title, author, price);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bookService.getOSGiServiceIdentifier();
	}

	@Override
	public BookService getWrappedService() {
		return _bookService;
	}

	@Override
	public void setWrappedService(BookService bookService) {
		_bookService = bookService;
	}

	private BookService _bookService;

}