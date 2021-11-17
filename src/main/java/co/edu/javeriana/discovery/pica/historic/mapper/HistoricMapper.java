package co.edu.javeriana.discovery.pica.historic.mapper;

import co.edu.javeriana.discovery.pica.historic.controller.model.RespGetHistorico;
import co.edu.javeriana.discovery.pica.historic.repository.model.Inspection;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HistoricMapper {

    public static RespGetHistorico mapInspectionToRespGetHistorico(final Inspection inspection) {
        RespGetHistorico respGetHistorico = new RespGetHistorico();
        respGetHistorico.setCodigo(inspection.getId());
        respGetHistorico.setCodigoSupervisor(inspection.getSupervisorId());
        respGetHistorico.setCodigoLocacion(inspection.getLocationId());
        respGetHistorico.setCodigoEmpleado(inspection.getEmployeeId());
        respGetHistorico.setTipo(inspection.getType());
        respGetHistorico.setFecha(inspection.getDate().toString());
        respGetHistorico.setTitulo(inspection.getTitle());
        respGetHistorico.setDescripcion(inspection.getDescription());
        respGetHistorico.setAprobado(inspection.getApproved());
        respGetHistorico.setNovedad(inspection.getNovelty());
        respGetHistorico.setDescripcionNovedad(inspection.getNoveltyDescription());
        respGetHistorico.setAccionMejora(inspection.getImprovementAction());
        respGetHistorico.setDescripcionAccionMejora(inspection.getImprovementActionDescription());
        respGetHistorico.setComentario(inspection.getComment());

        return respGetHistorico;
    }

}
