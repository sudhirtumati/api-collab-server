package io.apicollab.server.domain;

import io.apicollab.server.mapper.ApiTagsConverter;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"}, callSuper = true)
public class Api extends BaseEntity {

    private static final long serialVersionUID = 8281554038825109184L;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String version;

    @Column(nullable = false)
    private String description;

    @Column()
    @Convert(converter = ApiTagsConverter.class)
    private List<String> tags;

    @Column(nullable = false, columnDefinition = "CLOB")
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String swaggerDefinition;
    @ManyToOne
    private Application application;

    @Builder
    private Api(String id, String name, String version, String swaggerDefinition, List<String> tags) {
        super(id);
        this.name = name;
        this.version = version;
        this.swaggerDefinition = swaggerDefinition;
        this.tags = tags;
    }
}
