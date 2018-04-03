package mjuApps.noticeboard.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "status_dictionary")
public enum StatusEnum {

    ACTIVE(1), NOT_ACTIVATED(2), DEACTIVATED(3);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    StatusEnum(Integer id) {
        this.id = id;
    }

    public Integer getStatusId() {
        return id;
    }
}
