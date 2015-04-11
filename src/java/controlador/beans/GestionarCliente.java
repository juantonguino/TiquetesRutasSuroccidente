/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.SessionScoped;
import modelo.mundo.Cliente;

/**
 *
 * @author MiPc
 */
@ManagedBean
@RequestScoped
@ApplicationScoped
@SessionScoped
public class GestionarCliente extends Controller{

    
    private Cliente clienteAgregar;
    private Cliente clienteBuscar;
    private Cliente clienteModificar;
    private static List<Cliente> listaClientes;
    /**
     * Creates a new instance of GestionarCliente
     */
    public GestionarCliente() {
        clienteAgregar= new Cliente(0, "", "");
        clienteBuscar= new Cliente(0, "", "");
        clienteModificar= new Cliente(0, "", "");
        listaClientes= new ArrayList<>();
        super.darInstanciaMundo();
        restablecerListaClientes();
    }
    //--------------------------------------------------------------------------
    //REQUERIMIENTOS
    //--------------------------------------------------------------------------
    public void restablecerListaClientes(){
        listaClientes.clear();
        listaClientes.addAll(mundo.getClientes());
    }
    public void agregar(){
        mundo.agregarCliente(clienteAgregar.getNombres(), clienteAgregar.getApellidos(), clienteAgregar.getIdentificacion());
        restablecerListaClientes();
    }
    public void buscar(){
        Cliente cliente= mundo.buscarCliente(clienteBuscar.getIdentificacion());
        if(cliente!=null){
            listaClientes.clear();
            listaClientes.add(cliente);
        }
        else{
            listaClientes.clear();
        }
    }
    public void eliminar(Cliente cliente){
        mundo.eliminarCliente(cliente.getIdentificacion());
        restablecerListaClientes();
    }
    public String redireccionarModificar(Cliente cliente){
        clienteModificar= cliente;
        return "modificarCliente.xhtml";
    }
    public void modificarVehiculo(){
        mundo.modificarCliente(clienteModificar.getNombres(), clienteModificar.getApellidos(), clienteModificar.getIdentificacion());
        super.redireccionarVista("gestionarCliente.xhtml");
    }
    public void irPanelControl(){
        super.redireccionarVista("index.xhtml");
    } 
    //--------------------------------------------------------------------------
    //GETTERS AND SETTERS
    //--------------------------------------------------------------------------

    public Cliente getClienteAgregar() {
        return clienteAgregar;
    }

    public void setClienteAgregar(Cliente clienteAgregar) {
        this.clienteAgregar = clienteAgregar;
    }

    public Cliente getClienteBuscar() {
        return clienteBuscar;
    }

    public void setClienteBuscar(Cliente clienteBuscar) {
        this.clienteBuscar = clienteBuscar;
    }

    public Cliente getClienteModificar() {
        return clienteModificar;
    }

    public void setClienteModificar(Cliente clienteModificar) {
        this.clienteModificar = clienteModificar;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        GestionarCliente.listaClientes = listaClientes;
    }
    
}