package com.ejemplo.facturacion.servicio;

import com.ejemplo.facturacion.dao.ClienteDAO;
import com.ejemplo.facturacion.entidad.Cliente;

import java.util.List;

public class ClientService {
    private ClienteDAO clienteDAO;

    public ClientService() {
        clienteDAO = new ClienteDAO(); // Initialize the DAO
    }

    public void registerClient(Cliente client) {
        clienteDAO.registrarCliente(client);
    }

    public List<Cliente> listClients() {
        return clienteDAO.listarClientes();
    }

    public void updateClient(Cliente client) {
        clienteDAO.actualizarCliente(client);
    }

    public void deleteClient(Long id) {
        clienteDAO.eliminarCliente(id);
    }
}
