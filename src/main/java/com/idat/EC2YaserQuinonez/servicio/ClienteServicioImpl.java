package com.idat.EC2YaserQuinonez.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EC2YaserQuinonez.dto.ClienteDTORequest;
import com.idat.EC2YaserQuinonez.dto.ClienteDTOResponse;
import com.idat.EC2YaserQuinonez.modelo.Cliente;
import com.idat.EC2YaserQuinonez.repositorio.ClienteRepositorio;

@Service
public class ClienteServicioImpl implements ClienteServicio {
	
	@Autowired
	public ClienteRepositorio repositorio;

	@Override
	public void guardarCliente(ClienteDTORequest cliente) {
		// TODO Auto-generated method stub
		Cliente c = new Cliente();
		c.setIdCliente(cliente.getIdCliente());
		c.setNombre(cliente.getNombre());
		c.setDireccion(cliente.getDireccion());
		c.setDni(cliente.getDni());
		
		repositorio.save(c);
	}

	@Override
	public void editarCliente(ClienteDTORequest cliente) {
		// TODO Auto-generated method stub
		Cliente c = new Cliente();
		c.setIdCliente(cliente.getIdCliente());
		c.setNombre(cliente.getNombre());
		c.setDireccion(cliente.getDireccion());
		c.setDni(cliente.getDni());
		
		repositorio.saveAndFlush(c);
	}

	@Override
	public void eliminarCliente(Integer id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
	}

	@Override
	public List<ClienteDTOResponse> listarClientes() {
		// TODO Auto-generated method stub
		List<ClienteDTOResponse> response = new ArrayList<ClienteDTOResponse>();
		List<Cliente> clientes = repositorio.findAll();
		
		clientes.stream().forEach(c -> {
			ClienteDTOResponse cDTO = new ClienteDTOResponse();
			cDTO.setIdCliente(c.getIdCliente());
			cDTO.setNombre(c.getNombre());
			cDTO.setDireccion(c.getDireccion());
			cDTO.setDni(c.getDni());
			
			response.add(cDTO);
		});
		return response;
	}

	@Override
	public ClienteDTOResponse obtenerClienteId(Integer id) {
		// TODO Auto-generated method stub
		Cliente cliente = repositorio.findById(id).orElse(null);
		
		ClienteDTOResponse c = new ClienteDTOResponse();
		c.setIdCliente(cliente.getIdCliente());
		c.setNombre(cliente.getNombre());
		c.setDireccion(cliente.getDireccion());
		c.setDni(cliente.getDni());
		
		return c;
	}

}
