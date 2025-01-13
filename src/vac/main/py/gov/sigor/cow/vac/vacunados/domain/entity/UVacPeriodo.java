package py.gov.sigor.cow.vac.vacunados.domain.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "VAC_PERIODO")
public class UVacPeriodo {

    @Id
    @Column(name = "vac_periodo_id")
    private Long vacPeriodoId;

    @Column(name = "nombre", nullable = false, length = 80)
    private String nombre;

    @Column(name = "fecha_ini", nullable = false)
    private LocalDateTime fechaIni;

    @Column(name = "fecha_registro_fin", nullable = false)
    private LocalDateTime fechaRegistroFin;

    @Column(name = "fecha_registro_fin_bru")
    private LocalDateTime fechaRegistroFinBru;

    // Getters and Setters
    public Long getVacPeriodoId() {
        return vacPeriodoId;
    }

    public void setVacPeriodoId(Long vacPeriodoId) {
        this.vacPeriodoId = vacPeriodoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(LocalDateTime fechaIni) {
        this.fechaIni = fechaIni;
    }

    public LocalDateTime getFechaRegistroFin() {
        return fechaRegistroFin;
    }

    public void setFechaRegistroFin(LocalDateTime fechaRegistroFin) {
        this.fechaRegistroFin = fechaRegistroFin;
    }

    public LocalDateTime getFechaRegistroFinBru() {
        return fechaRegistroFinBru;
    }

    public void setFechaRegistroFinBru(LocalDateTime fechaRegistroFinBru) {
        this.fechaRegistroFinBru = fechaRegistroFinBru;
    }
}
