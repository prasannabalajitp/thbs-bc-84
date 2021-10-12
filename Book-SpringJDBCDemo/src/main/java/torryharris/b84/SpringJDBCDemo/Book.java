package torryharris.b84.SpringJDBCDemo;

public class Book {
	private int bookId;
	private String bookName;
	private int bookPrice;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	@Override
	public String toString() {
		return "Book [BookId=" + bookId + ", BookName=" + bookName + ", BookPrice=" + bookPrice + "]";
	}
}
