package br.ufac.sgcm.controller;

import java.util.List;

import br.ufac.sgcm.dao.PacienteDao;
import br.ufac.sgcm.model.Paciente;

public class PacienteController implements IController<Paciente> {

    private PacienteDao dao;

    public PacienteController() {
        dao = new PacienteDao();
    }

    @Override
    public List<Paciente> get() {
        return dao.get();
    }

    @Override
    public Paciente get(Long id) {
        return dao.get(id);
    }

    @Override
    public List<Paciente> get(String termoBusca) {
        return dao.get(termoBusca);
    }

    @Override
    public int save(Paciente objeto) {
        int registrosAfetados = 0;
        if (objeto.getId() == null) {
            registrosAfetados = dao.insert(objeto);            
        } else {
            registrosAfetados = dao.update(objeto);
        }
        return registrosAfetados;
    }

    @Override
    public int delete(Long id) {
        return dao.delete(id);
    }
    
}
