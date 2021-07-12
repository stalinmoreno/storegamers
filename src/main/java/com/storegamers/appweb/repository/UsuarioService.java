package com.storegamers.appweb.repository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repo;

    public void changePassword(String newPssw, String oldPssw) {
        String old = consult(oldPssw);
        repo.changePassword(newPssw, old);
    }

    public String consult(String pssw){
        return repo.searchPassword(pssw);
    }

}
