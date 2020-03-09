package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.Email;
import model.ProdCarrito;
import model.Productos;
import model.Restaurantes;
import service.BBDD;

@Controller
@EnableAutoConfiguration
public class Controlador {

	String correo0 = "pruebadeew@gmail.com";
	BBDD BBDD = new BBDD();
	
	Email email = new Email();

	String pagina = null;

	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	public String newUser() {
		return "/newUser";
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String goIndex() {
		return "index";
	}

	@RequestMapping(value = "/salir", method = RequestMethod.GET)
	public String salir() {
		return "/salir";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		try {
			BBDD.vaciarCarromato();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/login";
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome() {
		return "/welcome";
	}

	@RequestMapping(value = "/informacion", method = RequestMethod.GET)
	public String informacion() {
		return "/informacion";
	}

	@RequestMapping(value = "/consult", method = RequestMethod.GET)
	public String consult() {
		return "/consultaDir";
	}

	@RequestMapping(value = "/mantenimiento", method = RequestMethod.GET)
	public String mantenimiento() {
		return "/mantenimiento";
	}

	@RequestMapping(value = "/consultaDir", method = RequestMethod.GET)
	public String consultaDir() {
		return "/consultaDir";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {

		try {
			BBDD.vaciarCarromato();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "/index";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public ModelAndView logearse(HttpServletRequest request) throws ServletException, IOException {

		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");

		try {

			List<Restaurantes> usr = BBDD.unsuccesfullLogin(usuario, password);

			if (!usr.isEmpty()) {
				request.setAttribute("listaUsr", usr);
				pagina = "/login";

			} else {

				request.setAttribute("user", usuario);
				pagina = "/welcome";

			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return new ModelAndView(pagina);

	}

	@RequestMapping(method = RequestMethod.POST, value = "/welcome1")
	public ModelAndView welcome1(HttpServletRequest request) throws ServletException, IOException {

		try {

			List<Productos> pel = BBDD.mostrarTodo();

			request.setAttribute("listaPel", pel);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return new ModelAndView("bebidasCon");

	}

	@RequestMapping(method = RequestMethod.POST, value = "/welcome2")
	public ModelAndView welcome2(HttpServletRequest request) throws ServletException, IOException {

		try {

			List<Productos> pel = BBDD.mostrarTodo2();

			request.setAttribute("listaPel", pel);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return new ModelAndView("bebidasSin");

	}

	@RequestMapping(method = RequestMethod.POST, value = "/welcome3")
	public ModelAndView welcome3(HttpServletRequest request) throws ServletException, IOException {

		try {

			List<Productos> pel = BBDD.mostrarTodo3();

			request.setAttribute("listaPel", pel);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return new ModelAndView("comida");

	}

	@RequestMapping(method = RequestMethod.POST, value = "/carromato")
	public void carromato(HttpServletRequest request) throws ServletException, IOException {

		try {

			/* Recupera el carro */
			List<ProdCarrito> prodCarrito = BBDD.mostrarCarromato();

			request.setAttribute("listaPel", prodCarrito);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/bebidasCon")
	public void carromato1(HttpServletRequest request) throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("codProd"));
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		double peso = Double.parseDouble(request.getParameter("peso"));
		Integer stock = Integer.parseInt(request.getParameter("stock"));
		Integer categoria = Integer.parseInt(request.getParameter("categoria"));
		Integer numComprar = Integer.parseInt(request.getParameter("unidades"));

		try {

			/* llena el carromato */
			BBDD.addProducto(id, nombre, descripcion, peso, stock, categoria, numComprar);

			/* Vuelta a cargar */
			List<Productos> pel = BBDD.mostrarTodo();

			request.setAttribute("listaPel", pel);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				List<Productos> pel = BBDD.mostrarTodo();

				request.setAttribute("listaPel", pel);
			} catch (Exception i) {
				i.printStackTrace();
			}
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/bebidasSin")
	public void carromato2(HttpServletRequest request) throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("codProd"));
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		double peso = Double.parseDouble(request.getParameter("peso"));
		Integer stock = Integer.parseInt(request.getParameter("stock"));
		Integer categoria = Integer.parseInt(request.getParameter("categoria"));
		Integer numComprar = Integer.parseInt(request.getParameter("unidades"));

		try {

			/* llena el carromato */
			List<ProdCarrito> prodCarrito = BBDD.addProducto(id, nombre, descripcion, peso, stock, categoria,
					numComprar);

			/* Vuelta a cargar */
			List<Productos> pel = BBDD.mostrarTodo2();

			request.setAttribute("listaPel", pel);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				List<Productos> pel = BBDD.mostrarTodo2();

				request.setAttribute("listaPel", pel);
			} catch (Exception i) {
				i.printStackTrace();
			}
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/comida")
	public void carromato3(HttpServletRequest request) throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("codProd"));
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		double peso = Double.parseDouble(request.getParameter("peso"));
		Integer stock = Integer.parseInt(request.getParameter("stock"));
		Integer categoria = Integer.parseInt(request.getParameter("categoria"));
		Integer numComprar = Integer.parseInt(request.getParameter("unidades"));

		try {

			/* llena el carromato */
			List<ProdCarrito> prodCarrito = BBDD.addProducto(id, nombre, descripcion, peso, stock, categoria,
					numComprar);

			/* Vuelta a cargar */
			List<Productos> pel = BBDD.mostrarTodo3();

			request.setAttribute("listaPel", pel);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				
				List<Productos> pel = BBDD.mostrarTodo3();

				request.setAttribute("listaPel", pel);
				
			} catch (Exception i) {
				i.printStackTrace();
			}
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/vaciarCarromato")
	public ModelAndView vaciarCarromato(HttpServletRequest request) throws ServletException, IOException {

		try {

			List<ProdCarrito> prodCarrito = BBDD.vaciarCarromato();

			request.setAttribute("listaPel", prodCarrito);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return new ModelAndView("carromato");

	}

	@RequestMapping(method = RequestMethod.POST, value = "/borrarProducto")
	public ModelAndView borrarProducto(HttpServletRequest request) throws ServletException, IOException {

		Integer pedidos = Integer.parseInt(request.getParameter("pedidos"));
		Integer id = Integer.parseInt(request.getParameter("codProd"));
		Integer unidades = Integer.parseInt(request.getParameter("unidades"));

		try {

			List<ProdCarrito> prodCarrito = BBDD.deleteProductos(id, pedidos, unidades);

			request.setAttribute("listaPel", prodCarrito);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return new ModelAndView("carromato");

	}

	@RequestMapping(method = RequestMethod.POST, value = "/realizarPedido")
	public ModelAndView realizarPedido(HttpServletRequest request) throws ServletException, IOException {
	
		try {

			BBDD.finalizarPedido();
			email.enviarCorreo(correo0);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}catch (NullPointerException e) {
			
			e.printStackTrace();
		}

		return new ModelAndView("finalizarPedido");

	}

	/********************/

}
