package co.edu.javeriana.discovery.pica.historic.repository.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inspection", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inspection {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String id;

    @Column(name = "supervisor_id")
    private String supervisorId;

    @Column(name = "location_id")
    private String locationId;

    @Column(name = "employee_id")
    private String employeeId;

    @Column(name = "type")
    private String type;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "approved")
    private Boolean approved;

    @Column(name = "novelty")
    private Boolean novelty;

    @Column(name = "novelty_description")
    private String noveltyDescription;

    @Column(name = "improvement_action")
    private Boolean improvementAction;

    @Column(name = "improvement_action_description")
    private String improvementActionDescription;

    @Column(name = "comment")
    private String comment;
}
