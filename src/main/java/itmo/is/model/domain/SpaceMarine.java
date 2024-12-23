package itmo.is.model.domain;

import itmo.is.model.security.OwnedEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Entity
@Table(name = "marines")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpaceMarine extends OwnedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Embedded
    private Coordinates coordinates;

    @CreationTimestamp
    @Column(name = "creation_date", updatable = false)
    private LocalDate creationDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = true)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "chapter_id", nullable = true)
    private Chapter chapter;

    @NotNull
    @Min(1)
    @Column(name = "health", nullable = false)
    private Double health;

    @Column(name = "loyal")
    private boolean loyal;

    @NotNull
    @Column(name = "height", nullable = false)
    private Integer height;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    private AstartesCategory category;
}
