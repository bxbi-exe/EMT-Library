package finki.emt.library.model.dto;

import finki.emt.library.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private String name;
    private long authorId;
    private Integer availableCopies;
    private Category category;
}
