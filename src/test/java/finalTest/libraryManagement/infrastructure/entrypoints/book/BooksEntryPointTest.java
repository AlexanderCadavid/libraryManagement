package finalTest.libraryManagement.infrastructure.entrypoints.book;

import com.fasterxml.jackson.databind.ObjectMapper;
import finalTest.libraryManagement.domain.UseCases.book.BookUseCase;
import finalTest.libraryManagement.domain.models.book.Book;
import finalTest.libraryManagement.infrastructure.entrypoints.DTOs.bookDTO.BookDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BooksEntryPoint.class)
public class BooksEntryPointTest {

    @MockBean
    private BookUseCase bookUseCase;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Save book test")
    void saveBook() throws Exception {
        BookDTO bookDTO = new BookDTO(1, "book", "author", "category", true);
        Book book = BookDTO.toDomain(bookDTO);
        when(bookUseCase.saveBook((any(Book.class)))).thenReturn(book);
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mockMvc
                .perform(post("/book")
                                 .contentType(MediaType.APPLICATION_JSON)
                                 .content(mapper.writeValueAsString(bookDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated());
    }

}
