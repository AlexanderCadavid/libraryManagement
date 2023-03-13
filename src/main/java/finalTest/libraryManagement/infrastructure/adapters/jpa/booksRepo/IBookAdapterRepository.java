package finalTest.libraryManagement.infrastructure.adapters.jpa.booksRepo;

import finalTest.libraryManagement.infrastructure.adapters.DBOs.bookDBO.BookDBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookAdapterRepository extends JpaRepository<BookDBO, Integer> {
}
