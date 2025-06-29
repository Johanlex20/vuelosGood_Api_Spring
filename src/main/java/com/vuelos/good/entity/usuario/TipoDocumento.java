package com.vuelos.good.entity.usuario;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tipo_doc")
public class TipoDocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_doc")
    private Integer idDoc;

    @Column(name = "nom_doc")
    private String nombreDoc;

    @Column(name = "codi_doc")
    private String codigoDoc;

    @Column(name = "estado_doc")
    private String estadoDoc;

    @Column(name = "descri_doc")
    private String descriDoc;

    @Column(name = "doc_created_at")
    private LocalDate docCreatedAt;

    @Column(name = "doc_update_at")
    private LocalDate docUpdateAt;




    public TipoDocumento() {
    }

    public TipoDocumento(Integer idDoc, String nombreDoc, String codigoDoc, String estadoDoc, String descriDoc, LocalDate docCreatedAt, LocalDate docUpdateAt) {
        this.idDoc = idDoc;
        this.nombreDoc = nombreDoc;
        this.codigoDoc = codigoDoc;
        this.estadoDoc = estadoDoc;
        this.descriDoc = descriDoc;
        this.docCreatedAt = docCreatedAt;
        this.docUpdateAt = docUpdateAt;
    }

    public Integer getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(Integer idDoc) {
        this.idDoc = idDoc;
    }

    public String getNombreDoc() {
        return nombreDoc;
    }

    public void setNombreDoc(String nombreDoc) {
        this.nombreDoc = nombreDoc;
    }

    public String getCodigoDoc() {
        return codigoDoc;
    }

    public void setCodigoDoc(String codigoDoc) {
        this.codigoDoc = codigoDoc;
    }

    public String getEstadoDoc() {
        return estadoDoc;
    }

    public void setEstadoDoc(String estadoDoc) {
        this.estadoDoc = estadoDoc;
    }

    public String getDescriDoc() {
        return descriDoc;
    }

    public void setDescriDoc(String descriDoc) {
        this.descriDoc = descriDoc;
    }

    public LocalDate getDocCreatedAt() {
        return docCreatedAt;
    }

    public void setDocCreatedAt(LocalDate docCreatedAt) {
        this.docCreatedAt = docCreatedAt;
    }

    public LocalDate getDocUpdateAt() {
        return docUpdateAt;
    }

    public void setDocUpdateAt(LocalDate docUpdateAt) {
        this.docUpdateAt = docUpdateAt;
    }
}
