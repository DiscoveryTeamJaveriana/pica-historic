package co.edu.javeriana.discovery.pica.historic.service;

import co.edu.javeriana.discovery.pica.historic.controller.model.RespGetHistorico;

import java.util.ArrayList;

public interface IHistoricService {
    ArrayList<RespGetHistorico> getHistorico (String rquid, String tipoConsulta, String codigo);
    ArrayList<RespGetHistorico> getHistoricoFecha (String rquid, String fechaInicio, String fechaFin);
}