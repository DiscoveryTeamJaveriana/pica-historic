package co.edu.javeriana.discovery.pica.historic.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Validated
@Data
public class RespGetHistorico   {
  @JsonProperty("Codigo")
  private String codigo = null;

  @JsonProperty("CodigoSupervisor")
  private String codigoSupervisor = null;

  @JsonProperty("CodigoLocacion")
  private String codigoLocacion = null;

  @JsonProperty("CodigoEmpleado")
  private String codigoEmpleado = null;

  @JsonProperty("Tipo")
  private String tipo = null;

  @JsonProperty("Fecha")
  private String fecha = null;

  @JsonProperty("Titulo")
  private String titulo = null;

  @JsonProperty("Descripcion")
  private String descripcion = null;

  @JsonProperty("Aprobado")
  private Boolean aprobado = null;

  @JsonProperty("Novedad")
  private Boolean novedad = null;

  @JsonProperty("DescripcionNovedad")
  private String descripcionNovedad = null;

  @JsonProperty("AccionMejora")
  private Boolean accionMejora = null;

  @JsonProperty("DescripcionAccionMejora")
  private String descripcionAccionMejora = null;

  @JsonProperty("Comentario")
  private String comentario = null;

}

