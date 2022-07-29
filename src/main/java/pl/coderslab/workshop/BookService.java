package pl.coderslab.workshop;

import java.util.List;
import java.util.Optional;


public interface BookService {
	
	List<Book> getBooks ();
	
	void addBook (Book book);
	
	Optional<Book> get (Long id);
	
	void delete (Long id);
	
	void update (Book book);
	
}
