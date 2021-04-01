package dubby.serve.service.update.accountupdate.domain.oauth;

import dubby.serve.service.update.accountupdate.util.constants.CrudPermission;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PERMISSION", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "NAME"
        })
})
public class Permission implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "NAME", nullable = false, length = 8)
    private CrudPermission name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CrudPermission getName() {
        return name;
    }

    public void setName(CrudPermission name) {
        this.name = name;
    }
}
