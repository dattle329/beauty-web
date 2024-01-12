package com.vti.beautyweb.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class ProductCreateForm {
    @NotBlank
    @Length(max = 200)
    private String name;

    @NotBlank
    @Length(max = 500)
    private String img;

    @NotNull
    @Min(value = 0, message = "để số lowsn hơn 0")
    private Long price;
}
