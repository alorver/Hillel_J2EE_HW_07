package edu.avo.hillel_j2ee_hw_07.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ROLES")
@Setter
@Getter
@NoArgsConstructor
public class Role implements GrantedAuthority {
    @Id
    @Column(name="id", nullable = false)
    private Integer id;
    private String name;

    @Transient
    @ManyToMany(mappedBy = "roleSet", fetch = FetchType.EAGER)
    private Set<Person> personSet = new HashSet<>();


    @Override
    public String getAuthority() {
        return getName();
    }

    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
