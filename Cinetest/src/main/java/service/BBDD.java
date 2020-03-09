package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Email;
import model.Pedidos;
import model.PedidosProductos;
import model.ProdCarrito;
import model.Productos;
import model.Restaurantes;
import repository.BBDDDAO;


public class BBDD implements BBDDDAO {

	
	
	int result;

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("conexion");
	ArrayList<ProdCarrito> listaCarromato = new ArrayList<ProdCarrito>();
	ArrayList<ProdCarrito> listaCarromato2 = new ArrayList<ProdCarrito>();
	ArrayList<String> directorr = new ArrayList<String>();

	

	public List<Restaurantes> unsuccesfullLogin(String correo, String clave)
			throws SQLException, ClassNotFoundException {

		ArrayList<Restaurantes> array = new ArrayList<>();

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Query query = entitymanager
				.createQuery("SELECT r FROM Restaurantes r WHERE r.correo = :usuario AND r.clave = :password");

		query.setParameter("usuario", correo);
		query.setParameter("password", clave);

		array = (ArrayList<Restaurantes>) query.getResultList();

		if (array.isEmpty()) {
			array.add(new Restaurantes(404, "Error, vuelva a intentarlo", "", "", 0, "", ""));
		} else {
			array.clear();
		}

		return array;
	}

	public List<Productos> mostrarTodo() throws ClassNotFoundException, SQLException {

		ArrayList<Productos> lista = new ArrayList<Productos>();

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Query query = entitymanager.createQuery("SELECT p FROM Productos p where categoria=1");

		lista = (ArrayList<Productos>) query.getResultList();

		if (lista.isEmpty()) {
			lista.add(new Productos("Error"));
		}

		return lista;
	}

	public List<Productos> mostrarTodo2() throws ClassNotFoundException, SQLException {

		ArrayList<Productos> lista = new ArrayList<Productos>();

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Query query = entitymanager.createQuery("SELECT p FROM Productos p where categoria=2");

		lista = (ArrayList<Productos>) query.getResultList();

		if (lista.isEmpty()) {
			lista.add(new Productos("Error"));
		}

		return lista;
	}

	public List<Productos> mostrarTodo3() throws ClassNotFoundException, SQLException {

		ArrayList<Productos> lista = new ArrayList<Productos>();

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Query query = entitymanager.createQuery("SELECT p FROM Productos p where categoria=3");

		lista = (ArrayList<Productos>) query.getResultList();

		if (lista.isEmpty()) {
			lista.add(new Productos("Error"));
		}

		return lista;
	}

	public List<ProdCarrito> addProducto(Integer id,String nombre,String descripcion,double peso,Integer stock,Integer categoria,Integer numComprar) throws ClassNotFoundException, SQLException {

		ProdCarrito prodCarrito = new ProdCarrito( id, nombre, descripcion, peso, stock, categoria, numComprar);
		
		ListIterator<ProdCarrito> recorrer = listaCarromato.listIterator();
		
		while(recorrer.hasNext()) {
			ProdCarrito p = recorrer.next();
			if(p.getId() == id) {
				Integer nuevaCifra = p.getNumComprar() + numComprar;
				p.setNumComprar(nuevaCifra);
			}else {
				listaCarromato.add(prodCarrito);
			}
		}
		
//		for (ProdCarrito p : listaCarromato) {
//			if(p.getId() == id) {
//				Integer nuevaCifra = p.getNumComprar() + numComprar;
//				p.setNumComprar(nuevaCifra);
//			}else {
//				listaCarromato.add(prodCarrito);
//			}
//		}
		
		if(listaCarromato.isEmpty()) {
			listaCarromato.add(prodCarrito);
		}

		return listaCarromato;
	}
	
	public List<ProdCarrito> mostrarCarromato() throws ClassNotFoundException, SQLException {

		return listaCarromato;
	}
	
	public List<ProdCarrito> deleteProductos(Integer id, Integer pedidos, Integer unidades) throws ClassNotFoundException, SQLException {

		for (ProdCarrito p : listaCarromato) {
			if(p.getId() == id && p.getNumComprar() == pedidos) {
				pedidos = pedidos - unidades;
				p.setNumComprar(pedidos);
			}		
		}
		
		return listaCarromato;
	}
	
	public List<ProdCarrito> vaciarCarromato() throws ClassNotFoundException, SQLException {
		
		listaCarromato.clear();

		return listaCarromato;
	}
	
	public void finalizarPedido() throws ClassNotFoundException, SQLException {
		
		for (ProdCarrito p : listaCarromato) {
			
			EntityManager entitymanager = emfactory.createEntityManager();
			entitymanager.getTransaction().begin();
			
			Pedidos pedido = new Pedidos();
			Date fecha = new Date();
			Date fechaPed = new Date(fecha.getTime());
			
			pedido.setCodPed(1 + (int)(Math.random() * 1000));
			pedido.setCodRes(1);
			pedido.setEnviado(-1);
			pedido.setFecha(fechaPed);
						
			entitymanager.persist(pedido);
			entitymanager.getTransaction().commit();
						
			PedidosProductos pedidosProductos = new PedidosProductos();
		
			EntityManager entitymanager2 = emfactory.createEntityManager();
			entitymanager2.getTransaction().begin();
			
			pedidosProductos.setCodPedProd(1 + (int)(Math.random() * 1000));
			pedidosProductos.setPedido(pedido.getCodPed());
			pedidosProductos.setProducto(p.getId());
			pedidosProductos.setUnidades(p.getNumComprar());
			
			entitymanager2.persist(pedidosProductos);
			entitymanager2.getTransaction().commit();
			
			EntityManager entitymanager3 = emfactory.createEntityManager();
			entitymanager3.getTransaction().begin();
			
			Integer nc = p.getNumComprar();
			Query query2 = entitymanager3.createQuery("update Productos p set p.stock=(p.stock-"+nc+") where p.codProd="+p.getId()+")");
			
			query2.executeUpdate();			
			entitymanager3.getTransaction().commit();			
			
		}

		
	}
	
	
	
	/****************/

}