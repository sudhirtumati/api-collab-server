package io.apicollab.server.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiDTO implements Serializable {

    private static final long serialVersionUID = 321024407674977143L;

    @JsonProperty("id")
    private String apiId;
    @NotBlank
    private String name;
    @NotBlank
    private String version;
    private String swaggerDefinition;
}
