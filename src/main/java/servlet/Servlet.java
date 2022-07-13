package servlet;

import Data.UserConnect;
import domain.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
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
        
        //se recibe la accion desde el jsp y se redirecciona
        
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
        
    
        //Creamos el objeto y asignamos valores
        User usuarioRegistro = new User(nombre, apellido, email, genero, password);      
        boolean registroModificado = new UserConnect().insertar(usuarioRegistro);
        
        //Se lleva a pagina de exito en el registro
        if(usuarioRegistro.isValid()){
            response.sendRedirect("htmls/exitoRegistro.jsp");
            request.setAttribute("emailSuccess", email);
        } else {
            
        //de lo contrario se va al jsp de error en el registro
        
            System.out.println("Usuario ya registrado, saliendo del servlet al error.jsp");
            request.setAttribute("emailError", email);
            RequestDispatcher rd = request.getRequestDispatcher("htmls/errorRegister.jsp");
            rd.forward(request, response);
        }
    }
    
   
    
    public void loginUsuario (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        
        //recuperamos valores del formulario

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        //creamos el objeto y asignamos valores
        User usuarioLogin = new User(email, password);
        boolean validacion = new UserConnect().login(usuarioLogin);
                
        if (usuarioLogin.isValid()){
            //Si el usuario es valido, se le asigna el atributo y se lleva al mensaje de bienvenida
            HttpSession session = request.getSession();
            session.setAttribute("username",email);
            request.setAttribute("email", email);
            RequestDispatcher rd = request.getRequestDispatcher("htmls/exitoLogin.jsp");
            rd.forward(request, response);
            System.out.println("Validacion generada, email y passw correctos");
        } else {
            //De lo contrario se lleva a la pagina de error
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