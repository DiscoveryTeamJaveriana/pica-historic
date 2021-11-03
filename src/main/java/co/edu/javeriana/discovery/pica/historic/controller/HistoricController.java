package co.edu.javeriana.discovery.pica.historic.controller;

import co.edu.javeriana.discovery.pica.historic.controller.model.RespGetHistorico;
import co.edu.javeriana.discovery.pica.historic.service.IHistoricService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping("/c3p/v1/Portal")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HistoricController {

    private static final String RQUID = "X-RqUID";
    private static final String TIPO = "TipoConsulta";
    private static final String CODIGO = "Codigo";
    private static final String FECHAINICIO = "FechaInicio";
    private static final String FECHAFIN = "FechaFin";

    private IHistoricService historicService;

    @Autowired
    public HistoricController(IHistoricService historicService) {
        this.historicService = historicService;
    }

    @GetMapping("/Historico/{Codigo}")
    public ResponseEntity<ArrayList<RespGetHistorico>> getHistorico(@RequestHeader(value=RQUID) String xRqUID,@RequestHeader(value=TIPO) String tipoConsulta, @PathVariable(CODIGO) String codigo) {
        log.info("Get Historic by type for RqUID {}", xRqUID);
        ArrayList<RespGetHistorico> response = historicService.getHistorico(xRqUID,tipoConsulta,codigo);
        return new ResponseEntity<>(response,putRqUIDHeader(xRqUID),HttpStatus.OK);
    }

    @GetMapping("/Historico/Fecha")
    public ResponseEntity<ArrayList<RespGetHistorico>> getHistoricoFecha(@RequestHeader(value=RQUID) String xRqUID,@RequestHeader(value=FECHAINICIO) String fechaInicio, @RequestHeader(value=FECHAFIN) String fechaFin) {
        log.info("Get Historic by date for RqUID {}", xRqUID);
        ArrayList<RespGetHistorico>  response = historicService.getHistoricoFecha(xRqUID,fechaInicio,fechaFin);
        return new ResponseEntity<>(response,putRqUIDHeader(xRqUID),HttpStatus.OK);
    }

    private HttpHeaders putRqUIDHeader(String rquid) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(RQUID,rquid);
        return headers;
    }
}
