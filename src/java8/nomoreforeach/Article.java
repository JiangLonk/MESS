package java8.nomoreforeach;

import java.util.List;

/**
 * 一个
 * 
 * @author sa483
 *
 */
public class Article {
	private String title;
	private String author;
	private List<String> tags;

	public Article(String title, String author, List<String> tags) {
		this.title = title;
		this.author = author;
		this.tags = tags;
	}

	public Article() {
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}
}