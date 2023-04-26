package br.ufac.sgcm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import br.ufac.sgcm.dao.EspecialidadeDao;
import br.ufac.sgcm.dao.ProfissionalDao;
import br.ufac.sgcm.dao.UnidadeDao;
import br.ufac.sgcm.model.Especialidade;
import br.ufac.sgcm.model.Profissional;
import br.ufac.sgcm.model.Unidade;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

public class PrimeiroServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        PrintWriter saida = res.getWriter();

        ProfissionalDao dao = new ProfissionalDao();
        List<Profissional> profissionais = dao.get();
        // for (Profissional item : profissionais) {
        //     saida.println(item.getNome());
        //     saida.println(item.getEmail());
        //     saida.println(item.getEspecialidade().getNome());
        //     saida.println(item.getUnidade().getNome());
        //     saida.println();
        // }

        // Profissional p = dao.get(1L);
        // saida.println(p.getNome());
        // p.setNome("Daniel");
        // dao.update(p);
        // p = dao.get(1L);
        // saida.println(p.getNome());

        List<Profissional> profissionaisBusca = dao.get("cardiologia");
        for (Profissional itemProfissional : profissionaisBusca) {
            saida.println(itemProfissional.getNome());
            saida.println(itemProfissional.getEspecialidade().getNome());
            saida.println();
        }

        EspecialidadeDao dao2 = new EspecialidadeDao();
        List<Especialidade> especialidades = dao2.get();
        // for (Especialidade item : especialidades) {
        //     saida.println(item.getNome());
        //     saida.println();
        // }

        UnidadeDao dao3 = new UnidadeDao();
        List<Unidade> unidades = dao3.get();
        // for (Unidade item : unidades) {
        //     saida.println(item.getNome());
        //     saida.println();
        // }
        
    }
    
}
