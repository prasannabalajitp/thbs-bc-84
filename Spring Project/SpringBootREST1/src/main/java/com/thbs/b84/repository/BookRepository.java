package com.thbs.b84.repository;
import java.util.List;
import java.util.ArrayList;
import com.thbs.b84.model.Book;
public class BookRepository {
	
	List<Book> blist;
	
	public BookRepository()
	{
		blist = new ArrayList<Book>();
		
		Book b = new Book();
		b.setBookId(100);
		b.setBookName("Half GirlFriend");
		b.setBookPrice(300);
		
		Book b1 = new Book();
		b1.setBookId(101);
		b1.setBookName("3 Mistakes of my Life");
		b1.setBookPrice(500);
		
		Book b2 = new Book();
		b2.setBookId(102);
		b2.setBookName("Rich Dad Poor Dad");
		b2.setBookPrice(800);
		
		blist.add(b);
		blist.add(b1);
		blist.add(b2);
	}
	
	public List<Book> getAllBooks()
	{
		return blist;
	}
	
	public Book getABook(int bookId)
	{
		for(Book b:blist)
		{
			if(b.getBookId()==bookId)
			{
				return b;
			}
		}
		return null;
	}
	
	}
