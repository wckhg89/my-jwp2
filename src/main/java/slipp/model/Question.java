package slipp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Question {
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_question_writer"))
	private User writer;
	
	@Column(length = 100, nullable = false)
	private String title;

	@Column(nullable = false)
	@Lob
	private String contents;

	public void setId(Long id) {
		this.id = id;
	}

	public void setWriter(User writer) {
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
