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

package com.dz100.book.service.impl;

import com.dz100.book.model.Book;
import com.dz100.book.service.BookLocalServiceUtil;
import com.dz100.book.service.base.BookLocalServiceBaseImpl;


import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;

import org.osgi.service.component.annotations.Component;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * The implementation of the book local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.dz100.book.service.BookLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.dz100.book.model.Book",
	service = AopService.class
)
public class BookLocalServiceImpl extends BookLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.dz100.book.service.BookLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.dz100.book.service.BookLocalServiceUtil</code>.
	 */
	public void addBook(String title, String author, double price){
		Book book = BookLocalServiceUtil.createBook(CounterLocalServiceUtil.increment());
		book.setTitle(title);
		book.setAuthor(author);
		book.setPrice(price);
		BookLocalServiceUtil.addBook(book);
	}

	public void updateBook(long bookId, String title, String author, double price) throws PortalException {
		Book book = BookLocalServiceUtil.getBook(bookId);
		book.setTitle(title);
		book.setAuthor(author);
		book.setPrice(price);
		BookLocalServiceUtil.updateBook(book);
	}

}