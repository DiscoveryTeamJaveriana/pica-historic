package co.edu.javeriana.discovery.pica.historic.service.impl;

import co.edu.javeriana.discovery.pica.historic.controller.model.RespGetHistorico;
import co.edu.javeriana.discovery.pica.historic.service.IHistoricService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Slf4j
@Service
public class HistoricService implements IHistoricService {

    @Override
    public ArrayList<RespGetHistorico> getHistorico(String rquid, String tipoConsulta, String codigo) {
        log.info("Panic implement me !");
        ArrayList<RespGetHistorico> respGetHistoricos = new ArrayList<RespGetHistorico>();
        RespGetHistorico respGetHistorico = new RespGetHistorico();
        respGetHistorico.setCodigo("123");
        respGetHistorico.setCodigoSupervisor("123");
        respGetHistorico.setCodigoLocacion("123");
        respGetHistorico.setCodigoEmpleado("123");
        respGetHistorico.setTipo("Tipo");
        respGetHistorico.setFecha("10/10/10");
        respGetHistorico.setTitulo("Titulo");
        respGetHistorico.setDescripcion("Descripcion");
        respGetHistorico.setAprobado(true);
        respGetHistorico.setNovedad(true);
        respGetHistorico.setDescripcionNovedad("Descipcion");
        respGetHistorico.setAccionMejora(true);
        respGetHistorico.setDescripcionAccionMejora("Descripcion");
        respGetHistorico.setComentario("Comentario");

        RespGetHistorico respGetHistorico2 = new RespGetHistorico();
        respGetHistorico2.setCodigo("123");
        respGetHistorico2.setCodigoSupervisor("123");
        respGetHistorico2.setCodigoLocacion("123");
        respGetHistorico2.setCodigoEmpleado("123");
        respGetHistorico2.setTipo("Tipo");
        respGetHistorico2.setFecha("10/10/10");
        respGetHistorico2.setTitulo("Titulo");
        respGetHistorico2.setDescripcion("Descripcion");
        respGetHistorico2.setAprobado(true);
        respGetHistorico2.setNovedad(true);
        respGetHistorico2.setDescripcionNovedad("Descipcion");
        respGetHistorico2.setAccionMejora(true);
        respGetHistorico2.setDescripcionAccionMejora("Descripcion");
        respGetHistorico2.setComentario("Comentario");

        respGetHistoricos.add(respGetHistorico);
        respGetHistoricos.add(respGetHistorico2);

        return respGetHistoricos;

    }

    @Override
    public ArrayList<RespGetHistorico> getHistoricoFecha(String rquid, String fechaInicio, String fechaFin) {
        log.info("Panic implement me !");
        ArrayList<RespGetHistorico> respGetHistoricos = new ArrayList<RespGetHistorico>();
        RespGetHistorico respGetHistorico = new RespGetHistorico();
        respGetHistorico.setCodigo("123");
        respGetHistorico.setCodigoSupervisor("123");
        respGetHistorico.setCodigoLocacion("123");
        respGetHistorico.setCodigoEmpleado("123");
        respGetHistorico.setTipo("Tipo");
        respGetHistorico.setFecha("10/10/10");
        respGetHistorico.setTitulo("Titulo");
        respGetHistorico.setDescripcion("Descripcion");
        respGetHistorico.setAprobado(true);
        respGetHistorico.setNovedad(true);
        respGetHistorico.setDescripcionNovedad("Descipcion");
        respGetHistorico.setAccionMejora(true);
        respGetHistorico.setDescripcionAccionMejora("Descripcion");
        respGetHistorico.setComentario("Comentario");

        RespGetHistorico respGetHistorico2 = new RespGetHistorico();
        respGetHistorico2.setCodigo("123");
        respGetHistorico2.setCodigoSupervisor("123");
        respGetHistorico2.setCodigoLocacion("123");
        respGetHistorico2.setCodigoEmpleado("123");
        respGetHistorico2.setTipo("Tipo");
        respGetHistorico2.setFecha("10/10/10");
        respGetHistorico2.setTitulo("Titulo");
        respGetHistorico2.setDescripcion("Descripcion");
        respGetHistorico2.setAprobado(true);
        respGetHistorico2.setNovedad(true);
        respGetHistorico2.setDescripcionNovedad("Descipcion");
        respGetHistorico2.setAccionMejora(true);
        respGetHistorico2.setDescripcionAccionMejora("Descripcion");
        respGetHistorico2.setComentario("Comentario");

        respGetHistoricos.add(respGetHistorico);
        respGetHistoricos.add(respGetHistorico2);

        return respGetHistoricos;
    }
}
