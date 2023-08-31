package dev.lobato.crud.security.entity;


import com.sun.istack.NotNull;
import dev.lobato.crud.security.enums.RolNombre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rol")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rol implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolNombre rolNOmbre;

    public Rol(@NotNull RolNombre rolNombre) {
        this.rolNOmbre = rolNombre;
    }
}
