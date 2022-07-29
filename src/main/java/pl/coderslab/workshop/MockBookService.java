package pl.coderslab.workshop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
@AllArgsConstructor
@Getter
@Setter
public class MockBookService implements BookService {
	
	private List<Book> books;
	private static Long nextId = 4L;
	
	
	public MockBookService () {
		
		books = new ArrayList<>();
		
		books.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
		books.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
				"programming"));
		books.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
				"programming"));
	}
	
	@Override
	public List<Book> getBooks () {
		
		return books;
	}
	
	@Override
	public void addBook (Book book) {
		
		book.setId(nextId++);
		books.add(book);
	}
	
	@Override
	public Optional<Book> get (Long id) {
		
		return books.stream().filter(item -> item.getId().equals(id)).findFirst();
	}
	
	@Override
	public void delete (Long id) {
		
		if (get(id).isPresent()) {
			books.remove(this.get(id).get());
		}
	}
	
	@Override
	public void update (Book book) {
		
		if (this.get(book.getId()).isPresent()) {
			int indexOf = books.indexOf(this.get(book.getId()).get());
			books.set(indexOf, book);
		}
	}
}
