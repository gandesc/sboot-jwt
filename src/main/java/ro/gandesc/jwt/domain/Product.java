package ro.gandesc.jwt.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Product {

    private long id;
    private String name;
    private String description;
}
