package tarefas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import tarefas.conn.ConnGeneric;
import tarefas.conn.ConnPostgres;
import tarefas.model.Tarefa;

/**
 * @author Alcides Lemos
 */
public class TarefaDao extends GenericDao{
    private static TarefaDao instance;
    public static TarefaDao getInsance() {
        if (instance == null) {
            instance = new TarefaDao();
        }
        return instance;
    }

    public TarefaDao() {
        super();
    }
    
    @Override
    protected Object construirObjeto(ResultSet rs) {
        Tarefa tarefa = null;
        try {
            tarefa = new Tarefa(rs.getInt("id"),
                    rs.getString("descricao"),
                    rs.getBoolean("finalizacao"),
                    rs.getString("data_Finalizacao"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tarefa;
    }
    
    public ArrayList<Object> recuperarTodasTarefas() {
        try {
            return recuperarListaDeObjetos("SELECT * FROM TAREFA");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public Tarefa consultaPorID(int id) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Tarefa tarefa = null;
        String sql = "select * from tarefa where id = " + id;
        try{
            ps = conn.getConnection().prepareStatement(sql);
            rs = conn.getResultset(ps);
            while (rs.next()) {
                tarefa = (Tarefa) construirObjeto(rs);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            rs.close();
            ps.close();
        }
        return tarefa;
    }

    public void adiciona(Tarefa tarefa) {
        this.adicionar(tarefa, "tarefa");
    }
    
    public void deletar(int id) {
        try {
            super.deletar(id, "TAREFA");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void altera(Tarefa tarefa) {
        PreparedStatement ps = null;
        String sql = "INSERT INTO tarefa VALUES (nextval('tarefa_id'),?,?,?)";
        sql = "UPDATE TAREFA SET DESCRICAO = ?, FINALIZACAO = ?, DATA_FINALIZACAO = ? WHERE ID=?";
        try {
            ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, tarefa.getDescricao());
            ps.setBoolean(2, tarefa.isFinalizado());
            ps.setString(3, tarefa.getDataFinalizacao());
            ps.setInt(4, tarefa.getIdTarefa());
            conn.executeUpdate(ps);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    
    

    public void adicionar(Object obj, String tabela) {
        PreparedStatement ps = null;
        Tarefa tarefa = (Tarefa) obj;
        String sql;
        try {
            if (ConnGeneric.nameDAO.equalsIgnoreCase("ConnPostgres")){
                sql = "INSERT INTO " + tabela + " VALUES (nextval('tarefa_id'),?,?,?)";
            } else {
                sql = "INSERT INTO " + tabela + "(descricao,finalizacao,data_finalizacao) VALUES (?,?,?)";
            }
            ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, tarefa.getDescricao());
            ps.setBoolean(2, tarefa.isFinalizado());
            ps.setString(3, tarefa.getDataFinalizacao());

            conn.executeUpdate(ps);
            
            System.out.println("TarefaDao/adicionar");
        } catch (SQLException e) {
            System.out.println("Bugou no adicionar: Erro sql");
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Bugou no adicionar: Erro");
        }
    }
}