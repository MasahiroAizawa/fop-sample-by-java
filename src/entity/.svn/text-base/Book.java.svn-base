package entity;

public class Book {
	private Integer idBook;
	
	private String isbn;
	
	private String title;
	
	private String summary;
	
	private Integer price;

	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof Book)){
			return false;
		}
		Book compBook = (Book) obj;
	
		if(!this.idBook.equals(compBook.getIdBook())) return false;
		if(!this.isbn.equals(compBook.getIsbn())) return false;
		if(!this.title.equals(compBook.getTitle())) return false;
		if(!this.summary.equals(compBook.getSummary())) return false;
		if(!this.price.equals(compBook.getPrice())) return false;
		
		return true;
	}
	
	@Override
	public String toString(){
		return "ID:" + this.idBook + 
		", ISBN:" + this.isbn + 
		", TITLE:" + this.title + 
		", SUMMARY:" + this.summary + 
		", PRICE:" + this.price;
	}
	
	@Override
	public int hashCode(){
		int hash = this.idBook;
		
		char[] isbnArray = this.isbn.toCharArray();
		for(char c : isbnArray){
			hash += c;
		}
		char[] titleArray = this.isbn.toCharArray();
		for(char c : titleArray){
			hash += c;
		}
		char[] summaryArray = this.summary.toCharArray();
		for(char c : summaryArray){
			hash += c;
		}
		hash += price;
		
		return hash; 
	}
	
	public Integer getIdBook() {
		return idBook;
	}

	public void setIdBook(Integer idBook) {
		this.idBook = idBook;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
}
