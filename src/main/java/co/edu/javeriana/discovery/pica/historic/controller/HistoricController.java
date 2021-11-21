package co.edu.javeriana.discovery.pica.historic.controller;

import co.edu.javeriana.discovery.pica.historic.controller.model.Error;
import co.edu.javeriana.discovery.pica.historic.controller.model.RespGetHistorico;
import co.edu.javeriana.discovery.pica.historic.service.IHistoricService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/c3p/v1/Portal")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HistoricController {

    private static final String XRQUID = "X-RqUID";
    private static final String TIPO = "TipoConsulta";
    private static final String CODIGO = "Codigo";
    private static final String FECHAINICIO = "FechaInicio";
    private static final String FECHAFIN = "FechaFin";
    private static final String REQUEST = "Request";
    private static final String RESPONSE = "Response";
    private static final String RESPONSECODE = "ResponseCode";
    private static final String RQUID = "RqUID";
    private static final String ERRORCONSULTA = "Error al consultar historicos";
    private static final String CODIGOERRORCONSULTA = "200";

    private IHistoricService historicService;

    @Autowired
    private Tracer tracer;

    @Autowired
    public HistoricController(IHistoricService historicService) {
        this.historicService = historicService;
    }

    @GetMapping("/Historico/{Codigo}")
    public ResponseEntity<Object> getHistorico(@RequestHeader(value=XRQUID) String xRqUID, @RequestHeader(value=TIPO) String tipoConsulta, @PathVariable(CODIGO) String codigo) throws JsonProcessingException {
        log.info("Get Historic by type for RqUID {}", xRqUID);
        ObjectMapper mapper = new ObjectMapper();
        HistoricController.this.tracer.currentSpan().tag(RQUID,xRqUID);
        HistoricController.this.tracer.currentSpan().tag(TIPO,tipoConsulta);
        try {
        List<RespGetHistorico> response = historicService.getHistorico(xRqUID,tipoConsulta,codigo);
        String json = mapper.writeValueAsString(response);
        HistoricController.this.tracer.currentSpan().tag(RESPONSE,json);
        HistoricController.this.tracer.currentSpan().tag(RESPONSECODE,HttpStatus.OK.toString());
        return new ResponseEntity<>(response,putRqUIDHeader(xRqUID),HttpStatus.OK);
        }catch (Exception e) {
            HistoricController.this.tracer.currentSpan().tag(RESPONSECODE,HttpStatus.PARTIAL_CONTENT.toString());
            String jsonError = mapper.writeValueAsString(buildError(ERRORCONSULTA,CODIGOERRORCONSULTA));
            HistoricController.this.tracer.currentSpan().tag(RESPONSE,jsonError);
            return new ResponseEntity<>(jsonError,putRqUIDHeader(xRqUID),HttpStatus.PARTIAL_CONTENT);
        }
    }

    @GetMapping("/Historico/Fecha")
    public ResponseEntity<Object> getHistoricoFecha(@RequestHeader(value=XRQUID) String xRqUID,@RequestHeader(value=FECHAINICIO) String fechaInicio, @RequestHeader(value=FECHAFIN) String fechaFin) throws JsonProcessingException {
        log.info("Get Historic by date for RqUID {}", xRqUID);
        ObjectMapper mapper = new ObjectMapper();
        HistoricController.this.tracer.currentSpan().tag(RQUID,xRqUID);
        HistoricController.this.tracer.currentSpan().tag(FECHAINICIO,fechaInicio);
        HistoricController.this.tracer.currentSpan().tag(FECHAFIN,fechaFin);
        try {
        List<RespGetHistorico>  response = historicService.getHistoricoFecha(xRqUID,fechaInicio,fechaFin);
        String json = mapper.writeValueAsString(response);
        HistoricController.this.tracer.currentSpan().tag(RESPONSE,json);
        HistoricController.this.tracer.currentSpan().tag(RESPONSECODE,HttpStatus.OK.toString());
        return new ResponseEntity<>(response,putRqUIDHeader(xRqUID),HttpStatus.OK);
        }catch (Exception e) {
            HistoricController.this.tracer.currentSpan().tag(RESPONSECODE,HttpStatus.PARTIAL_CONTENT.toString());
            String jsonError = mapper.writeValueAsString(buildError(ERRORCONSULTA,CODIGOERRORCONSULTA));
            HistoricController.this.tracer.currentSpan().tag(RESPONSE,jsonError);
            return new ResponseEntity<>(jsonError,putRqUIDHeader(xRqUID),HttpStatus.PARTIAL_CONTENT);
        }
    }

    private HttpHeaders putRqUIDHeader(String rquid) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(XRQUID,rquid);
        return headers;
    }
    private Error buildError(String mensaje, String codigo) {
        Error error = new Error();
        error.setCodigo(codigo);
        error.setMensaje(mensaje);
        return error;
    }
}
