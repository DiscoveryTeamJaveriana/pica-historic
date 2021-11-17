package co.edu.javeriana.discovery.pica.historic.service;

import co.edu.javeriana.discovery.pica.historic.controller.model.RespGetHistorico;

import java.util.List;

public interface IHistoricService {
    List<RespGetHistorico> getHistorico (String rquid, String tipoConsulta, String codigo);
    List<RespGetHistorico> getHistoricoFecha (String rquid, String fechaInicio, String fechaFin);
}
