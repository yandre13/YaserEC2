package com.idat.EC2YaserQuinonez.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.EC2YaserQuinonez.modelo.Bodega;

@Repository
public interface BodegaRepositorio extends JpaRepository<Bodega, Integer> {

}
