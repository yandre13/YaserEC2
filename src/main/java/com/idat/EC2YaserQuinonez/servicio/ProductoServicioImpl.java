package com.idat.EC2YaserQuinonez.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EC2YaserQuinonez.dto.ProductoDTORequest;
import com.idat.EC2YaserQuinonez.dto.ProductoDTOResponse;
import com.idat.EC2YaserQuinonez.modelo.Producto;
import com.idat.EC2YaserQuinonez.repositorio.ProductoRepositorio;

@Service
public class ProductoServicioImpl implements ProductoServicio {

	@Autowired
	public ProductoRepositorio repositorio;

	@Override
	public void guardarProducto(ProductoDTORequest producto) {
		// TODO Auto-generated method stub
		Producto p = new Producto();
		p.setIdProducto(producto.getIdProducto());
		p.setProducto(producto.getProducto());
		p.setDescripcion(producto.getDescripcion());
		p.setPrecio(producto.getPrecio());
		p.setStock(producto.getStock());
		
		repositorio.save(p);
	}

	@Override
	public void editarProducto(ProductoDTORequest producto) {
		// TODO Auto-generated method stub
		Producto p = new Producto();
		p.setIdProducto(producto.getIdProducto());
		p.setProducto(producto.getProducto());
		p.setDescripcion(producto.getDescripcion());
		p.setPrecio(producto.getPrecio());
		p.setStock(producto.getStock());
		
		repositorio.saveAndFlush(p);
	}

	@Override
	public void eliminarProducto(Integer id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
	}

	@Override
	public List<ProductoDTOResponse> listarProductos() {
		// TODO Auto-generated method stub
		List<ProductoDTOResponse> response = new ArrayList<ProductoDTOResponse>();
		List<Producto> productos = repositorio.findAll();
		
		productos.stream().forEach(p -> {
			ProductoDTOResponse pDTO = new ProductoDTOResponse();
			pDTO.setIdProducto(p.getIdProducto());
			pDTO.setProducto(p.getProducto());
			pDTO.setDescripcion(p.getDescripcion());
			pDTO.setPrecio(p.getPrecio());
			pDTO.setStock(p.getStock());
			
			response.add(pDTO);
		});
		return response;
	}

	@Override
	public ProductoDTOResponse obtenerProductoId(Integer id) {
		// TODO Auto-generated method stub
		Producto producto = repositorio.findById(id).orElse(null);
		
		ProductoDTOResponse p = new ProductoDTOResponse();
		p.setIdProducto(producto.getIdProducto());
		p.setProducto(producto.getProducto());
		p.setDescripcion(producto.getDescripcion());
		p.setPrecio(producto.getPrecio());
		p.setStock(producto.getStock());
		
		return p;
	}
	
}
