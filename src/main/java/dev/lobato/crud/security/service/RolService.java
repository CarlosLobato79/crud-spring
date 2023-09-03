package dev.lobato.crud.security.service;

import dev.lobato.crud.security.enums.RolNombre;
import dev.lobato.crud.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dev.lobato.crud.security.entity.Rol;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        rolRepository.save(rol);
    }



}
