package com.ejemplo.facturacion.main;

import com.ejemplo.facturacion.entidad.Cliente;
import com.ejemplo.facturacion.servicio.ClienteServicio;

public class Main {
    public static void main(String[] args) {
        ClienteServicio clienteServicio = new ClienteServicio();

        // Registrar un nuevo cliente
        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setNombreCompleto("Juan Pérez");
        nuevoCliente.setEmail("juan.perez@example.com");
        nuevoCliente.setTelefono("123456789");
        // La fecha de registro se establece automáticamente en el constructor de Cliente
        clienteServicio.registrarCliente(nuevoCliente);

        // Listar todos los clientes
        System.out.println("Lista de clientes:");
        clienteServicio.listarClientes().forEach(cliente -> System.out.println(cliente.getNombreCompleto()));

        // Actualizar la información de contacto de un cliente
        nuevoCliente.setTelefono("987654321");
        clienteServicio.actualizarCliente(nuevoCliente);

        // Listar clientes después de la actualización
        System.out.println("Clientes después de la actualización:");
        clienteServicio.listarClientes().forEach(cliente -> System.out.println(cliente.getNombreCompleto()));

        // Eliminar un cliente del sistema
        clienteServicio.eliminarCliente(nuevoCliente.getId());
        System.out.println("Cliente eliminado.");
    }
}
