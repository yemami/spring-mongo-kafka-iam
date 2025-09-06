package com.example.app.task;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("tasks")  // tells spring Data this maps to the "tasks" collections
@Data @NoArgsConstructor @AllArgsConstructor @Builder  //Lombok (@Data, etc.) generates getters/setters/constructors to keep the class short.
public class Task {
    @Id  // mongo _id field (String)
    private String id;
    @NotBlank  // validate incoming JSON (title cannot be empty)
    private String title;
    private boolean done;
}
