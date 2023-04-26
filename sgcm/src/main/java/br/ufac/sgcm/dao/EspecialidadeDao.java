package br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufac.sgcm.model.Especialidade;

public class EspecialidadeDao implements IDao<Especialidade> {

    private Connection conexao;
    private PreparedStatement ps;
    private ResultSet rs;

    public EspecialidadeDao() {
        conexao = ConexaoDB.getConexao();
    }

    @Override
    public List<Especialidade> get() {
        List<Especialidade> registros = new ArrayList<>();
        String sql = "SELECT * FROM sgcm.especialidade" + 
        " ORDER BY especialidade.id";
        try {
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Especialidade registro = new Especialidade();
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                registros.add(registro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    @Override
    public Especialidade get(Long id) {
        Especialidade registro = new Especialidade();
        String sql = "SELECT * FROM sgcm.especialidade WHERE id = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registro;
    }

    @Override
    public List<Especialidade> get(String termoBusca) {
       List<Especialidade> registros = new ArrayList<>();
       String sql = "SELECT *" +
            " FROM sgcm.especialidade" +
            " WHERE especialidade.nome LIKE ?" +
            " ORDER BY especialidade.id";
       try {
        ps = conexao.prepareStatement(sql);
        ps.setString(1, "%" + termoBusca + "%");
        rs = ps.executeQuery();
        while (rs.next()) {
            Especialidade registro = new Especialidade();
            registro.setId(rs.getLong("id"));
            registro.setNome(rs.getString("nome"));
            registros.add(registro);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

       return registros;
    }

    @Override
    public int insert(Especialidade objeto) {
        int registrosAfetados = 0;
        String sql = "INSERT INTO sgcm.especialidade (nome) VALUES (?) ";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getNome());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registrosAfetados;
    }

    @Override
    public int update(Especialidade objeto) {
        int registrosAfetados = 0;
        String sql = "UPDATE sgcm.especialidade SET" +
            " nome = ?" +
            " WHERE id = ?";
            try {
                ps = conexao.prepareStatement(sql);
                ps.setString(1, objeto.getNome());
                ps.setLong(2, objeto.getId());
                registrosAfetados = ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return registrosAfetados;
        
    }

    @Override
    public int delete(Long id) {
        int registrosAfetados = 0;
        String sql = "DELETE FROM sgcm.especialidade WHERE id = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, id);
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }
    
}
