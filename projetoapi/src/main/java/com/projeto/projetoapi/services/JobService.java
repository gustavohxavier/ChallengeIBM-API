package com.projeto.projetoapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    @Autowired
    private MigracaoDadosService migracaoDadosService;

    @Scheduled(fixedDelay = 10000L)
    public void iniciar(){
        migracaoDadosService.migrar();
    }
}
