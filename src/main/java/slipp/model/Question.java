package slipp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Question {
	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 20, nullable = false)
	private String writer;

	@Column(length = 100, nullable = false)
	private String title;

	@Column(nullable = false)
	@Lob
	private String contents;

	public void setId(Long id) {
		this.id = id;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", writer=" + writer + ", title=" + title + ", contents=" + contents + "]";
	}
}
