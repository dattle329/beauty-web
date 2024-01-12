package com.vti.beautyweb.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class ProductUpdateForm {
    @NotBlank
    @Length(max = 200)
    private String name;

    @NotBlank
    @Length(max = 500)
    private String img;

    @NotNull
    @Min(value = 0, message = "khong dc để số âm")
    private Long price;
}
