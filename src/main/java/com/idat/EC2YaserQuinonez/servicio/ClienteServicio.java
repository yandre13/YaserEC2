package com.idat.EC2YaserQuinonez.servicio;

import java.util.List;

import com.idat.EC2YaserQuinonez.dto.ClienteDTORequest;
import com.idat.EC2YaserQuinonez.dto.ClienteDTOResponse;

public interface ClienteServicio {

	public void guardarCliente(ClienteDTORequest cliente);
	public void editarCliente(ClienteDTORequest cliente);
	public void eliminarCliente(Integer id);
	public List<ClienteDTOResponse> listarClientes();
	public ClienteDTOResponse obtenerClienteId(Integer id);
}
