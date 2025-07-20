package org.nik.Libraries.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(unique = true,nullable = false)
	private String username;
	@Column(nullable = false)
	private String bookname;
	@Column(nullable = false)
	private String category;
	@Column(nullable = false)
	private String establishDate;
	@Column(nullable = false)
	private int totalPages;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getTopic() {
		return category;
	}
	public void setTopic(String category) {
		this.category = category;
	}
	public String getEstablishDate() {
		return establishDate;
	}
	public void setEstablishDate(String establishDate) {
		this.establishDate = establishDate;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", bookname=" + bookname + ", category=" + category
				+ ", establishDate=" + establishDate + ", totalPages=" + totalPages + "]";
	}
}
