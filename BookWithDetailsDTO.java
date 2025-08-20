package com.example.Library_system.DTO;

import lombok.Data;
@Data

public class BookWithDetailsDTO {
    private String title;
    private String isbn;
    private String authorfirstname;
    private String authorlastname;
    private int authorbirthyear;
    private String authornationality;


}
