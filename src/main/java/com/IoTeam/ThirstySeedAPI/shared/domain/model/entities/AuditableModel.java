package com.platform.tutorgo.shared.domain.model.entities;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

//sirve para la escucha de eventos relacionados a la entidad
@EntityListeners(AuditingEntityListener.class)

//es una super clase que no se mapea en la tabla pero sus compos son heredados en las subclases
@MappedSuperclass

//crea los getter, setter, equal, hashCode y toString y reduce la verbosidad
@Data
public class AuditableModel {
    //la creacion de fecha y modificación se generaran automaticamente
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;

}
