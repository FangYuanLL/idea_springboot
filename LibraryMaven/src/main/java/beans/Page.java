package beans;

public class Page {
	int pageNow;
	int totalBooks;
	int booksPerPage = 5;
	public int getBooksPerPage() {
		return booksPerPage;
	}
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public int getTotalBooks() {
		return totalBooks;
	}
	public void setTotalBooks(int totalBooks) {
		this.totalBooks = totalBooks;
	}
	
	public int totalPages() {
		int totalpage=totalBooks % booksPerPage == 0 ? totalBooks / booksPerPage : totalBooks / booksPerPage + 1;
		return totalpage;
	}
	public int BeginIndex() {
		int beginIndex = (pageNow - 1) * booksPerPage;
		return beginIndex;
	}
}
