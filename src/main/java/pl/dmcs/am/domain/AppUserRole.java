package pl.dmcs.am.domain;
import javax.persistence.*;

@Entity
@Table(name="appuserrole")
public class AppUserRole {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String role;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

}
