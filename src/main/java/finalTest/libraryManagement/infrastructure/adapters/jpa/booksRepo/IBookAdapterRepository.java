package finalTest.libraryManagement.infrastructure.adapters.jpa.booksRepo;

import finalTest.libraryManagement.infrastructure.adapters.DBOs.booksDBO.BooksDBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookAdapterRepository extends JpaRepository <BooksDBO, Integer> {
}
