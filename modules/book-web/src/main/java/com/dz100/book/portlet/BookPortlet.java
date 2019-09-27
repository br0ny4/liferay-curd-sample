package com.dz100.book.portlet;

import com.dz100.book.constants.BookPortletKeys;

import com.dz100.book.model.Book;
import com.dz100.book.service.BookLocalService;
import com.dz100.book.service.BookLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author kiana
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Book",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + BookPortletKeys.BOOK,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class BookPortlet extends MVCPortlet {
	private static  final int PAGE_SIZE = 10;
	private static Log log = LogFactoryUtil.getLog(BookPortlet.class);

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		int pageNumber = ParamUtil.getInteger(renderRequest, "page_number");
		if (pageNumber == 0){
			pageNumber = 1;
		}

		log.info("获取第" + pageNumber + "页数据");

		int count = BookLocalServiceUtil.getBooksCount();
		int pageCount = (count + PAGE_SIZE -1) / PAGE_SIZE;
		int start = (pageNumber - 1) * PAGE_SIZE;
		List<Book> books = BookLocalServiceUtil.getBooks(start, start + PAGE_SIZE);

		renderRequest.setAttribute("pageCount", pageCount);
		renderRequest.setAttribute("currentPage", pageNumber);
		renderRequest.setAttribute("books", books);
		super.render(renderRequest, renderResponse);
	}

	public void addBook(ActionRequest actionRequest, ActionResponse actionResponse){
		String title = ParamUtil.getString(actionRequest, "title");
		String author = ParamUtil.getString(actionRequest, "author");
		double priceNum = ParamUtil.getDouble(actionRequest, "price");

		double price = new BigDecimal(priceNum).setScale(2, BigDecimal.ROUND_CEILING).doubleValue();
		BookLocalServiceUtil.addBook(title, author, price);
		log.info("添加成功");
	}

	public void updateBook(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		long bookId = ParamUtil.getLong(actionRequest, "bookId");
		String title = ParamUtil.getString(actionRequest, "title");
		String author = ParamUtil.getString(actionRequest, "author");
		double price = ParamUtil.getDouble(actionRequest, "price");

		BookLocalServiceUtil.updateBook(bookId, title, author, price);
		log.info("更新成功");
	}

	public void deleteBook(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		long bookId = ParamUtil.getLong(actionRequest, "bookId");
		BookLocalServiceUtil.deleteBook(bookId);
		log.info("删除成功");
	}
}