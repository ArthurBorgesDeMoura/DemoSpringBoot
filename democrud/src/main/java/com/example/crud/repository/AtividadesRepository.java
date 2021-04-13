package com.example.crud.repository;

import com.example.crud.models.Atividades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface AtividadesRepository extends JpaRepository<Atividades, Long> {
    }
