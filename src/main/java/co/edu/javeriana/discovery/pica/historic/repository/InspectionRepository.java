package co.edu.javeriana.discovery.pica.historic.repository;

import java.time.LocalDate;
import java.util.List;

import co.edu.javeriana.discovery.pica.historic.repository.model.Inspection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InspectionRepository extends JpaRepository<Inspection, String> {

    List<Inspection> findAllBySupervisorId(String supervisorId);

    List<Inspection> findAllByEmployeeId(String employeeId);

    List<Inspection> findAllByDateBetween(LocalDate initDate, LocalDate finalDate);
}
