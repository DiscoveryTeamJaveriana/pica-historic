package co.edu.javeriana.discovery.pica.historic.service.impl;

import co.edu.javeriana.discovery.pica.historic.controller.model.RespGetHistorico;
import co.edu.javeriana.discovery.pica.historic.mapper.HistoricMapper;
import co.edu.javeriana.discovery.pica.historic.repository.InspectionRepository;
import co.edu.javeriana.discovery.pica.historic.service.IHistoricService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class HistoricService implements IHistoricService {

    private final InspectionRepository inspectionRepository;

    @Override
    public List<RespGetHistorico> getHistorico(String rquid, String tipoConsulta, String codigo) {

        List<RespGetHistorico> respGetHistoricoList = null;
        try {
            if (tipoConsulta.equals("Supervisor")) {
                respGetHistoricoList = inspectionRepository.findAllBySupervisorId(codigo).stream()
                        .map(HistoricMapper::mapInspectionToRespGetHistorico)
                        .collect(Collectors.toList());
            } else {
                respGetHistoricoList = inspectionRepository.findAllByEmployeeId(codigo).stream()
                        .map(HistoricMapper::mapInspectionToRespGetHistorico)
                        .collect(Collectors.toList());
            }

            return respGetHistoricoList;
        }catch (Exception e) {
            log.info("Error al consultar historico");
            throw e;
        }
    }

    @Override
    public List<RespGetHistorico> getHistoricoFecha(String rquid, String fechaInicio, String fechaFin) {

        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
        try {
            return inspectionRepository
                    .findAllByDateBetween(LocalDate.parse(fechaInicio, formatter), LocalDate.parse(fechaFin, formatter)).stream()
                    .map(HistoricMapper::mapInspectionToRespGetHistorico)
                    .collect(Collectors.toList());
        }catch (Exception e) {
            log.info("Error al crear historico");
            throw e;
        }
    }

}

