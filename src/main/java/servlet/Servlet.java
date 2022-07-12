package servlet;

import Data.UserConnect;
import domain.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletControlador")
public class Servlet extends HttpServlet{
   

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {

                case "crear":
                    this.crearUsuario(request, response);
                    break;
                case "login":
                    this.loginUsuario(request, response);
                    break;
            }
        }
        
        
    }
    
    public void crearUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        
        
        //Recuperamos valores del formulario
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String genero = request.getParameter("genero");
        String password = request.getParameter("password");
        
    
        //Creamos objeto de cliente
        User usuarioRegistro = new User(nombre, apellido, email, genero, password);
    
        //Se inserta       
        boolean registroModificado = new UserConnect().insertar(usuarioRegistro);
        
        //Se lleva a pagina de error en el registro a desplegar el listado
        if(usuarioRegistro.isValid()){
            response.sendRedirect("htmls/exito.jsp");
            request.setAttribute("emailSuccess", email);
        } else {
            System.out.println("Usuario ya registrado, saliendo del servlet al error.jsp");
            request.setAttribute("emailError", email);
            response.sendRedirect("htmls/error.jsp");
        }
    }
    
   
    
    public void loginUsuario (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        User usuarioLogin = new User(email, password);
        
        boolean validacion = new UserConnect().login(usuarioLogin);
                
        if (usuarioLogin.isValid()){
            HttpSession session = request.getSession();
            session.setAttribute("username",email);
            response.sendRedirect("htmls/logged.jsp");
            System.out.println("Validacion generada, email y passw correctos");
        } else {
            response.getWriter().print("Credenciales incorrectas");
            response.sendRedirect("htmls/errorLogin.jsp");
            //HttpSession session = request.getSession();
            System.out.println("Validacion incorecta");
        }
        
    }
    
    
}


    /*
    @Override 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {

                case "editar":
                    this.editarCliente(request, response);
                    break;
                case "eliminar":
                    this.eliminarCliente(request, response);
                    break;
                default:
                    this.Default(request, response);
                    break;

            }

        } else {
            this.Default(request, response);
        }
        
        
    }
*/
    
    /*
    
    private void Default (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<Cliente> clientes = new ClienteDaoJDBC().listar();
        System.out.println("Lista de clientes: " + clientes);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("clientes", clientes);
        sesion.setAttribute("totalClientes", clientes.size());
        sesion.setAttribute("saldoTotal", this.calcularSaldoTot(clientes));
        //request.getRequestDispatcher("clientes.jsp").forward(request, response);
        response.sendRedirect("clientes.jsp");
        
    }
    
    
    private double calcularSaldoTot (List<Cliente> clientes) {

        double saldoTotal = 0;

        for (Cliente cliente: clientes) {       
            saldoTotal += cliente.getSaldo();

        }
        return saldoTotal;
    }
    

    public void editarCliente (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        
        
        //Recuperamos valores del formulario
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        Cliente cliente = new ClienteDaoJDBC().buscar(idCliente);
        request.setAttribute("cliente", cliente);
        String jspEditar = "/WEB-INF/paginas/cliente/editarCliente.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }
    
    public void modificarCliente (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        
        
        //Recuperamos valores del formulario
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoString = request.getParameter("saldo");
        
        if (saldoString != null && !"".equals(saldoString)){
        saldo = Double.parseDouble(saldoString);
            
        }
    
        //Modificar objeto de cliente
        Cliente cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);
    
        //Se inserta
        
        int registroModificado = new ClienteDaoJDBC().actualizar(cliente);
        System.out.println("Registros modificados: " + registroModificado);
        
        //Se vuelve a desplegar el listado
        
        this.Default(request, response);
    }
    
    public void eliminarCliente (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        
        
        //Recuperamos valores del formulario
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        
        //Eliminar un objeto
        
        Cliente cliente = new Cliente(idCliente);
        int registroModificado = new ClienteDaoJDBC().eliminar(cliente);
        
        System.out.println("Registro eliminado" + registroModificado);
        
        
        //Se vuelve a desplegar el listado
        this.Default(request, response);
        
    }


    */