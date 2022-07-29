package pl.coderslab.workshop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class Book {
	
	private Long id;
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private String type;
	
	public Book () {
	
	}
	
}
