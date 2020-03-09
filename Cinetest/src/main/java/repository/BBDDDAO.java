package repository;

import java.sql.SQLException;
import java.util.List;

import model.ProdCarrito;
import model.Productos;
import model.Restaurantes;


public interface BBDDDAO {



	public List<Restaurantes> unsuccesfullLogin(String usuario, String password) throws SQLException, ClassNotFoundException;

	public List<Productos> mostrarTodo() throws ClassNotFoundException, SQLException;

	public void finalizarPedido() throws ClassNotFoundException, SQLException;
	
	public List<ProdCarrito> vaciarCarromato() throws ClassNotFoundException, SQLException;
	
	public List<ProdCarrito> deleteProductos(Integer id, Integer pedidos, Integer unidades) throws ClassNotFoundException, SQLException;
	
	public List<ProdCarrito> mostrarCarromato() throws ClassNotFoundException, SQLException;
	
	public List<ProdCarrito> addProducto(Integer id,String nombre,String descripcion,double peso,Integer stock,Integer categoria,Integer numComprar) throws ClassNotFoundException, SQLException;

	public List<Productos> mostrarTodo3() throws ClassNotFoundException, SQLException;

	public List<Productos> mostrarTodo2() throws ClassNotFoundException, SQLException;
	
	

}
